package com.egiants.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.egiants.model.Brand;

public class BrandInMemory {
	static HashMap<Integer,Brand> brandIdMap = getBrandIdMap();
	public BrandInMemory(){
		super();
		if(brandIdMap == null){
			brandIdMap = new HashMap<Integer,Brand>();
		}
	}
	
	public Brand selectBrand(int id){
		Brand brand=brandIdMap.get(id);
		return brand;
	}
	public Brand saveBrand(Brand brand){
		brand.setBrand_id(brandIdMap.size() + 1);
		brandIdMap.put(brand.getBrand_id(), brand);
		return brand;
	}
	public void deleteBrand(int id){
		brandIdMap.remove(id);
	}
	public Brand updateBrand(Brand e){
		e.setBrand_id(brandIdMap.size() + 1);
		brandIdMap.put(e.getBrand_id(), e);
		return e;
	}
	public static HashMap<Integer,Brand> getBrandIdMap(){
		return brandIdMap;
	}
}
