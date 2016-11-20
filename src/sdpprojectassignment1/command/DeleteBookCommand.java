package sdpprojectassignment1.command;

import java.sql.*;

import sdpprojectassignment1.bean.Book;
import sdpprojectassignment1.book.type.BookType;
import sdpprojectassignment1.book.type.DigitalBookType;
import sdpprojectassignment1.book.type.TextBookType;

public class DeleteBookCommand extends DBCommand{
	
	Book book=null;
	int status=0;
	String sql=null;
	
	public DeleteBookCommand(Book book){
		this.book=book;
	}

	@Override
	public BookType getBookType(Book book) {
		System.out.println("Inside getBookType");
		
		if(book.getBookType().equalsIgnoreCase("textbook")){
			
			return  new TextBookType();
		
		}
	
		if(book.getBookType().equalsIgnoreCase("digitalbook")){
			
			return  new DigitalBookType();
		
		}
		return null;
	}

	
	@Override
	public void executeCommand() {
	
		
		try{
			System.out.println("DeleteDBCommand");
			String sql=getBookType(book).createQuery(book);
			System.out.println("Query Passed is "+sql);		
			System.out.print("\nDelete records from the table...");
			System.out.println(conn);
			Statement stmt = conn.createStatement();
		
			status = stmt.executeUpdate(sql); 
							
			}				
		
		catch (Exception e){
			System.out.println(e);
			e.printStackTrace();
		}
		
	}

		


	@Override
	public Object getResult() {
		
		return status;
	}

	@Override
	public void processResult(Object dbResult) {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public void queryDB() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void undoQueryDB() {
		
		try{
			book.setOperationType("insert");
			sql=getBookType(book).createQuery(book);
			System.out.println("Query Passed is "+sql);
			System.out.print("\n undoQueryDB() :: inserting records into table...");
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

