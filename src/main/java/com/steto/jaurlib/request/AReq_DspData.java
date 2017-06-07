package com.steto.jaurlib.request;

import com.steto.jaurlib.modbus.MB_code;
import com.steto.jaurlib.response.AuroraResponse;
import com.steto.jaurlib.response.AuroraResponseBuilder;

/**
 * Created by sbrega on 02/12/2014.
 */
public class AReq_DspData  extends AuroraRequest {


    @Override
    public AuroraResponse create(AuroraResponseBuilder factory) {
        return factory.createResponse(this);
    }

    public AReq_DspData(MB_code code) {
        super(code);

    }

    public AuroraDspRequestEnum getType() {
        return AuroraDspRequestEnum.fromCode(getParam1());
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()+"-"+getType();
    }
}
