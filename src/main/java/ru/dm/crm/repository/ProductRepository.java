package ru.dm.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dm.crm.entity.Product;

import java.util.List;

/**
 * Created by Denis on 31.03.2018.
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAll();
    Product findByArticule(String articule);
}
