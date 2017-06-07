package com.steto.jaurlib.response;

/**
 * Created by sbrega on 02/12/2014.
 */


public class AResp_DspData extends AuroraResponse{


    @Override
    public String getValue() {
        return String.valueOf(getFloatParam());
    }

    public AResp_DspData() {
        super();

    }
    @Override
    public String toString() {

        return description.isEmpty() ? super.toString(): description+": "+this.getFloatParam();
    }



}