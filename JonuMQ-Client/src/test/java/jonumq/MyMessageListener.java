/*
 *
 */
package jonumq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/23/2016
 */
public class MyMessageListener implements MessageListener
{
    static int actual = 1;
    static long start;

    @Override
    public void onMessage(Message message)
    {
        if (actual == 1) {
            start = System.currentTimeMillis();
        }
        if (message instanceof TextMessage) {

            TextMessage textMessage = (TextMessage) message;

            try {
                String text = textMessage.getText();
                int received = Integer.parseInt(text);
                if (actual != received) {
                    //System.out.println("Messages out of sync Actual: " + actual + "  but received: " + received);
                }
                if (actual % 100000 == 0) {
                    long elapsed = (System.currentTimeMillis() - start);
                    //System.out.println("Message received " + actual + "  in " + elapsed + " ms or " + elapsed / 1000 + " sec");
                    //start = System.currentTimeMillis();
                }
                System.out.println(received);
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }

        actual++;
    }
}
