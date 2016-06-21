package com.jonu.jonumq.exception;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/9/2016
 */
public class UnknownDefinedChannel extends NullPointerException
{
    public UnknownDefinedChannel(String msg)
    {
        super(msg);
    }
}
