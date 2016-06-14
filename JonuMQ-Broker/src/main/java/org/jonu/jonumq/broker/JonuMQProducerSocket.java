/*
 *
 */
package org.jonu.jonumq.broker;

import java.net.Socket;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/13/2016
 */
public class JonuMQProducerSocket extends JonuMQSocket
{
    public JonuMQProducerSocket()
    {

    }

    public void sendMessage()
    {
        System.out.println("Message sent");
    }
}
