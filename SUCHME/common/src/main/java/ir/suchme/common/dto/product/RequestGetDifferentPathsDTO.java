package ir.suchme.common.dto.product;

import ir.suchme.common.dto.base.RequestDTO;
import org.assertj.core.api.Assertions;


public class RequestGetDifferentPathsDTO implements RequestDTO{
    private String productId;

    @Override
    public void validation() {
        Assertions.assertThat(productId).isNotNull();
        Assertions.assertThat(productId).isNotJavaBlank();
    }

    public RequestGetDifferentPathsDTO() {
    }

    public String getProductId() {

        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public RequestGetDifferentPathsDTO(String productId) {

        this.productId = productId;
    }
}
