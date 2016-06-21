/*
 *
 */
package com.jonu.jonumq.destination;

import com.jonu.jonumq.JonuMQWireMessage;
import com.jonu.jonumq.exception.DestinationNotFound;

import java.io.IOException;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/16/2016
 */
public class DestinationResolver
{
    final static int DESTINATION_LENGTH = 128; //TODO should go in Configuration

    public static String resolve(JonuMQWireMessage wireMessage) throws IOException
    {
        String destination = wireMessage.getDestination();

        if (destination == null || destination.isEmpty()) {
            throw new DestinationNotFound("Destination Name cannot be null");
        }

        return destination.trim();
    }
}
