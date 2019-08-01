package com.guice.example.config;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.guice.example.impl.StudentServiceImpl;
import com.guice.example.service.StudentService;
import com.guice.example.servlet.ViewStudentData;

public class ServletConfig extends GuiceServletContextListener{

	@Override
	protected Injector getInjector() {
		return Guice.createInjector(new ServletModule() {
			@Override
			protected void configureServlets() {
				bind(StudentService.class).to(StudentServiceImpl.class);
				serve("/*").with(ViewStudentData.class);
			}
		});
	}

}
