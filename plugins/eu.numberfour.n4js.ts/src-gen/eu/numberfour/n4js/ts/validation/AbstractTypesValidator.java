/*
 * generated by Xtext
 */
package eu.numberfour.n4js.ts.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;

public class AbstractTypesValidator extends org.eclipse.xtext.validation.AbstractDeclarativeValidator {

	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.numberfour.eu/ide/ts/Types"));
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.numberfour.eu/ide/ts/TypeRefs"));
		return result;
	}
}