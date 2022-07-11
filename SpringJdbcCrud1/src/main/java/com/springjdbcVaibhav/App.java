package com.springjdbcVaibhav;

import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;  
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App 
{
	
	
	static Scanner sc = new Scanner(System.in);
	@SuppressWarnings("resource")
	static ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");  
    static StudentDio sdao=(StudentDio)context.getBean("sdao"); 
	
    public static void main( String[] args )
    {
    	 

    	while(true) {
    		System.out.println("*******Welcome********");
    		System.out.println("1.Insert");
    		System.out.println("2.Delete");
    		System.out.println("3.Display");
    		System.out.println("4.Update");
    		System.out.println("5.Exit");
    		
    		System.out.print("plese enter your choise :)");
    		int c= sc.nextInt();
    		if(c==1) {
    			sdao.insertSudent();
    		}
    		else if(c==2) {
    			sdao.deleteStudent(); 
    		}
    		else if(c==3) {
    			

    		    
    			List<Student> list=sdao.getAllStudent(); 
    	         for(Student e:list)  
    		            System.out.println(e);
    			
    		}
    		else if(c==4) {
    				
    			sdao.updateStudent(); 
    		
    		  
    		}
    		else if(c==5) {
    			//exit
    			break;
    		}
    		
    		
    	}System.out.println("you are succsessfully existed .... thank you");
     
    	
    	
    
    }  
}
  