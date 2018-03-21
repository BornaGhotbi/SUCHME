package ir.suchme.common.dto.product;

import ir.suchme.common.dto.base.RequestDTO;


public class RequestCreateMiddlewareProduct implements RequestDTO{

    @Override
    public void validation() {

    }

    private String name;

    public RequestCreateMiddlewareProduct(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
