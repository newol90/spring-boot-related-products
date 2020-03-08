package com.app.service;

import java.util.List;

import com.app.api.NewProductDto;
import com.app.api.NewRelatedProductDto;
import com.app.api.ProductDto;
import com.app.api.RelatedProductFilterDto;
import com.app.api.error.MyException;

public interface ProductService {

	ProductDto addProduct(NewProductDto dto) throws MyException;

	List<ProductDto> getRelatedProducts(RelatedProductFilterDto filter);

	void addRelatedProduct(NewRelatedProductDto dto) throws MyException;

}
