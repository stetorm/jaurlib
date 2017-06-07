package com.steto.jaurlib.cmd;


import com.steto.jaurlib.AuroraDriver;
import com.steto.jaurlib.response.AuroraResponse;

import java.util.logging.Logger;

/**
 * Created by stefano on 23/12/14.
 */
public abstract class InverterCommand {

    protected Logger log = Logger.getLogger(getClass().getSimpleName());

    protected final int address;

    public InverterCommand(int addressParameter) {
        address= addressParameter;

    }


    public abstract AuroraResponse execute(AuroraDriver auroraDriver) ;
}
