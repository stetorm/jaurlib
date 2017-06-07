package com.steto.jaurlib.cmd;

import com.steto.jaurlib.AuroraDriver;
import com.steto.jaurlib.request.AuroraCumEnergyEnum;
import com.steto.jaurlib.response.AuroraResponse;

/**
 * Created by stefano on 27/12/15.
 */
public class InvCmdCumEnergy extends InverterCommand {
    public AuroraCumEnergyEnum period;

    public InvCmdCumEnergy(int addressParameter, AuroraCumEnergyEnum aPeriod) {
        super(addressParameter);
        period = aPeriod;

    }

    @Override
    public AuroraResponse execute(AuroraDriver auroraDriver) {

        AuroraResponse auroraResponse=null;
        try {
            auroraResponse  =  auroraDriver.acquireCumulatedEnergy(address, period);

        } catch (Exception e) {
            String errorString = e.getMessage();
            log.severe("Bad Response: "+auroraResponse);
        }

        return auroraResponse;

    }


}
