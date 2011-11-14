package org.daragon;

import java.util.Collection;

public interface Visitor {

	void visitString(StringElement stringElement);

	void visitFloat(FloatElement floatElement);

	public void visitCollection(Collection<Visitable>  collection);

}
