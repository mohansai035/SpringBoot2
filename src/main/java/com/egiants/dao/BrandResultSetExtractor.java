package com.egiants.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.egiants.model.Brand;

public class BrandResultSetExtractor implements ResultSetExtractor {

    @Override
    public Object extractData(ResultSet rs) throws SQLException {
        Brand brand = new Brand();
        brand.setBrand_id(rs.getInt(1));
        brand.setBrand_name(rs.getString(2));
        brand.setBrand_desc(rs.getString(3));
        return brand;
    }

}
