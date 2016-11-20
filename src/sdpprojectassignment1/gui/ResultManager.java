package sdpprojectassignment1.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import sdpprojectassignment1.bean.Book;
import sdpprojectassignment1.bean.DigitalBook;
import sdpprojectassignment1.bean.TextBook;

public class ResultManager extends JDialog {


	private static final long serialVersionUID = 8905360466257587815L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JPanel panel;
	private JScrollPane jScrollPane;

	/**
	 * Create the dialog.
	 */
	public ResultManager(final String bookType, Object result) {
		setTitle("Search Results and Operations");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel label = new JLabel("Search Result Table");
		table = showTableData(result,bookType);
		table.setPreferredScrollableViewportSize(table.getPreferredSize());
		jScrollPane = new JScrollPane( table );
		panel = new JPanel();
		panel.add(label);
		panel.add(jScrollPane);


		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int minIndex = table.getSelectedRow();
				System.out.println(table.getValueAt(minIndex, 0).toString());
				System.out.println(table.getValueAt(minIndex, 1).toString());
				System.out.println(table.getValueAt(minIndex, 2).toString());
				System.out.println(table.getValueAt(minIndex, 3).toString());
				System.out.println(table.getValueAt(minIndex, 4).toString());
				Book book=null;
				if("textbook".equalsIgnoreCase(bookType)){
					book = new TextBook(Integer.parseInt(table.getValueAt(minIndex, 0).toString()), table.getValueAt(minIndex, 1).toString(), 
							table.getValueAt(minIndex, 2).toString(),table.getValueAt(minIndex, 3).toString(), 
							Double.parseDouble(table.getValueAt(minIndex, 4).toString()), 
							bookType, "update");
				}else{
					book = new DigitalBook(Integer.parseInt(table.getValueAt(minIndex, 0).toString()), table.getValueAt(minIndex, 1).toString(), 
							table.getValueAt(minIndex, 2).toString(),table.getValueAt(minIndex, 3).toString(), 
							Double.parseDouble(table.getValueAt(minIndex, 4).toString()), 
							bookType, "update");
				}
				UpdateManager updatePage = new UpdateManager(bookType,book);
				updatePage.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				updatePage.setVisible(true);
			}});
		panel.add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int minIndex = table.getSelectedRow();
				System.out.println(table.getValueAt(minIndex, 0).toString());
				System.out.println(table.getValueAt(minIndex, 1).toString());
				System.out.println(table.getValueAt(minIndex, 2).toString());
				System.out.println(table.getValueAt(minIndex, 3).toString());
				System.out.println(table.getValueAt(minIndex, 4).toString());
				Book book=null;
				if(bookType.equalsIgnoreCase("textbook")){
					book = new TextBook(Integer.parseInt(table.getValueAt(minIndex, 0).toString()), table.getValueAt(minIndex, 1).toString(), 
							table.getValueAt(minIndex, 2).toString(),table.getValueAt(minIndex, 3).toString(), 
							Double.parseDouble(table.getValueAt(minIndex, 4).toString()), 
							bookType, "delete");
				}else{
					book = new DigitalBook(Integer.parseInt(table.getValueAt(minIndex, 0).toString()), table.getValueAt(minIndex, 1).toString(), 
							table.getValueAt(minIndex, 2).toString(),table.getValueAt(minIndex, 3).toString(), 
							Double.parseDouble(table.getValueAt(minIndex, 4).toString()), 
							bookType, "deleted");
				}
				DeleteManager deletePage = new DeleteManager(bookType,book);
				deletePage.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				deletePage.setVisible(true);
			}});
		panel.add(btnDelete);
		getContentPane().add(panel);
	}

	@SuppressWarnings({ "serial", "unchecked" })
	protected JTable showTableData(Object result, String tableType) {

		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFillsViewportHeight(true);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JScrollPane scroll = new JScrollPane(table);
		scroll.setHorizontalScrollBarPolicy(
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);		
		DefaultTableModel model = null;
		if("textbook".equalsIgnoreCase(tableType)){
			model = new DefaultTableModel(new Object[]{"bookID","BookName","authorName","ISBN","price"},0){
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			for(Object book:(List<TextBook>)result){
				TextBook textBook = (TextBook)book;
				model.addRow(new Object[]{textBook.getBookId(),textBook.getBookName(),textBook.getAuthorName(), textBook.getISBN(),textBook.getPrice() });
			}
		}else if("digitalbook".equalsIgnoreCase(tableType)){
			model = new DefaultTableModel(new Object[]{"bookID","BookName","authorName","devicecompability","price"},0){
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			for(Object book:(List<DigitalBook>)result){
				DigitalBook digitalBook = (DigitalBook)book;
				model.addRow(new Object[]{digitalBook.getBookId(),digitalBook.getBookName(),digitalBook.getAuthorName(), digitalBook.getDeviceCompatibility(),digitalBook.getPrice() });
			}
		}
		table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFillsViewportHeight(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table.add(table.getTableHeader(), BorderLayout.PAGE_START);
		table.setFillsViewportHeight(true);

		/*listSelectionModel = table.getSelectionModel();
		table.setSelectionModel(listSelectionModel);
		listSelectionModel.addListSelectionListener(new SharedListSelectionHandler());
		table.setSelectionModel(listSelectionModel);*/

		return table;

	}

}
