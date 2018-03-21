package ir.suchme.core.catalogue;

import ir.suchme.core.domain.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class EmployeeCatalogue {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeCatalogue(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
}
