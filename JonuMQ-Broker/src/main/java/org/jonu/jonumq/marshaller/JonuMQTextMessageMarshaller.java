/*
 *
 */
package org.jonu.jonumq.marshaller;

import org.jonu.jonumq.JonuMQTextMessage;

import javax.jms.JMSException;
import java.io.DataInput;
import java.io.DataOutput;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/14/2016
 */
public class JonuMQTextMessageMarshaller extends JonuMQMessageMarshaller implements JonuMQMarshaller
{
    public void marshall(JonuMQTextMessage message, DataOutput out)
    {
        super.marshall(message, out);
    }

    public void unmarshall(JonuMQTextMessage message, DataInput in) throws JMSException
    {
        super.unmarshall(message, in);

        StringBuilder msg = new StringBuilder();
        msg.append("Hello Message");
        //TODO write unmarshalling code from IN stream to Message
        message.setText(msg.toString());
    }
}
