package com.steto.jaurlib.cmd;

import com.steto.jaurlib.AuroraDriver;
import com.steto.jaurlib.request.AuroraDspRequestEnum;
import com.steto.jaurlib.response.AuroraResponse;

/**
 * Created by stefano on 27/12/15.
 */
public class InvCmdDspData extends InverterCommand {
    public AuroraDspRequestEnum magnitude;

    public InvCmdDspData(int addressParameter, AuroraDspRequestEnum magnitudeSelector) {
        super(addressParameter);
        magnitude = magnitudeSelector;

    }

    @Override
    public AuroraResponse execute(AuroraDriver auroraDriver) {

        AuroraResponse auroraResponse=null;
        try {
            auroraResponse  =  auroraDriver.acquireDspValue(address, magnitude);

        } catch (Exception e) {
            String errorString = e.getMessage();
            log.severe("Bad Response: "+auroraResponse+", "+e.getMessage());
        }

        return auroraResponse;

    }

}
