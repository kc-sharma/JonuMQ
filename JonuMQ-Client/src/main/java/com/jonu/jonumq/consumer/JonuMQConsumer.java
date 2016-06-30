/*
 *
 */
package com.jonu.jonumq.consumer;

import com.jonu.jonumq.JonuMQListener;
import com.jonu.jonumq.message.JonuMQMessage;
import com.jonu.jonumq.message.JonuMQMessageWrapper;
import com.jonu.jonumq.message.JonuMQWireMessage;
import com.jonu.jonumq.transport.TransportFactory;

import javax.jms.*;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/21/2016
 */
public class JonuMQConsumer implements MessageConsumer
{
    private JonuMQListener listener = null;
    final private JonuMQWireMessage consumerRegisteringMessage;
    private TransportFactory transportFactory;
    private Destination destination;

    public JonuMQConsumer(final JonuMQWireMessage wireMessage, TransportFactory transportFactory, Destination destination)
    {

        this.consumerRegisteringMessage = wireMessage;
        this.transportFactory = transportFactory;
        this.destination = destination;
    }

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
        try {
            startConsumption();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void startConsumption() throws ClassNotFoundException, JMSException
    {

        while (true) {

            JonuMQMessageWrapper messageWrapper = transportFactory.readNextMessage(consumerRegisteringMessage);
            if (messageWrapper != null) {
                JonuMQMessage message = messageWrapper.getMessage();
                listener.onMessage(message);
            }
        }
    }

    private void reRegisterConsumer() throws JMSException
    {
        transportFactory.send(consumerRegisteringMessage);
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
