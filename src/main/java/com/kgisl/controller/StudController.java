package com.kgisl.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import com.kgisl.dao.StudDAO;

import com.kgisl.model.Student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class StudController {
	
	@Autowired
	private StudDAO studDao;

	@RequestMapping("/student")
	public ModelAndView handleRequest() throws Exception {
		List<Student> listUsers = studDao.list();
		ModelAndView model = new ModelAndView("StudentList");
		model.addObject("studentList", listUsers);
		return model;
	}
	
	@RequestMapping(value = "/new1", method = RequestMethod.GET)
	public ModelAndView newStudent() {
		ModelAndView model = new ModelAndView("StudentForm");
		model.addObject("studt", new Student());
		return model;		
	}
	
	@RequestMapping(value = "/edit1", method = RequestMethod.GET)
	public ModelAndView editStudent(HttpServletRequest request) {
		int userId = Integer.parseInt(request.getParameter("id"));
		Student stud = studDao.get(userId);
		ModelAndView model = new ModelAndView("StudentForm");
		model.addObject("studt", stud);
		return model;		
	}
	
	@RequestMapping(value = "/delete1", method = RequestMethod.GET)
	public ModelAndView deleteStudent(HttpServletRequest request) {
		int userId = Integer.parseInt(request.getParameter("id"));
		studDao.delete(userId);
		return new ModelAndView("redirect:/");		
	}
	
	@RequestMapping(value = "/save1", method = RequestMethod.POST)
	public ModelAndView saveStudent(@ModelAttribute Student stud) {
		studDao.saveOrUpdate(stud);
		System.out.println(studDao);
		return new ModelAndView("redirect:/");
	}
	
}
