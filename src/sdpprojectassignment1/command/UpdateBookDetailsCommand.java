package sdpprojectassignment1.command;

import java.sql.*;

import sdpprojectassignment1.bean.Book;
import sdpprojectassignment1.book.type.BookType;
import sdpprojectassignment1.book.type.DigitalBookType;
import sdpprojectassignment1.book.type.TextBookType;
public class UpdateBookDetailsCommand extends DBCommand{
	
	String sql=null;
	/*private int bookID= 0;
	private String bookName=null;
	
	TextBook book= new TextBook();
	public UpdateBookDetailsCommand(int bookID,String bookName){
		this.bookID=bookID;
		this.bookName=bookName;
	}*/
	
	private Book book;

	public UpdateBookDetailsCommand(Book book) {
		this.book=book;
	}

	@Override
	public BookType getBookType(Book book) {
		System.out.println("Inside getBookType BookType="+book.getBookType());
		
		if(book.getBookType().equalsIgnoreCase("textbook")){
			System.out.println("getBookType():: getBookType Text");
			return  new TextBookType();
		}
		
		else if(book.getBookType().equalsIgnoreCase("digitalbook")){
			System.out.println("getBookType():: getBookType DigitalBook");
			return  new DigitalBookType();
		}
		System.out.println("getBookType():: getBookType");
		return null;
	}

	
	
	@Override
	public void executeCommand() {
		try{
			 
			int resultset;
			
			System.out.print("\nUpdate records from the table...");
			sql=getBookType(book).createQuery(book);
			System.out.println("Query Passed is "+sql);
			System.out.println("Connetion"+conn);
			
			Statement stmt = conn.createStatement();
			
			resultset=stmt.executeUpdate(sql);
			System.out.println("Value of the Resultset"+resultset);
			
			
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
	
	@Override
	public void processResult(Object dbResult) {
		//return result;
		System.out.println("Updated Successfully");
	}
	
	
	@Override
	public void queryDB() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void undoQueryDB() {
		// TODO Auto-generated method stub
		
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

