package sdpprojectassignment1.controller;

import java.util.ArrayList;
import java.util.List;

import sdpprojectassignment1.bean.Book;
import sdpprojectassignment1.bean.DigitalBook;
import sdpprojectassignment1.bean.TextBook;
import sdpprojectassignment1.database.DBMgr;

@SuppressWarnings("unchecked")
public class BookOperationsController {

	public void saveBook(Book book){

		System.out.println("Inside BookOperationsController saveBook method");
		System.out.println("Book to be inserted::"+book);
		DBMgr dao = new DBMgr();
		if("insert".equalsIgnoreCase(book.getOperationType())){
			System.out.println("inside insert save");
			book.setOperationType("insert");
			dao.insertBook(book);
		}else if("update".equalsIgnoreCase(book.getOperationType())){
			System.out.println("inside update save");
			book.setOperationType("update");
			dao.updateBookDetails(book);
		}
		
		System.out.println("BookOperationsController saveBook method completed");
	}

	public void deleteBook(Book book){
		System.out.println("Inside BookOperationsController deleteBook method");
		System.out.println("Book to be deleted::"+book);
		DBMgr dao = new DBMgr();
		book.setOperationType("delete");
		dao.DeleteBook(book);
		System.out.println("BookOperationsController deleteBook method completed");
	}

	public List<?> getAllBooks(String bookType){
		System.out.println("Inside BookOperationsController getAllBooks method");
		DBMgr dao = new DBMgr();
		Book book = null;
		if(bookType.equalsIgnoreCase("textbook")){
			book=new TextBook(bookType,"fetchAll");
		}else if(bookType.equalsIgnoreCase("digitalbook")){
			book=new DigitalBook(bookType,"fetchAll");
		}
		Object returnedBooks = dao.fetchAllDetails(book);

		if(returnedBooks!=null && returnedBooks instanceof List){
			System.out.println("BookOperationsController getAllBooks returned valid list");
			if("textbook".equalsIgnoreCase(book.getBookType())){
				
				List<TextBook> textBook = (ArrayList<TextBook>)returnedBooks;
				return textBook;
			}
			else if("digitalbook".equalsIgnoreCase(book.getBookType())){
				List<DigitalBook> digitalBook = (ArrayList<DigitalBook>)returnedBooks;
				return digitalBook;
			}
		}

		return null;

	}

	public List<?> findBookById(Book book){

		System.out.println("Inside BookOperationsController findBookById method");
		DBMgr dao = new DBMgr();
		book.setOperationType("fetchbyID");
		Object returnedBooks = dao.getBookDetails(book);

		if(returnedBooks!=null && returnedBooks instanceof List){
			System.out.println("BookOperationsController findBookById returned valid list");
			if("textbook".equalsIgnoreCase(book.getBookType())){
				List<TextBook> textBook = (ArrayList<TextBook>)returnedBooks;
				return textBook;
			}
			else if("digitalbook".equalsIgnoreCase(book.getBookType())){
				List<DigitalBook> digitalBook = (ArrayList<DigitalBook>)returnedBooks;
				return digitalBook;
			}
		}

		return null;

	}
	public List<?> findBookByName(Book book){

		System.out.println("Inside BookOperationsController findBookByName method");
		DBMgr dao = new DBMgr();
		book.setOperationType("fetchbyName");
		Object returnedBooks = dao.getBookDetails(book);

		if(returnedBooks!=null && returnedBooks instanceof List){
			System.out.println("BookOperationsController findBookByName returned valid list");
			if("textbook".equalsIgnoreCase(book.getBookType())){
				List<TextBook> textBook = (ArrayList<TextBook>)returnedBooks;
				return textBook;
			}
			else if("digitalbook".equalsIgnoreCase(book.getBookType())){
				List<DigitalBook> digitalBook = (ArrayList<DigitalBook>)returnedBooks;
				return digitalBook;
			}
		}

		return null;

	}
	public List<?> findBookByAuthor(Book book){

		System.out.println("Inside BookOperationsController findBookByAuthor method");
		DBMgr dao = new DBMgr();
		book.setOperationType("fetchbyauthor");
		Object returnedBooks = dao.getBookDetails(book);

		if(returnedBooks!=null && returnedBooks instanceof List){
			System.out.println("BookOperationsController findBookByAuthor returned valid list");
			if("textbook".equalsIgnoreCase(book.getBookType())){
				List<TextBook> textBook = (ArrayList<TextBook>)returnedBooks;
				return textBook;
			}
			else if("digitalbook".equalsIgnoreCase(book.getBookType())){
				List<DigitalBook> digitalBook = (ArrayList<DigitalBook>)returnedBooks;
				return digitalBook;
			}
		}

		return null;

	}

}
