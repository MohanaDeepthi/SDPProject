package sdpprojectassignment1.test;
import java.util.*;

import sdpprojectassignment1.bean.Book;
import sdpprojectassignment1.bean.DigitalBook;
import sdpprojectassignment1.bean.TextBook;
import sdpprojectassignment1.database.DBMgr;

public class BookControllerTest {
	
@SuppressWarnings("rawtypes")
public static void main(String[] args){
	
	DBMgr dao = new DBMgr();
	String operationType=null;
	
	
	ArrayList dbResult = new ArrayList();
	
	Scanner bookInput = new Scanner(System.in);
	
	System.out.println("Please enter the operation Insert or Delete or Update or FetchbyID or FetchbyName or FetchByAuthor or FetchAll");
	operationType=bookInput.nextLine();
	
	System.out.println("Please enter the BookType:TextBook or DigitalBook");
	String bookType=bookInput.nextLine();

	
	if(operationType.equalsIgnoreCase("insert")){
		//Insert Book Details
		System.out.println("Please Enter BookTitle");
		String bookName=bookInput.nextLine();
	
		System.out.println("Please Enter AuthorName");
		String authorName=bookInput.nextLine();
		
		System.out.println("Please Enter BookID");
		int bookID=(bookInput.nextInt());
		System.out.println("Please Enter Price");
		double price=bookInput.nextDouble();

		
			
		if(bookType.equalsIgnoreCase("textbook")){
			bookInput.nextLine();
		System.out.print("Please Enter ISBN No");
		String ISBN=bookInput.nextLine();
		

		Book book=new TextBook(bookID,bookName,authorName,ISBN,price,bookType,operationType); 
		
		dao.insertBook(book);
		}
		else if(bookType.equalsIgnoreCase("digitalbook")){
			bookInput.nextLine();
			System.out.print("Please Enter Device Compatibility:\n");
			String deviceCompability=bookInput.nextLine();
						
			
			System.out.println(" Device Compatibility:"+deviceCompability);
			Book book=new DigitalBook(bookID,bookName,authorName,deviceCompability,price,bookType,operationType); 
			
			dao.insertBook(book);

		}
	}
	
	else if(operationType.equalsIgnoreCase("delete")){
		System.out.println("Inside the delete operation");
		//Delete Book Details
		
		System.out.println("Please Enter BookID");
		int bookID=bookInput.nextInt();
		if(bookType.equalsIgnoreCase("textbook")){
			Book book=new TextBook(bookID,bookType,operationType);
		    dao.DeleteBook(book);
		}
		else if(bookType.equalsIgnoreCase("digitalbook")){
			Book book=new DigitalBook(bookID,bookType,operationType);
		    dao.DeleteBook(book);
		}
	}
	
	else if(operationType.equalsIgnoreCase("update")){
		System.out.println("Inside the Update operation");
		//Delete Book Details
		
		System.out.println("Please Enter BookID");
		int bookID=bookInput.nextInt();
		bookInput.nextLine();
		System.out.println("Please Enter BookName to update");
		String bookName = bookInput.nextLine(); 
		if(bookType.equalsIgnoreCase("textbook")){
			Book book=new TextBook(bookID,bookName,bookType,operationType);
		    dao.updateBookDetails(book);
		}
		else if(bookType.equalsIgnoreCase("digitalbook")){
			Book book=new DigitalBook(bookID,bookName,bookType,operationType);
		    dao.updateBookDetails(book);
		}
	}
	else if(operationType.equalsIgnoreCase("fetchbyid")){
		//Fetch Book by ID
		System.out.println("Inside fetch operation: ");
		System.out.println("Enter Book Id");
		int bookID=bookInput.nextInt();
		if(bookType.equalsIgnoreCase("textbook")){
			TextBook book=new TextBook(bookID,bookType,operationType);
		
			Object returnedBooks = dao.getBookDetails(book);
			
			if(returnedBooks!=null)
			{
				if(returnedBooks instanceof ArrayList)
				{
					dbResult = (ArrayList)returnedBooks;
					
					if(dbResult.size()> 0)
					{
						for(int i=0; i<dbResult.size(); i++)
						{
							book = (TextBook)dbResult.get(i);
							System.out.print(book.getBookId()+"\t\t\t");
							System.out.print(book.getBookName()+"\t\t\t");
							System.out.print(book.getAuthorName()+"\t\t\t");
							System.out.print(book.getISBN()+"\t\t\t");
							System.out.print(book.getPrice()+"\n");
							
							
						}
					}
				}
			}
				
		}		
		
				
		else if(bookType.equalsIgnoreCase("digitalbook")){
		
			DigitalBook book=new DigitalBook(bookID,bookType,operationType);
			
			Object returnedBooks = dao.getBookDetails(book);
								
			if(returnedBooks!=null)
			{
				if(returnedBooks instanceof ArrayList)
				{
					dbResult = (ArrayList)returnedBooks;
					
					if(dbResult.size()> 0)
					{
						for(int i=0; i<dbResult.size(); i++)
						{
							book = (DigitalBook)dbResult.get(i);
							System.out.print(book.getBookId()+"\t\t\t");
							System.out.print(book.getBookName()+"\t\t\t");
							System.out.print(book.getAuthorName()+"\t\t\t");
							System.out.print(book.getDeviceCompatibility()+"\t\t\t");
							System.out.print(book.getPrice()+"\n");
							
							
						}
					}
				}
			}
			
		}
	
	
	}		
	
	else if(operationType.equalsIgnoreCase("fetchbyname")){
		
		System.out.println("Inside fetch operation: ");
		System.out.println("Enter BookName");
		String bookName=bookInput.nextLine();
		if(bookType.equalsIgnoreCase("textbook")){
			TextBook book=new TextBook(bookName,bookType,operationType);
		
			Object returnedBooks = dao.getBookDetails(book);
			
			if(returnedBooks!=null)
			{
				if(returnedBooks instanceof ArrayList)
				{
					dbResult = (ArrayList)returnedBooks;
					
					if(dbResult.size()> 0)
					{
						for(int i=0; i<dbResult.size(); i++)
						{
							book = (TextBook)dbResult.get(i);
							System.out.print(book.getBookId()+"\t\t\t");
							System.out.print(book.getBookName()+"\t\t\t");
							System.out.print(book.getAuthorName()+"\t\t\t");
							System.out.print(book.getISBN()+"\t\t\t");
							System.out.print(book.getPrice()+"\n");
							
							
						}
					}
				}
			}
				
		}		
		
				
		else if(bookType.equalsIgnoreCase("digitalbook")){
		
			DigitalBook book=new DigitalBook(bookName,bookType,operationType);
			
			Object returnedBooks = dao.getBookDetails(book);
								
			if(returnedBooks!=null)
			{
				if(returnedBooks instanceof ArrayList)
				{
					dbResult = (ArrayList)returnedBooks;
					
					if(dbResult.size()> 0)
					{
						for(int i=0; i<dbResult.size(); i++)
						{
							book = (DigitalBook)dbResult.get(i);
							System.out.print(book.getBookId()+"\t\t\t");
							System.out.print(book.getBookName()+"\t\t\t");
							System.out.print(book.getAuthorName()+"\t\t\t");
							System.out.print(book.getDeviceCompatibility()+"\t\t\t");
							System.out.print(book.getPrice()+"\n");
							
							
						}
					}
				}
			}
			
		}
		
	}			
	
else if(operationType.equalsIgnoreCase("fetchbyauthor")){
		
		System.out.println("Inside fetch operation: ");
		System.out.println("Enter AuthorName");
		String authorName=bookInput.nextLine();
		System.out.println(authorName);
		if(bookType.equalsIgnoreCase("textbook")){
			TextBook book=new TextBook(authorName,bookType,operationType);
		
			Object returnedBooks = dao.getBookDetails(book);
			
			if(returnedBooks!=null)
			{
				if(returnedBooks instanceof ArrayList)
				{
					dbResult = (ArrayList)returnedBooks;
					
					if(dbResult.size()> 0)
					{
						for(int i=0; i<dbResult.size(); i++)
						{
							book = (TextBook)dbResult.get(i);
							System.out.print(book.getBookId()+"\t\t\t");
							System.out.print(book.getBookName()+"\t\t\t");
							System.out.print(book.getAuthorName()+"\t\t\t");
							System.out.print(book.getISBN()+"\t\t\t");
							System.out.print(book.getPrice()+"\n");
							
							
						}
					}
				}
			}
				
		}		
		
				
		else if(bookType.equalsIgnoreCase("digitalbook")){
		
			DigitalBook book=new DigitalBook(authorName,bookType,operationType);
			
			Object returnedBooks = dao.getBookDetails(book);
								
			if(returnedBooks!=null)
			{
				if(returnedBooks instanceof ArrayList)
				{
					dbResult = (ArrayList)returnedBooks;
					
					if(dbResult.size()> 0)
					{
						for(int i=0; i<dbResult.size(); i++)
						{
							book = (DigitalBook)dbResult.get(i);
							System.out.print(book.getBookId()+"\t\t\t");
							System.out.print(book.getBookName()+"\t\t\t");
							System.out.print(book.getAuthorName()+"\t\t\t");
							System.out.print(book.getDeviceCompatibility()+"\t\t\t");
							System.out.print(book.getPrice()+"\n");
							
							
						}
					}
				}
			}
			
		}
		
	}			
	
	
	

	else if(operationType.equalsIgnoreCase("fetchAll")){
		//Fetch all
		System.out.println("Inside fetch All operation: ");
		
		if(bookType.equalsIgnoreCase("textbook")){
			TextBook book=new TextBook(bookType,operationType);
		
			Object returnedBooks = dao.getBookDetails(book);
			
			if(returnedBooks!=null)
			{
				if(returnedBooks instanceof ArrayList)
				{
					dbResult = (ArrayList)returnedBooks;
					
					if(dbResult.size()> 0)
					{
						for(int i=0; i<dbResult.size(); i++)
						{
							book = (TextBook)dbResult.get(i);
							System.out.print(book.getBookId()+"\t\t\t");
							System.out.print(book.getBookName()+"\t\t\t");
							System.out.print(book.getAuthorName()+"\t\t\t");
							System.out.print(book.getISBN()+"\t\t\t");
							System.out.print(book.getPrice()+"\n");
							
							
						}
					}
				}
			}
				
		}
		
		else if(bookType.equalsIgnoreCase("digitalbook")){
			
			DigitalBook book=new DigitalBook(bookType,operationType);
			
			Object returnedBooks = dao.getBookDetails(book);
								
			if(returnedBooks!=null)
			{
				if(returnedBooks instanceof ArrayList)
				{
					dbResult = (ArrayList)returnedBooks;
					
					if(dbResult.size()> 0)
					{
						for(int i=0; i<dbResult.size(); i++)
						{
							book = (DigitalBook)dbResult.get(i);
							System.out.print(book.getBookId()+"\t\t\t");
							System.out.print(book.getBookName()+"\t\t\t");
							System.out.print(book.getAuthorName()+"\t\t\t");
							System.out.print(book.getDeviceCompatibility()+"\t\t\t");
							System.out.print(book.getPrice()+"\n");
							
							
						}
					}
				}
			}
			
		}
	
			
			bookInput.close();	
}		
			
			
}
}




		

