package org.bimserver.ifcvalidator.checks;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.ifcvalidator.CheckerContext;
import org.bimserver.validationreport.IssueContainer;
import org.bimserver.validationreport.IssueException;

public class CheckNlSFB extends ModelCheck  {

	public CheckNlSFB() {
		super("", "");
	}

	@Override
	public void check(IfcModelInterface model, IssueContainer issueContainer, CheckerContext checkerContext) throws IssueException {
	}
}