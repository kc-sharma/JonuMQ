/*
 *
 */
package com.jonu.jonumq.destination;

import com.jonu.jonumq.JonuMQWireMessage;
import com.jonu.jonumq.channel.ChannelExecutor;

import java.io.DataOutputStream;
import java.io.IOException;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/16/2016
 */
public interface JonuMQDestinationType
{
    public void consume(JonuMQWireMessage wireMessage, DataOutputStream out, ChannelExecutor executor) throws IOException;

    public void produce(JonuMQWireMessage wireMessage, DataOutputStream out, ChannelExecutor executor) throws IOException;
}
