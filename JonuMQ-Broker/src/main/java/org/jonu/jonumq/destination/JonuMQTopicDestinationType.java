/*
 *
 */
package org.jonu.jonumq.destination;

import org.jonu.jonumq.JonuMQWireMessage;
import org.jonu.jonumq.channel.ChannelExecutor;

import java.io.DataOutputStream;
import java.io.IOException;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/16/2016
 */
public class JonuMQTopicDestinationType implements JonuMQDestinationType
{
    @Override
    public void consume(JonuMQWireMessage wireMessage, DataOutputStream out, ChannelExecutor executor) throws IOException
    {

    }

    @Override
    public void produce(JonuMQWireMessage wireMessage, DataOutputStream out, ChannelExecutor executor) throws IOException
    {

    }
}
