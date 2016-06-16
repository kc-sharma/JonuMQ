/*
 *
 */
package org.jonu.jonumq.client;

import java.io.DataInput;
import java.io.IOException;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/15/2016
 */
public class ClientTypeResolver
{
    public static ClientTypeHandler resolve(DataInput in) throws IOException
    {
        short value = in.readShort();

        if (value < 1) {
            throw new NullPointerException("Consumer type is not defined");
        }

        switch (value) {
            case 1:
                return new ConsumerClientTypeHandler();
            case 2:
                return new ProducerClientTypeHandler();

            default:
                return null;
        }

    }
}
