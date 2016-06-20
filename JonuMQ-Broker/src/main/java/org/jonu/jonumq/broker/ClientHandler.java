/*
 *
 */
package org.jonu.jonumq.broker;

import org.jonu.jonumq.JonuMQWireMessage;
import org.jonu.jonumq.channel.ChannelExecutor;
import org.jonu.jonumq.client.ClientTypeHandler;
import org.jonu.jonumq.client.ClientTypeResolver;
import org.jonu.jonumq.exception.BrokerStoppedException;
import sun.net.ConnectionResetException;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/15/2016
 */
public class ClientHandler extends Thread
{
    private Socket socket;
    private ChannelExecutor executor;

    public ClientHandler(Socket socket, ChannelExecutor executor)
    {
        this.socket = socket;
        this.executor = executor;
    }

    @Override
    public void run()
    {
        System.out.println("Hello");
        DataInputStream in = null;
        DataOutputStream out = null;
        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            doProcess(in, out);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BrokerStoppedException e) {
            e.printStackTrace();
        } finally {

        }
    }

    private void doProcess(DataInputStream in, DataOutputStream out) throws BrokerStoppedException
    {
        ObjectInputStream objectInputStream = null;
        while (true) {
            try {
                if (objectInputStream == null) {
                    objectInputStream = getInputStream(in);
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Couldn't get input stream, retrying again");
            }
            if (objectInputStream != null) {
                if (!Server.isBrokerRunning()) {
                    throw new BrokerStoppedException("Broker was stopped, stopping all work");
                }
                // start Processing if we receive any data on input stream
                try {
                    JonuMQWireMessage wireMessage = receiveObject(objectInputStream);
                    if (wireMessage != null) {
                        ClientTypeHandler client = null;

                        client = ClientTypeResolver.resolve(wireMessage);
                        client.doProcess(wireMessage, out, executor);
                    }
                } catch (ConnectionResetException cre) {
                    System.out.println("Client got disconnected");
                    break;
                } catch (SocketException ex) {
                    System.out.println("Client Got Disconnected");
                    break;
                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }

    }

    private ObjectInputStream getInputStream(DataInputStream in) throws IOException
    {
        return new ObjectInputStream(in);
    }

    private boolean checkIfAnyObjectReceived(DataInput in)
    {

        try {
            short value = in.readShort();
            if (value > 0)
                return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private JonuMQWireMessage receiveObject(ObjectInputStream in) throws IOException, ClassNotFoundException
    {
        return (JonuMQWireMessage) in.readObject();
    }
}
