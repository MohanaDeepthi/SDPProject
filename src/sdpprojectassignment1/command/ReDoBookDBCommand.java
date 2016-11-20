package sdpprojectassignment1.command;
import java.util.ArrayList;
import java.util.List;

import sdpprojectassignment1.bean.Book;
import sdpprojectassignment1.bean.TextBook;
import sdpprojectassignment1.book.type.BookType;
import sdpprojectassignment1.book.type.DigitalBookType;
import sdpprojectassignment1.book.type.TextBookType;
import sdpprojectassignment1.database.DBMgr;
import sdpprojectassignment1.stack.ExecuteStack;
import sdpprojectassignment1.stack.UndoneStack;


public class ReDoBookDBCommand extends DBCommand{

	
	Book book=null;
	int status=0;
	String sql=null;
	
	public ReDoBookDBCommand(Book book) {
		this.book=book;
	}
	
	public ReDoBookDBCommand() {
		
	}
	
	@Override
	public void queryDB() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void undoQueryDB() {
		// TODO Auto-generated method stub
		
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
			
			
			System.out.println("==== Inside redo() ====");
			DBCommand cmd = UndoneStack.pop();
			System.out.println("==== Inside redo() :: cmd===="+cmd);
			
			if(cmd instanceof InsertBookDBCommand)
			{
				InsertBookDBCommand insertcmd = (InsertBookDBCommand)cmd;
				insertcmd.getBook().setOperationType("delete");
				DeleteBookCommand deletecmd = new DeleteBookCommand(insertcmd.getBook());
				deletecmd.execute();
				
				ExecuteStack.push(deletecmd);
				
			}
			else if(cmd instanceof DeleteBookCommand)
			{
				DeleteBookCommand deletecmd = (DeleteBookCommand)cmd;
				deletecmd.getBook().setOperationType("insert");
				InsertBookDBCommand insertcmd = new InsertBookDBCommand(deletecmd.getBook());
				insertcmd.execute();
				
				ExecuteStack.push(insertcmd);
								
			}
			else if(cmd instanceof UpdateBookDetailsCommand)
			{
				DBMgr dbmgr = new DBMgr();
				UpdateBookDetailsCommand updateDetailsCommand = (UpdateBookDetailsCommand)cmd;
				updateDetailsCommand.getBook().setOperationType("update");
				Object returnedBooks = dbmgr.getBookDetails(updateDetailsCommand.getBook());
				
				if(returnedBooks!=null)
				{
					if(returnedBooks instanceof ArrayList)
					{
						@SuppressWarnings("rawtypes")
						List dbResult = (ArrayList)returnedBooks;
						
						if(dbResult.size()> 0)
						{
							for(int i=0; i<dbResult.size(); i++)
							{
								book = (TextBook)dbResult.get(i);							
								
							}
						}
					}
				}
				book.setOperationType("update");
				UpdateBookDetailsCommand updateOld = new UpdateBookDetailsCommand(book);
				updateOld.execute();
				
				ExecuteStack.push(updateOld);
								
			}
							
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
		// TODO Auto-generated method stub
		
	}



}
