package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.entity.ProductProduct;
import com.app.model.entity.ProductProductPK;

@Repository
public interface ProductProductRepository extends JpaRepository<ProductProduct, ProductProductPK> {

}
