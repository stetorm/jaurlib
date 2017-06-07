package com.steto.jaurlib.cmd;

import com.steto.jaurlib.request.AuroraCumEnergyEnum;
import com.steto.jaurlib.request.AuroraDspRequestEnum;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by stefano on 28/12/15.
 */
public class InverterCommandFactory {

    Logger log = Logger.getLogger(getClass().getSimpleName());

    Map<String, AuroraCumEnergyEnum> mapEnergyCmd = new HashMap<>();
    Map<String, AuroraDspRequestEnum> mapDspCmd = new HashMap<>();


    public InverterCommandFactory() {
        mapEnergyCmd.put("daily", AuroraCumEnergyEnum.DAILY);
        mapEnergyCmd.put("weekly", AuroraCumEnergyEnum.WEEKLY);
        mapEnergyCmd.put("monthly", AuroraCumEnergyEnum.MONTHLY);
        mapEnergyCmd.put("yearly", AuroraCumEnergyEnum.YEARLY);
        mapEnergyCmd.put("last7days", AuroraCumEnergyEnum.LAST7DAYS);
        mapEnergyCmd.put("partial", AuroraCumEnergyEnum.PARTIAL);
        mapEnergyCmd.put("total", AuroraCumEnergyEnum.TOTAL);

        mapDspCmd.put("freqAll", AuroraDspRequestEnum.FREQUENCY_ALL);
        mapDspCmd.put("gridVoltageAll", AuroraDspRequestEnum.GRID_VOLTAGE_ALL);
        mapDspCmd.put("gridCurrentAll", AuroraDspRequestEnum.GRID_CURRENT_ALL);
        mapDspCmd.put("gridPowerAll", AuroraDspRequestEnum.GRID_POWER_ALL);
        mapDspCmd.put("input1Voltage", AuroraDspRequestEnum.INPUT_1_VOLTAGE);
        mapDspCmd.put("input1Current", AuroraDspRequestEnum.INPUT_1_CURRENT);
        mapDspCmd.put("input2Voltage", AuroraDspRequestEnum.INPUT_2_VOLTAGE);
        mapDspCmd.put("input2Current", AuroraDspRequestEnum.INPUT_2_CURRENT);
        mapDspCmd.put("inverterTemp", AuroraDspRequestEnum.INVERTER_TEMPERATURE_GRID_TIED);
        mapDspCmd.put("boosterTemp", AuroraDspRequestEnum.BOOSTER_TEMPERATURE_GRID_TIED);
    }


    public InverterCommand create(String opCodeParameter, String subCodeParameter, int addressParameter) {

        InverterCommand result = null;
        switch (opCodeParameter) {
            case "cumEnergy":
                AuroraCumEnergyEnum period = mapEnergyCmd.get(subCodeParameter);
                result = new InvCmdCumEnergy(addressParameter, period);
                break;
            case "dspData":
                AuroraDspRequestEnum magnitude = mapDspCmd.get(subCodeParameter);
                result = new InvCmdDspData(addressParameter, magnitude);
                break;
            case "productNumber":
                result = new InvCmdProductNumber(addressParameter);
                break;
            case "serialNumber":
                result = new InvCmdSerialNumber(addressParameter);
                break;
            case "versionNumber":
                result = new InvCmdVersionNumber(addressParameter);
                break;
            case "firmwareNumber":
                result = new InvCmdFirmwareVersion(addressParameter);
                break;
            case "manufacturingDate":
                result = new InvCmdMFGdate(addressParameter);
                break;
            case "sysConfig":
                result = new InvCmdSysConfig(addressParameter);
                break;
            case "timeCounter":
                result = new InvCmdTimeCounter(addressParameter);
                break;
            case "actualTime":
                result = new InvCmdActualTime(addressParameter);
                break;
            case "lastAlarms":
                result = new InvCmdLastAlarms(addressParameter);
                break;
            default:
                log.severe("Received unknown inverter command, with opcode: " + opCodeParameter);

        }

        return result;

    }

}
