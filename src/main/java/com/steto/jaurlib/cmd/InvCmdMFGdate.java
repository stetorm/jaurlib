package com.steto.jaurlib.cmd;

import com.steto.jaurlib.AuroraDriver;
import com.steto.jaurlib.response.AuroraResponse;

/**
 * Created by stefano on 27/12/15.
 */
public class InvCmdMFGdate extends InverterCommand {


    public InvCmdMFGdate(int aInverterAddress) {
        super(aInverterAddress);
    }

    @Override
    public AuroraResponse execute(AuroraDriver auroraDriver) {

        AuroraResponse auroraResponse=null;
        try {
            auroraResponse  =  auroraDriver.acquireMFGdate(address);

        } catch (Exception e) {
            String errorString = e.getMessage();
            log.severe("Bad Response: "+auroraResponse+", "+e.getMessage());
        }

        return auroraResponse;

    }

}
