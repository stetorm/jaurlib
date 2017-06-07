package com.steto.jaurlib.eventbus;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.steto.jaurlib.AuroraDriver;
import com.steto.jaurlib.cmd.InverterCommand;
import com.steto.jaurlib.cmd.InverterCommandFactory;
import com.steto.jaurlib.response.AuroraResponse;
import com.steto.jaurlib.response.ResponseErrorEnum;

/**
 * Created by stefano on 28/12/15.
 */
public class EventBusInverterAdapter {
    private final EventBus eventBus;
    private final AuroraDriver auroraDriver;
    private final InverterCommandFactory inverterCommandFactory;

    public EventBusInverterAdapter(EventBus aEventBus, AuroraDriver aAuroraDriver, InverterCommandFactory aInverterCommandFactory) {
        eventBus = aEventBus;
        auroraDriver = aAuroraDriver;
        eventBus.register(this);
        inverterCommandFactory = aInverterCommandFactory;
    }


    @Subscribe
    public void handleInverterCommand(EBInverterRequest cmd) {
        EBResponse ebResponse = null;


        try {
            InverterCommand inverterCommand = inverterCommandFactory.create(cmd.opcode(), cmd.subcode(), cmd.address());

            if (inverterCommand != null) {

                AuroraResponse auroraResponse = inverterCommand.execute(auroraDriver);

                ebResponse = (auroraResponse.getErrorCode() == ResponseErrorEnum.NONE) ? new EBResponseOK(auroraResponse.getValue()) : new EBResponseNOK(auroraResponse.getErrorCode().get(), auroraResponse.getErrorCode().toString());
            } else {
                ebResponse = new EBResponseNOK(1, "Unrecognized Command");
            }

        } catch (Exception e) {
            String errorString = e.getMessage();
            ebResponse = new EBResponseNOK(-1, errorString);
        }


        cmd.response = ebResponse;

    }

}
