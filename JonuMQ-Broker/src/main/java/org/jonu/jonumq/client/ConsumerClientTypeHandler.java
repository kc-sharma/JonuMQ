/*
 *
 */
package org.jonu.jonumq.client;

import org.jonu.jonumq.channel.ChannelExecutor;
import org.jonu.jonumq.destination.DestinationTypeResolver;
import org.jonu.jonumq.destination.JonuMQDestinationType;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/15/2016
 */
public class ConsumerClientTypeHandler implements ClientTypeHandler
{
    @Override
    public void doProcess(DataInput in, DataOutput out, ChannelExecutor executor) throws IOException
    {
        // Third Step done : Checking destination type if Queue or Topic
        JonuMQDestinationType destinationType = DestinationTypeResolver.resolve(in);
        destinationType.consume(in, out, executor);

    }
}
