/*
 *
 */
package org.jonu.jonumq.consumer;

import org.jonu.jonumq.channel.Channel;

import java.io.IOException;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/17/2016
 */
public interface Consumer
{
    public void doProcess(Channel channel) throws IOException;
}
