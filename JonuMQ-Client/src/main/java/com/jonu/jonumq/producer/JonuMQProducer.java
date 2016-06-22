/*
 *
 */
package com.jonu.jonumq.producer;

import com.jonu.jonumq.JonuMQDestination;
import com.jonu.jonumq.message.JonuMQMessage;
import com.jonu.jonumq.message.JonuMQMessageWrapper;
import com.jonu.jonumq.message.JonuMQWireMessage;
import com.jonu.jonumq.transport.TransportFactory;

import javax.jms.*;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/10/2016
 */
public class JonuMQProducer implements MessageProducer
{
    private JonuMQDestination destination;
    int deliveryMode;
    private TransportFactory transportFactory;
    private JonuMQWireMessage wireMessage;

    public JonuMQProducer(JonuMQWireMessage wireMessage, TransportFactory transportFactory, Destination destination)
    {
        this.wireMessage = wireMessage;
        this.transportFactory = transportFactory;
        this.destination = (JonuMQDestination) destination;
    }

    @Override
    public void setDisableMessageID(boolean b) throws JMSException
    {
        //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean getDisableMessageID() throws JMSException
    {
        return false;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setDisableMessageTimestamp(boolean b) throws JMSException
    {
        //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean getDisableMessageTimestamp() throws JMSException
    {
        return false;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setDeliveryMode(int i) throws JMSException
    {
        this.deliveryMode = i;
    }

    @Override
    public int getDeliveryMode() throws JMSException
    {
        return deliveryMode;
    }

    @Override
    public void setPriority(int i) throws JMSException
    {
        //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getPriority() throws JMSException
    {
        return 0;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setTimeToLive(long l) throws JMSException
    {
        //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public long getTimeToLive() throws JMSException
    {
        return 0;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setDeliveryDelay(long l) throws JMSException
    {
        //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public long getDeliveryDelay() throws JMSException
    {
        return 0;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Destination getDestination() throws JMSException
    {
        return null;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void close() throws JMSException
    {
        //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void send(Message message) throws JMSException
    {
        sendMessage(message);
    }

    private void sendMessage(Message message) throws JMSException
    {
        setWireMessageProperties(message);
        transportFactory.send(wireMessage);
    }

    private void setWireMessageProperties(Message message)
    {
        JonuMQMessageWrapper messageWrapper = new JonuMQMessageWrapper();
        messageWrapper.setDestination(wireMessage.getDestination());
        messageWrapper.setMessage((JonuMQMessage) message);
        messageWrapper.setMessageCreationTime(System.currentTimeMillis());
        messageWrapper.setPersistent(getPersistMode());
        wireMessage.setMessage(messageWrapper);

    }


    private Message marshallMessageToOurFormat()
    {
        return null;  //$REVIEW$ To change body of created methods use File | Settings | File Templates.
    }

    @Override
    public void send(Message message, int i, int i2, long l) throws JMSException
    {
        //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void send(Destination destination, Message message) throws JMSException
    {
        //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void send(Destination destination, Message message, int i, int i2, long l) throws JMSException
    {
        //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void send(Message message, CompletionListener completionListener) throws JMSException
    {
        //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void send(Message message, int i, int i2, long l, CompletionListener completionListener) throws JMSException
    {
        //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void send(Destination destination, Message message, CompletionListener completionListener) throws JMSException
    {
        //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void send(Destination destination, Message message, int i, int i2, long l, CompletionListener completionListener) throws JMSException
    {
        //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean getPersistMode()
    {
        if (deliveryMode == DeliveryMode.PERSISTENT)
            return true;
        return false;
    }
}
