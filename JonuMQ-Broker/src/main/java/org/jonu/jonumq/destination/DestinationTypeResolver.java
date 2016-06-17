/*
 *
 */
package org.jonu.jonumq.destination;

import java.io.DataInput;
import java.io.IOException;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/16/2016
 */
public class DestinationTypeResolver
{
    static JonuMQDestinationType[] destinations;

    static {
        destinations = new JonuMQDestinationType[3];
        destinations[1] = new JonuMQQueueDestinationType();
        destinations[2] = new JonuMQTopicDestinationType();
    }

    public static JonuMQDestinationType resolve(DataInput in) throws IOException
    {
        short value = in.readShort();
        if (value < 1) {
            throw new NullPointerException("Unrecognised value at input stream");
        }
        try {
            return destinations[value];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException("Unknown Destination type" + e);
        }
    }
}
