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
public class DestinationResolver
{
    public static JonuMQDestination resolve(DataInput in) throws IOException
    {
        short value = in.readShort();

        return null;
    }
}
