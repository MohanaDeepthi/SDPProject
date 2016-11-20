package sdpprojectassignment1.command;
//import java.util.ArrayList;
//import java.util.List;

import sdpprojectassignment1.bean.Book;
//import sdpprojectassignment1.bean.TextBook;
import sdpprojectassignment1.book.type.BookType;
import sdpprojectassignment1.book.type.DigitalBookType;
import sdpprojectassignment1.book.type.TextBookType;
//import sdpprojectassignment1.database.DBMgr;
import sdpprojectassignment1.stack.BookStack;
import sdpprojectassignment1.stack.ExecuteStack;
import sdpprojectassignment1.stack.UndoneStack;
public class UnDoBookDBCommand extends DBCommand{

	
	Book book=null;
	int status=0;
	String sql=null;
	
	public UnDoBookDBCommand(Book book) {
		this.book=book;
	}
	
	public UnDoBookDBCommand() {
		
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
	
			DBCommand cmd = ExecuteStack.pop();
			if(cmd instanceof InsertBookDBCommand)
			{
				InsertBookDBCommand insertcmd = (InsertBookDBCommand)cmd;
				insertcmd.getBook().setOperationType("delete");
				DeleteBookCommand deletecmd = new DeleteBookCommand(insertcmd.getBook());
				deletecmd.execute();
				
				UndoneStack.push(deletecmd);
				
			}
			else if(cmd instanceof DeleteBookCommand)
			{
				DeleteBookCommand deletecmd = (DeleteBookCommand)cmd;
				deletecmd.getBook().setOperationType("insert");
				InsertBookDBCommand insertcmd = new InsertBookDBCommand(deletecmd.getBook());
				insertcmd.execute();
				
				UndoneStack.push(insertcmd);
				
			}
			else if(cmd instanceof UpdateBookDetailsCommand)
			{
				//DBMgr dbmgr = new DBMgr();
				UpdateBookDetailsCommand updateDetailsCommand = (UpdateBookDetailsCommand)cmd;
				
				Book previousBook = BookStack.getBook().pop(); 
				System.out.println("*** UnDoBookCommand :: executeCommand() :: previousBook=["+previousBook+"]");
				System.out.println("*** UnDoBookCommand :: executeCommand() :: previousBook.AuthNAme=["+previousBook.getAuthorName()+"]");
				System.out.println("*** UnDoBookCommand :: executeCommand() :: previousBook.BookType=["+previousBook.getBookType()+"]");
				previousBook.setOperationType("update");
				updateDetailsCommand.setBook(previousBook);
				
				updateDetailsCommand.execute();
				
				UndoneStack.push(updateDetailsCommand);
				
/*				updateDetailsCommand.getBook().setOperationType("update");
				Object returnedBooks = dbmgr.getBookDetails(updateDetailsCommand.getBook());
				System.out.println(":: executeCommand() :: returnedBooks=["+returnedBooks+"]");
				if(returnedBooks!=null)
				{
					if(returnedBooks instanceof ArrayList)
					{
						@SuppressWarnings("rawtypes")
						List dbResult = (ArrayList)returnedBooks;
						System.out.println("dbResult=["+dbResult+"]");
						if(dbResult.size()> 0)
						{
							for(int i=0; i<dbResult.size(); i++)
							{
								
								book = (TextBook)dbResult.get(i);			
								System.out.println("inside loop book=["+book+"]");
								
							}
						}
					}
				}
				UpdateBookDetailsCommand updateOld = new UpdateBookDetailsCommand(book);
				updateOld.execute();
				UndoneStack.push(updateOld);*/
				
				
				
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
