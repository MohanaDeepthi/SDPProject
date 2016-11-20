package sdpprojectassignment1.database;

import sdpprojectassignment1.bean.Book;


public class DBMgr {
	String dbType = null;
	DBBookImplInterface imp= new MySqlBookImpl(); 

	public DBMgr() {
		//String dbType=DBTypes.MYSQL.getValue();
	}
	public int updateBookDetails(Book book) {

		int i=imp.updateBookDetails(book);
		return i;
	}


	public int insertBook(Book book) {
		int i=imp.insertBook(book);
		return i;
	}


	public Object getBookDetails(Book book2) {
		Object book=(Object)imp.getBookDetails(book2);
		return book;
	}


	public boolean DeleteBook(Book book) {
		boolean b= imp.DeleteBook(book);
		return b;
	}

	public Object fetchAllDetails(Book book1){

		Object book=(Object)imp.fetchAllDetails(book1);
		return book;


	}

	public void redo(){
		imp.redo();
	}

	public void undo(){
		imp.undo();
	}



}			
