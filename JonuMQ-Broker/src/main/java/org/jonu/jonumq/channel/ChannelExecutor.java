
package org.jonu.jonumq.channel;

import org.jonu.jonumq.exception.DuplicateChannelException;
import org.jonu.jonumq.exception.UnknownDefinedChannel;

import java.util.HashMap;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/9/2016
 */
public class ChannelExecutor
{

    private static ChannelExecutor channelExecutor = new ChannelExecutor();

    static HashMap<String, Channel> channels;

    private ChannelExecutor()
    {
        channels = new HashMap<String, Channel>();
    }

    public static ChannelExecutor getChannelExecutor()
    {
        return channelExecutor;
    }

    public Channel getChannel(String channelName)
    {
        if (channelName != null || channelName.isEmpty()) {
            throw new UnknownDefinedChannel("Channel Name can't be null or empty");
        }
        return channels.get(channelName);
    }

    public void addNewChannel(String channelName)
    {
        checkIfChannelAlreadyExist(channelName);
        channels.put(channelName, new Channel());
    }

    private void checkIfChannelAlreadyExist(String channelName)
    {
        if (channels.containsKey(channelName)) {
            throw new DuplicateChannelException("Channel Already exist with the name " + channelName);
        }
    }
}
