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

    public Server()
    {
        connectedClients = new ArrayList<Thread>();
    }

    public Server(String host, int port) throws IOException
    {
        this();
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(10000);
    }

    public void start(ChannelExecutor executor)
    {
        while (true) {
            if (!brokerRunning) {
                stop();
                break;
            }
            try {
                System.out.println("Waiting for client on port " +
                        serverSocket.getLocalPort() + "...");
                Socket clientSocket = serverSocket.accept();

                System.out.println("Just connected to "
                        + clientSocket.getRemoteSocketAddress());

                Thread t = new ClientHandler(clientSocket,executor);
                t.start();
                connectedClients.add(t);

            } catch (SocketTimeoutException s) {
                System.out.println("Socket timed out! Still waiting for client");
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
