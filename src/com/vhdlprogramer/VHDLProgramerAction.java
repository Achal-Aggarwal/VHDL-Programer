package com.vhdlprogramer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.vhdlprogramer.constructs.ui.ArchitectureUi;
import com.vhdlprogramer.constructs.ui.EntityUi;

public class VHDLProgramerAction implements ActionListener {

	/**
	 * @param args
	 */
	VHDLProgramerUi vp_ui;
	public VHDLProgramerAction(VHDLProgramerUi vp_ui){
		this.vp_ui= vp_ui;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == vp_ui.btn_entity)
		{
			EntityUi entity_ui = new EntityUi();
			entity_ui.setVisible(true);
			String prev_code = vp_ui.ta_code.getText();
			if(entity_ui.entity.name!=null)prev_code += entity_ui.entity.toString() + "\n";
			vp_ui.ta_code.setText(prev_code);
		}
		else if (e.getSource() == vp_ui.btn_arch)
		{
			ArchitectureUi arch_ui = new ArchitectureUi();
			arch_ui.setVisible(true);
			String prev_code = vp_ui.ta_code.getText();
			if(arch_ui.architecture.name!=null)
				prev_code += arch_ui.architecture.toString() + "\n";
			vp_ui.ta_code.setText(prev_code);
		}
	}

}
