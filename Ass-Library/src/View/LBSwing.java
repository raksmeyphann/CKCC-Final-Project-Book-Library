package View;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class LBSwing extends JFrame implements ActionListener
{
	JMenuBar menuBar;
	JMenu mFile,mAboutBook,mMember,mThesis,mList ,mHelp;
	//For Menu FIle
	JMenuItem mItemNew, mItemSave, mItemExit;
	//FOr Menu About Book
	JMenuItem mAddBook,mBorrowBook,mReturnBook;
	//For Menu Member
	JMenuItem mMembers;
	//For Menu Thesis
	JMenuItem mThesises;
	//For Menu List 
	JMenuItem lstMember,lstCatetory,lstBorrow;
	// For Menu Help
	JMenuItem mItemWelcome, mItemHelpContents, mItemCheckUpdate, mItemAbout;
	
	//JTree for Library
	JTree jTreeLb;
	JTabbedPane JTab;
	
	
	//For add Book
	JTextField txtId,txtTitle,txtPublisher,txtPublisherYear,txtISBN,txtPrice,txtAuthor,txtEdition;
	JButton btnAdd,btnCancel;
	
	public LBSwing()
	{
		       // Create object MenuItem of file
				mItemNew = new JMenuItem("New");
				mItemSave= new JMenuItem("Save");
				mItemExit = new JMenuItem("Exit");
				
				// Create object Menu File and add its items
				mFile = new JMenu("File");
				mFile.add(mItemNew);
				mFile.add(mItemSave);
				mFile.add(new JSeparator());
				mFile.add(mItemExit);	
				//=============== END OF FILE ===============
				
				
				// Create Object of Menu About Book
				mAddBook = new JMenuItem("Add New Book");
				mBorrowBook = new JMenuItem("Borrow A Book");
				mReturnBook = new JMenuItem("Return A Book");
				// Create Object Menu About Book and Add its Items
				mAboutBook = new JMenu("About Book");
				mAboutBook.add(mAddBook);
				mAboutBook.addSeparator();
				mAboutBook.add(mBorrowBook);
				mAboutBook.addSeparator();
				mAboutBook.add(mReturnBook);
			   //================== END OF About BOOk===============
				
				//Create Object of Menu Member
				mMembers = new JMenuItem("Add Member");
				//Create object Menu Report and Add its Item
				mMember = new JMenu("Members");
			    mMember.add(mMembers);
				//==================== END OF MEMBER ================
				
			    
			    //Create Object of Menu Thesis
			    mThesises = new JMenuItem("Add Thesis");
			    //Create Object of Menu Thesis And add Its Item
			    mThesis = new JMenu("Thesis");
			    mThesis.add(mThesises);
			    //================= End of Thesis===================
			    
			    
				//Create Object of Menu List
				lstMember = new JMenuItem("List Members");
				lstCatetory = new JMenuItem("List Book By Catetory");
				lstBorrow = new JMenuItem("List of Borrowed Book");
				//Create Object of Menu List and add Its Item
				mList  = new JMenu("List");
				mList.add(lstMember);
				mList.add(lstCatetory);
				mList.add(lstBorrow);
				//===================== End OF List===============================
				
				//create object menu item of help
				mItemWelcome = new JMenuItem( "Welcome");
				mItemHelpContents = new  JMenuItem( "Help Contents");
				mItemCheckUpdate = new JMenuItem( "Check Update");
				mItemAbout = new JMenuItem( "About Employee Mgt");
				
				//Create object menu bar and its menus
				mHelp = new JMenu( "Help");
				mHelp.add(mItemWelcome);
				mHelp.add(mItemHelpContents);
				mHelp.add(new JSeparator());
				mHelp.add(mItemCheckUpdate);
				mHelp.add(mItemAbout);
				//==================END OF HELP=============================
				
				
				// create object menu bar and add its menus
				menuBar = new JMenuBar();
				menuBar.add(mFile);
				menuBar.add(mAboutBook);
				menuBar.add(mMember);
				menuBar.add(mThesis);
				menuBar.add(mList);
				menuBar.add(mHelp);
				
				// ======================END MENU BAR===================
				 JTree leftJTree = createJTree();
				 JTab = new JTabbedPane();
				 
				 JSplitPane jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,leftJTree,JTab);
					jsp.setDividerLocation(180);
					// Add Menu bar to Frame
					add(menuBar);
					add(jsp);
					setTitle("Library Project Version Noob");
					setJMenuBar(menuBar);
					setExtendedState(MAXIMIZED_BOTH);
					setVisible(true);
				
				
				
				
	}
	private void performAddBook()
	{
		JPanel BlockAddBook = new JPanel(new GridLayout(8,2,10,10));
		BlockAddBook.add(new JLabel("ID :"),SwingConstants.CENTER);
		BlockAddBook.add(txtId = new JTextField());
		BlockAddBook.add(new JLabel("Title :"),SwingConstants.CENTER);
		BlockAddBook.add(txtTitle = new JTextField());
		BlockAddBook.add(new JLabel("Publisher :"),SwingConstants.CENTER);
		BlockAddBook.add(txtPublisher = new JTextField());
		BlockAddBook.add(new JLabel("Publisher Year :"),SwingConstants.CENTER);
		BlockAddBook.add(txtPublisherYear = new JTextField());
		BlockAddBook.add(new JLabel("ISBN :"),SwingConstants.CENTER);
		BlockAddBook.add(txtISBN = new JTextField());
		BlockAddBook.add(new JLabel("Price :"),SwingConstants.CENTER);
		BlockAddBook.add(txtPrice = new JTextField());
		BlockAddBook.add(new JLabel("Author :"),SwingConstants.CENTER);
		BlockAddBook.add(txtAuthor = new JTextField());
		BlockAddBook.add(new JLabel("Edition :"),SwingConstants.CENTER);
		BlockAddBook.add(txtEdition = new JTextField());
		
		JPanel BlockAddBookFinal = new JPanel(new BorderLayout(10,10));
		BlockAddBookFinal.add(new JLabel("Adding New Book"),BorderLayout.NORTH);
		BlockAddBookFinal.add(new JSeparator(),BorderLayout.CENTER);
		BlockAddBookFinal.add(BlockAddBook,BorderLayout.SOUTH);
		
		JTab.addTab("Add New Book", BlockAddBookFinal);
		JTab.setSelectedComponent(BlockAddBookFinal);
		
	}
	private JTree createJTree()
	{

		// Create Tree Node Of Library
		DefaultMutableTreeNode nodeBook = new DefaultMutableTreeNode("Books");
		DefaultMutableTreeNode nodeAddBook = new DefaultMutableTreeNode("Add New Book");
		DefaultMutableTreeNode nodeBoroBook = new DefaultMutableTreeNode("Borrow A book");
		DefaultMutableTreeNode nodeReturnBook = new DefaultMutableTreeNode("Return A Book");
		nodeBook.add(nodeAddBook);
		nodeBook.add(nodeBoroBook);
		nodeBook.add(nodeReturnBook);
		//=====================End tree node of Books===================
		
		DefaultMutableTreeNode nodeMember = new DefaultMutableTreeNode("Member");
		DefaultMutableTreeNode nodeMembers = new DefaultMutableTreeNode("Add Member");
		nodeMember.add(nodeMembers);
		//=====================End tree node of Member==========================
		
		DefaultMutableTreeNode nodeThesis = new DefaultMutableTreeNode("Thesis");
		DefaultMutableTreeNode nodeThesises = new DefaultMutableTreeNode("Add Thesis");
		nodeThesis.add(nodeThesises);
		//=====================End tree node of Thesis==========================
		
		//create tree node List
		DefaultMutableTreeNode nodeList = new DefaultMutableTreeNode("List");
		DefaultMutableTreeNode nodelistMember = new DefaultMutableTreeNode( "List of Member");
		DefaultMutableTreeNode nodelistCategory = new DefaultMutableTreeNode( "List Book By Category");
		DefaultMutableTreeNode nodelistBorrow = new DefaultMutableTreeNode( "List Return Book");
		nodeList.add(nodelistMember);
		nodeList.add(nodelistCategory);
		nodeList.add(nodelistBorrow);
		//================== ENd of Node of List================
		
		DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode();
		rootNode.add(nodeBook);
		rootNode.add(nodeMember);
		rootNode.add(nodeThesis);
		rootNode.add(nodeList);
		
		
		//create object of jTree Library
		jTreeLb = new JTree(rootNode);
		jTreeLb.setRowHeight(25);
		jTreeLb.setRootVisible(false);
		jTreeLb.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		//Expand all tree nodes
		jTreeLb.addMouseListener(new MouseAdapter()
				{
			public void mousePressed(MouseEvent e)
			{
				// Find Selected Node of Tree
				int selectedNode = jTreeLb.getRowForLocation(e.getX(), e.getY());
				// COndition when mouse pressed on a Specific node
				if(selectedNode != -1)
					//When mouse Pressed is Double click
					if(e.getClickCount() == 2)
					{   
						//Get for Tree whole tree path
						TreePath treepath = jTreeLb.getPathForLocation(e.getX(), e.getY());
						//Get Last Selected Path
						String lastselectedpath = treepath.getLastPathComponent().toString();
						if(lastselectedpath.equals("Add New Book"))
						{
							  performAddBook();
						}
						else if(lastselectedpath.equals("List Employee"))
						{
						      
						}
						else if(lastselectedpath.equals("Employee Tax"))
						{
							
						}
						else if(lastselectedpath.equals("Tax Rule 2018"))
						{
													}
						else if(lastselectedpath.equals("Tax Calculator"))
						{
						   
						
						}
						
					}
				
			}
			});
		for(int i =0; i<=jTreeLb.getRowCount(); i++)
		jTreeLb.expandRow(i);
		//Add tree to panel
		//leftPanel.add(jTreeEmp);
		
		return jTreeLb;
		
	}
	
	    
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] arg)
	{
		new LBSwing();
	}
}
