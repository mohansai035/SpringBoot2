package com.egiants.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BrandRowMapper implements RowMapper {
   @Override
    public Object mapRow(ResultSet rs, int line) throws SQLException {
        BrandResultSetExtractor extractor = new BrandResultSetExtractor();
        return extractor.extractData(rs);
    }

}