package raf.console.springshopdemo.service;

import raf.console.springshopdemo.dto.ProductDto;

import java.util.List;

public interface ProductService {
	List<ProductDto> getAll();
	void addToUserBucket(Long productId, String username);
	void addProduct(ProductDto dto);
	ProductDto getById(Long id);
}
