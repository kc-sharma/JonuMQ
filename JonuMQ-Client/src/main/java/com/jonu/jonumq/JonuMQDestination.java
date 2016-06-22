/*
 *
 */
package com.jonu.jonumq;

import javax.jms.Destination;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/21/2016
 */
public class JonuMQDestination implements Destination
{
    private String destinationName;

    public JonuMQDestination(String destinationName)
    {
        this.destinationName = destinationName;
    }

    public String getDestinationName()
    {
        return destinationName;
    }

    public void setDestinationName(String destinationName)
    {
        this.destinationName = destinationName;
    }
}
