package com.vhdlprogramer.constructs.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.vhdlprogramer.constructs.ui.ArchitectureUi;

public class ArchitectureAction implements ActionListener {
	ArchitectureUi arch_ui = null;
	public ArchitectureAction(ArchitectureUi arch_ui){
		this.arch_ui = arch_ui;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == arch_ui.btn_insert){
			arch_ui.architecture.name = arch_ui.tf_aname.getText();
			arch_ui.architecture.entity_name = arch_ui.tf_ename.getText();
			arch_ui.status = "ok";
			arch_ui.setVisible(false);
		}else if(e.getSource() == arch_ui.btn_reset){
			arch_ui.tf_aname.setText("");
			arch_ui.tf_ename.setText("");
		}else if(e.getSource() == arch_ui.btn_cancel){
			arch_ui.setVisible(false);
		}
	}
	
}
