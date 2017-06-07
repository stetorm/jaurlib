package com.steto.jaurlib.request;

import com.steto.jaurlib.modbus.MB_ADU_Request;
import com.steto.jaurlib.modbus.MB_PDU;
import com.steto.jaurlib.modbus.MB_address;
import com.steto.jaurlib.modbus.PDUFactory;

/**
 * Created by sbrega on 26/11/2014.
 */
public class AuroraRequestPacket extends MB_ADU_Request {

    static final PDUFactory factory = new AuroraRequestFactory();

    public AuroraRequestPacket(MB_address mb_address, MB_PDU pdu) {
        super(factory, mb_address, pdu);

    }


    public AuroraRequestPacket()  {
       super(factory);

    }
}
