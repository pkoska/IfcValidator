package org.bimserver.ifcvalidator.checks;

import java.util.List;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.ifcvalidator.CheckerContext;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcSite;
import org.bimserver.validationreport.IssueContainer;
import org.bimserver.validationreport.IssueException;
import org.bimserver.validationreport.Type;

public class IfcSiteLatitude extends ModelCheck {

	public IfcSiteLatitude() {
		super("SITE", "LATITUDE");
	}

	@Override
	public void check(IfcModelInterface model, IssueContainer issueContainer, CheckerContext checkerContext) throws IssueException {
		List<IfcSite> sites = model.getAll(IfcSite.class);
		for (IfcSite ifcSite : sites) {
			// Only checking whether this data is available
			
			if (ifcSite.eIsSet(Ifc2x3tc1Package.eINSTANCE.getIfcSite_RefLatitude())) {
				// TODO check whether this is a valid WSG84
				issueContainer.builder().type(Type.SUCCESS).object(ifcSite).message("RefLatitude").is(ifcSite.getRefLatitude()).shouldBe("Not null").add();
			} else {
				issueContainer.builder().type(Type.ERROR).object(ifcSite).message("RefLatitude").is(null).shouldBe("Not null").add();
			}
		}
	}
}
