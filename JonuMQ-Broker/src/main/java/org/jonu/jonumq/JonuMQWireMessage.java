/*
 *
 */
package org.jonu.jonumq;

import org.jonu.jonumq.marshaller.JonuMQMarshaller;

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
    int destinationLength;
    String destination;
    JonuMQMarshaller marshaller;
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

    public JonuMQMarshaller getMarshaller()
    {
        return marshaller;
    }

    public void setMarshaller(JonuMQMarshaller marshaller)
    {
        this.marshaller = marshaller;
    }

    public String getDestination()
    {
        return destination;
    }

    public void setDestination(String destination)
    {
        this.destination = destination;
    }

    public int getDestinationLength()
    {
        return destinationLength;
    }

    public void setDestinationLength(int destinationLength)
    {
        this.destinationLength = destinationLength;
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
