package ir.suchme.core.domain.repository;

import ir.suchme.core.domain.entity.Supplier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


public interface SupplierRepository extends CrudRepository<Supplier, UUID> {

    Supplier findFirstByName(String name);
    List<Supplier> findAllByNameLike(String name);


}
