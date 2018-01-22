package com.egiants.controller;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.egiants.model.Brand;
import com.egiants.service.BrandService;



@RestController
@RequestMapping(value ="/brands")
public class BrandController {
	
	@Autowired
	private BrandService brandService;
	
	
	
	//To get single entry from db by id
	@GetMapping(value="/brand/{id}", produces="application/json")
	public Brand getBrandById(@PathVariable(value = "id") Integer brandId) {
	    Brand brand = brandService.getBrand(brandId);
	    return brand;
	}
		
	
	//To post a new entry in db
	@PostMapping(value="/load",produces="application/json")
	public int persist(@Validated @RequestBody Brand brand){
		return brandService.saveBrand(brand);
	}
	
	@PostMapping(value="/delete",produces="application/json")
	public int delete(@Validated @RequestBody Brand brand){
		return brandService.deleteBrand(brand);
	}
		
	@PostMapping(value="/update",produces="application/json")
	public int update(@Validated @RequestBody Brand brand){
		return brandService.updateBrand(brand);
	}
}

