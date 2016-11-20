package sdpprojectassignment1.stack;

import java.util.Stack;

import sdpprojectassignment1.bean.Book;
import sdpprojectassignment1.command.DBCommand;

public class BookStack {
	
	private static Stack<DBCommand> eStack;
	private static Stack<Book> bookStack;
	
	   protected BookStack() {
	      // Exists only to defeat instantiation.
	   }
	   public static Stack<DBCommand>  getStack() {
	      if(eStack == null) {
	         eStack = new Stack<DBCommand>();
	      }
	      return eStack;
	   }
	   
	   public static Stack<Book>  getBook() {
	      if(bookStack == null) {
	    	  bookStack = new Stack<Book>();
	      }
	      return bookStack;
	   }
	   
	   
	}
