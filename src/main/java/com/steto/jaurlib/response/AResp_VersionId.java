package com.steto.jaurlib.response;

import com.steto.jaurlib.modbus.MB_code;

/**
 * Created by sbrega on 27/11/2014.
 */
public class AResp_VersionId extends AuroraResponse {


    public AResp_VersionId(MB_code code) {
        super(code);

    }

    public AResp_VersionId() {
        super();

    }


    @Override
    public String toString() {
        String localDescription = getValue();
        return description.isEmpty() ? super.toString() : description + " " + localDescription;
    }

    public String getType() {
        AI_Type type = AI_Type.fromCode(getParam4());
        return type == null ? "UNKNOWN" : type.toString();
    }

    public String getTransformerInfo() {
        AI_TransformerType type = AI_TransformerType.fromCode(getParam3());
        return type == null ? "UNKNOWN" : type.toString();
    }

    public String getNationality() {
        AI_NationEnum type = AI_NationEnum.fromCode(getParam2());
        return type == null ? "UNKNOWN" : type.toString();
    }


    public String getModelName() {
        AI_ModelsEnum type = AI_ModelsEnum.fromCode(getParam1());
        return type == null ? "UNKNOWN" : type.toString();
    }

    @Override
    public String getValue() {
        String localDescription = "Model: " + getModelName() + ", Nationality: " + getNationality() + ", Transformer " + getTransformerInfo() + ", Type: " + getType();
        return localDescription;
    }

}
