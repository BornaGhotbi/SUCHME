package ir.suchme.core.domain.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;


@Entity
@Table(name = "EMPLOYEE")
public class Employee extends User{


}
