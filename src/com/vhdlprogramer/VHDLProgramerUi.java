package com.vhdlprogramer;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSplitPane;

public class VHDLProgramerUi {

	private JFrame frame;
	public VHDLProgramerAction vpaction;
	public JTextArea ta_code;
	public JButton btn_arch,btn_entity;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VHDLProgramerUi window = new VHDLProgramerUi();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VHDLProgramerUi() {
		vpaction = new VHDLProgramerAction(this);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btn_entity = new JButton("Entity");
		btn_entity.setBounds(12, 12, 117, 25);
		frame.getContentPane().add(btn_entity);
		btn_entity.addActionListener(vpaction);
		
		ta_code = new JTextArea();
		ta_code.setBounds(141, 0, 286, 197);
		frame.getContentPane().add(ta_code);
		
		btn_arch = new JButton("Architecture");
		btn_arch.setBounds(12, 49, 117, 25);
		frame.getContentPane().add(btn_arch);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mnFile.add(mntmNew);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mnFile.add(mntmOpen);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);
		
		JMenuItem mntmSaveAs = new JMenuItem("Save As");
		mnFile.add(mntmSaveAs);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmCut = new JMenuItem("Cut");
		mnEdit.add(mntmCut);
		
		JMenuItem mntmCopy = new JMenuItem("Copy");
		mnEdit.add(mntmCopy);
		
		JMenuItem mntmPaste = new JMenuItem("Paste");
		mnEdit.add(mntmPaste);
		
		JMenu mnInsert = new JMenu("Insert");
		menuBar.add(mnInsert);
		
		JMenu mnConstructs = new JMenu("Constructs");
		mnInsert.add(mnConstructs);
		
		JMenuItem mntmEntity = new JMenuItem("Entity");
		mnConstructs.add(mntmEntity);
		
		JMenuItem mntmArchitecture = new JMenuItem("Architecture");
		mnConstructs.add(mntmArchitecture);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
		btn_arch.addActionListener(vpaction);
		
		
	}
}
