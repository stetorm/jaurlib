package com.steto.jaurlib.request;


import com.steto.jaurlib.modbus.MB_code;
import com.steto.jaurlib.response.AuroraResponse;
import com.steto.jaurlib.response.AuroraResponseBuilder;

/**
 * Created by stefano on 22/11/14.
 */
public class AReq_VersionId extends AuroraRequest {


    @Override
    public AuroraResponse create(AuroraResponseBuilder inverter) {
        return inverter.createResponse(this);
    }

    public AReq_VersionId(MB_code code) {
              super(code);
              setParam1('.');

    }
}
