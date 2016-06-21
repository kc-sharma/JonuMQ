/*
 *
 */
package com.jonu.jonumq.marshaller;

import com.jonu.jonumq.exception.UnknownMessageTypeException;

import java.nio.ByteBuffer;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/14/2016
 */
public class JonuMQMarshallerResolver
{
    JonuMQMarshaller[] marshallers = new JonuMQMarshaller[10];

    public JonuMQMarshallerResolver()
    {
        marshallers[0] = new JonuMQTextMessageMarshaller();
    }

    public JonuMQMarshaller resolve(ByteBuffer in)
    {
        JonuMQMarshaller marshaller = null;
        try {
            marshaller = marshallers[in.getShort()];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new UnknownMessageTypeException("Message Type Is Unknown");
        }
        return null;
    }
}
