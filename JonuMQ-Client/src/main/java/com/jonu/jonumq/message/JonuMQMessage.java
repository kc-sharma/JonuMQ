/*
 *
 */
package com.jonu.jonumq.message;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import java.util.Enumeration;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/21/2016
 */
public class JonuMQMessage implements Message
{
    @Override
    public String getJMSMessageID() throws JMSException
    {
        return null;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setJMSMessageID(String s) throws JMSException
    {
        //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public long getJMSTimestamp() throws JMSException
    {
        return 0;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setJMSTimestamp(long l) throws JMSException
    {
        //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public byte[] getJMSCorrelationIDAsBytes() throws JMSException
    {
        return new byte[0];  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setJMSCorrelationIDAsBytes(byte[] bytes) throws JMSException
    {
        //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setJMSCorrelationID(String s) throws JMSException
    {
        //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getJMSCorrelationID() throws JMSException
    {
        return null;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Destination getJMSReplyTo() throws JMSException
    {
        return null;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setJMSReplyTo(Destination destination) throws JMSException
    {
        //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Destination getJMSDestination() throws JMSException
    {
        return null;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setJMSDestination(Destination destination) throws JMSException
    {
        //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getJMSDeliveryMode() throws JMSException
    {
        return 0;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setJMSDeliveryMode(int i) throws JMSException
    {
        //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean getJMSRedelivered() throws JMSException
    {
        return false;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setJMSRedelivered(boolean b) throws JMSException
    {
        //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getJMSType() throws JMSException
    {
        return null;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setJMSType(String s) throws JMSException
    {
        //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public long getJMSExpiration() throws JMSException
    {
        return 0;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setJMSExpiration(long l) throws JMSException
    {
        //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public long getJMSDeliveryTime() throws JMSException
    {
        return 0;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setJMSDeliveryTime(long l) throws JMSException
    {
        //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getJMSPriority() throws JMSException
    {
        return 0;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setJMSPriority(int i) throws JMSException
    {
        //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void clearProperties() throws JMSException
    {
        //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean propertyExists(String s) throws JMSException
    {
        return false;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean getBooleanProperty(String s) throws JMSException
    {
        return false;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public byte getByteProperty(String s) throws JMSException
    {
        return 0;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public short getShortProperty(String s) throws JMSException
    {
        return 0;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getIntProperty(String s) throws JMSException
    {
        return 0;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public long getLongProperty(String s) throws JMSException
    {
        return 0;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public float getFloatProperty(String s) throws JMSException
    {
        return 0;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public double getDoubleProperty(String s) throws JMSException
    {
        return 0;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getStringProperty(String s) throws JMSException
    {
        return null;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Object getObjectProperty(String s) throws JMSException
    {
        return null;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Enumeration getPropertyNames() throws JMSException
    {
        return null;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setBooleanProperty(String s, boolean b) throws JMSException
    {
        //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setByteProperty(String s, byte b) throws JMSException
    {
        //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setShortProperty(String s, short i) throws JMSException
    {
        //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setIntProperty(String s, int i) throws JMSException
    {
        //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setLongProperty(String s, long l) throws JMSException
    {
        //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setFloatProperty(String s, float v) throws JMSException
    {
        //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setDoubleProperty(String s, double v) throws JMSException
    {
        //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setStringProperty(String s, String s2) throws JMSException
    {
        //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setObjectProperty(String s, Object o) throws JMSException
    {
        //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void acknowledge() throws JMSException
    {
        //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void clearBody() throws JMSException
    {
        //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T> T getBody(Class<T> tClass) throws JMSException
    {
        return null;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isBodyAssignableTo(Class aClass) throws JMSException
    {
        return false;  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }
}
