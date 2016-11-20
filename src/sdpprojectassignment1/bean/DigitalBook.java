package sdpprojectassignment1.bean;

public class DigitalBook extends Book{

	String deviceCompatibility;
	
	public DigitalBook() {
		// TODO Auto-generated constructor stub
	}
	public DigitalBook(int bookID, String bookName, String authorName, String deviceCompability, double price,
			String bookType, String operationType) {
		this.bookID=bookID;
		this.bookName=bookName;
		this.authorName=authorName;
		this.deviceCompatibility=deviceCompability;
		this.price=price;
		this.bookType=bookType;
		this.operationType=operationType;
	}
	public DigitalBook(int bookID, String bookType, String operationType) {
		
		this.bookID=bookID;
		this.bookType=bookType;
		this.operationType=operationType;
		
	}
	public DigitalBook(int bookID, String bookName, String bookType, String operationType) {
		this.bookID=bookID;
		this.bookName=bookName;
		this.bookType=bookType;
		this.operationType=operationType;
	}
	public DigitalBook(String bookType, String operationType) {
	this.bookType=bookType;
	this.operationType=operationType;
	}
	public DigitalBook(String bookName, String bookType, String operationType) {
		this.bookName=bookName;
		this.bookType=bookType;
		this.operationType=operationType;
	}
	/**
	 * @return the deviceCompatibility
	 */
	public String getDeviceCompatibility() {
		return deviceCompatibility;
	}
	/**
	 * @param deviceCompatibility the deviceCompatibility to set
	 */
	public void setDeviceCompatibility(String deviceCompatibility) {
		this.deviceCompatibility = deviceCompatibility;
	}
	
	
	
}
