/*
 *
 */
package org.jonu.jonumq.consumer;

import org.jonu.jonumq.channel.Channel;
import org.jonu.jonumq.channel.ChannelType;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/17/2016
 */
public class ConsumerResolver
{
    private static QueueConsumer queueConsumer = new QueueConsumer();
    private static TopicConsumer topicConsumer = new TopicConsumer();

    public static Consumer resolve(Channel channel)
    {
        if (channel.getChannelType() == null) {
            throw new NullPointerException("Consumer Type can not be null");
        }
        if (channel.getChannelType().equals(ChannelType.QUEUE)) {
            return queueConsumer;
        } else if (channel.getChannelType().equals(ChannelType.TOPIC))
            return topicConsumer;

        return null;
    }
}
