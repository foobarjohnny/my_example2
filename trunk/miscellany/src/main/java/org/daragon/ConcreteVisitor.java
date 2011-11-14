package org.daragon;

import java.util.Collection;

public class ConcreteVisitor implements Visitor {

	@Override
	public void visitCollection(Collection<Visitable> collection) {
		for (Visitable v : collection) {
			v.accept(this	);

		}

	}

	@Override
	public void visitFloat(FloatElement floatElement) {
		System.out.println(floatElement.getValue() + "F");
	}

	@Override
	public void visitString(StringElement stringElement) {
		System.out.println(stringElement.getValue());
	}

}
