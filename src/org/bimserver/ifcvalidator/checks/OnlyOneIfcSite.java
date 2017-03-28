package org.bimserver.ifcvalidator.checks;

import java.util.List;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.ifcvalidator.CheckerContext;
import org.bimserver.models.ifc2x3tc1.IfcSite;
import org.bimserver.validationreport.IssueContainer;
import org.bimserver.validationreport.IssueException;
import org.bimserver.validationreport.Type;

public class OnlyOneIfcSite extends ModelCheck {

	public OnlyOneIfcSite() {
		super("SITE", "ONLY_ONE_SITE");
	}

	@Override
	public void check(IfcModelInterface model, IssueContainer issueContainer, CheckerContext checkerContext) throws IssueException {
		List<IfcSite> sites = model.getAll(IfcSite.class);
		IfcSite ifcSite = sites.size() == 1 ? sites.get(0) : null;
		
		issueContainer.builder().type(sites.size() == 1 ? Type.SUCCESS : Type.ERROR).object(ifcSite).message(checkerContext.translate("NUMBER_OF_SITES")).is(sites.size() + " " + checkerContext.translate(sites.size() == 1 ? "SITE" : "SITES")).shouldBe(checkerContext.translate("EXACTLY_ONE_SITE")).add();
	}
}
