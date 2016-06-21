/*
 *
 */
package org.jonu.jonumq.broker;

import org.jonu.jonumq.channel.ChannelExecutor;
import org.jonu.jonumq.marshaller.JonuMQMarshallerResolver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/13/2016
 */
public class Server
{
    private ServerSocket serverSocket;
    private JonuMQMarshallerResolver marshallerResolver = new JonuMQMarshallerResolver();
    static boolean brokerRunning = true;
    List<Thread> connectedClients;
    private static final Logger logger = Logger.getLogger(ClientHandler.class.getName());

    public Server()
    {
        connectedClients = new ArrayList<Thread>();
    }

    public Server(String host, int port) throws IOException
    {
        this();
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(0);
    }

    public void start(ChannelExecutor executor)
    {
        while (true) {
            if (!brokerRunning) {
                stop();
                break;
            }
            try {
                logger.log(Level.INFO, "Waiting for new client on port " + serverSocket.getLocalPort() + "...");
                Socket clientSocket = serverSocket.accept();

                logger.log(Level.INFO, "Just connected to " + clientSocket.getRemoteSocketAddress());

                Thread t = new ClientHandler(clientSocket, executor);
                t.start();
                connectedClients.add(t);

            } catch (SocketTimeoutException s) {
                logger.log(Level.INFO, "Socket timed out! Still waiting for client");
            } catch (IOException e) {
                try {
                    serverSocket.close();
                } catch (IOException s) {
                    s.printStackTrace();
                }
                e.printStackTrace();
                break;
            }
        }
    }

    public void stop()
    {
        for (Thread t : connectedClients) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static boolean isBrokerRunning()
    {
        return brokerRunning;
    }

    public static void setBrokerRunning(boolean running)
    {
        brokerRunning = running;
    }
}
