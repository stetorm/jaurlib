package com.steto.jaurlib.request;

/**
 * Created by sbrega on 19/11/2014.
 */
public enum AuroraRequestCodeEnum {


    GETSTATE(50),
    GETPRODUCTNUMBER(52),
    GETSERIALNUMBER(63),
    GETVERSIONID(58),
    GETDSP(59),
    GETACTUALTIME(70),
    GETFWVERSION(72),
    GETSYSTEMCONFIG(77),
    GETACCUMULATEDENERGY(78),
    GETMFGDATE(65),
    GETTIMECOUNTER(80),
    GETLASTALARMS(86);

    public final int value;

    AuroraRequestCodeEnum(int val) {
        value=val;
    }


}