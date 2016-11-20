package sdpprojectassignment1.bean;

public class TextBook extends Book{

	//int bookID;
	//String bookName;
	
	private String ISBN;
	
	//Boolean isAvailable;
	
	
	
	public TextBook(){
		/*super();
		this.bookID=0;
		this.bookName=null;*/
	}
	public TextBook(int bookID){
		this.bookID=bookID;
	}
	public TextBook(int bookID,String bookName){
		this.bookID=bookID;
		this.bookName=bookName;
	}
	public TextBook(int bookID, String bookName, String bookType, String operationType) {
		this.bookID=bookID;
		this.bookName=bookName;
		this.bookType = bookType;
		this.operationType = operationType;
		
	}
	public TextBook(int bookID, String bookName, String authorName, String iSBN, double price, String bookType,
			String operationType) {
		this.bookID=bookID;
		this.bookName=bookName;
		this.authorName=authorName;
		this.ISBN=iSBN;
		this.price=price;
		this.bookType=bookType;
		this.operationType=operationType;
	}
	
	public TextBook(int bookID, String bookType, String operationType) {
		this.bookID=bookID;
		this.bookType=bookType;
		this.operationType=operationType;
	}
	public TextBook(String bookType, String operationType) {
		this.bookType=bookType;
		this.operationType=operationType;
	}
	public TextBook(String bookName, String bookType, String operationType) {
		this.bookName=bookName;
		this.bookType=bookType;
		this.operationType=operationType;
	}
	/**
	 * @return the iSBN
	 */
	public String getISBN() {
		return ISBN;
	}
	/**
	 * @param iSBN the iSBN to set
	 */
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
		
	
}



