package sdpprojectassignment1.gui;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import sdpprojectassignment1.bean.Book;
import sdpprojectassignment1.bean.DigitalBook;
import sdpprojectassignment1.bean.TextBook;
import sdpprojectassignment1.controller.BookOperationsController;

public class SelectManager {

	JFrame frmChooseTablesAnd;
	
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	protected ListSelectionModel listSelectionModel;
	private String bookType;
	private JComboBox<String> comboBox;
	private JScrollPane jScrollPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblBookId;
	private JLabel lblBookName;
	private JLabel lblAuthorName;

	/**
	 * Create the application.
	 */
	public SelectManager() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frmChooseTablesAnd = new JFrame();
		frmChooseTablesAnd.setTitle("Choose Tables and Operations");
		frmChooseTablesAnd.setBounds(100, 100, 450, 300);
		frmChooseTablesAnd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmChooseTablesAnd.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblTheChoiceOf = new JLabel("The Choice of DB table to modify:\r\n");
		lblTheChoiceOf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTheChoiceOf.setHorizontalAlignment(SwingConstants.LEFT);
		frmChooseTablesAnd.getContentPane().add(lblTheChoiceOf);

		comboBox = new JComboBox();

		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"TextBook", "DigitalBook"}));
		frmChooseTablesAnd.getContentPane().add(comboBox);
		bookType = (String)comboBox.getSelectedItem();

		panel_1 = new JPanel();
		JButton btnInsert = new JButton("Insert");
		panel_1.add(btnInsert);
		btnInsert.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bookType = (String)comboBox.getSelectedItem();
				InsertManager insertPage = new InsertManager(bookType);
				insertPage.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				insertPage.setVisible(true);
			}});

		bookType = (String)comboBox.getSelectedItem();
		JButton fetchAllButton = new JButton("Fetch All");
		panel_1.add(fetchAllButton);
		fetchAllButton.setFont(new Font("Tahoma", Font.PLAIN, 12));

		fetchAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bookType = (String)comboBox.getSelectedItem();
				if(jScrollPane != null){
					frmChooseTablesAnd.getContentPane().remove(jScrollPane);	
				}
				if(panel_2 != null){
					frmChooseTablesAnd.getContentPane().remove(panel_2);	
				}

				System.out.println("Object selected::"+bookType);
				Book book=null;

				if("textbook".equalsIgnoreCase(bookType))
				{
					book=new TextBook(bookType,"fetchAll");
				}
				else if("digitalbook".equalsIgnoreCase(bookType))
				{
					book=new DigitalBook(bookType,"fetchAll");
				}
				BookOperationsController bookOperationsController = ApplicationManager.getBookOperationsController();
				Object result = bookOperationsController.getAllBooks(book.getBookType());
				ResultManager resultManager = new ResultManager(bookType, result);
				resultManager.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				resultManager.setVisible(true);
				resultManager.setAlwaysOnTop(true);
			}
		});
		{
			lblBookId = new JLabel("Book ID:");
		}
		{
			textField = new JTextField();
			textField.setColumns(10);
		}
		panel_3 = new JPanel();
		panel_3.add(lblBookId);
		panel_3.add(textField);
		JButton btnfetchByID = new JButton("Fetch By ID");
		panel_3.add(btnfetchByID);
		btnfetchByID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnfetchByID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Data Missing");
				else{
					bookType = (String)comboBox.getSelectedItem();
					if(jScrollPane != null){
						frmChooseTablesAnd.getContentPane().remove(jScrollPane);	
					}
					if(panel_2 != null){
						frmChooseTablesAnd.getContentPane().remove(panel_2);	
					}

					System.out.println("Object selected::"+bookType);
					Book book=null;

					if("textbook".equalsIgnoreCase(bookType))
					{
						book=new TextBook(bookType,"fetchbyID");
					}
					else if("digitalbook".equalsIgnoreCase(bookType))
					{
						book=new DigitalBook(bookType,"fetchbyID");
					}
					book.setBookId(Integer.parseInt(textField.getText()));
					BookOperationsController bookOperationsController = ApplicationManager.getBookOperationsController();
					Object result = bookOperationsController.findBookById(book);
					ResultManager resultManager = new ResultManager(bookType, result);
					resultManager.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					resultManager.setVisible(true);
					resultManager.setAlwaysOnTop(true);
				}
			}});
		{
			lblBookName = new JLabel("Book Name:");
		}
		{
			textField_1 = new JTextField();
			textField_1.setColumns(10);
		}
		panel_4 = new JPanel();
		panel_4.add(lblBookName);
		panel_4.add(textField_1);
		JButton btnfetchByName = new JButton("Fetch By Name");
		panel_4.add(btnfetchByName);
		btnfetchByName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnfetchByName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField_1.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Data Missing");
				else{
					bookType = (String)comboBox.getSelectedItem();
					if(jScrollPane != null){
						frmChooseTablesAnd.getContentPane().remove(jScrollPane);	
					}
					if(panel_2 != null){
						frmChooseTablesAnd.getContentPane().remove(panel_2);	
					}
					System.out.println("Object selected::"+bookType);
					Book book=null;

					if("textbook".equalsIgnoreCase(bookType))
					{
						book=new TextBook(bookType,"fetchbyID");
					}
					else if("digitalbook".equalsIgnoreCase(bookType))
					{
						book=new DigitalBook(bookType,"fetchbyID");
					}
					book.setBookName(textField_1.getText());
					BookOperationsController bookOperationsController = ApplicationManager.getBookOperationsController();
					Object result = bookOperationsController.findBookByName(book);
					ResultManager resultManager = new ResultManager(bookType, result);
					resultManager.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					resultManager.setVisible(true);
					resultManager.setAlwaysOnTop(true);
				}
			}});
		{
			lblAuthorName = new JLabel("Author Name:");
		}
		{
			textField_2 = new JTextField();
			textField_2.setColumns(10);
		}
		panel_5 = new JPanel();
		panel_5.add(lblAuthorName);
		panel_5.add(textField_2);
		JButton btnfetchByAuthor = new JButton("Fetch By Author");
		panel_5.add(btnfetchByAuthor);
		btnfetchByAuthor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnfetchByAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField_2.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Data Missing");
				else{
					bookType = (String)comboBox.getSelectedItem();
					if(jScrollPane != null){
						frmChooseTablesAnd.getContentPane().remove(jScrollPane);	
					}
					if(panel_2 != null){
						frmChooseTablesAnd.getContentPane().remove(panel_2);	
					}

					System.out.println("Object selected::"+bookType);
					Book book=null;

					if("textbook".equalsIgnoreCase(bookType))
					{
						book=new TextBook(bookType,"fetchbyID");
					}
					else if("digitalbook".equalsIgnoreCase(bookType))
					{
						book=new DigitalBook(bookType,"fetchbyID");
					}
					book.setAuthorName(textField_2.getText());
					BookOperationsController bookOperationsController = ApplicationManager.getBookOperationsController();
					Object result = bookOperationsController.findBookByAuthor(book);
					ResultManager resultManager = new ResultManager(bookType, result);
					resultManager.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					resultManager.setVisible(true);
					resultManager.setAlwaysOnTop(true);
				}
			}});
		frmChooseTablesAnd.getContentPane().add(panel_3);
		frmChooseTablesAnd.getContentPane().add(panel_4);
		frmChooseTablesAnd.getContentPane().add(panel_5);
		
		/*JButton btnRedo = new JButton("Redo");

		btnRedo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DBMgr dbMgr = new DBMgr();

				dbMgr.redo();
				JOptionPane.showMessageDialog(null, "Redo successfully");

			}
		});
		panel_2.add(btnRedo);

		JButton btnUndo = new JButton("Undo");
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DBMgr dbMgr = new DBMgr();

				dbMgr.undo();
				JOptionPane.showMessageDialog(null, "Redo successfully");

			}
		});
		panel_2.add(btnUndo);*/
		frmChooseTablesAnd.getContentPane().add(panel_1);

	}

}
