package com.elkardumen.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.directwebremoting.Browser;
import org.directwebremoting.ScriptSessions;

public class MyThread implements Runnable{

	private static boolean active = true;
    private static Thread hiloMyThread=null;	


	public synchronized void arranca() {
		//Garantizamos que solo sea un hilo
		if(hiloMyThread==null){
			
			System.out.println("*******************************");
			System.out.println("****Inicio de MyThread  **********");
			System.out.println("*******************************");
			
			hiloMyThread=new Thread(this);
			hiloMyThread.start();
		}
		
	}
	
	@Override
	public void run() {
		try{
			//Hilo va ser infinito hasta que active sea igual a False
			while(active){
				Date now2 = new Date();
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				
				System.out.println("------------>"+format.format(now2));
				final String funcion="miFuncionJavaScript";
				final String mensaje=format.format(now2);
				
				
				Browser.withPage("/SingletonThread/prueba.html",
						new Runnable() {
							public void run() {
								ScriptSessions.addFunctionCall(funcion, mensaje);
							}
						}
					);
				
				Thread.sleep(1000L);
			}
			System.out.println("*******************************");
			System.out.println("****Fin de MyThread  **********");
			System.out.println("*******************************");
			
	}catch(Exception e){
		
		e.printStackTrace();
	}
	
}	
	public static boolean isActive() {
		return active;
	}


	public static void setActive(boolean active) {
		MyThread.active = active;
	}

	
}
