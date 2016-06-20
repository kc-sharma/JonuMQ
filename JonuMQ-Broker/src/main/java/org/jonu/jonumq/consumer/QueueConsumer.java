/*
 *
 */
package org.jonu.jonumq.consumer;

import org.jonu.jonumq.JonuMQMessageWrapper;
import org.jonu.jonumq.channel.Channel;

import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/17/2016
 */
public class QueueConsumer implements Consumer
{
    @Override
    public void
    doProcess(Channel channel) throws IOException
    {
        JonuMQMessageWrapper message = channel.getFirstMessage();
        message.setMessageOutTime(System.currentTimeMillis());

        if (message.isPersistent()) {
            // TODO persist the message
        }


        for (ObjectOutputStream out : channel.getConsumerList()) {
            out.writeObject(message);
            break;
        }
    }
}
