package ru.dm.crm.service;
import ru.dm.crm.entity.Product;

import java.util.List;

/**
 * Created by Denis on 31.03.18.
 */
public interface ProductService {
    Product findById(long id);
    Product findByArticule(String articule);
    List<Product> findAll();
}
