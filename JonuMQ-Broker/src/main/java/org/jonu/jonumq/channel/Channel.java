package org.jonu.jonumq.channel;

import org.jonu.jonumq.JonuMQMessageWrapper;

import java.io.DataOutput;
import java.util.ArrayList;
import java.util.List;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/9/2016
 */
public class Channel
{
    private List<JonuMQMessageWrapper> listOfMessages;
    private List<DataOutput> consumerList;
    private int messageCount;
    private ChannelType channelType = null;
    private boolean running = true;

    public Channel()
    {
        this.listOfMessages = new ArrayList<JonuMQMessageWrapper>();
        this.consumerList = new ArrayList<DataOutput>();
    }

    public List<JonuMQMessageWrapper> getListOfMessages()
    {
        return listOfMessages;
    }

    public void setListOfMessages(List<JonuMQMessageWrapper> listOfMessages)
    {
        this.listOfMessages = listOfMessages;
    }

    public void addMessage(JonuMQMessageWrapper jonuMQMessageWrapper)
    {
        if (jonuMQMessageWrapper == null) {
            throw new NullPointerException("Message object can't be null");
        }
        this.listOfMessages.add(messageCount, jonuMQMessageWrapper);
        messageCount++;
    }

    public JonuMQMessageWrapper getFirstMessage()
    {
        if (!listOfMessages.isEmpty()) {
            messageCount--;
            return listOfMessages.remove(0);
        }

        return null;
    }

    public void addConsumer(DataOutput out)
    {
        consumerList.add(out);
    }

    public ChannelType getChannelType()
    {
        return channelType;
    }

    public void setChannelType(ChannelType channelType)
    {
        this.channelType = channelType;
    }

    public boolean isRunning()
    {
        return running;
    }

    public void setRunning(boolean running)
    {
        this.running = running;
    }

    public int getMessageCount()
    {
        return messageCount;
    }

    public void setMessageCount(int messageCount)
    {
        this.messageCount = messageCount;
    }

    public List<DataOutput> getConsumerList()
    {
        return consumerList;
    }

    public void setConsumerList(List<DataOutput> consumerList)
    {
        this.consumerList = consumerList;
    }
}
