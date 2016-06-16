package org.jonu.jonumq.broker;

import org.jonu.jonumq.channel.ChannelExecutor;

import java.io.IOException;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/9/2016
 */
public class JonuMQBroker
{

    private static JonuMQBroker jonuMQBroker = null;
    private static ChannelExecutor channelExecutor = null;
    private static String host;
    private static int port;

    private JonuMQBroker()
    {

    }

    private JonuMQBroker(String host, int port)
    {
        this.host = host;
        this.port = port;
    }


    public static void igniteBroker(String host, int port) throws Exception
    {
        if (jonuMQBroker != null || channelExecutor != null) {
            throw new Exception("Broker Already ignited");
        }
        jonuMQBroker = new JonuMQBroker(host, port);
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

    static Server server;

    public static void start()
    {
        try {
            server = new Server(host, port);
            server.start(channelExecutor);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void stop()
    {
        server.setBrokerRunning(false);
    }
}
