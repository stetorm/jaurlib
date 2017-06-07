package com.steto.jaurlib.response;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by stefano on 29/11/14.
 */



public enum AI_ModelsEnum {


    PVI_2000('i'),
    PVI_2000_OUTD('o'),
    PVI_3600('I'),
    PVI_3600_OUTD('O'),
    PVI_5000_OUTD('5'),
    PVI_6000_OUTD('6'),
    PVI_3G74('P'),
    PVI_CENTRAL_50('C'),
    PVI_4_2_OUTD('4'),
    PVI_3_6_OUTD('3'),
    PVI_3_3_OUTD('2'),
    PVI_3_0_OUTD('1'),
    PVI_12_5_OUTD('D'),
    PVI_10_0_OUTD('X'),
    PVI_4_6I_OUTD('H'),
    PVI_3_8I_OUTD('h'),
    PVI_12_0I_OUTD_480VAC('T'),
    PVI_10_0I_OUTD_480VAC('t'),
    PVI_12_0I_OUTD_208VAC('U'),
    PVI_10_0I_OUTD_208VAC('u'),
    PVI_12_0I_OUTD_380VAC('V'),
    PVI_10_0I_OUTD_380VAC('v'),
    PVI_12_0I_OUTD_600VAC('Z'),
    PVI_10_0I_OUTD_600VAC('z'),
    PVI_CENTRAL_250('M'),
    PVI_10_0I_OUTD_480VAC_CurrentLimit_12A('w'),
    TRIO_27_6_TL_OUTD('Y'),
    TRIO_20_TL_OUTD('y'),
    UNO_2_0I('g'),
    UNO_2_5I('G'),
    PVI_CENTRAL_350_LiquidCooled_CTRL_Board('L'),
    PVI_CENTRAL_350_LiquidCooled_Display_Board('B'),
    PVI_CENTRAL_350_LiquidCooled_AC_gathering('A');


    final char value;

    AI_ModelsEnum(char val) {
        value=val;
    }

    private static Map mapVal2Enum = createMap();

    private static Map createMap() {

        Map result = new HashMap();
        for (AI_ModelsEnum e : values())
        {
            result.put(e.get(), e);
        }
        return Collections.unmodifiableMap(result);
    }


    public char get() {
        return value;
    }

    public static AI_ModelsEnum fromCode(char code) {

        return (AI_ModelsEnum) mapVal2Enum.get(code);
    }

}
