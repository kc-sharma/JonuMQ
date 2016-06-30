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

    @Override
    public void onMessage(Message message)
    {
        if (message instanceof TextMessage) {

            TextMessage textMessage = (TextMessage) message;

            try {
                String text = textMessage.getText();
                int received = Integer.parseInt(text);
                if (actual != received) {
                    System.out.println("Messages out of sync Actual: " + actual + "  but received: " + received);
                }
                if (received % 100000 == 0)
                    System.out.println(received);
                //System.out.println(received);
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }

        actual++;
    }
}
