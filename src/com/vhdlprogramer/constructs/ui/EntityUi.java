package com.vhdlprogramer.constructs.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.language.constructs.Entity;
import com.vhdlprogramer.constructs.action.EntityAction;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class EntityUi extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7513775026745569641L;
	private final JPanel contentPanel = new JPanel();
	public JTextField tf_ename,tf_pgname,tf_pgtype,tf_starting_index,tf_ending_index;
	public JButton btn_add, btn_remove,btn_insert,btn_reset,btn_cancel;
	EntityAction entity_action=null;
	public JButton btn_port,btn_generics;
	public JComboBox cmb_mode,cmb_indexing_scheme;
	public Entity entity=null;
	public List lst_ports,lst_generics;
	public String result="cancel";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			EntityUi dialog = new EntityUi();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public EntityUi() {
		setTitle("Entity");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 333, 515);
		entity_action = new EntityAction(this);
		entity = new Entity();
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lbl_ename = new JLabel("Name");
		lbl_ename.setBounds(30, 30, 70, 15);
		contentPanel.add(lbl_ename);
		
		tf_ename = new JTextField();
		tf_ename.setBounds(115, 28, 193, 19);
		contentPanel.add(tf_ename);
		tf_ename.setColumns(10);
		{
			JLabel lbl_pgame = new JLabel("Name");
			lbl_pgame.setBounds(50, 96, 70, 15);
			contentPanel.add(lbl_pgame);
		}
		{
			tf_pgname = new JTextField();
			tf_pgname.setBounds(125, 94, 164, 19);
			contentPanel.add(tf_pgname);
			tf_pgname.setColumns(10);
		}
		{
			JLabel lbl_mode = new JLabel("Mode");
			lbl_mode.setBounds(50, 130, 70, 15);
			contentPanel.add(lbl_mode);
		}
		{
			String mode[] = {"Select", "IN", "OUT","INOUT","BUFFER","LINKAGE"};
			cmb_mode = new JComboBox(mode);
			cmb_mode.setBounds(125, 125, 164, 24);
			contentPanel.add(cmb_mode);
		}
		{
			JLabel lbl_pgtype = new JLabel("Type");
			lbl_pgtype.setBounds(50, 163, 70, 15);
			contentPanel.add(lbl_pgtype);
		}
		{
			tf_pgtype = new JTextField();
			tf_pgtype.setBounds(125, 161, 164, 19);
			contentPanel.add(tf_pgtype);
			tf_pgtype.setColumns(10);
		}
		{
			JLabel lbl_pgrange = new JLabel("Range :");
			lbl_pgrange.setBounds(50, 190, 70, 15);
			contentPanel.add(lbl_pgrange);
		}
		{
			tf_starting_index = new JTextField();
			tf_starting_index.setBounds(50, 215, 75, 19);
			contentPanel.add(tf_starting_index);
			tf_starting_index.setColumns(10);
		}
		{
			String indexing_scheme[] = {"Select", "DOWNTO", "TO"};
			cmb_indexing_scheme = new JComboBox(indexing_scheme);
			cmb_indexing_scheme.setBounds(126, 214, 84, 19);
			contentPanel.add(cmb_indexing_scheme);
		}
		{
			tf_ending_index = new JTextField();
			tf_ending_index.setBounds(213, 215, 76, 19);
			contentPanel.add(tf_ending_index);
			tf_ending_index.setColumns(10);
		}
		{
			lst_ports = new List();
			lst_ports.setBounds(30, 280, 278, 155);
			contentPanel.add(lst_ports);
		}
		{
			lst_generics = new List();
			lst_generics.setBounds(30, 280, 278, 155);
			lst_generics.setVisible(false);
			contentPanel.add(lst_generics);
		}
		{
			btn_add = new JButton("Add");
			btn_add.addActionListener(entity_action);
			btn_add.setBounds(60, 242, 97, 25);
			contentPanel.add(btn_add);
		}
		{
			btn_remove = new JButton("Remove");
			btn_remove.addActionListener(entity_action);
			btn_remove.setBounds(169, 242, 97, 25);
			contentPanel.add(btn_remove);
		}
		
		btn_port = new JButton("Ports");
		btn_port.addActionListener(entity_action);
		btn_port.setEnabled(false);
		btn_port.setBounds(40, 57, 117, 25);
		contentPanel.add(btn_port);
		{
			btn_generics = new JButton("Generics");
			btn_generics.addActionListener(entity_action);
			btn_generics.setBounds(169, 57, 117, 25);
			contentPanel.add(btn_generics);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btn_insert = new JButton("Insert");
				btn_insert.addActionListener(entity_action);
				buttonPane.add(btn_insert);
				getRootPane().setDefaultButton(btn_insert);
			}
			{
				btn_reset = new JButton("Reset");
				btn_reset.addActionListener(entity_action);
				buttonPane.add(btn_reset);
			}
			{
				btn_cancel = new JButton("Cancel");
				btn_cancel.addActionListener(entity_action);
				btn_cancel.setActionCommand("Cancel");
				buttonPane.add(btn_cancel);
			}
		}
	}
}
