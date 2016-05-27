package com.sap.jnc.marketing.web.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sap.jnc.marketing.persistence.models.Wine;
import com.sap.jnc.marketing.persistence.repositories.interfaces.WineRepository;

/**
 * @author I071053 Diouf Du
 */

@RestController
@RequestMapping
public class TestController {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
	private WineRepository wineRepository;

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
	
	@RequestMapping(value = "wechat", method = RequestMethod.GET)
	public String AndyTest(HttpServletRequest request) {
		Wine wineObject = new Wine();
		wineObject.setId("572B502000550C7DE10000000A6E98BC");
		return wineObject.getAmountA().toString();
	}
	
	@RequestMapping(value = "/wine/{id}", method = RequestMethod.GET)
	public Wine AndyTest(@PathVariable("id") String id) {
		 Wine wine = wineRepository.findOne(id);
		 return wine;
	}
}
