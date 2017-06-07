package com.steto.jaurlib.request;


import com.steto.jaurlib.response.AuroraResponseBuilder;
import com.steto.jaurlib.modbus.MB_code;
import com.steto.jaurlib.response.AuroraResponse;

/**
 * Created by sbrega on 10/12/2014.
 */
public class AReq_TimeCounter extends AuroraRequest{
    public AReq_TimeCounter(MB_code code) {
        super(code);
    }

    @Override
    public AuroraResponse create(AuroraResponseBuilder factory) {
        return factory.createResponse(this);
    }
}
