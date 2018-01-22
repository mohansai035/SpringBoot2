package com.egiants.dao;



import java.util.List;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.egiants.model.Brand;
public interface BrandRepository  {
	void setDataSource(DataSource ds);

    void create(int brand_id,String brand_name, String brand_desc);

    public List<Brand> select(int brandId);

    List<Brand> selectAll();

    void deleteAll();

    public void delete(int brandId);

}




