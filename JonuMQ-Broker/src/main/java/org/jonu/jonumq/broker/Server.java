/*
 *
 */
package org.jonu.jonumq.broker;

import org.jonu.jonumq.marshaller.JonuMQMarshallerResolver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/13/2016
 */
public class Server extends Thread
{
    private ServerSocket serverSocket;
    private JonuMQMarshallerResolver marshallerResolver = new JonuMQMarshallerResolver();

    public Server(String host, int port) throws IOException
    {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(10000);
    }

    public void run()
    {
        while (true) {
            try {
                System.out.println("Waiting for client on port " +
                        serverSocket.getLocalPort() + "...");
                Socket server = serverSocket.accept();
                System.out.println("Just connected to "
                        + server.getRemoteSocketAddress());
                DataInput in = new DataInputStream(server.getInputStream());
                DataOutput out = new DataOutputStream(server.getOutputStream());
                /*Implement here */
                server.close();
            } catch (SocketTimeoutException s) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Socket timed out!");
                break;
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
}
