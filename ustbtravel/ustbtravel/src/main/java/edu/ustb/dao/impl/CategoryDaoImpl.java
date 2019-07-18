package edu.ustb.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import edu.ustb.dao.CategoryDao;
import edu.ustb.domain.Category;
import edu.ustb.util.JDBCUtils;

public class CategoryDaoImpl implements CategoryDao{
	
	private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

	@Override
	public List<Category> findAll(){
		String sql="select * from tab_category";
		return template.query(sql, new BeanPropertyRowMapper<Category>(Category.class));
	}

}
