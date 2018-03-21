package ir.suchme.core.domain.repository;

import ir.suchme.core.domain.entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;


public interface EmployeeRepository extends CrudRepository<Employee,UUID>{
}
