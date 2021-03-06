package ir.suchme.common.dto.component;

import ir.suchme.common.dto.base.RequestDTO;


public class RequestSearchComponentDTO implements RequestDTO {

    private String name;

    @Override
    public void validation() {
    }

    public RequestSearchComponentDTO(String name) {
        this.name = name;
    }

    public RequestSearchComponentDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                '}';
    }
}
