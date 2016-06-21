/*
 *
 */
package com.jonu.jonumq.consumer;

import com.jonu.jonumq.JonuMQMessageWrapper;
import com.jonu.jonumq.channel.Channel;

import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/17/2016
 */
public abstract class Consumer
{
    public abstract void doProcess(Channel channel) throws IOException;

    public void dispatchMessage(ObjectOutputStream out, JonuMQMessageWrapper message) throws IOException
    {
        out.writeObject(message);

    }

    public void persistMessage(JonuMQMessageWrapper message)
    {
        if (!message.isConsumed() && message.isPersistent()) {
            // TODO persist the message
            //
        }
    }
}
