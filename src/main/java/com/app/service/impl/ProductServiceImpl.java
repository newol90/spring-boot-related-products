package com.app.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.api.ClientDto;
import com.app.api.NewProductDto;
import com.app.api.NewRelatedProductDto;
import com.app.api.ProductDto;
import com.app.api.RelatedProductFilterDto;
import com.app.api.error.MyException;
import com.app.model.entity.Product;
import com.app.model.entity.ProductProduct;
import com.app.model.entity.ProductProductPK;
import com.app.model.mapper.ProductMapper;
import com.app.repository.ProductProductRepository;
import com.app.repository.ProductRepository;
import com.app.service.ProductService;
import com.app.util.ExceptionUtils;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductProductRepository productProductrepository;

	@Autowired
	private ProductMapper productMapper;

	@Override
	public ProductDto addProduct(NewProductDto dto) throws MyException {

		ProductDto productDto = new ProductDto();
		productDto.setName(dto.getName());
		productDto.setClient(new ClientDto());
		productDto.getClient().setIdClient(dto.getIdClient());
		Product product = this.productMapper.productDtoToProduct(productDto);
		try {
			product = this.productRepository.save(product);
			return this.productMapper.productToProductDto(product);
		} catch (Exception e) {
			throw new MyException(ExceptionUtils.getMessageCause(e));
		}
	}

	@Override
	public List<ProductDto> getRelatedProducts(RelatedProductFilterDto filter) throws MyException {

		Optional<Product> product = this.productRepository.findByNameAndClient_idClient(filter.getProductName(),
				filter.getIdClient());
		if (product.isPresent()) {
			return this.productMapper.productsToProductDtos(product.get().getRelatedProducts());
		} else {
			throw new MyException(String.format("Product with name %s does not exist for customer %s",
					filter.getProductName(), filter.getIdClient()));
		}
	}

	@Override
	public void addRelatedProduct(NewRelatedProductDto dto) throws MyException {

		ProductProduct product = new ProductProduct();
		ProductProductPK productProductPK1 = new ProductProductPK();
		productProductPK1.setIdProduct(dto.getIdProduct());
		productProductPK1.setIdRelatedProduct(dto.getIdRelatedProduct());
		product.setId(productProductPK1);

		ProductProduct relatedProduct = new ProductProduct();
		ProductProductPK productProductPK2 = new ProductProductPK();
		productProductPK2.setIdProduct(dto.getIdRelatedProduct());
		productProductPK2.setIdRelatedProduct(dto.getIdProduct());
		relatedProduct.setId(productProductPK2);

		try {
			this.productProductrepository.saveAll(Arrays.asList(product, relatedProduct));
		} catch (Exception e) {
			throw new MyException(ExceptionUtils.getMessageCause(e));
		}
	}

}
