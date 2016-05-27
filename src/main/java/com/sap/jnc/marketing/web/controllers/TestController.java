package com.sap.jnc.marketing.web.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author I071053 Diouf Du
 */

@RestController
@RequestMapping
public class TestController {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@RequestMapping(value = "test", method = RequestMethod.GET)
	public String findAll(HttpServletRequest request) {
		String sql = "SELECT TOP 10 * FROM \"JNC\".\"jncpf2::data_column.wine\"";
		List<String> results = jdbcTemplate.query(sql, new RowMapper<String>() {

			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString(1);
			}
		});
		String result = "";
		for (String cell : results) {
			result += cell + "             ";
		}
		return result;
	}
}
