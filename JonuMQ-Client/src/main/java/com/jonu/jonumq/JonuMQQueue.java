/*
 *
 */
package com.jonu.jonumq;

import javax.jms.JMSException;
import javax.jms.Queue;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/21/2016
 */
public class JonuMQQueue extends JonuMQDestination implements Queue
{
    public JonuMQQueue(String queueName)
    {
        super(queueName);
    }

    @Override
    public String getQueueName() throws JMSException
    {
        return super.getDestinationName();
    }
}
