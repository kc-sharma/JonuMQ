/*
 *
 */
package org.jonu.jonumq.client;

import org.jonu.jonumq.JonuMQWireMessage;

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
        handlers[1] = new ProducerClientTypeHandler();
        handlers[2] = new ConsumerClientTypeHandler();
    }

    public static ClientTypeHandler resolve(JonuMQWireMessage wireMessage) throws IOException
    {
        short value = wireMessage.getClientType();

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
