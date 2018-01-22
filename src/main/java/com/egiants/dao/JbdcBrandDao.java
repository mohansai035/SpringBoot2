package com.egiants.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.egiants.model.Brand;

public class JbdcBrandDao implements BrandRepository {  
	 private DataSource dataSource;

	    public void setDataSource(DataSource ds) {
	        dataSource = ds;
	    }

	    public void create(int BrandId,String BrandName, String BrandDesc){
	        JdbcTemplate insert = new JdbcTemplate(dataSource);
	        insert.update("INSERT INTO brand (brand_id, brand_name,brand_des) VALUES(?,?,?)",
	                new Object[] { BrandId, BrandName,BrandDesc });
	    }

	    public List<Brand> select(int brandId) {
	        JdbcTemplate select = new JdbcTemplate(dataSource);
	        return select
	        		.query(
	                        "select  * from brand where brand_id = ?",
	                        new Object[] {brandId},
	                        new BrandRowMapper());
	    }

	    public List<Brand> selectAll(){
	        JdbcTemplate select = new JdbcTemplate(dataSource);
	        return select.query("select * from brand",
	                new BrandRowMapper());
	    }

	    public void deleteAll() {
	        JdbcTemplate delete = new JdbcTemplate(dataSource);
	        delete.update("DELETE from brand");
	    }

	    public void delete(int brandId) {
	        JdbcTemplate delete = new JdbcTemplate(dataSource);
	        delete.update("DELETE from brand where brand_id= ?",
	                new Object[] { brandId });
	    }
  
}  
