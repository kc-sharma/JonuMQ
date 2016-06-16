/*
 *
 */
package org.jonu.jonumq.client;

import org.jonu.jonumq.channel.Channel;
import org.jonu.jonumq.channel.ChannelExecutor;
import org.jonu.jonumq.destination.DestinationResolver;
import org.jonu.jonumq.destination.JonuMQDestination;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/15/2016
 */
public class ProducerClientTypeHandler implements ClientTypeHandler
{
    @Override
    public void doProcess(DataInput in, DataOutput out) throws IOException
    {
        JonuMQDestination destination = DestinationResolver.resolve(in);

        ChannelExecutor executor = null;
        Channel channel = executor.getChannel("");

        destination.produce(in, out, channel); // yahan pe dedo channel

    }
}
