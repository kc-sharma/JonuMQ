/*
 *
 */
package org.jonu;

import java.io.*;
import java.net.Socket;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/17/2016
 */
public class Test
{
    public static void main(String[] args) throws IOException, InterruptedException
    {
        readSocket();
    }

    public static void readSocket() throws IOException, InterruptedException
    {
        Socket client = new Socket("localhost", 2056);
        DataOutput out = null;
        try {
            DataInput in = new DataInputStream(client.getInputStream());
            out = new DataOutputStream(client.getOutputStream());
        } catch (Exception e) {

        }

        while (true) {
            Thread.sleep(10000);
            out.writeShort(1);
            out.writeShort(1);
            out.writeShort(1);

            byte[] buf = new byte[128];
            out.write(buf);

            out.writeShort(1);

            ObjectOutputStream outputStream = new ObjectOutputStream(new DataOutputStream((DataOutputStream) out));
            outputStream.writeObject(new JonuMQMessageWrapper());
        }
    }
}
