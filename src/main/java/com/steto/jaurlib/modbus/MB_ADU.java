package com.steto.jaurlib.modbus;

/**
 * Created by stefano on 22/11/14.
 */
public  abstract class MB_ADU extends MB_Struct {

    MB_PDU pdu = null;
    MB_CRC crc = null;

    PDUFactory pduFactory = null;


    protected void checkCrc(MB_CRC otherCrc) throws Exception {


        if (computeCrc().getValue() != otherCrc.val.get()) {
            throw new Exception("CRC Error");
        }
    }

    protected abstract MB_CRC computeCrc();

    public  MB_PDU getPdu()
    {
        return pdu;
    }


}

