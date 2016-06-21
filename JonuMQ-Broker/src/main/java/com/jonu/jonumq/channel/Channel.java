package com.jonu.jonumq.channel;

import com.jonu.jonumq.JonuMQMessageWrapper;

import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/9/2016
 */
public class Channel
{
    private final Logger logger = Logger.getLogger(Channel.class.getName());
    private volatile List<JonuMQMessageWrapper> listOfMessages;
    private volatile List<ObjectOutputStream> consumerList;
    private volatile int messageCount;
    private volatile ChannelType channelType = null;
    private volatile boolean running = true;
    private final int MAX_MESSAGES = Integer.MAX_VALUE;

    public Channel()
    {
        this.listOfMessages = new ArrayList<JonuMQMessageWrapper>();
        this.consumerList = new ArrayList<ObjectOutputStream>();
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

        haltIfReachedMaxMessage();
        this.listOfMessages.add(jonuMQMessageWrapper);
        messageCount++;
    }

    private void haltIfReachedMaxMessage()
    {
        if (messageCount >= MAX_MESSAGES) {
            logger.log(Level.INFO, "Buffer message queue is full halting producer for a while to send message");
            while (messageCount > MAX_MESSAGES - 10) ;
        }
    }

    public JonuMQMessageWrapper getFirstMessage()
    {
        if (!listOfMessages.isEmpty()) {
            messageCount--;
            return listOfMessages.remove(0);
        }

        return null;
    }

    public void addConsumer(ObjectOutputStream out)
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

    public List<ObjectOutputStream> getConsumerList()
    {
        return consumerList;
    }

    public void setConsumerList(List<ObjectOutputStream> consumerList)
    {
        this.consumerList = consumerList;
    }

    public void removeOutStream(ObjectOutputStream out)
    {
        consumerList.remove(out);
    }
}
