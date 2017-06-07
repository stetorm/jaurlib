package com.steto.jaurlib.request;

import com.steto.jaurlib.modbus.MB_code;
import com.steto.jaurlib.response.AuroraResponseBuilder;
import com.steto.jaurlib.response.AuroraResponse;

/**
 * Created by stefano on 09/12/14.
 */
public class AReq_SerialNumber  extends AuroraRequest {
    public AReq_SerialNumber(MB_code code) {
        super(code);
    }

    @Override
    public AuroraResponse create(AuroraResponseBuilder inverter) {
        return inverter.createResponse(this);
    }
}
