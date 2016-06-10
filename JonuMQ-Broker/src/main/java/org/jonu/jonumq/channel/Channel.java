
package org.jonu.jonumq.channel;

import org.jonu.jonumq.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/9/2016
 */
public class Channel
{
    private List<Message> listOfMessages;
    private int messageCount;

    public Channel()
    {
        this.listOfMessages = new ArrayList<Message>();
    }

    public List<Message> getListOfMessages()
    {
        return listOfMessages;
    }

    public void setListOfMessages(List<Message> listOfMessages)
    {
        this.listOfMessages = listOfMessages;
    }

    public void addMessage(Message message)
    {
        if (message == null) {
            throw new NullPointerException("Message object can't be null");
        }
        this.listOfMessages.add(messageCount, message);
        messageCount++;
    }

    public Message getFirstMessage()
    {
        if (!listOfMessages.isEmpty()) {
            messageCount--;
            return listOfMessages.remove(0);
        }

        return null;
    }
}
