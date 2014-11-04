package com.elkardumen.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.elkardumen.service.MyThread;

public class SimpleServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		MyThread.setActive(false);
		
		System.out.println("Destruye while de Hilo");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("Servlet conext initialized");
	}

}
