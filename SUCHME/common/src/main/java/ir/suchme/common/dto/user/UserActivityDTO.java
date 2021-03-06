package ir.suchme.common.dto.user;

import java.util.Date;


public class UserActivityDTO {

    private String component;

    private String method;

    private String description;

    private String userName;

    private String name;

    private Date date;

    public UserActivityDTO(String component, String method, String description, String userName, String name, Date date) {
        this.component = component;
        this.method = method;
        this.description = description;
        this.userName = userName;
        this.name = name;
        this.date = date;
    }

    public UserActivityDTO() {
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
