/*
 *
 */
package org.jonu.jonumq.marshaller;

import org.jonu.jonumq.JonuMQTextMessage;

import java.io.DataInput;
import java.io.DataOutput;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/14/2016
 */
public class JonuMQTextMessageJonuMQMarshaller extends JonuMQMessageMarshaller implements JonuMQMarshaller
{
    public void marshall(JonuMQTextMessage message, DataOutput out)
    {

    }

    public void unmarshall(JonuMQTextMessage message, DataInput in)
    {
        super.unmarshall(message, in);
    }
}
