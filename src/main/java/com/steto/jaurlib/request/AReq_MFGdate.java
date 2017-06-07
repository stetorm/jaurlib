package com.steto.jaurlib.request;

import com.steto.jaurlib.modbus.MB_code;
import com.steto.jaurlib.response.AuroraResponse;
import com.steto.jaurlib.response.AuroraResponseBuilder;

/**
 * Created by stefano on 08/12/14.
 */
public class AReq_MFGdate extends AuroraRequest {
    public AReq_MFGdate(MB_code code) {
        super(code);
    }

    @Override
    public AuroraResponse create(AuroraResponseBuilder inverter) {
        return inverter.createResponse(this);
    }


}
