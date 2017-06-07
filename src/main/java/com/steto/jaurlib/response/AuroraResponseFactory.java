package com.steto.jaurlib.response;

import com.steto.jaurlib.request.*;
import com.steto.jaurlib.modbus.MB_PDU;
import com.steto.jaurlib.modbus.MB_code;
import com.steto.jaurlib.modbus.PDUFactory;

/**
 * Created by sbrega on 27/11/2014.
 */


public class AuroraResponseFactory extends PDUFactory implements AuroraResponseBuilder {


    public AuroraResponseFactory() {
        super();
    }


    @Override
    protected MB_PDU create(MB_code code) {
        return null;
    }

    public AuroraResponse createResponse(AReq_ActualTime request) {

        AResp_ActualTime result = new AResp_ActualTime();
        result.setDescription("Inverter Time");
        return result;

    }

    public AuroraResponse createResponse(AReq_VersionId request) {
        AResp_VersionId result = new AResp_VersionId();
        result.setDescription("Version Number");
        return result;
    }

    public AuroraResponse createResponse(AReq_MFGdate request) {
        AResp_MFGdate result = new AResp_MFGdate();
        result.setDescription("Manufacturing Date");
        return result;
    }

    public AuroraResponse createResponse(AReq_TimeCounter request) {

        AResp_TimeCounter result = new AResp_TimeCounter();
        result.setDescription("Time Counter (days)");
        return result;
    }

    public AuroraResponse createResponse(AReq_State request) {
        AResp_State result = new AResp_State();
        result.setDescription("Configuration");
        return result;
    }

    public AuroraResponse createResponse(AReq_FwVersion request) {
        AResp_FwVersion result = new AResp_FwVersion();
        result.setDescription("Firmware Version");
        return result;
    }

    public AuroraResponse createResponse(AReq_SerialNumber request) {
        AResp_SerialNumber result = new AResp_SerialNumber();
        result.setDescription("Serial Number");
        return result;
    }

    public AuroraResponse createResponse(AReq_SystemConfig request) {
        return new AResp_SysConfig();
    }

    public AuroraResponse createResponse(AReq_ProductNumber request) {
        AResp_ProductNumber result = new AResp_ProductNumber();
        result.setDescription("Product Number");
        return result;
    }

    public AuroraResponse createResponse(AReq_CumulatedEnergy request) {
        AResp_CumulatedEnergy result = new AResp_CumulatedEnergy();
        String description = AuroraCumEnergyEnum.fromCode((int) request.getParam1()).toString() + " Cumulated Energy";
        result.setDescription(description);
        return result;
    }

    public AuroraResponse createResponse(AReq_DspData request) {
        AResp_DspData result = new AResp_DspData();
        String description = AuroraDspRequestEnum.fromCode((int) request.getParam1()).toString();
        result.setDescription(description);
        return result;

    }

    @Override
    public AuroraResponse createResponse(AReq_LastAlarms request) {
        AResp_LastAlarms result = new AResp_LastAlarms();
        result.setDescription("Alarms List");
        return result;
    }

}