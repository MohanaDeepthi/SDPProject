package sdpprojectassignment1.command;
import java.sql.*;

import sdpprojectassignment1.bean.Book;
import sdpprojectassignment1.book.type.BookType;

public abstract class DBCommand {
	
	
		 public Object result;
		 public Object dbResult;
		 public Connection conn=null;
		 final String JDBC_DRIVER= "com.mysql.jdbc.Driver";
		 final String DB_URL="jdbc:mysql://localhost/Cse1";
			
		
		 final String USER="root";
		 final String PASSWORD = "root";
		 	 
		 public abstract void executeCommand();
		 public abstract Object getResult(); 
		 public abstract BookType getBookType(Book book);
		 
		 private Connection connectDB(){
			 try {
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("Connecting to a selected database...");
					try {
						this.conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
						
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
					System.out.println("Connecting to a selected database..."+conn);
				} catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				}
						
				return conn;
		 }
		 private void disConnectDB(){
				
					try {
						if(this.conn!=null){
						conn.close();
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
		 }
		 
		 public abstract void processResult(Object dbResult);
		 
		 public abstract void queryDB();
			
		 public abstract void undoQueryDB();
		 
		 //Template Method
		 public Object execute(){
			  
			 connectDB();
			 executeCommand();
			 processResult(dbResult);
			 disConnectDB();
			 return getResult();
			  
		 }
		 
		 
		 public void undo()
			{
				try
				{
					if(conn!=null)
					{
						undoQueryDB();
						processResult(dbResult);
					}
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				finally
				{
					disConnectDB();
				}	
			}
		 
		 		 
		}


