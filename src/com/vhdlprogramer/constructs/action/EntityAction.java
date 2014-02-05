package com.vhdlprogramer.constructs.action;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import com.language.dataobjects.Generic;
import com.language.dataobjects.Port;
import com.language.datatypes.ArrayType;
import com.language.datatypes.DataType;
import com.vhdlprogramer.constructs.ui.EntityUi;

public class EntityAction implements ActionListener,WindowListener{
	EntityUi entity_ui=null;
	public EntityAction(EntityUi entity_ui){
		this.entity_ui = entity_ui;
	}
	public void actionPerformed(ActionEvent e) 
	{
		Component invokingComp = (Component) e.getSource();
		if (invokingComp == entity_ui.btn_add)
		{
			if(!entity_ui.btn_port.isEnabled()){//to add ports
				DataType data_type = null;
				String index_scheme = entity_ui.cmb_indexing_scheme.getSelectedItem().toString();
				if(index_scheme.equals("Select")){
					data_type = new DataType(entity_ui.tf_pgtype.getText());
					
				}
				else{
					data_type = new ArrayType(index_scheme,entity_ui.tf_starting_index.getText(),
							entity_ui.tf_ending_index.getText());
					data_type.name = entity_ui.tf_pgtype.getText();
					data_type.type = "array";
				}
				entity_ui.entity.addPort(new Port(entity_ui.tf_pgname.getText(), 
						data_type ,entity_ui.cmb_mode.getSelectedItem().toString()));
				
				String str = "Port " + entity_ui.tf_pgname.getText() + " of mode "
						+ entity_ui.cmb_mode.getSelectedItem().toString() + " and type " 
						+ entity_ui.tf_pgtype.getText().toUpperCase();
				str += !index_scheme.equals("Select") ? 
						" Range " + entity_ui.tf_starting_index.getText() + " " 
						+ index_scheme + " " + entity_ui.tf_ending_index.getText()
						: "";
				entity_ui.lst_ports.add(str);
				entity_ui.tf_pgname.setText("");
			}
			else{//to add generics
				DataType data_type = null;
				String index_scheme = entity_ui.cmb_indexing_scheme.getSelectedItem().toString();
				if(index_scheme.equals("Select")){
					data_type = new DataType(entity_ui.tf_pgtype.getText());
				}
				else{
					data_type = new ArrayType(index_scheme,entity_ui.tf_starting_index.getText(),
							entity_ui.tf_ending_index.getText());
					data_type.name = entity_ui.tf_pgtype.getText();
				}
				entity_ui.entity.addGeneric(new Generic(entity_ui.tf_pgname.getText(), 
						data_type));
				
				String str = "Generic " + entity_ui.tf_pgname.getText() + " of type " 
						+ entity_ui.tf_pgtype.getText().toUpperCase();
				str += !index_scheme.equals("Select") ? 
						" Range " + entity_ui.tf_starting_index.getText() + " " 
						+ index_scheme + " " + entity_ui.tf_ending_index.getText()
						: "";
				entity_ui.lst_generics.add(str);
				entity_ui.tf_pgname.setText("");
			}
		}
		else if(invokingComp == entity_ui.btn_remove)
		{
			if(!entity_ui.btn_port.isEnabled()){//to remove ports
				String selected_items[] = entity_ui.lst_ports.getSelectedItems();
				String stg = null;
				for(int i=0;i<selected_items.length;i++){
					stg = selected_items[i];
					if (entity_ui.entity.removePort((stg.split(" ", 3))[1]))
					entity_ui.lst_ports.remove(stg);
				}
			}
			else{
				String selected_items[] = entity_ui.lst_generics.getSelectedItems();
				for(int i=0;i<selected_items.length;i++){
					if (entity_ui.entity.removeGeneric((selected_items[i].split(" ", 3))[1]))
					entity_ui.lst_generics.remove(selected_items[i]);
				}
			}
		}
		else if(invokingComp == entity_ui.btn_insert)
		{
			entity_ui.entity.name = entity_ui.tf_ename.getText();
			entity_ui.result = "ok";
			entity_ui.setVisible(false);
		}
		else if(invokingComp == entity_ui.btn_reset)
		{
			entity_ui.entity.removeAllPorts();
			entity_ui.tf_ename.setText("");
			entity_ui.tf_pgname.setText("");
			entity_ui.tf_pgtype.setText("");
			entity_ui.tf_starting_index.setText("");
			entity_ui.tf_ending_index.setText("");
			entity_ui.cmb_mode.setSelectedIndex(0);
			entity_ui.cmb_indexing_scheme.setSelectedIndex(0);
			entity_ui.lst_ports.removeAll();
			entity_ui.lst_generics.removeAll();
			entity_ui.btn_port.setEnabled(false);
			entity_ui.btn_generics.setEnabled(true);
		}
		else if(invokingComp == entity_ui.btn_cancel)
		{
			entity_ui.result = "cancel";
			entity_ui.setVisible(false);
		}
		else if(invokingComp == entity_ui.btn_generics)
		{
			entity_ui.cmb_mode.setEnabled(false);
			entity_ui.btn_generics.setEnabled(false);
			entity_ui.btn_port.setEnabled(true);
			entity_ui.lst_ports.setVisible(false);
			entity_ui.lst_generics.setVisible(true);
		}
		else if(invokingComp == entity_ui.btn_port)
		{
			entity_ui.cmb_mode.setEnabled(true);
			entity_ui.btn_port.setEnabled(false);
			entity_ui.btn_generics.setEnabled(true);
			entity_ui.lst_generics.setVisible(false);
			entity_ui.lst_ports.setVisible(true);
		}
	}
	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		entity_ui.result = "cancel";
		entity_ui.setVisible(false);
	}
	
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
