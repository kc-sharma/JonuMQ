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
    static ClientTypeHandler[] handlers;

    static {
        handlers = new ClientTypeHandler[3];
        handlers[1] = new ConsumerClientTypeHandler();
        handlers[2] = new ProducerClientTypeHandler();
    }

    public static ClientTypeHandler resolve(DataInput in) throws IOException
    {
        short value = in.readShort();

        if (value < 1) {
            throw new NullPointerException("Consumer type is not defined");
        }

        try {
            return handlers[value];
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("Unknown Client Type Handler");
        }

    }
}
