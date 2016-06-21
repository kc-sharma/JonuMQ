/*
 *
 */
package com.jonu.jonumq.marshaller;

import com.jonu.jonumq.JonuMQMessageWrapper;

import java.io.DataInput;
import java.io.DataOutput;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/14/2016
 */
public class JonuMQTextMessageMarshaller extends JonuMQMessageMarshaller implements JonuMQMarshaller
{
    public void marshall(JonuMQMessageWrapper message, DataOutput out)
    {
        super.marshall(message, out);
    }

    public void unmarshall(JonuMQMessageWrapper message, DataInput in)
    {

    }
}
