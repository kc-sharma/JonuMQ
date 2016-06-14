package org.jonu.jonumq;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/10/2016
 */
public class JonuMQTextMessage extends JonuMQMessage implements TextMessage
{
    String text;

    @Override
    public void setText(String s) throws JMSException
    {
        this.text = s;
    }

    @Override
    public String getText() throws JMSException
    {
        return text;
    }
}
