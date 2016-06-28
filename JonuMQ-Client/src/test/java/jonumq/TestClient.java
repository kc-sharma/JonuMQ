/*
 *
 */
package jonumq;

import com.jonu.jonumq.transport.JonuMQConnectionFactory;
import org.junit.Test;

import javax.jms.*;
import java.util.concurrent.CountDownLatch;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/13/2016
 */
public class TestClient
{
    private CountDownLatch latch = new CountDownLatch(1);

    @Test
    public void TestReceiveMessageQueue()
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
            MessageConsumer consumer = session.createConsumer(destination);
            MyMessageListener listener = new MyMessageListener();
            consumer.setMessageListener(listener);
            latch.await();
            // Clean up
            session.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void TestSendMessageToQueue()
    {
        try {
            JonuMQConnectionFactory connectionFactory = new JonuMQConnectionFactory();

            // Create a Connection
            Connection connection = connectionFactory.createConnection();
            //connection.start();

            // Create a Session
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Create the destination (Topic or Queue)
            Destination destination = session.createQueue("TEST.FOO");

            // Create a MessageProducer from the Session to the Topic or Queue
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

            // Create a messages
            String text = "";


            // Tell the producer to send the message
            int i = 1;
            while (true) {
                System.out.println(i);
                TextMessage message = session.createTextMessage(text + i++);
                producer.send(message);
            }

            // Clean up
            //session.close();
            //connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
