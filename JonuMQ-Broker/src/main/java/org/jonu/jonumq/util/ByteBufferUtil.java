/*
 *
 */
package org.jonu.jonumq.util;

import java.nio.ByteBuffer;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/16/2016
 */
public class ByteBufferUtil
{
    public static short readShort(ByteBuffer bf)
    {
        return bf.getShort();
    }

    public static int readInt(ByteBuffer bf)
    {
        return bf.getInt();
    }
}
