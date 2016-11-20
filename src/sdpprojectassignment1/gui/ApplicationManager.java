package sdpprojectassignment1.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;

import javax.swing.Action;

import java.awt.event.ActionListener;

import javax.swing.JPanel;

import sdpprojectassignment1.controller.BookOperationsController;
import sdpprojectassignment1.controller.UndoRedoController;
import sdpprojectassignment1.stack.ExecuteStack;
import sdpprojectassignment1.stack.UndoneStack;

@SuppressWarnings("unused")
public class ApplicationManager {

	private JFrame frmSoftwareDesignPattern;
	private final Action action = new SwingAction();
	
	private static UndoRedoController undoRedoController;
	private static BookOperationsController bookOperationsController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationManager window = new ApplicationManager();
					window.frmSoftwareDesignPattern.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ApplicationManager() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		undoRedoController = new UndoRedoController();
		bookOperationsController = new BookOperationsController();
		
		ExecuteStack.initialize();
		UndoneStack.initialize();
		
		frmSoftwareDesignPattern = new JFrame();
		frmSoftwareDesignPattern.setTitle("Software Design Pattern");
		frmSoftwareDesignPattern.setBounds(100, 100, 450, 300);
		frmSoftwareDesignPattern.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSoftwareDesignPattern.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		String labelText = "<html><h3>Welcome to Software design patterns framework tool</h3></br><p>This tool can be used connect to database and perform DML operations <br/>which is built using various design patterns.</p></html>";
		JLabel lblWelcomeToSoftware = new JLabel(labelText);
		frmSoftwareDesignPattern.getContentPane().add(lblWelcomeToSoftware);
		
		JButton btnClickToProceed = new JButton("Click to proceed");
		btnClickToProceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
						SelectManager window = new SelectManager();
						window.frmChooseTablesAnd.setVisible(true);
				
			}
		});
		btnClickToProceed.setAction(action);
		frmSoftwareDesignPattern.getContentPane().add(btnClickToProceed);
	}

	@SuppressWarnings("serial")
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Click to proceed");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}

	/**
	 * @return the undoRedoController
	 */
	public static UndoRedoController getUndoRedoController() {
		return undoRedoController;
	}

	/**
	 * @param undoRedoController the undoRedoController to set
	 */
	public static void setUndoRedoController(UndoRedoController undoRedoController) {
		ApplicationManager.undoRedoController = undoRedoController;
	}

	/**
	 * @return the bookOperationsController
	 */
	public static BookOperationsController getBookOperationsController() {
		return bookOperationsController;
	}

	/**
	 * @param bookOperationsController the bookOperationsController to set
	 */
	public static void setBookOperationsController(
			BookOperationsController bookOperationsController) {
		ApplicationManager.bookOperationsController = bookOperationsController;
	}
	
	
}
