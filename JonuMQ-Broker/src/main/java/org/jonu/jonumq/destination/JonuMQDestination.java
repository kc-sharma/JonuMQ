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
public interface JonuMQDestination
{
    public void consume(DataInput in, DataOutput out, Channel channel) throws IOException;

    public void produce(DataInput in, DataOutput out, Channel channel) throws IOException;
}
