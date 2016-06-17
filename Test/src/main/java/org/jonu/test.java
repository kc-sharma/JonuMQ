/*
 *
 */
package org.jonu;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.net.Socket;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/17/2016
 */
public class Test
{
    public static void main(String[] args) throws IOException
    {
        Socket client = new Socket("localhost", 2056);

        DataInput in = (DataInput) client.getInputStream();
        DataOutput out = (DataOutput) client.getOutputStream();
        
        while (true) {


        }
    }
}
