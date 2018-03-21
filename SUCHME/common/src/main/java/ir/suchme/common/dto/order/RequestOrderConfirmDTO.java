package ir.suchme.common.dto.order;

import ir.suchme.common.dto.base.RequestDTO;
import org.assertj.core.api.Assertions;


public class RequestOrderConfirmDTO implements RequestDTO {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                '}';
    }

    public RequestOrderConfirmDTO() {
    }

    public RequestOrderConfirmDTO(String id) {

        this.id = id;
    }

    @Override
    public void validation() {
        Assertions.assertThat(id).isNotNull();
    }
}
