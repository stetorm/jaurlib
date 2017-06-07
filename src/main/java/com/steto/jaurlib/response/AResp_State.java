package com.steto.jaurlib.response;

/**
 * Created by stefano on 07/12/14.
 */
public class AResp_State  extends AuroraResponse {

    public AResp_State() {
        super();

    }


    public void setGlobalState(char val) {
        setSubCode(val);
    }

    public void setInverterState(char val) {
        setParam1(val);

    }

    public void setCh1DcDcState(char val) {
        setParam2(val);

    }

    public void setCh2DcDcState(char val) {
        setParam3(val);

    }

    public void setAlarmState(char val) {
        setParam4(val);
    }

    public char getGlobalState() {
        return getSubCode();
    }

    public char getInverterState() {
        return getParam1();
    }

    public char getCh1DcDcState() {
        return getParam2();
    }

    public char getCh2DcDcState() {
        return getParam3();
    }

    public char getAlarmState() {
        return getParam4();
    }

    @Override
    public String getValue() {
        return ""+getSubCode()+getParam1()+getParam2()+getParam3()+getParam4();
    }

}
