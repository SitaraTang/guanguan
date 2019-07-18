package edu.ustb.service.impl;

import java.util.List;

import edu.ustb.dao.CategoryDao;
import edu.ustb.dao.impl.CategoryDaoImpl;
import edu.ustb.domain.Category;
import edu.ustb.service.CategoryService;

public class CategoryServiceImpl implements CategoryService{
	public  List<Category> findAll(){
		List<Category> c = null;
		CategoryDao cd = new CategoryDaoImpl();
		c=cd.findAll();
		return c;
	}

}
