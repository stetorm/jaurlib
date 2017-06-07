package com.steto.jaurlib.eventbus;

import com.steto.jaurkit.EventBusRequest;

import java.util.Map;

/**
 * Created by stefano on 28/12/15.
 */
public class EBInverterRequest extends EventBusRequest {
    private String opcode;
    private final String subcode;
    private final int address;

    public EBInverterRequest(String opcode, String subcode, int inverterAddress) {
        this.opcode=opcode;
        this.subcode=subcode;
        this.address=inverterAddress;

    }

    public EBInverterRequest(Map cmdParams) {
        this.opcode = (String) cmdParams.get("opcode");
        this.subcode = (String) cmdParams.get("subcode");
        this.address = Integer.parseInt((String) cmdParams.get("address"));

    }


    public String opcode() {
        return opcode;
    }

    public String subcode() {
        return subcode;
    }

    public int address() {
        return address;

    }
}
