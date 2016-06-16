/*
 *
 */
package org.jonu.jonumq.destination;

import org.jonu.jonumq.channel.Channel;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/16/2016
 */
public class JonuMQQueueDestination implements JonuMQDestination
{

    @Override
    public void consume(DataInput in, DataOutput out, Channel channel) throws IOException
    {

    }

    @Override
    public void produce(DataInput in, DataOutput out, Channel channel) throws IOException
    {

        // We doesn't need marshaller here, why we wanna marshall and unmarshall here, we can simply store the
        // message in byte format
    }
}
