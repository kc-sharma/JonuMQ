/*
 * Copyright 2016 Autodesk, Inc. All Rights Reserved.
 *
 * This computer source code and related instructions and comments 
 * are the unpublished confidential and proprietary information of Autodesk, Inc. 
 * and are protected under applicable copyright and trade secret law.  
 * They may not be disclosed to, copied or used by any third party without the prior 
 * written consent of Autodesk, Inc.
 */
package org.jonu.jonumq.transport;

import javax.jms.*;
import java.io.Serializable;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/10/2016
 */
public class JonuMQSession implements Session
{
    @Override
    public BytesMessage createBytesMessage() throws JMSException
    {
        return null;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public MapMessage createMapMessage() throws JMSException
    {
        return null;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Message createMessage() throws JMSException
    {
        return null;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ObjectMessage createObjectMessage() throws JMSException
    {
        return null;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ObjectMessage createObjectMessage(Serializable serializable) throws JMSException
    {
        return null;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public StreamMessage createStreamMessage() throws JMSException
    {
        return null;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public TextMessage createTextMessage() throws JMSException
    {
        return null;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public TextMessage createTextMessage(String s) throws JMSException
    {
        return null;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean getTransacted() throws JMSException
    {
        return false;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getAcknowledgeMode() throws JMSException
    {
        return 0;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void commit() throws JMSException
    {
        //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void rollback() throws JMSException
    {
        //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void close() throws JMSException
    {
        //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void recover() throws JMSException
    {
        //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public MessageListener getMessageListener() throws JMSException
    {
        return null;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setMessageListener(MessageListener messageListener) throws JMSException
    {
        //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void run()
    {
        //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public MessageProducer createProducer(Destination destination) throws JMSException
    {
        return null;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public MessageConsumer createConsumer(Destination destination) throws JMSException
    {
        return null;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public MessageConsumer createConsumer(Destination destination, String s) throws JMSException
    {
        return null;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public MessageConsumer createConsumer(Destination destination, String s, boolean b) throws JMSException
    {
        return null;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public MessageConsumer createSharedConsumer(Topic topic, String s) throws JMSException
    {
        return null;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public MessageConsumer createSharedConsumer(Topic topic, String s, String s2) throws JMSException
    {
        return null;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Queue createQueue(String s) throws JMSException
    {
        return null;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Topic createTopic(String s) throws JMSException
    {
        return null;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public TopicSubscriber createDurableSubscriber(Topic topic, String s) throws JMSException
    {
        return null;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public TopicSubscriber createDurableSubscriber(Topic topic, String s, String s2, boolean b) throws JMSException
    {
        return null;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public MessageConsumer createDurableConsumer(Topic topic, String s) throws JMSException
    {
        return null;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public MessageConsumer createDurableConsumer(Topic topic, String s, String s2, boolean b) throws JMSException
    {
        return null;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public MessageConsumer createSharedDurableConsumer(Topic topic, String s) throws JMSException
    {
        return null;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public MessageConsumer createSharedDurableConsumer(Topic topic, String s, String s2) throws JMSException
    {
        return null;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public QueueBrowser createBrowser(Queue queue) throws JMSException
    {
        return null;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public QueueBrowser createBrowser(Queue queue, String s) throws JMSException
    {
        return null;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public TemporaryQueue createTemporaryQueue() throws JMSException
    {
        return null;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public TemporaryTopic createTemporaryTopic() throws JMSException
    {
        return null;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void unsubscribe(String s) throws JMSException
    {
        //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }
}
