/*
 *
 */
package org.jonu.jonumq.client;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/15/2016
 */
public interface ClientTypeHandler
{
    public void doProcess(DataInput in, DataOutput out) throws IOException;
}
