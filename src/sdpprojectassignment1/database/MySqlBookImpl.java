package sdpprojectassignment1.database;

import java.util.ArrayList;
import java.util.List;

import sdpprojectassignment1.bean.Book;
import sdpprojectassignment1.bean.DigitalBook;
import sdpprojectassignment1.bean.TextBook;
import sdpprojectassignment1.command.DBCommand;
import sdpprojectassignment1.command.DeleteBookCommand;
import sdpprojectassignment1.command.FetchAllRecordsCommand;
import sdpprojectassignment1.command.FetchBookByAuthorCommand;
import sdpprojectassignment1.command.FetchBookByIDCommand;
import sdpprojectassignment1.command.FetchBookByNameCommand;
import sdpprojectassignment1.command.InsertBookDBCommand;
import sdpprojectassignment1.command.ReDoBookDBCommand;
import sdpprojectassignment1.command.UnDoBookDBCommand;
import sdpprojectassignment1.command.UpdateBookDetailsCommand;
import sdpprojectassignment1.stack.BookStack;
import sdpprojectassignment1.stack.ExecuteStack;
import sdpprojectassignment1.stack.UndoneStack;

public class MySqlBookImpl implements DBBookImplInterface{
	//Constructor
	public MySqlBookImpl(){
		
		ExecuteStack.initialize();
		UndoneStack.initialize();
	}

	@Override
	public int insertBook(Book book) {
		try{
			System.out.println("Inside MySql text book");
			DBCommand cmd=new InsertBookDBCommand(book);
			cmd.execute();
			ExecuteStack.push(cmd);
			
			
			
			System.out.print("\nInserted records into table...");
			System.out.println("Insert record Result"+ cmd.getResult());
			
			

							
			}
				
		
		catch (Exception e){
			System.out.println(e);
		}
		return 0;
	}



	@Override
	public boolean DeleteBook(Book book) {
		try{
			System.out.println("Delete Bookin MyDQLBOOkDAO");
			DBCommand cmd=new DeleteBookCommand(book);
			cmd.execute();
			ExecuteStack.push(cmd);
			return true;
			
			}
			catch (Exception e){
				System.out.println(e);
				e.printStackTrace();
			}
			return false;

	}

	@Override
	public Object getBookDetails(Book book) {
		Object dbResult = null;
		try{
			System.out.println("Inside the 'MySqlImpl' getBookDetails Method");
			if(book.getOperationType().equalsIgnoreCase("fetchbyID")){
				DBCommand cmd=new FetchBookByIDCommand(book);
				cmd.execute();
				dbResult = cmd.getResult();
				}
			else if(book.getOperationType().equalsIgnoreCase("fetchbyName")){
				DBCommand cmd=new FetchBookByNameCommand(book);
				cmd.execute();
				dbResult = cmd.getResult();
			}
			else if(book.getOperationType().equalsIgnoreCase("fetchbyauthor")){
				DBCommand cmd=new FetchBookByAuthorCommand(book);
				cmd.execute();
				dbResult = cmd.getResult();
			}
			
			}
				
		
		catch (Exception e){
			System.out.println(e);
			e.printStackTrace();
		}
		return dbResult;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int updateBookDetails(Book book) {
		try{
			
			//Book originalBook = null;
			TextBook originalTBook = null;
			DigitalBook originalDBook = null;
			
			if("textbook".equalsIgnoreCase(book.getBookType()) )
			{
				//originalDBook = (DigitalBook)book;
				
				originalTBook = new TextBook(book.getBookId(), book.getBookType(),"fetchbyID");	
				
				FetchBookByIDCommand origianlBookCmd=new FetchBookByIDCommand(originalTBook);
				origianlBookCmd.execute();
				//@SuppressWarnings("unchecked")
				List<TextBook> dbBookList = (ArrayList<TextBook>)origianlBookCmd.getResult();
				originalTBook = (TextBook)dbBookList.get(0);
				BookStack.getBook().push(originalTBook); // for Undo update command to restore the entered Book details in UI
				
				System.out.println("*** MySQLImpl :: updateBookDetails() :: book=["+origianlBookCmd.getBook()+"]");
				System.out.println("***  MySQLImpl :: updateBookDetails() :: book.BookName=["+originalTBook.getBookName()+"]");
				System.out.println("***  MySQLImpl :: updateBookDetails() :: book.AuthNAme=["+originalTBook.getAuthorName()+"]");
				System.out.println("***  MySQLImpl :: updateBookDetails() :: book.Price=["+originalTBook.getPrice()+"]");
				
				System.out.println("***  MySQLImpl :: updateBookDetails() :: book.BookType=["+originalTBook.getBookType()+"]");
				
			}
			else if("digitalbook".equalsIgnoreCase(book.getBookType()) )
			{
				//originalDBook = (DigitalBook)book;
				
				originalDBook = new DigitalBook(book.getBookId(), book.getBookType(),"fetchbyID");	
				
				FetchBookByIDCommand origianlBookCmd=new FetchBookByIDCommand(originalDBook);
				origianlBookCmd.execute();
				List<DigitalBook> dbBookList = (ArrayList<DigitalBook>)origianlBookCmd.getResult();
				originalDBook = (DigitalBook)dbBookList.get(0);
				BookStack.getBook().push(originalDBook); // for Undo update command to restore the entered Book details in UI
				
				System.out.println("*** MySQLImpl :: updateBookDetails() :: book=["+origianlBookCmd.getBook()+"]");
				System.out.println("***  MySQLImpl :: updateBookDetails() :: book.BookName=["+originalDBook.getBookName()+"]");
				System.out.println("***  MySQLImpl :: updateBookDetails() :: book.AuthNAme=["+originalDBook.getAuthorName()+"]");
				System.out.println("***  MySQLImpl :: updateBookDetails() :: book.Price=["+originalDBook.getPrice()+"]");
				
				System.out.println("***  MySQLImpl :: updateBookDetails() :: book.BookType=["+originalDBook.getBookType()+"]");
			}
			
			DBCommand cmd=new UpdateBookDetailsCommand(book);
			cmd.execute();
			ExecuteStack.push(cmd);
			
			}
		catch (Exception e){
			System.out.println(e);
			e.printStackTrace();
		}
		return book.getBookId();
		
	}

	@Override
	public Object fetchAllDetails(Book book) {
		
		try{
			DBCommand cmd=new FetchAllRecordsCommand(book);
			cmd.execute();
					
			Object resultList = cmd.getResult();
			return resultList;
			}
		catch (Exception e){
			System.out.println(e);
			e.printStackTrace();
		}
		
		return book;
	}
	
	public void redo(){
		
		try{
			DBCommand cmd=new ReDoBookDBCommand();
			cmd.execute();
					
			
			}
		catch (Exception e){
			System.out.println(e);
			e.printStackTrace();
		}
		
	}

	@Override
	public void undo() {
		
		try{
			DBCommand cmd=new UnDoBookDBCommand();
			cmd.execute();
					
			
		}
		catch (Exception e){
			System.out.println(e);
			e.printStackTrace();
		}
		
	}

	
}


