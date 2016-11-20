package sdpprojectassignment1.database;

public enum DBTypes {
ORACLE("ORACLE"),MYSQL("MYSQL");
	
	private String value;  
	private DBTypes(String value){  
	this.value=value;  
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	} 
	
	
}
