package com.steto.jaurlib.inverter.driver.unit.response;

import com.steto.jaurlib.AuroraDriver;
import com.steto.jaurlib.request.AuroraRequestFactory;
import com.steto.jaurlib.response.AResp_State;
import com.steto.jaurlib.response.AuroraResponse;
import com.steto.jaurlib.response.AuroraResponseFactory;
import com.steto.jaurlib.response.ResponseErrorEnum;
import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortTimeoutException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

/**
 * Created by stefano on 26/12/14.
 */
@RunWith(MockitoJUnitRunner.class)
public class TestResponseError {


    String serialPort1 = "/dev/ttys001";
    String serialPort2 = "/dev/ttys002";

    @Mock
    private SerialPort serialPort;


    @InjectMocks
    private AuroraDriver auroraDriver = new AuroraDriver(serialPort, new AuroraRequestFactory(), new AuroraResponseFactory());


    @Before
    public void before() throws InterruptedException, ParseException, SerialPortException, SerialPortTimeoutException {


        auroraDriver.initSerialPort();


    }

    @Test
    public void shouldGenerateCRCErrorCode() throws Exception {

        byte[] rawMsg = {0x02, 0x32, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, (byte) 0xAA, (byte) 0xBB};

        when(serialPort.readBytes(anyInt())).thenReturn(rawMsg);
        when(serialPort.readBytes(anyInt(), anyInt())).thenReturn(rawMsg);

        // exercise
        AuroraResponse response = auroraDriver.acquireState(1);

        // verify
        assertTrue(response instanceof AResp_State);
        assertEquals(ResponseErrorEnum.CRC, response.getErrorCode());


    }

    @Test
    public void shouldGenerateTimeoutError() throws Exception {

        byte[] rawMsg = {0x02, 0x32, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, (byte) 0xAA, (byte) 0xBB};

        when(serialPort.readBytes(anyInt())).thenReturn(rawMsg);
        when(serialPort.readBytes(anyInt(), anyInt())).thenThrow(new SerialPortTimeoutException(serialPort1, "method", 1000));

        // exercise
        AuroraResponse response = auroraDriver.acquireState(1);

        // verify
        assertTrue(response instanceof AResp_State);
        assertEquals(ResponseErrorEnum.TIMEOUT, response.getErrorCode());


    }

}
