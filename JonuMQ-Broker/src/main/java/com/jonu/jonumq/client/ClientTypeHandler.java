/*
 *
 */
package com.jonu.jonumq.client;

import com.jonu.jonumq.channel.ChannelExecutor;
import com.jonu.jonumq.message.JonuMQWireMessage;

import java.io.DataOutputStream;
import java.io.IOException;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/15/2016
 */
public interface ClientTypeHandler
{
    public void doProcess(JonuMQWireMessage wireMessage, DataOutputStream out, ChannelExecutor executor) throws IOException, ClassNotFoundException;
}
