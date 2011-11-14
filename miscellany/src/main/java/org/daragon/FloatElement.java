package org.daragon;

public class FloatElement implements Visitable {
	private float value;

	public FloatElement(float f) {
		value = f;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visitFloat(this);
	}

	public Float getValue() {
		// TODO Auto-generated method stub
		return value;
	}

}
