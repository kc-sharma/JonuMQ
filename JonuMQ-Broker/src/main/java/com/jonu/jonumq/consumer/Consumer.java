/*
 *
 */
package com.jonu.jonumq.consumer;

import com.jonu.jonumq.channel.Channel;
import com.jonu.jonumq.message.JonuMQMessageWrapper;

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
        message.setMessageOutTime(System.currentTimeMillis());
        out.writeObject(message);

    }

    JonuMQMessageWrapper getFirstMessage(Channel channel)
    {
        JonuMQMessageWrapper message = null;
        try {
            message = channel.getFirstMessage();
        } catch (InterruptedException e) {
            e.printStackTrace();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e1) {
                e1.printStackTrace();  //$REVIEW$ To change body of catch statement use File | Settings | File Templates.
            }
        }
        return message;
    }


    public void persistMessage(JonuMQMessageWrapper message)
    {
        if (!message.isConsumed() && message.isPersistent()) {
            // TODO persist the message
            //
        }
    }
}
