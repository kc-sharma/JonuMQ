/*
 *
 */
package com.jonu.jonumq.consumer;

import com.jonu.jonumq.channel.Channel;

import java.io.IOException;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/17/2016
 */
public class MessageConsumption extends Thread
{
    volatile Channel channel;

    public MessageConsumption(Channel channel)
    {
        this.channel = channel;
    }

    @Override
    public void run()
    {
        // Target TODO
        // if this channel has new message
        // if channel is queue or topic
        // if consumer is durable or not
        while (channel.isRunning()) {
            try {
                if (checkIfNewMessageArrived()) {
                    Consumer consumer = ConsumerResolver.resolve(channel);
                    try {
                        consumer.doProcess(channel);
                    } catch (IOException e) {
                        System.out.println("Couldn't send the message to the client");
                        e.printStackTrace();
                    }
                }
            } catch (InterruptedException e) {
                // Ignore
            }
        }
    }

    private boolean checkIfNewMessageArrived() throws InterruptedException
    {
        if (channel.getMessageCount() > 0)
            return true;

        Thread.sleep(100);
        return false;
    }
}
