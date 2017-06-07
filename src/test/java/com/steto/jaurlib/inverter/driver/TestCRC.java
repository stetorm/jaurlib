package com.steto.jaurlib.inverter.driver;

import com.steto.jaurlib.modbus.MB_CRC;
import com.steto.jaurlib.modbus.MB_Struct;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by stefano on 19/11/14.
 */
public class TestCRC {

    @Test
    public void shouldComputeCRCofByteArray()
    {
        byte[] testBuff= {0x11, 0x22, 0x33, 0x44, 0x55, 0x66, 0x77, (byte) 0x88, (byte) 0x99, (byte) 0xAA, (byte) 0xBB, (byte) 0xCC};
        MB_CRC crc = new MB_CRC(testBuff);
        assertEquals(0x8F51,crc.val.get());


    }


    @Test
    public void should() {
        class Address extends MB_Struct {
            Unsigned8 val = new Unsigned8();
            Address()
            {
             val.set((short) 0x01);
            }
        }

        class Body extends MB_Struct {
            Unsigned16 val = new Unsigned16();
            Body()
            {
                val.set((short) 0x0A02);
            }
        }


        byte[] testBuff1= {0x01};
        // in formato little endian
        byte[] testBuff2= {0x01, 0x02, 0x0A};
        MB_CRC crc_byte_array1 = new MB_CRC(testBuff1);
        MB_CRC crc_byte_array2 = new MB_CRC(testBuff2);

        MB_CRC mb_crc1 = new MB_CRC(new Address());
        MB_CRC mb_crc2 = new MB_CRC(new Address(),new Body());

        assertEquals(crc_byte_array1.getValue(), mb_crc1.getValue());
        assertEquals(crc_byte_array2.getValue(), mb_crc2.getValue());


    }


}