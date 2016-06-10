
package org.jonu.jonumq;

/**
 * @author prabhato
 * @version $Revision$, $Date$, $Author$
 * @since 6/10/2016
 */
public class Message
{
    int messageId;
    byte[] data;

    public int getMessageId()
    {
        return messageId;
    }

    public void setMessageId(int messageId)
    {
        this.messageId = messageId;
    }

    public byte[] getData()
    {
        return data;
    }

    public void setData(byte[] data)
    {
        this.data = data;
    }
}
