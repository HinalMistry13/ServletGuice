package com.guice.example.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.google.inject.Inject;
import com.guice.example.service.Student;
import com.guice.example.service.StudentService;

public class StudentServiceImpl implements StudentService {

	private EntityManager entityManager;
	
	@Override
	public List<Student> getStudents() {	
		List<Student> list = new ArrayList<Student>();
		for(int i=1;i<=10;i++) {
			Student stud = new Student();
			stud.setRollNo(i);
			stud.setName("ABC "+ i);
			list.add(stud);
		}
		return list;
	}
}
