package com.steto.jaurlib.inverter.driver.unit.response;

import com.steto.jaurlib.modbus.MB_code;
import com.steto.jaurlib.response.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

/**
 * Created by sbrega on 20/11/2014.
 */
public class TestAuroraResponseSerialization {

    private static final int BUFFER_SIZE = 1024;


    @Test
    public void shouldSerializeDeserialize_AResp_VersionId() throws Exception {
        //setup

        byte[] rawMsg = {0x3A, 0x00, 0x31, 0x49, 0x54, 0x4E, (byte) 0x9D, (byte) 0xCC};
        ByteArrayOutputStream output = new ByteArrayOutputStream(BUFFER_SIZE);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(rawMsg);


        AResp_VersionId respVersionId = new AResp_VersionId(new MB_code(0x3a));
        respVersionId.setParam1('1');
        respVersionId.setParam2('I');
        respVersionId.setParam3('T');
        respVersionId.setParam4('N');
        respVersionId.setDescription("Inverter Info:");
        System.out.println(respVersionId.toString());
        AuroraResponsePacket arPacket = new AuroraResponsePacket(respVersionId);

        // serialization
        arPacket.write(output);
        // deserialization
        AuroraResponsePacket arPacket_read  = new AuroraResponsePacket(new AResp_VersionId());
        arPacket_read.read(inputStream);

        // verify
        assertTrue(arPacket_read.getPdu() instanceof AResp_VersionId);
        assertArrayEquals(rawMsg, output.toByteArray());

    }

    @Test
    public void shouldDeserialize_AResp_DspData() throws Exception {
        //setup

        byte[] rawMsg = {0x3B, 0x00, 0x42, 0x44, 0x00, 0x00, (byte) 0xAC, (byte) 0x57};
        ByteArrayOutputStream output = new ByteArrayOutputStream(BUFFER_SIZE);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(rawMsg);

        AResp_DspData resp_DspData = new AResp_DspData();

        // deserialization
        AuroraResponsePacket arPacket_read  = new AuroraResponsePacket(resp_DspData);
        arPacket_read.read(inputStream);

        // verify
        assertTrue(arPacket_read.getPdu() instanceof AResp_DspData);
      //  float val=((AResp_DspData) arPacket_read.getPdu()).getParam1();
      //  assertEquals(49,val);
        Assert.assertArrayEquals(rawMsg, arPacket_read.toByteArray());

    }

    @Test
    public void shouldSerialize_AResp_DspData() throws Exception {
        //setup

        byte[] rawMsg = {0x00, 0x00, 0x42, 0x44, 0x00, 0x00, (byte) 0x59, (byte) 0xBD};
        ByteArrayOutputStream output = new ByteArrayOutputStream(BUFFER_SIZE);

        AResp_DspData resp_DspData = new AResp_DspData();
        resp_DspData.setFloatParam(49);

        // deserialization
        AuroraResponsePacket arPacket  = new AuroraResponsePacket(resp_DspData);
        arPacket.write(output);

        // verify

        assertArrayEquals(output.toByteArray(),rawMsg);

    }

    @Test
    public void shouldSerializeAResp_State() throws Exception {
        //setup

        byte[] rawMsg = {0x00, 0x10, 0x01, 0x02, 0x03, 0x04, (byte) 0x80, (byte) 0x86};
        ByteArrayOutputStream output = new ByteArrayOutputStream(BUFFER_SIZE);

        AResp_State respState = new AResp_State();
        char param1 = 1;
        char param2 = 2;
        char param3 = 3;
        char param4 = 4;

        respState.setGlobalState((char) 0x10);
        respState.setInverterState(param1);
        respState.setCh1DcDcState(param2);
        respState.setCh2DcDcState(param3);
        respState.setAlarmState(param4);

        // deserialization
        AuroraResponsePacket arPacket  = new AuroraResponsePacket(respState);
        arPacket.write(output);

        // verify

        assertArrayEquals(output.toByteArray(),rawMsg);

    }

    @Test
    public void shouldDeserializeAResp_State() throws Exception {
        //setup

        byte[] rawMsg = {0x32, 0x01, 0x12, 0x13, 0x14, 0x15, (byte) 0xB6, (byte) 0x16};
        ByteArrayInputStream inputStream = new ByteArrayInputStream(rawMsg);

        AResp_State resp_State = new AResp_State();

        // deserialization
        AuroraResponsePacket arPacket_read  = new AuroraResponsePacket(resp_State);
        arPacket_read.read(inputStream);

        // verify
        assertTrue(arPacket_read.getPdu() instanceof AResp_State);
        AResp_State readState= (AResp_State) arPacket_read.getPdu();

        assertEquals(readState.getGlobalState(), 1);
        assertEquals(readState.getInverterState(), 0x12);
        assertEquals(readState.getCh1DcDcState(), 0x13);
        assertEquals(readState.getCh2DcDcState(), 0x14);
        assertEquals(readState.getAlarmState(), 0x15);

    }



    @Test
    public void shouldSerializeAResp_FwVersion() throws Exception {
        //setup

        byte[] rawMsg = {0x00, 0x00, '4', '2', 0x00, 0x00, (byte) 0x87, (byte) 0xFA};
        ByteArrayOutputStream output = new ByteArrayOutputStream(BUFFER_SIZE);

        AResp_FwVersion respState = new AResp_FwVersion();

        respState.set("42");

        // deserialization
        AuroraResponsePacket arPacket  = new AuroraResponsePacket(respState);
        arPacket.write(output);

        // verify
        assertArrayEquals(output.toByteArray(),rawMsg);

    }

    @Test
    public void shouldDeserializeAResp_FwVersion() throws Exception {
        //setup

        byte[] rawMsg = {0x72, 0x00, '1', '0', '2', '6', (byte) 0x98, (byte) 0x3D};

        ByteArrayInputStream inputStream = new ByteArrayInputStream(rawMsg);

        AResp_FwVersion resp_FwVersion = new AResp_FwVersion();

        // deserialization
        AuroraResponsePacket arPacket_read  = new AuroraResponsePacket(resp_FwVersion);
        arPacket_read.read(inputStream);

        // verify
        assertTrue(arPacket_read.getPdu() instanceof AResp_FwVersion);
        AResp_FwVersion readState= (AResp_FwVersion) arPacket_read.getPdu();

        assertEquals(readState.get(), "1.0.2.6");

    }


}
