/*
 *
 */
package com.jonu.jonumq.message;

import java.io.Serializable;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/18/2016
 */
public class JonuMQWireMessage implements Serializable
{
    short clientType;
    short destinationType;
    String destination;
    JonuMQMessageWrapper message;

    public JonuMQWireMessage()
    {

    }

    public JonuMQMessageWrapper getMessage()
    {
        return message;
    }

    public void setMessage(JonuMQMessageWrapper message)
    {
        this.message = message;
    }

    public String getDestination()
    {
        return destination;
    }

    public void setDestination(String destination)
    {
        this.destination = destination;
    }

    public short getDestinationType()
    {
        return destinationType;
    }

    public void setDestinationType(short destinationType)
    {
        this.destinationType = destinationType;
    }

    public short getClientType()
    {
        return clientType;
    }

    public void setClientType(short clientType)
    {
        this.clientType = clientType;
    }
}
