package com.steto.jaurlib.response;

import com.steto.jaurlib.request.AuroraCumEnergyEnum;

import java.io.IOException;

/**
 * Created by sbrega on 11/12/2014.
 */
public class AResp_CumulatedEnergy extends AuroraResponse {
    public void setType(AuroraCumEnergyEnum partial) {
        setParam1((char) partial.get());
    }

    public Long get() {
        try {
            return getLongParam();
        } catch (IOException e) {
            return null;
        }
    }
    @Override
    public String toString() {

        return description.isEmpty() ? super.toString(): description+": "+get();
    }


    @Override
    public String getValue() {
        return Long.toString(get());
    }
}
