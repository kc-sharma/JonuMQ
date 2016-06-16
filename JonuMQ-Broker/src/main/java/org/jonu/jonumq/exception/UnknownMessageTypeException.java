/*
 *
 */
package org.jonu.jonumq.exception;

import java.util.UnknownFormatFlagsException;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/15/2016
 */
public class UnknownMessageTypeException extends UnknownFormatFlagsException
{
    public UnknownMessageTypeException(String msg)
    {
        super(msg);
    }
}
