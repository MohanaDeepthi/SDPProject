package sdpprojectassignment1.book.type;

import sdpprojectassignment1.bean.Book;
import sdpprojectassignment1.bean.DigitalBook;

public class DigitalBookType extends BookType{
	private String sql=null;
	@Override
	public String createQuery(Book book) {
		DigitalBook digitalBook = (DigitalBook)book;
		if(book.getOperationType().equalsIgnoreCase("insert")){
			 sql = "INSERT INTO DigitalBook (bookid, bookName,authorName,devicecompability,price)" +
			        " VALUES ("+digitalBook.getBookId()+",\""+digitalBook.getBookName()+"\""+",\""+digitalBook.getAuthorName()+"\""+",\""+digitalBook.getDeviceCompatibility()+"\""+","+digitalBook.getPrice()+")";
			 
		}
		else if(book.getOperationType().equalsIgnoreCase("Delete")){
			sql = "Delete from DigitalBook where bookId="+digitalBook.getBookId();
		}
		else if(book.getOperationType().equalsIgnoreCase("Update")){
			sql="update DigitalBook SET bookname="+"\""+digitalBook.getBookName()+"\""+
					" , authorName="+"\""+digitalBook.getAuthorName()+"\""+
					" , devicecompability="+"\""+digitalBook.getDeviceCompatibility()+"\""+" , price="+digitalBook.getPrice()+" where bookId="+digitalBook.getBookId();
		}
		else if(book.getOperationType().equalsIgnoreCase("fetchbyID")){
			sql = "select * from DigitalBook where bookId="+digitalBook.getBookId();
		}
		
		else if(book.getOperationType().equalsIgnoreCase("fetchByName")){
			sql="select * from DigitalBook where bookName="+"\""+digitalBook.getBookName()+"\"";
		}
		else if(book.getOperationType().equalsIgnoreCase("fetchByAuthor")){
			sql="select * from DigitalBook where authorName="+"\""+digitalBook.getAuthorName()+"\"";
		}
		else if(book.getOperationType().equalsIgnoreCase("fetchAll")){
			sql = "select * from DigitalBook";
		} 
		System.out.println("createQuery():: sql="+sql);
		return sql;
	}

}
