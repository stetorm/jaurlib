package com.steto.jaurlib.response;

import com.steto.jaurlib.request.*;

/**
 * Created by stefano on 06/12/14.
 */
public interface AuroraResponseBuilder {


    public AuroraResponse createResponse(AReq_ActualTime request);

    public AuroraResponse createResponse(AReq_VersionId request);

    public AuroraResponse createResponse(AReq_MFGdate request);

    public AuroraResponse createResponse(AReq_TimeCounter request);

    public AuroraResponse createResponse(AReq_State request);

    public AuroraResponse createResponse(AReq_FwVersion request);

    public AuroraResponse createResponse(AReq_SerialNumber request);

    public AuroraResponse createResponse(AReq_SystemConfig request);

    public AuroraResponse createResponse(AReq_ProductNumber request);

    public AuroraResponse createResponse(AReq_CumulatedEnergy request);

    public AuroraResponse createResponse(AReq_DspData request);

    public AuroraResponse createResponse(AReq_LastAlarms request);
}
