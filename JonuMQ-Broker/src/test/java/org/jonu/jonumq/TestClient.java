/*
 *
 */
package org.jonu.jonumq;

import org.jonu.jonumq.broker.JonuMQBroker;
import org.jonu.jonumq.transport.JonuMQConnectionFactory;
import org.junit.Test;

import javax.jms.*;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/13/2016
 */
public class TestClient
{
    @Test
    public void igniteBroker()
    {
        try {

            JonuMQBroker.igniteBroker("localhost", 2056);
            JonuMQBroker.start();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }

    }

    @Test
    public void TestMe()
    {
        try {
            JonuMQConnectionFactory connectionFactory = new JonuMQConnectionFactory();

            // Create a Connection
            Connection connection = connectionFactory.createConnection();
            connection.start();

            // Create a Session
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Create the destination (Topic or Queue)
            Destination destination = session.createQueue("TEST.FOO");

            // Create a MessageProducer from the Session to the Topic or Queue
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

            // Create a messages
            String text = "Hello world! From: " + Thread.currentThread().getName() + " : " + this.hashCode();
            TextMessage message = session.createTextMessage(text);

            // Tell the producer to send the message
            System.out.println("Sent message: " + message.hashCode() + " : " + Thread.currentThread().getName());
            producer.send(message);

            // Clean up
            session.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
