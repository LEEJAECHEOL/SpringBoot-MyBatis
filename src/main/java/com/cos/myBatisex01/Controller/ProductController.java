package com.cos.myBatisex01.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cos.myBatisex01.model.beans.PanmaeBean;
import com.cos.myBatisex01.repository.PanmaeRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ProductController {
   private final PanmaeRepository panmaeRepository;
   
   @GetMapping("/panmae/{id}")
   public PanmaeBean findByIdAndJoin(@PathVariable int id){
	   return panmaeRepository.findByIdAndJoin(id);
   }
}