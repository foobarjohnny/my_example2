package ilife.common.utils;

public interface CodeGenerator<T, R> {

	public R generateCode(T t);
}

class UUIDCodeGenerator implements CodeGenerator<String, String> {

	@Override
	public String generateCode(String t) {
		return null;
	}
}
