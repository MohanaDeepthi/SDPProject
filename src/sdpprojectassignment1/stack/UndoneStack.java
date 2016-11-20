package sdpprojectassignment1.stack;

import java.util.Stack;

import sdpprojectassignment1.command.DBCommand;



public class UndoneStack {
	
	private static Stack<DBCommand> uStack;
	
	public static void initialize()
	{
		uStack = new Stack<DBCommand>();		
	}
	
	public static void push(DBCommand cmd)
	{
		uStack = BookStack.getStack();
		uStack.push(cmd);
	}
	
	public static DBCommand pop()
	{
		uStack = BookStack.getStack();
		if(!uStack.isEmpty())
			return uStack.pop();
		
		return null;
	}
		
}
