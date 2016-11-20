package sdpprojectassignment1.bean;

public class Book {

	protected int bookID;
	protected String bookName;
	protected String authorName;
	protected double price;
	protected String bookType;
	protected String operationType;
	
	public Book(){
		
	}
	public Book(int bookID){
		this.bookID=bookID;
	}
	public Book(int bookID,String bookName){
		this.bookID=bookID;
		this.bookName=bookName;
	}
	
	
	//getter method
	public String getBookName(){
		return bookName;
	}
	public int getBookId(){
		return bookID;
	}
	
	//Setter Methods
	public void setBookName(String BookName){
		this.bookName=BookName;
		
	}
	
	public void setBookId(int bookID){
		this.bookID=bookID;
	}
	/**
	 * @return the bookType
	 */
	public String getBookType() {
		return bookType;
	}
	/**
	 * @param bookType the bookType to set
	 */
	public void setBookType(String bookType) {
		this.bookType = bookType;
	}
	/**
	 * @return the operationType
	 */
	public String getOperationType() {
		return operationType;
	}
	/**
	 * @param operationType the operationType to set
	 */
	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}
	/**
	 * @param bookID
	 * @param bookName
	 * @param bookType
	 * @param operationType
	 */
	public Book(int bookID, String bookName, String bookType, String operationType) {
		this.bookID = bookID;
		this.bookName = bookName;
		this.bookType = bookType;
		this.operationType = operationType;
	}
	
	
	public Book(int bookID, String bookType, String operationType) {
		this.bookID = bookID;
		this.bookType = bookType;
		this.operationType=operationType;
		
		
	}
	public boolean equals(Object other){
		if(other==this) return true;
		if(other==null) return false;
		if(getClass()!=other.getClass()) return false;
		Book book = (Book)other;
		return (
			      (bookID==book.bookID || 
			        (bookID != 0 )) &&
			      (bookName == book.bookName || 
			        (bookName != null && bookName.equals(book.bookName)))
			    );
		
		
	}
	
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * @return the authorName
	 */
	public String getAuthorName() {
		return authorName;
	}
	/**
	 * @param authorName the authorName to set
	 */
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	

	
}