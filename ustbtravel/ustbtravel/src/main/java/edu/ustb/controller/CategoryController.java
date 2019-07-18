package edu.ustb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ustb.domain.Category;
import edu.ustb.service.CategoryService;
import edu.ustb.service.impl.CategoryServiceImpl;

/**
 * Servlet implementation class CategoryController
 */
@WebServlet("/category/*")
public class CategoryController extends BaseServlet {
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    
    private CategoryService service = new CategoryServiceImpl();


    public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        List<Category> category = service.findAll();
        writeValue(category,response);
    }

}
