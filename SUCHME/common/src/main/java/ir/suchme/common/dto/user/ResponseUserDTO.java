package ir.suchme.common.dto.user;


import ir.suchme.common.dto.base.BaseResponseDTO;

public class ResponseUserDTO extends BaseResponseDTO {

    public ResponseUserDTO(String id, String responseCode) {
        setUserId(id);
        setResponseCode(responseCode);
    }

    public ResponseUserDTO(String error, String responseCode, String userId) {
        super(error, responseCode, userId);
    }

    public ResponseUserDTO() {
    }
}
