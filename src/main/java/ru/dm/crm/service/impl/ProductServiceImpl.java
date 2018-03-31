package ru.dm.crm.service.impl;

import org.springframework.stereotype.Service;
import ru.dm.crm.service.ProductService;
import ru.dm.crm.entity.Product;
import ru.dm.crm.repository.ProductRepository;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    public ProductRepository productRepository;

    @Override
    public Product findById(long id) {
        return productRepository.findOne(id);
    }
    @Override
    public Product findByArticule(String articule) {
        return productRepository.findByArticule(articule);
    }
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

}