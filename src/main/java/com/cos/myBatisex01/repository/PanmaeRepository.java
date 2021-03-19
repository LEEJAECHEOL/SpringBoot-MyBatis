package com.cos.myBatisex01.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cos.myBatisex01.model.Product;
import com.cos.myBatisex01.model.beans.PanmaeBean;

@Mapper
// @Repository
public interface PanmaeRepository {
	public PanmaeBean findByIdAndJoin(int id);

}
