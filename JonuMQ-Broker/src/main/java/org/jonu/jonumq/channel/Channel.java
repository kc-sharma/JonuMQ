
package org.jonu.jonumq.channel;

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
    private List<JonuMQTextMessage> listOfJonuMQTextMessages;
    private int messageCount;

    public Channel()
    {
        this.listOfJonuMQTextMessages = new ArrayList<JonuMQTextMessage>();
    }

    public List<JonuMQTextMessage> getListOfJonuMQTextMessages()
    {
        return listOfJonuMQTextMessages;
    }

    public void setListOfJonuMQTextMessages(List<JonuMQTextMessage> listOfJonuMQTextMessages)
    {
        this.listOfJonuMQTextMessages = listOfJonuMQTextMessages;
    }

    public void addMessage(JonuMQTextMessage jonuMQTextMessage)
    {
        if (jonuMQTextMessage == null) {
            throw new NullPointerException("Message object can't be null");
        }
        this.listOfJonuMQTextMessages.add(messageCount, jonuMQTextMessage);
        messageCount++;
    }

    public JonuMQTextMessage getFirstMessage()
    {
        if (!listOfJonuMQTextMessages.isEmpty()) {
            messageCount--;
            return listOfJonuMQTextMessages.remove(0);
        }

        return null;
    }
}
