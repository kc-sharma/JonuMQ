/*
 *
 */
package com.jonu.jonumq;

import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/21/2016
 */
public class JonuMQListener
{
    MessageListener listener;

    public JonuMQListener(MessageListener listener)
    {
        this.listener = listener;
    }

    public void onMessage(Message message)
    {
        listener.onMessage(message);
    }
}
