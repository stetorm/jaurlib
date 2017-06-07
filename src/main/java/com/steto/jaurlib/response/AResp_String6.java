package com.steto.jaurlib.response;

import com.steto.jaurlib.modbus.MB_code;

/**
 * Created by sbrega on 12/12/2014.
 */

public class AResp_String6 extends AuroraResponse {
    public void set(String productNumber) {

        setCode(new MB_code(0));
        setSubCode((char) 0);
        setParam1((char) 0);
        setParam2((char) 0);
        setParam3((char) 0);
        setParam4((char) 0);
        if (productNumber==null || productNumber.length()==0)
        {
            return;
        }
        switch (productNumber.length())
        {
            // no, it's not a mistake
            default:
            case 6:
                setParam4(productNumber.charAt(5));
            case 5:
                setParam3(productNumber.charAt(4));
            case 4:
                setParam2(productNumber.charAt(3));
            case 3:
                setParam1(productNumber.charAt(2));
            case 2:
                setSubCode(productNumber.charAt(1));
            case 1:
                setCode(new MB_code(productNumber.charAt(0)));
                break;
        }

    }

    public String get() {
        char param0 = (char) code.getValue().byteValue();
        String result = ""+param0+getSubCode()+getParam1()+getParam2()+getParam3()+getParam4();

        return result.trim();
    }

    @Override
    public String toString() {
        return description.isEmpty() ? super.toString() : description+": "+get();
    }

    @Override
    public String getValue() {
        return get();
    }

}
