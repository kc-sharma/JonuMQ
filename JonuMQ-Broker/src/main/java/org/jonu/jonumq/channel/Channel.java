package org.jonu.jonumq.channel;

import org.jonu.jonumq.JonuMQMessage;
import org.jonu.jonumq.JonuMQTextMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/9/2016
 */
public class Channel
{
    private List<JonuMQMessage> listOfMessages;
    private int messageCount;

    public Channel()
    {
        this.listOfMessages = new ArrayList<JonuMQMessage>();
    }

    public List<JonuMQMessage> getListOfMessages()
    {
        return listOfMessages;
    }

    public void setListOfMessages(List<JonuMQMessage> listOfMessages)
    {
        this.listOfMessages = listOfMessages;
    }

    public void addMessage(JonuMQTextMessage jonuMQTextMessage)
    {
        if (jonuMQTextMessage == null) {
            throw new NullPointerException("Message object can't be null");
        }
        this.listOfMessages.add(messageCount, jonuMQTextMessage);
        messageCount++;
    }

    public JonuMQMessage getFirstMessage()
    {
        if (!listOfMessages.isEmpty()) {
            messageCount--;
            return listOfMessages.remove(0);
        }

        return null;
    }
}
