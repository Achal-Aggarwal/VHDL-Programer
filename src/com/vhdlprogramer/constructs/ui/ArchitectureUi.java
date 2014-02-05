package com.vhdlprogramer.constructs.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.language.constructs.Architecture;
import com.vhdlprogramer.constructs.action.ArchitectureAction;

public class ArchitectureUi extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4890061827460257662L;
	private final JPanel contentPanel = new JPanel();
	public JTextField tf_aname;
	public JTextField tf_ename;
	public JButton btn_insert,btn_reset,btn_cancel;
	public Architecture architecture = null;
	ArchitectureAction arch_action = null;
	public String status = "cancel";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ArchitectureUi dialog = new ArchitectureUi();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ArchitectureUi() {
		setModal(true);
		setTitle("Architecture");
		setBounds(100, 100, 302, 194);
		architecture = new Architecture();
		arch_action = new ArchitectureAction(this);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(30, 30, 70, 15);
		contentPanel.add(lblName);
		
		tf_aname = new JTextField();
		tf_aname.setBounds(133, 28, 114, 19);
		contentPanel.add(tf_aname);
		tf_aname.setColumns(10);
		
		JLabel lblEntityName = new JLabel("Entity Name");
		lblEntityName.setBounds(30, 57, 90, 15);
		contentPanel.add(lblEntityName);
		
		tf_ename = new JTextField();
		tf_ename.setBounds(133, 53, 114, 19);
		contentPanel.add(tf_ename);
		tf_ename.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btn_insert = new JButton("Insert");
				btn_insert.setActionCommand("OK");
				buttonPane.add(btn_insert);
				getRootPane().setDefaultButton(btn_insert);
				btn_insert.addActionListener(arch_action);
			}
			{
				btn_reset = new JButton("Reset");
				buttonPane.add(btn_reset);
				btn_reset.addActionListener(arch_action);
			}
			{
				btn_cancel = new JButton("Cancel");
				btn_cancel.setActionCommand("Cancel");
				buttonPane.add(btn_cancel);
				btn_cancel.addActionListener(arch_action);
			}
		}
	}
}
