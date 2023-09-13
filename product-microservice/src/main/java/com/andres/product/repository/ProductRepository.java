package com.andres.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.andres.product.entity.ProductEntity;

public interface ProductRepository extends MongoRepository<ProductEntity, String> {

}
