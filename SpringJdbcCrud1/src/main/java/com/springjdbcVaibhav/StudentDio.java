package com.springjdbcVaibhav;

import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.ArrayList;  
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.ResultSetExtractor;  
import org.springframework.jdbc.core.RowMapper;  

public class StudentDio { 

	static Scanner sc = new Scanner(System.in);
	 private JdbcTemplate template;   
	@SuppressWarnings("resource")
	static ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");  
    static StudentDio sdao=(StudentDio)context.getBean("sdao"); 
    
    
	 public void setTemplate(JdbcTemplate template) {  
	    this.template = template;  
	}  
	
	  
	  public List<Student> getAllStudent(){
		  
		  
		 
		 List<Student> list = template.query("select * from student",new RowMapper<Student>(){  
			 	public Student mapRow(ResultSet rs, int rownumber) throws SQLException {  
			        Student s=new Student();  
			        s.setId(rs.getInt(1));  
			        s.setFname(rs.getString(2));  
			        return s;  
			    }  
			    });
		 return list;		    
		     
	        
		
	}
	 
	 public void insertSudent() {
		 
		 
		 
		 	System.out.println("Enter id:");
		 	int id = sc.nextInt();
		 	
		 	System.out.println("Enter fname:");
		 	String fname = sc.next();
		 	String sql = "insert into student (id,fname) values (?,?)";
		 	int result= this.template.update(sql,id,fname);
		 	if(result==0) {
		 		System.out.println("Insertion Failed...");
		 	}else {
		 		System.out.println("Insertion Success...");
		 	}
		 
		 
	 }


	public void updateStudent() {
		System.out.println("Enter id:");
	 	int id = sc.nextInt();
	 	
	 	System.out.println("Enter New fname:");
	 	String fname = sc.next();

	 	
	 	String sql = "update student set fname=? where id=?;";
	 	int result= this.template.update(sql,fname,id);
	 	
	 	if(result==0) {
	 		System.out.println("Updation Failed...");
	 	}else {
	 		System.out.println("Updation Success...");
	 	}

	}


	public void deleteStudent() {
		System.out.println("Enter id:");
	 	int id = sc.nextInt();
	 	
	 	
	 	
	 	String sql = "delete from student where id=?;";
	 	int result= this.template.update(sql,id);
	 	
	 	if(result==0) {
	 		System.out.println("Deletion Failed...");
	 	}else { 
	 		System.out.println("Deletion Success...");
	 	}
		
	}
	
} 
