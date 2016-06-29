/*
 *
 */
package com.jonu.jonumq.broker;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/13/2016
 */
public class BrokerStartHelper extends Thread
{
    public static void main(String[] args) throws Exception
    {
        try {
            JonuMQBroker.igniteBroker("localhost", 2056);
            JonuMQBroker.start();
        } finally {
        }

    }
}
