package ir.suchme.core.domain.repository;

import ir.suchme.core.domain.entity.Requirement;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;


public interface RequirementRepository extends CrudRepository<Requirement,UUID> {
}
