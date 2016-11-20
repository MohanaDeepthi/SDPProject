package sdpprojectassignment1.command;
import java.sql.*;
import java.util.ArrayList;

import sdpprojectassignment1.bean.Book;
import sdpprojectassignment1.bean.DigitalBook;
import sdpprojectassignment1.bean.TextBook;
import sdpprojectassignment1.book.type.BookType;
import sdpprojectassignment1.book.type.DigitalBookType;
import sdpprojectassignment1.book.type.TextBookType;

public class FetchAllRecordsCommand extends DBCommand{
	
	Book book= new Book();
	String sql=null;
	
	public FetchAllRecordsCommand(Book book){
		this.book=book;	
	}

	@Override
	public BookType getBookType(Book book) {
		System.out.println("Inside getBookType");
		if(book.getBookType().equalsIgnoreCase("textbook")){
			
			return new TextBookType();
			
		}
		
		else if(book.getBookType().equalsIgnoreCase("digitalbook")){
			return  new DigitalBookType();
			
		}
			
		return null;
	}
	
	
	@Override
	public void executeCommand() {
		try{
			ResultSet resultset=null; 
			sql=getBookType(book).createQuery(book);
			System.out.println("Query Passed is "+sql);
			System.out.print("\nFetching all records from the table...");
			System.out.println("connection"+conn);
			System.out.println(conn);
			Statement stmt = conn.createStatement();


			resultset=stmt.executeQuery(sql);
			this.dbResult=resultset;
		}
		catch(Exception e){
			System.out.println(e);
			e.printStackTrace();
		}
		
		
	}

	@Override
	public Object getResult() {
		
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void processResult(Object dbResult) {
		@SuppressWarnings("rawtypes")
		ArrayList dbResultList = new ArrayList();
		if(dbResult!=null){
			if(dbResult instanceof ResultSet){
				
				try {
					ResultSet resultset=(ResultSet) dbResult;
					
					while(resultset.next()){
						
						if("textbook".equalsIgnoreCase(book.getBookType()))
						{
							TextBook book = new TextBook();
							
							book.setBookId(resultset.getInt("bookID"));
							book.setBookName(resultset.getString("BookName"));
							book.setAuthorName(resultset.getString("authorName"));
							book.setISBN(resultset.getString("ISBN"));
							book.setPrice(resultset.getFloat("price"));
							
							dbResultList.add(book);
						}
						else if("digitalbook".equalsIgnoreCase(book.getBookType()))
						{
							DigitalBook book = new DigitalBook();
							book.setBookId(resultset.getInt("bookID"));
							book.setBookName(resultset.getString("BookName"));
							book.setAuthorName(resultset.getString("authorName"));
							book.setDeviceCompatibility(resultset.getString("devicecompability"));
							book.setPrice(resultset.getFloat("price"));
							dbResultList.add(book);
						}
						
						
						
					}
					result = dbResultList;
				} catch (SQLException e) {
					
					e.printStackTrace();
				}	
			}
		}
		
	}
	
	@Override
	public void queryDB() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void undoQueryDB() {
		// TODO Auto-generated method stub
		
	}


}
