/*
 *
 */
package com.jonu.jonumq.client;

import com.jonu.jonumq.channel.ChannelExecutor;
import com.jonu.jonumq.destination.DestinationTypeResolver;
import com.jonu.jonumq.destination.JonuMQDestinationType;
import com.jonu.jonumq.message.JonuMQWireMessage;

import java.io.DataOutputStream;
import java.io.IOException;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/15/2016
 */
public class ConsumerClientTypeHandler implements ClientTypeHandler
{
    @Override
    public void doProcess(JonuMQWireMessage wireMessage, DataOutputStream out, ChannelExecutor executor) throws IOException, ClassNotFoundException
    {
        // Third Step done : Checking destination type if Queue or Topic
        JonuMQDestinationType destinationType = DestinationTypeResolver.resolve(wireMessage);
        destinationType.consume(wireMessage, out, executor);

    }
}
