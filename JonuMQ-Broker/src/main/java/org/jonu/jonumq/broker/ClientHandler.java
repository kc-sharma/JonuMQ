/*
 *
 */
package org.jonu.jonumq.broker;

import org.jonu.jonumq.channel.ChannelExecutor;
import org.jonu.jonumq.client.ClientTypeHandler;
import org.jonu.jonumq.client.ClientTypeResolver;
import org.jonu.jonumq.exception.BrokerStoppedException;

import java.io.*;
import java.net.Socket;

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
        DataInput in = null;
        DataOutput out = null;
        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            doProcess(in, out);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BrokerStoppedException e) {
            e.printStackTrace();
        }
    }

    private void doProcess(DataInput in, DataOutput out) throws BrokerStoppedException
    {
        while (true) {
            if (!Server.isBrokerRunning()) {
                throw new BrokerStoppedException("Broker was stopped, stopping all work");
            }
            // start Processing if we receive any data on inputput stream
            if (checkIfAnyBytesReceived(in)) {
                ClientTypeHandler client = null;
                try {
                    client = ClientTypeResolver.resolve(in);
                    client.doProcess(in, out, executor);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private boolean checkIfAnyBytesReceived(DataInput in)
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
}
