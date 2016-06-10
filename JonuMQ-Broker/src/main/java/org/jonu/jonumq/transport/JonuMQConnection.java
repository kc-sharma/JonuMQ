/*
 *
 */
package org.jonu.jonumq.transport;

import javax.jms.*;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/10/2016
 */
public class JonuMQConnection implements Connection
{

    @Override
    public Session createSession(boolean b, int i) throws JMSException
    {
        return null;
    }

    @Override
    public Session createSession(int i) throws JMSException
    {
        return null;
    }

    @Override
    public Session createSession() throws JMSException
    {
        return null;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getClientID() throws JMSException
    {
        return null;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setClientID(String s) throws JMSException
    {
        //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ConnectionMetaData getMetaData() throws JMSException
    {
        return null;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ExceptionListener getExceptionListener() throws JMSException
    {
        return null;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setExceptionListener(ExceptionListener exceptionListener) throws JMSException
    {
        //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void start() throws JMSException
    {
        //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void stop() throws JMSException
    {
        //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void close() throws JMSException
    {
        //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ConnectionConsumer createConnectionConsumer(Destination destination, String s, ServerSessionPool serverSessionPool, int i) throws JMSException
    {
        return null;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ConnectionConsumer createSharedConnectionConsumer(Topic topic, String s, String s2, ServerSessionPool serverSessionPool, int i) throws JMSException
    {
        return null;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ConnectionConsumer createDurableConnectionConsumer(Topic topic, String s, String s2, ServerSessionPool serverSessionPool, int i) throws JMSException
    {
        return null;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ConnectionConsumer createSharedDurableConnectionConsumer(Topic topic, String s, String s2, ServerSessionPool serverSessionPool, int i) throws JMSException
    {
        return null;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }
}
