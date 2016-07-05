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
public class QueueConsumer extends Consumer
{
    @Override
    public void
    doProcess(Channel channel) throws IOException
    {
        while (true) {
            JonuMQMessageWrapper message = super.getFirstMessage(channel);
            if (message != null) {

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
                // Persist the message if not consumed
                super.persistMessage(message);
            }
        }
    }
}
