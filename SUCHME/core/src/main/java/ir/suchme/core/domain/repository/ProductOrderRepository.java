package ir.suchme.core.domain.repository;

import ir.suchme.core.domain.ProductOrder;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;
import java.util.List;
import java.util.UUID;


public interface ProductOrderRepository extends PagingAndSortingRepository<ProductOrder,UUID> {
    List<ProductOrder>findAllByCreatedBetweenAndDeletedIsFalse(Date from, Date to, Pageable pageable);
    Integer countAllByCreatedBetween(Date from, Date to);
}
