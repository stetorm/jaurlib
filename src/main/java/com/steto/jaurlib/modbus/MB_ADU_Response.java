package com.steto.jaurlib.modbus;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by stefano on 22/11/14.
 */
public class MB_ADU_Response extends MB_ADU {


    public MB_ADU_Response(MB_PDU pdu) {


        this.pdu = pdu;
        this.crc = new MB_CRC(pdu);
    }


    public int read(InputStream in) throws IOException {
        crc = new MB_CRC();
        int nbytes =pdu.read(in);
        nbytes += crc.read(in);

        try {
            checkCrc(crc);
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }

        return nbytes;
    }

    public void write(OutputStream out) throws IOException {

        pdu.write(out);
        crc.write(out);


    }

    protected void checkCrc(MB_CRC otherCrc) throws Exception {


        MB_CRC computedCrc = computeCrc();
        if (computedCrc.val.get() != otherCrc.val.get()) {
            throw new Exception("CRC Error");
        }
    }

    @Override
    protected MB_CRC computeCrc() {
        return new MB_CRC(pdu);
    }
}

