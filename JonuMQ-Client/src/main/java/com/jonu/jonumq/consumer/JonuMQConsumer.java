/*
 *
 */
package com.jonu.jonumq.consumer;

import com.jonu.jonumq.JonuMQListener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/21/2016
 */
public class JonuMQConsumer implements MessageConsumer
{
    JonuMQListener listener = null;

    @Override
    public String getMessageSelector() throws JMSException
    {
        return null;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public MessageListener getMessageListener() throws JMSException
    {
        if (listener == null) {
            throw new NullPointerException("Message Listener is not set");
        }
        return (MessageListener) listener;
    }

    @Override
    public void setMessageListener(MessageListener listener) throws JMSException
    {
        this.listener = new JonuMQListener(listener);
    }

    @Override
    public Message receive() throws JMSException
    {
        return null;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Message receive(long l) throws JMSException
    {
        return null;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Message receiveNoWait() throws JMSException
    {
        return null;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void close() throws JMSException
    {
        //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }
}
