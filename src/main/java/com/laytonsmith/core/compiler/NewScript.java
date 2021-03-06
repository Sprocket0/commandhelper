package com.laytonsmith.core.compiler;

import com.laytonsmith.core.ParseTree;
import com.laytonsmith.core.constructs.Construct;
import com.laytonsmith.core.constructs.Variable;
import java.util.List;

/**
 *
 * @author lsmith
 */
public class NewScript {
	ParseTree executable;
	List<Construct> signature;
	String label;
	
	public NewScript(List<Construct> signature, ParseTree executable, String label){
		this.signature = signature;
		this.executable = executable;
		this.label = label;
		if("".equals(label)){
			this.label = null;
		}
	}

	@Override
	public String toString() {
		StringBuilder b = new StringBuilder(label != null?label + ":":"");
		boolean first = true;
		for(Construct c : signature){
			if(!first){
				b.append(" ");
			}
			first = false;
			if(c instanceof Variable){
				Variable var = (Variable)c;
				if(var.isOptional() && !var.getDefault().trim().equals("")){
					b.append("[").append(var.getName()).append("='").append(var.getDefault()).append("']");
				} else if(var.isOptional()){
					b.append("[").append(var.getName()).append("]");
				} else {
					b.append(var.getName());
				}
			} else {
				b.append(c.val());
			}
		}
		return b.toString();
	}		
	
}
