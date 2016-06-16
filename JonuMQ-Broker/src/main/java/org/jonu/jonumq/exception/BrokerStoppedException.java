/*
 *
 */
package org.jonu.jonumq.exception;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/15/2016
 */
public class BrokerStoppedException extends Exception
{
    public BrokerStoppedException(String msg)
    {
        super(msg);
    }
}
