package com.steto.jaurlib.response;

/**
 * Created by sbrega on 09/12/2014.
 */
public class AResp_SysConfig  extends AuroraResponse{
    public void setConfigCode(int code) {
        setParam1((char) code);
    }

    public int getConfigCode() {
        return getParam1();
    }

    @Override
    public String getValue() {
        return String.valueOf(getConfigCode());
    }

}
