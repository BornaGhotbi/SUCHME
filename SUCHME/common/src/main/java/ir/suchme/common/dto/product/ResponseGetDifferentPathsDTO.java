package ir.suchme.common.dto.product;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ir.suchme.common.dto.base.BaseResponseDTO;
import ir.suchme.common.dto.component.ComponentDTO;
import ir.suchme.common.dto.component.SupplyComponentDTO;
import ir.suchme.common.util.ComponentDeserializer;

import java.util.HashMap;
import java.util.List;


public class ResponseGetDifferentPathsDTO extends BaseResponseDTO{
    @JsonDeserialize(keyUsing = ComponentDeserializer.class)
    private HashMap<ComponentDTO,List<SupplyComponentDTO>> pathDTOs;

    @Override
    public String toString() {
        return "{" +
                "pathDTOs=" + pathDTOs +
                '}';
    }

    public HashMap<ComponentDTO, List<SupplyComponentDTO>> getPathDTOs() {
        return pathDTOs;
    }

    public void setPathDTOs(HashMap<ComponentDTO, List<SupplyComponentDTO>> pathDTOs) {
        this.pathDTOs = pathDTOs;
    }

    public ResponseGetDifferentPathsDTO() {

    }

    public ResponseGetDifferentPathsDTO(String error, String responseCode, String userId, HashMap<ComponentDTO, List<SupplyComponentDTO>> pathDTOs) {

        super(error, responseCode, userId);
        this.pathDTOs = pathDTOs;
    }

    public ResponseGetDifferentPathsDTO(HashMap<ComponentDTO, List<SupplyComponentDTO>> pathDTOs) {
        this.pathDTOs = pathDTOs;
    }
}
