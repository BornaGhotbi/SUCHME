package ir.suchme.common.dto.component;

import ir.suchme.common.dto.base.RequestDTO;
import org.assertj.core.api.Assertions;

import java.util.UUID;


public class RequestUpdateComponentMinMaxDTO implements RequestDTO {

    private String productId;

    private Integer minimum;

    private Integer maximum;

    @Override
    public void validation() {
        Assertions.assertThat(productId).isNotNull();
        try{
            UUID.fromString(productId);
        }catch (Exception e){
            throw new AssertionError("componentId is not a UUID",e);
        }
    }

    public RequestUpdateComponentMinMaxDTO(String productId, Integer minimum, Integer maximum) {
        this.productId = productId;
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public RequestUpdateComponentMinMaxDTO() {
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getMinimum() {
        return minimum;
    }

    public void setMinimum(Integer minimum) {
        this.minimum = minimum;
    }

    public Integer getMaximum() {
        return maximum;
    }

    public void setMaximum(Integer maximum) {
        this.maximum = maximum;
    }

    @Override
    public String toString() {
        return "{" +
                "productId='" + productId + '\'' +
                ", minimum=" + minimum +
                ", maximum=" + maximum +
                '}';
    }
}
