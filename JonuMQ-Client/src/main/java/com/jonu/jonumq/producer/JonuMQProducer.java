/*
 *
 */
package com.jonu.jonumq.producer;

import com.jonu.jonumq.JonuMQDestination;

import javax.jms.*;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/10/2016
 */
public class JonuMQProducer implements MessageProducer
{
    private ObjectOutputStream out;
    private JonuMQDestination destination;
    int deliveryMode;
    private Socket client;

    public JonuMQProducer(Socket client, Destination destination, ObjectOutputStream out)
    {
        this.client = client;
        this.destination = (JonuMQDestination) destination;
        this.out = out;
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

    private void sendMessage(Message message)
    {
        Message wireMessage = marshallMessageToOurFormat();
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
}
