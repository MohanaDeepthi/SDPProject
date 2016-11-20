package sdpprojectassignment1.controller;

import sdpprojectassignment1.database.DBMgr;


public class UndoRedoController {
  public void undo(){
	  DBMgr dbMgr = new DBMgr();
		dbMgr.undo();
		System.out.println("UndoRedoController undo operation completed");
  }
  
  public void redo(){
	  DBMgr dbMgr = new DBMgr();
		dbMgr.redo();
		System.out.println("UndoRedoController redo operation completed");
  }
}
