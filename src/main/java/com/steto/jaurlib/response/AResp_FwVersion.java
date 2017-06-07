package com.steto.jaurlib.response;

/**
 * Created by stefano on 07/12/14.
 */
public class AResp_FwVersion extends AuroraResponse {
    public AResp_FwVersion() {
        super();
    }


    public void set(String productNumber) {

        setParam1((char) 0);
        setParam2((char) 0);
        setParam3((char) 0);
        setParam4((char) 0);
        if (productNumber == null || productNumber.length() == 0) {
            return;
        }
        switch (productNumber.length()) {
            // no, it's not a mistake
            default:
            case 4:
                setParam4(productNumber.charAt(3));
            case 3:
                setParam3(productNumber.charAt(2));
            case 2:
                setParam2(productNumber.charAt(1));
            case 1:
                setParam1(productNumber.charAt(0));
                break;
        }

    }

    public String get() {
        char param0 = (char) code.getValue().byteValue();
        String result = "" + getParam1() + "." + getParam2() +"." + getParam3() + "." +getParam4();

        return result.trim();
    }

    @Override
    public String toString() {
        return description.isEmpty()?super.toString(): description+": "+get();
    }



    @Override
    public String getValue() {
        return get();
    }

}