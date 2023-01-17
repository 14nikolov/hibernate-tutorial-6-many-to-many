# hibernate-tutorial-3-one-to-many-mapping

---I. Project Purpose ----------------------------------------------------------------------------------- 
	
	- The project is based on Section 24 from the Udemy course
	 Spring & Hibernate for Beginners (includes Spring Boot) by Chad Darby
	 
	- In this section we learn about:
	- @OneToMany mapping
	- @ManyToOne mapping
	- How to properly save a Parent Item and it's Children (check "CreateNewRowsInTablesDemo.java" for more details)
		- Use "session.save()" when working with "cascade=CascadeType.ALL"
		- Use "session.persist()" when working with specified cascade types
			example: cascade={CascadeType.DETACH,CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH}
	
	- Section 24 as of the time of making this project is:
    	Section 24: Hibernate Advanced Mappings - @OneToMany
	
---II. Project requires:---------------------------------------------------------------------------------------
	
	- Used OS - Windows 11 Pro 22H2 
	- Eclipse IDE (Used Version: 2022-09 (4.25.0) Build id: 20220908-1902)
	- Java 8 or 11 (Used Version: 11)
	- MySQL Server (Used Version: 8.0.31 MySQL Community Server - GPL)
	- MySQL Workbench (Used Version: 8.0.31 build 2235049 CE (64 bits) Community)
	- MySQL Connector/J (Used Version: Platform Independent mysql-connector-j-8.0.31)
	- Hibernate ORM 5.6.x. (Used Version: 5.6.5)
	- hibernate.cfg.xml starter file 

	
	
