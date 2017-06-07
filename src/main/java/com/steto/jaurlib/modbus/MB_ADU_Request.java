package com.steto.jaurlib.modbus;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by stefano on 22/11/14.
 */
public class MB_ADU_Request extends MB_ADU{

    MB_address address = null;

    public MB_ADU_Request(PDUFactory pduFactory)  {
        this.pduFactory=pduFactory;
    }


    public MB_ADU_Request(PDUFactory pduFactory, MB_address mb_address, MB_PDU mb_pdu) {
        this.pduFactory=pduFactory;
        this.address=mb_address;
        this.pdu = mb_pdu;
        this.crc = new MB_CRC(address,pdu);

    }


    public int read(InputStream in) throws IOException {
        address = new MB_address(0);
        crc = new MB_CRC();
        int nbytes =address.read(in);
        pdu =  pduFactory.read(in);
        if (pdu==null)
        {
            throw new IOException("No Class created for input bytes: "+in);
        }
        nbytes += pdu.size();
        nbytes += crc.read(in);

        try {
            checkCrc(crc);
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }

        return nbytes;
    }

    public void write(OutputStream out) throws IOException {

        address.write(out);
        pdu.write(out);
        crc.write(out);


    }


    @Override
    protected MB_CRC computeCrc() {
        MB_CRC crc = new MB_CRC(address,pdu);
        return crc;
    }

}

