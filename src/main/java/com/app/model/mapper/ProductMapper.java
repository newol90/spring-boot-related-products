package com.app.model.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.app.api.ProductDto;
import com.app.model.entity.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {

	@Mapping(target = "client.products", ignore = true)
	@Mapping(target = "relatedProducts", ignore = true)
	ProductDto productToProductDto(Product product);

	Product productDtoToProduct(ProductDto productDto);

	List<ProductDto> productsToProductDtos(List<Product> products);

}
