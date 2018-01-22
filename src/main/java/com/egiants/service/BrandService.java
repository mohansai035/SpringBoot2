package com.egiants.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import com.egiants.dao.BrandRepository;
import com.egiants.dao.JbdcBrandDao;
import com.egiants.model.Brand;


@Service
public class BrandService  {

	@Autowired
	private JbdcBrandDao brandRepository;
	
	public Brand getBrand(int brandId) {
	return brandRepository.selectBrand(brandId);
	}
	
	public int updateBrand(Brand e){
		return brandRepository.updateBrand(e);
	};
	public int deleteBrand(Brand e){
		return brandRepository.deleteBrand(e);
	};
	
	
	public int saveBrand(Brand e){
		return brandRepository.saveBrand(e);
	}
	
}
