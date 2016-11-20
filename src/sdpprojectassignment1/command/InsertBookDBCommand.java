package sdpprojectassignment1.command;
import java.sql.*;

import sdpprojectassignment1.bean.Book;
import sdpprojectassignment1.book.type.BookType;
import sdpprojectassignment1.book.type.DigitalBookType;
import sdpprojectassignment1.book.type.TextBookType;
public class InsertBookDBCommand extends DBCommand{

	
	Book book=null;
	int status=0;
	String sql=null;
	
	public InsertBookDBCommand(Book book) {
		this.book=book;
	}
	
	
@Override
public BookType getBookType(Book book) {
	System.out.println("Inside getBookType");
	
	if(book.getBookType().equalsIgnoreCase("textbook")){
		//System.out.println("Inside IF");
		return  new TextBookType();
		
	}
	
	else if(book.getBookType().equalsIgnoreCase("digitalbook"))
	{
	
		return  new DigitalBookType();
		
	}
	
	
	return null;
}
	@Override
	public void executeCommand() {
		
		
		try{
			sql=getBookType(book).createQuery(book);
			System.out.println("Query Passed is "+sql);
			System.out.print("\nInserting records into table...");
			System.out.println("connection"+conn);
			Statement stmt=conn.createStatement();
			System.out.println(stmt);
			status= stmt.executeUpdate(sql); 
			
		    
							
			}				
		
		catch (Exception e){
			e.printStackTrace();
			System.out.println(e);
		}
		
	}

	@Override
	public Object getResult() {
		return status;
	}


	@Override
	public void processResult(Object dbResult) {
		
		
	}
	
	@Override
	public void queryDB() {
		
		
	}
	
	@Override
	public void undoQueryDB() {
		
		
	}


	/**
	 * @return the book
	 */
	public Book getBook() {
		return book;
	}


	/**
	 * @param book the book to set
	 */
	public void setBook(Book book) {
		this.book = book;
	}

}
