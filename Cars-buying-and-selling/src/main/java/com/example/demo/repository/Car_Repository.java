package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.example.demo.model.CarData;

@Repository
public class Car_Repository {

	@Autowired
	private JdbcTemplate template;

	public int adddata(CarData entity) {
		SimpleJdbcInsert inserter = new SimpleJdbcInsert(template);
		inserter.withTableName("CarData").usingColumns("carnumber", "model", "year_of_manufacturer",
				"kilometers_travelled", "owner_name", "status");
		BeanPropertySqlParameterSource sql = new BeanPropertySqlParameterSource(entity);
		return inserter.execute(sql);
	}

	public List<CarData> getallCardata() {

		String sql = "select * from CarData";

		List<CarData> custList = template.query(sql, BeanPropertyRowMapper.newInstance(CarData.class));

		return custList;
	}
	
	public List<CarData> getallCardata1() {

		String sql = "select * from CarData where status=unsold";

		List<CarData> custList1 = template.query(sql, BeanPropertyRowMapper.newInstance(CarData.class));

		return custList1;
	}
	
	
	public List<CarData> getallCardata2() {

		String sql = "select * from CarData where model=hyundai";

		List<CarData> custList2 = template.query(sql, BeanPropertyRowMapper.newInstance(CarData.class));

		return custList2;
	}
//

}
