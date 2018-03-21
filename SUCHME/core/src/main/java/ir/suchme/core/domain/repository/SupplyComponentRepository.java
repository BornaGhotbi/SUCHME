package ir.suchme.core.domain.repository;

import ir.suchme.core.domain.entity.Component;
import ir.suchme.core.domain.entity.Supplier;
import ir.suchme.core.domain.entity.SupplyComponent;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;


public interface SupplyComponentRepository extends CrudRepository<SupplyComponent, UUID>{
    SupplyComponent findByComponentAndSupplier(Component component, Supplier supplier);
}
