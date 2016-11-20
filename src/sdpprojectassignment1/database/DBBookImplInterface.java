package sdpprojectassignment1.database;

import sdpprojectassignment1.bean.Book;

public interface DBBookImplInterface {
	public int insertBook(Book book);
	public boolean DeleteBook(Book book);
	public Object getBookDetails(Book book);
	public int updateBookDetails(Book book);
	public Object fetchAllDetails(Book book);
	public void redo();
	public void undo();
}