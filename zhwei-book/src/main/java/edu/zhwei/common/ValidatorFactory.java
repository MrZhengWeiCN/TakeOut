package edu.zhwei.common;

public class ValidatorFactory {

	private ValidatorFactory() {
	}

	private static NameValidator nameValidator = new NameValidator();

	private static PhoneValidator phoneValidator = new PhoneValidator();

	public static NameValidator getNameValidator() {
		return nameValidator;
	}

	public static PhoneValidator getPhoneValidator() {
		return phoneValidator;
	}
}
