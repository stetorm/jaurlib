package com.steto.jaurlib.request;

import com.steto.jaurlib.modbus.MB_code;
import com.steto.jaurlib.response.AuroraResponse;
import com.steto.jaurlib.response.AuroraResponseBuilder;

/**
 * Created by sbrega on 11/12/2014.
 */
public class AReq_CumulatedEnergy extends AuroraRequest {
    public AReq_CumulatedEnergy(MB_code code) {
        super(code);
    }

    @Override
    public AuroraResponse create(AuroraResponseBuilder factory) {
        return factory.createResponse(this);
    }

    public AuroraCumEnergyEnum getType() {
        return AuroraCumEnergyEnum.fromCode(getParam1());
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()+"-"+getType();
    }
}
