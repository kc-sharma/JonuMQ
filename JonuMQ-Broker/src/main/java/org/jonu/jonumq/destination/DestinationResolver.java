/*
 *
 */
package org.jonu.jonumq.destination;

import org.jonu.jonumq.exception.DestinationNotFound;

import java.io.DataInput;
import java.io.IOException;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/16/2016
 */
public class DestinationResolver
{
    final static int DESTINATION_LENGTH = 128; //TODO should go in Configuration

    public static String resolve(DataInput in) throws IOException
    {
        byte[] bytes = new byte[DESTINATION_LENGTH];
        in.readFully(bytes, 1, DESTINATION_LENGTH);
        String destination = new String(bytes).trim();

        if (destination == null || destination.isEmpty()) {
            throw new DestinationNotFound("Destination Name cannot be null");
        }

        return destination.trim();
    }
}
