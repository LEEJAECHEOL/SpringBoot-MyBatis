package com.cos.myBatisex01.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cos.myBatisex01.model.Product;

@Mapper
// @Repository
public interface ProductRepository {
	public void save(Product product);
	public void deleteById(int id);
	public void update(Product product);
	public List<Product> findAll();
	public Product findById(int id);
	
}
