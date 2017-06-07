package com.steto.jaurlib.request;

import com.steto.jaurlib.modbus.MB_code;
import com.steto.jaurlib.response.AuroraResponse;
import com.steto.jaurlib.response.AuroraResponseBuilder;

/**
 * Created by sbrega on 09/12/2014.
 */
public class AReq_SystemConfig extends AuroraRequest {
    public AReq_SystemConfig(MB_code code) {
        super(code);
    }

    @Override
    public AuroraResponse create(AuroraResponseBuilder inverter) {
        return inverter.createResponse(this);
    }
}
