package com.steto.jaurlib.request;

import com.steto.jaurlib.modbus.MB_PDU;
import com.steto.jaurlib.modbus.MB_code;
import com.steto.jaurlib.modbus.PDUFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by stefano on 22/11/14.
 */


public class AuroraRequestFactory extends PDUFactory {


    static protected Map<Integer, Class> mapCode2ClassMsg = new HashMap<Integer, Class>();
    static protected Map<Class, Integer> mapClassMsg2Code = new HashMap<Class, Integer>();


    public AuroraRequestFactory() {
        initMap();
        revertMap();
    }


    protected void revertMap() {
        for (Integer code : mapCode2ClassMsg.keySet()) {
            mapClassMsg2Code.put(mapCode2ClassMsg.get(code), code);
        }
    }

    public MB_PDU create(Class<?> aClass) {

        MB_PDU result;

        try {
            Integer code = mapClassMsg2Code.get(aClass);
            result = (MB_PDU) aClass.getConstructor(MB_code.class).newInstance(new MB_code(code));
        } catch (Exception e) {
            result = null;
        }
        return result;
    }


    protected MB_PDU create(MB_code code) {

        MB_PDU result;

        try {
            Class theClass = mapCode2ClassMsg.get(code.getValue());
            result = (MB_PDU) theClass.getConstructor(MB_code.class).newInstance(code);
        } catch (Exception e) {
            result = null;
        }
        return result;
    }


    public void initMap() {
        mapCode2ClassMsg.put(AuroraRequestCodeEnum.GETVERSIONID.value, AReq_VersionId.class);
        mapCode2ClassMsg.put(AuroraRequestCodeEnum.GETDSP.value, AReq_DspData.class);
        mapCode2ClassMsg.put(AuroraRequestCodeEnum.GETSTATE.value, AReq_State.class);
        mapCode2ClassMsg.put(AuroraRequestCodeEnum.GETFWVERSION.value, AReq_FwVersion.class);
        mapCode2ClassMsg.put(AuroraRequestCodeEnum.GETMFGDATE.value, AReq_MFGdate.class);
        mapCode2ClassMsg.put(AuroraRequestCodeEnum.GETSERIALNUMBER.value, AReq_SerialNumber.class);
        mapCode2ClassMsg.put(AuroraRequestCodeEnum.GETSYSTEMCONFIG.value, AReq_SystemConfig.class);
        mapCode2ClassMsg.put(AuroraRequestCodeEnum.GETPRODUCTNUMBER.value, AReq_ProductNumber.class);
        mapCode2ClassMsg.put(AuroraRequestCodeEnum.GETTIMECOUNTER.value, AReq_TimeCounter.class);
        mapCode2ClassMsg.put(AuroraRequestCodeEnum.GETACCUMULATEDENERGY.value, AReq_CumulatedEnergy.class);
        mapCode2ClassMsg.put(AuroraRequestCodeEnum.GETACTUALTIME.value, AReq_ActualTime.class);
        mapCode2ClassMsg.put(AuroraRequestCodeEnum.GETLASTALARMS.value, AReq_LastAlarms.class);

    }


    public AuroraRequest createAReq_VersionId() {

        AuroraRequest req = (AuroraRequest) create(AReq_VersionId.class);
        return req;
    }


    public AuroraRequest createAR_VersionIdShort() {

        AuroraRequest req = (AuroraRequest) create(AReq_VersionId.class);
        if (req != null) {
            req.setParam1('\0');
        }
        return req;
    }

    public AuroraRequest createAReq_DspData(AuroraDspRequestEnum auroraDspRequestEnum) {

        AReq_DspData req = (AReq_DspData) create(AReq_DspData.class);
        req.setParam1((char) auroraDspRequestEnum.get());
        return req;
    }

    public AuroraRequest createAReq_CumulatedEnergy(AuroraCumEnergyEnum requestedValue) {
        AReq_CumulatedEnergy req = (AReq_CumulatedEnergy) create(AReq_CumulatedEnergy.class);
        req.setParam1((char) requestedValue.get());
        return req;
    }

    public AuroraRequest createAReq_State() {
        AReq_State req = (AReq_State) create(AReq_State.class);
        return req;
    }

    public AuroraRequest createAReq_FwVersion() {
        AReq_FwVersion req = (AReq_FwVersion) create(AReq_FwVersion.class);
        return req;
    }

    public AuroraRequest createAReq_MFGdate() {
        AReq_MFGdate req = (AReq_MFGdate) create(AReq_MFGdate.class);
        return req;
    }

    public AuroraRequest createAReq_SerialNumber() {
        AReq_SerialNumber req = (AReq_SerialNumber) create(AReq_SerialNumber.class);
        return req;
    }

    public AuroraRequest createAReq_SystemConfig() {
        AReq_SystemConfig req = (AReq_SystemConfig) create(AReq_SystemConfig.class);
        return req;
    }

    public AuroraRequest createAReq_ProductNumber() {
        AReq_ProductNumber req = (AReq_ProductNumber) create(AReq_ProductNumber.class);
        return req;
    }

    public AuroraRequest createAReq_TimeCounter() {
        AReq_TimeCounter req = (AReq_TimeCounter) create(AReq_TimeCounter.class);
        return req;
    }

    public AuroraRequest createAReq_ActualTime() {
        AReq_ActualTime req = (AReq_ActualTime) create(AReq_ActualTime.class);
        return req;
    }

    public AuroraRequest createAReq_AlarmsList() {
        AReq_LastAlarms req = (AReq_LastAlarms) create(AReq_LastAlarms.class);
        return req;
    }
}
