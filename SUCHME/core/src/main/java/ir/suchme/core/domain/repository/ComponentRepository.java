package ir.suchme.core.domain.repository;

import ir.suchme.core.domain.entity.Component;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;


public interface ComponentRepository extends CrudRepository<Component,UUID> {
    List<Component> findAllByNameLike(String name);
}
