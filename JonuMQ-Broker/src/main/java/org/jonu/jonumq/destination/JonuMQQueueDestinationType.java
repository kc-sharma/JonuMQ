/*
 *
 */
package org.jonu.jonumq.destination;

import org.jonu.jonumq.JonuMQMessageWrapper;
import org.jonu.jonumq.channel.Channel;
import org.jonu.jonumq.channel.ChannelExecutor;
import org.jonu.jonumq.channel.ChannelType;

import java.io.*;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/16/2016
 */
public class JonuMQQueueDestinationType implements JonuMQDestinationType
{
    @Override
    public void consume(DataInput in, DataOutput out, ChannelExecutor executor) throws IOException
    {
        Channel channel = getChannel(in, executor);
        channel.setChannelType(ChannelType.QUEUE);
        addConsumerIfNotExist(channel, out);
    }

    @Override
    public void produce(DataInput in, DataOutput out, ChannelExecutor executor) throws IOException, ClassNotFoundException
    {

        // We doesn't need marshaller here, why we wanna marshall and unmarshall here, we can simply store the
        // message in byte format

        Channel channel = getChannel(in, executor);
        channel.setChannelType(ChannelType.QUEUE);

        // read marshaller information and ignore it as we will not use marshaller at broker side
        readMarshaller(in);

        // read the message object from in stream
        JonuMQMessageWrapper message = deserializeObject(in);
        message.setMessageInTime(System.currentTimeMillis());

        channel.addMessage(message);
    }

    private Channel getChannel(DataInput in, ChannelExecutor executor) throws IOException
    {
        // read the destination name
        String destination = DestinationResolver.resolve(in);
        Channel channel = executor.getChannel(destination);
        if (channel == null) {
            channel = executor.addNewChannel(destination);
        }
        return channel;
    }

    private void readMarshaller(DataInput in) throws IOException
    {
        in.readShort();
    }

    private JonuMQMessageWrapper deserializeObject(DataInput in) throws IOException, ClassNotFoundException
    {
        ObjectInputStream inputStream = new ObjectInputStream(new DataInputStream((DataInputStream) in));
        JonuMQMessageWrapper message = (JonuMQMessageWrapper) inputStream.readObject();

        return message;
    }

    private void addConsumerIfNotExist(Channel channel, DataOutput out)
    {
        channel.addConsumer(out);
    }
}
