package sdpprojectassignment1.stack;


import java.util.Stack;

import sdpprojectassignment1.command.DBCommand;

public class ExecuteStack {
		
		private static Stack<DBCommand> eStack;
		
		public ExecuteStack() {
			eStack = new Stack<DBCommand>();	
		}
		
		public static void initialize()
		{
			eStack = new Stack<DBCommand>();		
		}
		
		public static void push(DBCommand cmd)
		{
			eStack = BookStack.getStack();
			eStack.push(cmd);
		}
		
		public static DBCommand pop()
		{
			eStack = BookStack.getStack();
			if(!eStack.isEmpty())
				return eStack.pop();
			
			return null;
		}
		
		
			
}



