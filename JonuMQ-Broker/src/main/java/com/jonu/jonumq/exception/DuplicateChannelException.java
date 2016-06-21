package com.jonu.jonumq.exception;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/10/2016
 */
public class DuplicateChannelException extends ExceptionInInitializerError
{
    public DuplicateChannelException(String msg)
    {
        super(msg);
    }
}
