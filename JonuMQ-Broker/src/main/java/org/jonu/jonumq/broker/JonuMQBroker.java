
package org.jonu.jonumq.broker;

import org.jonu.jonumq.channel.ChannelExecutor;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/9/2016
 */
public class JonuMQBroker
{

    private static JonuMQBroker jonuMQBroker = null;
    private ChannelExecutor channelExecutor;

    private JonuMQBroker()
    {

    }

    private void igniteBroker()
    {
        jonuMQBroker = new JonuMQBroker();
        channelExecutor = ChannelExecutor.getChannelExecutor();
    }

    public static JonuMQBroker getBroker()
    {
        if (jonuMQBroker == null) {
            throw new NullPointerException("Broker is not ignited");
        }
        return jonuMQBroker;
    }

    public void shutDownBroker()
    {
        jonuMQBroker = null;
    }
}
