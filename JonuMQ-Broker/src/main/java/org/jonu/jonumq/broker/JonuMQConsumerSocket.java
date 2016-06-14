/*
 *
 */
package org.jonu.jonumq.broker;

import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/13/2016
 */
public class JonuMQConsumerSocket extends JonuMQSocket
{
    MessageListener listener;

    public JonuMQConsumerSocket(MessageListener listener)
    {
        this.listener = listener;
    }

    public Message receiveMessage()
    {
        System.out.println("Message Received");
        return null;
    }
}
