package com.steto.jaurlib.response;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sbrega on 02/12/2014.
 */
public enum AuroraAlarmEnum {
    NO_ALARM(0),
    SUN_LOW_W001_1(1),
    INPUT_OVER_CURRENT_E001(2),
    INPUT_UNDER_VOLTAGE_W002(3),
    INPUT_OVER_VOLTAGE_E002(4),
    SUN_LOW_W001_5(5),
    NO_PARAMETERS_E003(6),
    BULK_OVER_VOLTAGE_E004(7),
    COMM_ERROR_E005(8),
    OUTPUT_OVER_CURRENT_E006(9),
    IGBT_SAT_E007(10),
    BULK_UV_W011(11),
    INTERNAL_ERROR_E009(12),
    GRID_FAIL_W003(13),
    BULK_LOW_E010(14),
    RAMP_FAIL_E011(15),
    DC_DC_FAIL_E012(16),
    WRONG_MODE_E013(17),
    GROUND_FAULT_(18),
    OVER_TEMP_E014(19),
    BULK_CAP_FAIL_E015(20),
    INVERTER_FAIL_E016(21),
    START_TIMEOUT_E017(22),
    GROUND_FAULT_E018(23),
    DEGAUSS_ERROR(24),
    ILEAK_SENS_FAIL_E019(25),
    DCDC_FAIL_E012(26),
    SELF_TEST_ERROR_1_E020(27),
    SELF_TEST_ERROR_2_E021(28),
    SELF_TEST_ERROR_3_E019(29),
    SELF_TEST_ERROR_4_E022(30),
    DC_INJ_ERROR_E023(31),
    GRID_OVER_VOLTAGE_W004(32),
    GRID_UNDER_VOLTAGE_W005(33),
    GRID_OF_W006(34),
    GRID_UF_W007(35),
    Z_GRID_HI_W008(36),
    INTERNAL_ERROR_E024(37),
    RISO_LOW_E025(38),
    VREF_ERROR_E026(39),
    ERROR_MEAS_V_E027(40),
    ERROR_MEAS_F_E028(41),
    ERROR_MEAS_I_E029(42),
    ERROR_MEAS_ILEAK_E030(43),
    READ_ERROR_V_E031(44),
    READ_ERROR_I_E032(45),
    TABLE_FAIL_W009(46),
    FAN_FAIL_W010(47),
    UTH_E033(48),
    INTERLOCK_FAIL(49),
    REMOTE_OFF(50),
    VOUT_AVG_ERROR(51),
    BATTERY_LOW(52),
    CLK_FAIL(53),
    INPUT_UC(54),
    ZERO_POWER(55),
    FAN_STUCKED(56),
    DC_SWITCH_OPEN(57),
    TRAS_SWITCH_OPEN(58),
    AC_SWITCH_OPEN(59),
    BULK_UV(60),
    AUTOEXCLUSION(61),
    GRID_DF_DT(62),
    DEN_SWITCH_OPEN(63),
    JBOX_FAIL(64);

    public final int value;
    private static Map mapVal2Enum = createMap();

    private static Map createMap() {

        Map result = new HashMap();
        for (AuroraAlarmEnum e : values())
        {
            result.put(e.get(), e);
        }
        return Collections.unmodifiableMap(result);
    }

    AuroraAlarmEnum(int val) {
        value=val;
    }

    public int get() {
        return value;
    }

    public static AuroraAlarmEnum fromCode(int code) {

        return (AuroraAlarmEnum) mapVal2Enum.get(code);
    }


    @Override
    public String toString() {
        return super.toString().replace('_',' ');
    }
}

