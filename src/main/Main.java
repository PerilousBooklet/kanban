package main;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.logging.Logger;

import javax.swing.JFrame;

import gui.AddButton;
import gui.Board;
import gui.SideBar;
import gui.SideBarItem;
import gui.TopBar;
import logic.MediatorGUI;

public class Main {

  // Logger
  private static final Logger logger = Logger.getLogger(Main.class.getName());
	
	// Constants
  public static final int appWidth = 1600;
  public static final int appHeight = 900;

  public static final int panelGap = 10;
  
  public static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  public static final Dimension panelSize = new Dimension(50, 50);
  public static final Dimension columnSize = new Dimension(200, 200);
  public static final int screenWidth = (int) screenSize.getWidth();
  public static final int screenHeight = (int) screenSize.getHeight();
  
  public static Font mainFont = new Font("SansSerif", Font.PLAIN, 14);
  public static Font columnTitleFont = new Font("SansSerif", Font.PLAIN, 16);
  public static Font topBarTitleFont = new Font("SansSerif", Font.PLAIN, 18);
  
  // GUI Components Communication
  public static final MediatorGUI mediator = new MediatorGUI();
  
  // GUI Components
  public static JFrame frame = new JFrame("Kanban");
  
  public static TopBar panelTopBar = new TopBar();
  
  public static SideBar panelSideBar = new SideBar();
  public static SideBarItem sidebarItem = new SideBarItem();
  
  public static Board panelBoard = new Board();
  
  public static AddButton addBoardButton = new AddButton();
  public static AddButton addColumnButton = new AddButton();
  
  // Layouts
  private static final BorderLayout layoutMain = new BorderLayout();
  
	// GUI
	private static void createAndShowUI() {
		//Create and set the window
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    //Set the content pane
    Container contentPane = frame.getContentPane();
    contentPane.setLayout(layoutMain);
    
    // Assemble the base UI
    panelTopBar.add(Board.boardTitle);
    logger.info("boardTitle added to TopBar.");
    
    panelSideBar.add(sidebarItem);
    logger.info("SideBarItem added to SideBar.");
    panelSideBar.add(addBoardButton);
    logger.info("AddBoardButton added to SideBar.");
    
    // frame.add(panelTopBar, BorderLayout.NORTH);
    logger.info("TopBar added to frame.");
    frame.add(panelSideBar, BorderLayout.WEST);
    logger.info("SideBar added to frame.");
    frame.add(panelBoard, BorderLayout.CENTER);
    logger.info("Board added to frame.");
    
    //Display the window
    frame.pack();
    frame.setVisible(true);
    frame.setResizable(true);
    frame.setBounds(
      (screenWidth/2 - appWidth/2), 
      (screenHeight/2 - appHeight/2), 
      appWidth, 
      appHeight
    );
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
	
	public static void main(String args[]) {
    javax.swing.SwingUtilities.invokeLater(
      new Runnable() {
        public void run() {
          createAndShowUI();
        }
      }
    );
	}
	
}
