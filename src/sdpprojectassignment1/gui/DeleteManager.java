package sdpprojectassignment1.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import sdpprojectassignment1.bean.Book;
import sdpprojectassignment1.bean.DigitalBook;
import sdpprojectassignment1.bean.TextBook;
import sdpprojectassignment1.controller.BookOperationsController;
import sdpprojectassignment1.controller.UndoRedoController;

public class DeleteManager extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblBookId;
	private JLabel lblBookName;
	private JLabel lblAuthorName;
	private JLabel lblIsbnNo;
	private JLabel lblPrice;
	private JButton redoButton;
	private JButton undoButton;
	
	
	/**
	 * Create the dialog.
	 */
	public DeleteManager(final String bookType, Book book) {
		setTitle("Update Book Record");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			lblBookId = new JLabel("Book ID:");
		}
		{
			textField = new JTextField();
			textField.setColumns(10);
			textField.setText(String.valueOf(book.getBookId()));
			textField.setEditable(false);
			//textField.setEnabled(false);
		}
		{
			lblBookName = new JLabel("Book Name:");
		}
		{
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setText(book.getBookName());
			textField_1.setEditable(false);
			//textField_1.setEnabled(false);
		}
		{
			lblAuthorName = new JLabel("Author Name:");
		}
		{
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setText(book.getAuthorName());
			textField_2.setEditable(false);
			//textField_2.setEnabled(false);
		}
		if("textbook".equalsIgnoreCase(bookType)){
			lblIsbnNo = new JLabel("ISBN No:");
			{
				textField_3 = new JTextField();
				textField_3.setColumns(10);
				textField_3.setText(((TextBook)book).getISBN());
				textField_3.setEditable(false);
				//textField_3.setEnabled(false);
			}
		}else
		{
			lblIsbnNo = new JLabel("Device Compatibility:");
			{
				textField_3 = new JTextField();
				textField_3.setColumns(10);
				textField_3.setText(((DigitalBook)book).getDeviceCompatibility());
				textField_3.setEditable(false);
				//textField_3.setEnabled(false);
			}
		}
		
		{
			lblPrice = new JLabel("Price:");
		}
		{
			textField_4 = new JTextField();
			textField_4.setColumns(10);
			textField_4.setText(String.valueOf(book.getPrice()));
			textField_4.setEditable(false);
			//textField_4.setEnabled(false);
		}
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(65)
					.addComponent(lblBookId)
					.addGap(6)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(49)
					.addComponent(lblBookName)
					.addGap(6)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(39)
					.addComponent(lblAuthorName)
					.addGap(6)
					.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(63)
					.addComponent(lblIsbnNo)
					.addGap(6)
					.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE))
				
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(79)
					.addComponent(lblPrice)
					.addGap(6)
					.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblBookId))
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblBookName))
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblAuthorName))
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblIsbnNo))
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblPrice))
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Delete");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				
				
				
				
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(textField.getText().isEmpty()||(textField_1.getText().isEmpty())||(textField_2.getText().isEmpty())||(textField_3.getText().isEmpty()) || (textField_4.getText().isEmpty()))
							JOptionPane.showMessageDialog(null, "Data Missing");
						else{
							BookOperationsController bookOperationsController = ApplicationManager.getBookOperationsController();
							if(bookType.equalsIgnoreCase("textbook")){
								bookOperationsController.deleteBook(new TextBook(Integer.parseInt(textField.getText()),textField_1.getText(), textField_2.getText(), 
										textField_3.getText(), Double.parseDouble(textField_4.getText()), bookType, "delete"));
							}else if(bookType.equalsIgnoreCase("digitalbook")){
								bookOperationsController.deleteBook(new DigitalBook(Integer.parseInt(textField.getText()),textField_1.getText(), textField_2.getText(), 
										textField_3.getText(), Double.parseDouble(textField_4.getText()), bookType, "delete"));
							}
							
							JOptionPane.showMessageDialog(null, "Data Submitted");
						}
						if(undoButton != null){
							undoButton.setEnabled(true);
						}
						
					}
					
				});
			}
			/*{
				JButton resetButton = new JButton("Reset");
				resetButton.setActionCommand("Reset");
				buttonPane.add(resetButton);
				resetButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						textField_1.setText(null);
						textField_2.setText(null);
						textField.setText(null);
						textField_3.setText(null);
						textField_4.setText(null);
						
						
					}
				});
			}*/
			
			/*{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
						
						
					}
				});
			}*/
			{
				redoButton = new JButton("Redo");
				redoButton.setActionCommand("Redo");
				redoButton.setEnabled(false);
				buttonPane.add(redoButton);
				redoButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						UndoRedoController undoRedoController = ApplicationManager.getUndoRedoController();
						undoRedoController.redo();
						JOptionPane.showMessageDialog(null, "Redo successfully");
						
					}
				});
			}
			
			{
				undoButton = new JButton("Undo");
				undoButton.setActionCommand("Undo");
				undoButton.setEnabled(false);
				buttonPane.add(undoButton);
				undoButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(redoButton != null){
							redoButton.setEnabled(true);
						}
						UndoRedoController undoRedoController = ApplicationManager.getUndoRedoController();
						undoRedoController.undo();
						JOptionPane.showMessageDialog(null, "Undo successfully");
						
						
					}
				});
			}
		}
	}
		

}
