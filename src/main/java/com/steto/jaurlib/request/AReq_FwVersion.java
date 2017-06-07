package com.steto.jaurlib.request;

import com.steto.jaurlib.modbus.MB_code;
import com.steto.jaurlib.response.AuroraResponse;
import com.steto.jaurlib.response.AuroraResponseBuilder;

/**
 * Created by stefano on 07/12/14.
 */
public class AReq_FwVersion extends AuroraRequest {

    @Override
    public AuroraResponse create(AuroraResponseBuilder inverter) {
        return inverter.createResponse(this);
    }

    public AReq_FwVersion(MB_code code) {
        super(code);

    }
}
