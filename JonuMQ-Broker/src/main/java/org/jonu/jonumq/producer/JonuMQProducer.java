/*
 *
 */
package org.jonu.jonumq.producer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/10/2016
 */
public abstract class JonuMQProducer implements MessageProducer
{
    @Override
    public void send(Message message) throws JMSException
    {

    }
}
