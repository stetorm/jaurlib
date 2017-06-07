package com.steto.jaurlib.response;

/**
 * Created by sbrega on 02/12/2014.
 */


public class AResp_LastAlarms extends AuroraResponse {


    @Override
    public String getValue() {
        return toString();
    }

    public AResp_LastAlarms() {
        super();

    }

    @Override
    public String toString() {

        return  "{" + this.getAlarm1Description()+", "+getAlarm2Description()+", "+getAlarm3Description()+", "+getAlarm4Description()+"}";
    }


    public String getAlarm1Description() {
        return AuroraAlarmEnum.fromCode(getAlarm1()).toString();
    }

    public String getAlarm2Description() {
        return AuroraAlarmEnum.fromCode(getAlarm2()).toString();
    }

    public String getAlarm3Description() {
        return AuroraAlarmEnum.fromCode(getAlarm3()).toString();
    }

    public String getAlarm4Description() {
        return AuroraAlarmEnum.fromCode(getAlarm4()).toString();
    }

    public int getAlarm1() {
        return getParam1();
    }

    public int getAlarm2() {
        return getParam2();
    }

    public int getAlarm3() {
        return getParam3();
    }

    public int getAlarm4() {
        return getParam4();
    }

    public void setAlarm1(int alarmCode) {
        setParam1((char) alarmCode);
    }

    public void setAlarm2(int alarmCode) {
        setParam2((char) alarmCode);
    }

    public void setAlarm3(int alarmCode) {
        setParam3((char) alarmCode);
    }

    public void setAlarm4(int alarmCode) {
        setParam4((char) alarmCode);
    }
}
