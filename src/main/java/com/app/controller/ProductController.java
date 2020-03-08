package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.api.NewProductDto;
import com.app.api.NewRelatedProductDto;
import com.app.api.ProductDto;
import com.app.api.RelatedProductFilterDto;
import com.app.api.error.MyException;
import com.app.service.ProductService;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController extends BaseController {

	@Autowired
	private ProductService productService;

	@PostMapping("/add-product")
	public ResponseEntity<ProductDto> addProduct(final NewProductDto dto) throws MyException {

		ProductDto product = this.productService.addProduct(dto);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@GetMapping("/get-related-products")
	public ResponseEntity<List<ProductDto>> getRelatedProducts(final RelatedProductFilterDto filter) {

		List<ProductDto> relatedProducts = this.productService.getRelatedProducts(filter);
		return new ResponseEntity<>(relatedProducts, HttpStatus.OK);
	}
	
	@PostMapping("/add-related-product")
	public ResponseEntity<String> addRelatedProduct(final NewRelatedProductDto dto) throws MyException {

		this.productService.addRelatedProduct(dto);
		return new ResponseEntity<>("Success related products", HttpStatus.OK);
	}

}
