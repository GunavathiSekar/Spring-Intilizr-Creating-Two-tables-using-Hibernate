package com.kgisl.dao;

import java.util.List;

import com.kgisl.model.Student;;

public interface StudDAO {
	public List<Student> list();
	
	public Student get(int id);
	
	public void saveOrUpdate(Student stud);
	
	public void delete(int id);
}