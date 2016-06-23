/*
 *
 */
package com.jonu.jonumq.message;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/21/2016
 */
public class JonuMQTextMessage extends JonuMQMessage implements TextMessage
{
    private String text;

    public JonuMQTextMessage()
    {

    }

    public JonuMQTextMessage(String s)
    {
        this.text = s;
    }

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
