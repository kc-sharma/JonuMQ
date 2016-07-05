/*
 *
 */
package com.jonu.jonumq.destination;

import com.jonu.jonumq.channel.ChannelExecutor;
import com.jonu.jonumq.channel.ChannelType;
import com.jonu.jonumq.message.JonuMQWireMessage;

import java.io.DataOutputStream;
import java.io.IOException;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/16/2016
 */
public class JonuMQQueueDestinationType extends JonuMQDestinationType
{
    @Override
    public void consume(JonuMQWireMessage wireMessage, DataOutputStream out, ChannelExecutor executor) throws IOException
    {
        super.consumeMessage(wireMessage, out, executor, ChannelType.QUEUE);
    }

    @Override
    public void produce(JonuMQWireMessage wireMessage, DataOutputStream out, ChannelExecutor executor) throws IOException
    {

        super.produceMessage(wireMessage, out, executor, ChannelType.QUEUE);
    }
}
