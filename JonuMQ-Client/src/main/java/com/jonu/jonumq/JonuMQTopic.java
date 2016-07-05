/*
 *
 */
package com.jonu.jonumq;

import javax.jms.JMSException;
import javax.jms.Topic;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 7/5/2016
 */
public class JonuMQTopic extends JonuMQDestination implements Topic
{
    public JonuMQTopic(String destinationName)
    {
        super(destinationName);
    }

    @Override
    public String getTopicName() throws JMSException
    {
        return super.getDestinationName();  //$REVIEW$ To change body of implemented methods use File | Settings | File Templates.
    }
}
