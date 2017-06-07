package com.steto.jaurlib.inverter.driver.unit.request;

import com.steto.jaurlib.modbus.MB_data;
import com.steto.jaurlib.request.*;
import com.steto.jaurlib.modbus.MB_address;
import javolution.io.Struct;
import org.junit.Test;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created by sbrega on 18/11/2014.
 */
public class TestRequestSerialization {

    private static final int BUFFER_SIZE = 1024;
    private MB_data data;

    private void assertStructEquals(Struct a, Struct b) throws IOException {
        boolean equals = false;

        OutputStream aOutputStream = new ByteArrayOutputStream();
        OutputStream bOutputStream = new ByteArrayOutputStream();
        a.write(aOutputStream);
        aOutputStream.flush();
        b.write(bOutputStream);
        bOutputStream.flush();

        byte[] aMessageBuffer = ((ByteArrayOutputStream) aOutputStream).toByteArray();
        byte[] bMessageBuffer = ((ByteArrayOutputStream) bOutputStream).toByteArray();

        assertArrayEquals(aMessageBuffer,bMessageBuffer);

    }



    @Test
    public void shouldSerializeDeserializeAuraraRequestPacketWith_AR_VersionId() throws Exception {
        //setup

        byte[] rawMsg = {0x01,0x3A, '.', 0x00, 0x00, 0x00, 0x00, 0x00, (byte) 0x13, (byte) 0x81};
        ByteArrayOutputStream output = new ByteArrayOutputStream(BUFFER_SIZE);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(rawMsg);

        AuroraRequestFactory auroraInverterRequestFactory = new AuroraRequestFactory();
        AuroraRequest pduToWrite = auroraInverterRequestFactory.createAReq_VersionId();

        AuroraRequestPacket arPacket = new AuroraRequestPacket( new MB_address(1),pduToWrite);

        // serialization
        arPacket.write(output);
        // deserialization
        AuroraRequestPacket arPacket_read  = new AuroraRequestPacket();
        arPacket_read.read(inputStream);

        // verify
        assertTrue(arPacket_read.getPdu() instanceof AReq_VersionId);
        assertArrayEquals(rawMsg, output.toByteArray());

    }

    @Test
    public void shouldSerializeDeserializeAuraraRequestPacketWith_AReq_State() throws Exception {
        //setup

        byte[] rawMsg = {0x02,0x32, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, (byte) 0xED, (byte) 0x69};
        ByteArrayOutputStream output = new ByteArrayOutputStream(BUFFER_SIZE);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(rawMsg);

        AuroraRequestFactory auroraInverterRequestFactory = new AuroraRequestFactory();
        AuroraRequest pduToWrite = auroraInverterRequestFactory.createAReq_State();

        AuroraRequestPacket arPacket = new AuroraRequestPacket( new MB_address(2),pduToWrite);

        // serialization
        arPacket.write(output);
        // deserialization
        AuroraRequestPacket arPacket_read  = new AuroraRequestPacket();
        arPacket_read.read(inputStream);

        // verify
        assertTrue(arPacket_read.getPdu() instanceof AReq_State);
        assertArrayEquals(rawMsg, output.toByteArray());

    }

    @Test
    public void shouldSerializeDeserializeAuraraRequestPacketWith_AReq_FwVersion() throws Exception {
        //setup

        byte[] rawMsg = {0x02,0x48, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, (byte) 0xf6, (byte) 0x91};
        ByteArrayOutputStream output = new ByteArrayOutputStream(BUFFER_SIZE);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(rawMsg);

        AuroraRequestFactory auroraInverterRequestFactory = new AuroraRequestFactory();
        AuroraRequest pduToWrite = auroraInverterRequestFactory.createAReq_FwVersion();

        AuroraRequestPacket arPacket = new AuroraRequestPacket( new MB_address(2),pduToWrite);

        // serialization
        arPacket.write(output);
        // deserialization
        AuroraRequestPacket arPacket_read  = new AuroraRequestPacket();
        arPacket_read.read(inputStream);

        // verify
        assertTrue(arPacket_read.getPdu() instanceof AReq_FwVersion);
        assertArrayEquals(rawMsg, output.toByteArray());

    }


}
