package ir.suchme.core.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "CUSTOMER")
public class Customer extends User{
    public Customer(String userName, String password, String name, String email) {
        super(userName, password, name, email);
    }

    public Customer() {
    }
}
