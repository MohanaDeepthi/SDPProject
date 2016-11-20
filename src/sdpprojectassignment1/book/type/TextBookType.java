package sdpprojectassignment1.book.type;

import sdpprojectassignment1.bean.Book;
import sdpprojectassignment1.bean.TextBook;

//It returns query based on textbook type and operation type

public class TextBookType extends BookType{
private String sql=null;
@Override
public String createQuery(Book book) {
	TextBook textBook = (TextBook)book;
	if(book.getOperationType().equalsIgnoreCase("insert")){
		 sql = "INSERT INTO TextBook (bookid, bookName,authorName,ISBN,price)" +
		        " VALUES ("+textBook.getBookId()+",\""+textBook.getBookName()+"\""+",\""+textBook.getAuthorName()+"\""+",\""+textBook.getISBN()+"\""+","+textBook.getPrice()+")";
		 
	}
	else if(book.getOperationType().equalsIgnoreCase("Delete")){
		sql = "Delete from TextBook where bookId="+textBook.getBookId();
	}
	else if(book.getOperationType().equalsIgnoreCase("Update")){
		sql="update TextBook SET bookname="+"\""+textBook.getBookName()+"\""+
				" , authorName="+"\""+textBook.getAuthorName()+"\""+
				" , ISBN="+"\""+textBook.getISBN()+"\""+" , price="+textBook.getPrice()+
				" where bookId="+textBook.getBookId();
	}
	else if(book.getOperationType().equalsIgnoreCase("fetchbyID")){
		sql = "select * from TextBook where bookId="+textBook.getBookId();
	}
	
	else if(book.getOperationType().equalsIgnoreCase("fetchByName")){
		sql="select * from TextBook where bookName="+"\""+textBook.getBookName()+"\"";
	}
	else if(book.getOperationType().equalsIgnoreCase("fetchByAuthor")){
		sql="select * from TextBook where authorName="+"\""+textBook.getAuthorName()+"\"";
	}
	else if(book.getOperationType().equalsIgnoreCase("fetchAll")){
		sql = "select * from TextBook";
	} 
	
	return sql;
}

}
