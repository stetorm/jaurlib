package com.steto.jaurlib.request;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sbrega on 02/12/2014.
 */
public enum AuroraDspRequestEnum {
    GRID_VOLTAGE_ALL(1),
    GRID_CURRENT_ALL(2),
    GRID_POWER_ALL(3),
    FREQUENCY_ALL(4),
    VBULK_ILEAK_DCDC(5),
    ILEAK_DCDC(6),
    ILEAK_INVERTER(7),
    PIN_1(8),
    PIN_2(9),
    INVERTER_TEMPERATURE_GRID_TIED(21),
    BOOSTER_TEMPERATURE_GRID_TIED(22),
    INPUT_1_VOLTAGE(23),
    INPUT_1_CURRENT(25),
    INPUT_2_VOLTAGE(26),
    INPUT_2_CURRENT(27),
    GRID_VOLTAGE(28),
    GRID_FREQUENCY(29),
    ISOLATION_RESISTANCE_ALL(30),
    VBULK_GRID(31),
    AVERAGE_GRID_VOLTAGE(32),
    VBULK_MID_GRID_TIED(33),
    POWER_PEAK_ALL(34),
    POWER_PEAK_TODAY_AL(35),
    GRID_VOLTAGE_NEUTRAL_GRID_TIED(36),
    WIND_GENERATOR_FREQUENCY(37),
    GRID_VOLTAGE_NEUTRAL_PHASE_CENTRAL(38),
    GRID_CURRENT_PHASE_R_CENTRAL_AND_3_PHASE(39),
    GRID_CURRENT_PHASE_S_CENTRAL_AND_3_PHASE(40),
    GRID_CURRENT_PHASE_T_CENTRAL_AND_3_PHASE(41),
    FREQUENCY_PHASE_R_CENTRAL_AND_3_PHASE(42),
    FREQUENCY_PHASE_S_CENTRAL_AND_3_PHASE(43),
    FREQUENCY_PHASE_T_CENTRAL_AND_3_PHASE(44),
    VBULK_PLUS_CENTRAL_AND_3_PHASE(45),
    VBULK_MINUS_CENTRAL(46),
    SUPERVISOR_TEMPERATURE_CENTRAL(47),
    ALIM_TEMPERATURE_CENTRAL(48),
    HEAK_SINK_TEMPERATURE_CENTRAL(49),
    TEMPERATURE_1_CENTRAL(50),
    TEMPERATURE_2_CENTRAL(51),
    TEMPERATURE_3_CENTRAL(52),
    FAN_1_SPEED_CENTRAL(53),
    FAN_2_SPEED_CENTRAL(54),
    FAN_3_SPEED_CENTRAL(55),
    FAN_4_SPEED_CENTRAL(56),
    FAN_5_SPEED_CENTRAL(57),
    POWER_SATURATION_LIMIT_DER_CENTRAL(58),
    REFERENCE_RING_BULK_CENTRAL(59),
    VPANEL_MICRO_CENTRAL(60),
    GRID_VOLTAGE_PHASE_R_CENTRAL_AND_3_PHASE(63),
    GRID_VOLTAGE_PHASE_S_CENTRAL_AND_3_PHASE(64),
    GRID_VOLTAGE_PHASE_T_CENTRAL_AND_3_PHASE(65),
    FAN_1_SPEED_RPM_CENTRAL(95),
    FAN_2_SPEED_RPM_CENTRAL(96),
    FAN_3_SPEED_RPM_CENTRAL(97),
    FAN_4_SPEED_RPM_CENTRAL(98),
    FAN_5_SPEED_RPM_CENTRAL(99),
    FAN_6_SPEED_RPM_CENTRAL(100),
    FAN_7_SPEED_RPM_CENTRAL(101);

    public final int value;
    private static Map mapVal2Enum = createMap();

    private static Map createMap() {

        Map result = new HashMap();
        for (AuroraDspRequestEnum e : values())
        {
            result.put(e.get(), e);
        }
        return Collections.unmodifiableMap(result);
    }

    AuroraDspRequestEnum(int val) {
        value=val;
    }

    public int get() {
        return value;
    }

    public static AuroraDspRequestEnum fromCode(int code) {

        return (AuroraDspRequestEnum) mapVal2Enum.get(code);
    }


    @Override
    public String toString() {
        return super.toString().replace('_',' ');
    }
}

