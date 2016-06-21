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
public class QueueConsumer extends Consumer
{
    @Override
    public void
    doProcess(Channel channel) throws IOException
    {
        JonuMQMessageWrapper message = channel.getFirstMessage();
        if (message != null) {
            message.setMessageOutTime(System.currentTimeMillis());

            for (ObjectOutputStream out : channel.getConsumerList()) {
                try {
                    super.dispatchMessage(out, message);
                    message.setConsumed(true);
                } catch (IOException ex) {
                    // If consumer is disconnected we can remove the consumer OUTPUT stream from the list
                    channel.removeOutStream(out);
                }
                break;
            }

            super.persistMessage(message);
        }
    }
}
