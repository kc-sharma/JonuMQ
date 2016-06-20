/*
 *
 */
package org.jonu.jonumq.destination;

import org.jonu.jonumq.JonuMQMessageWrapper;
import org.jonu.jonumq.JonuMQWireMessage;
import org.jonu.jonumq.channel.Channel;
import org.jonu.jonumq.channel.ChannelExecutor;
import org.jonu.jonumq.channel.ChannelType;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/16/2016
 */
public class JonuMQQueueDestinationType implements JonuMQDestinationType
{
    @Override
    public void consume(JonuMQWireMessage wireMessage, DataOutputStream out, ChannelExecutor executor) throws IOException
    {
        Channel channel = getChannel(wireMessage, executor);
        channel.setChannelType(ChannelType.QUEUE);

        // read marshaller information and ignore it as we will not use marshaller at broker side
        // readMarshaller(in);

        addConsumerIfNotExist(channel, out);
    }

    @Override
    public void produce(JonuMQWireMessage wireMessage, DataOutputStream out, ChannelExecutor executor) throws IOException
    {

        // We doesn't need marshaller here, why we wanna marshall and unmarshall here, we can simply store the
        // message in byte format

        Channel channel = getChannel(wireMessage, executor);
        channel.setChannelType(ChannelType.QUEUE);

        // read marshaller information and ignore it as we will not use marshaller at broker side
        //readMarshaller(in);

        // read the message object from in stream
        JonuMQMessageWrapper message = wireMessage.getMessage();
        message.setMessageInTime(System.currentTimeMillis());

        channel.addMessage(message);
    }

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
}
