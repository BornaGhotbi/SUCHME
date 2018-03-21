package ir.suchme.common.dto.supplier;

import ir.suchme.common.dto.base.RequestDTO;


public class RequestSearchSupplierDTO implements RequestDTO{
    private String name;

    @Override
    public void validation() {

    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                '}';
    }

    public RequestSearchSupplierDTO(String name) {
        this.name = name;
    }

    public RequestSearchSupplierDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
