/*
 *
 */
package com.jonu.jonumq.destination;

import com.jonu.jonumq.channel.Channel;
import com.jonu.jonumq.channel.ChannelExecutor;
import com.jonu.jonumq.channel.ChannelType;
import com.jonu.jonumq.message.JonuMQMessageWrapper;
import com.jonu.jonumq.message.JonuMQWireMessage;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/16/2016
 */
public abstract class JonuMQDestinationType
{
    public abstract void consume(JonuMQWireMessage wireMessage, DataOutputStream out, ChannelExecutor executor) throws IOException;

    public abstract void produce(JonuMQWireMessage wireMessage, DataOutputStream out, ChannelExecutor executor) throws IOException;

    private Channel getChannel(JonuMQWireMessage wireMessage, ChannelExecutor executor) throws IOException
    {
        // read the destination name
        String destination = DestinationResolver.resolve(wireMessage);
        Channel channel = executor.getChannel(destination);
        if (channel == null) {
            channel = executor.addNewChannel(destination);
        }
        return channel;
    }

    private void addConsumerIfNotExist(Channel channel, DataOutputStream out) throws IOException
    {
        ObjectOutputStream outputStream = new ObjectOutputStream(out);
        channel.addConsumer(outputStream);
    }


    public void consumeMessage(JonuMQWireMessage wireMessage, DataOutputStream out, ChannelExecutor executor, ChannelType channelType) throws IOException
    {
        Channel channel = getChannel(wireMessage, executor);
        channel.setChannelType(channelType);

        addConsumerIfNotExist(channel, out);
    }

    public void produceMessage(JonuMQWireMessage wireMessage, DataOutputStream out, ChannelExecutor executor, ChannelType channelType) throws IOException
    {
        // We doesn't need marshaller here, why we wanna marshall and unmarshall here, we can simply store the
        // message in byte format

        Channel channel = getChannel(wireMessage, executor);
        channel.setChannelType(channelType);

        // read marshaller information and ignore it as we will not use marshaller at broker side
        //readMarshaller(in);

        // read the message object from in stream
        JonuMQMessageWrapper message = wireMessage.getMessage();
        message.setMessageInTime(System.currentTimeMillis());

        channel.addMessage(message);
    }
}
