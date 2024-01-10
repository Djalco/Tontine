package util;

import java.util.regex.Pattern;

public class Validator {

	private String emptyMsg;
	private int length;
	private String lengthMsg;
	private Pattern regex;
	private String regexMsg;


	public Validator(String emptyMsg, int length, String lengthMsg, String regex, String regexMsg) {
		super();
		this.emptyMsg = emptyMsg;
		this.length = length;
		this.lengthMsg = lengthMsg;
		setRegex(regex);
		this.regexMsg = regexMsg;
	}

	public Validator(String emptyMsg, int length, String lengthMsg) {
		this(emptyMsg,length,lengthMsg,"","");
	}

	public Validator(String emptyMsg, String regex, String regexMsg) {
		this(emptyMsg,0,"",regex,regexMsg);
	}

	public Validator(String emptyMsg) {
		this(emptyMsg, 0, "");
	}

	public String getEmptyMsg() {
		return emptyMsg;
	}

	public String getregexMsg() {
		return regexMsg;
	}

	public void setRegex(String regex) {
		this.regex = Pattern.compile(regex);
	}

	public String getLengthMsg() {
		return lengthMsg;
	}

	public boolean isValidlength(String text) {
		return text.length() >= length;
	}
	public boolean isValidRegex(String text) {
		return regex.matcher(text).find();
	}
	
	public boolean isValid(String text) {
		return text.length() >= length && regex.matcher(text).find();
	}

	public static enum RegexType{
		LOGIN("^[a-z][a-z0-9]{0,}$"), 
		MAIL("^[a-z-A-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"),
		PASSWORD("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9!@#\\$%\\^&\\*])(?=\\S+$).{0,}$"),
		NUMBER("-?\\d+");
		String regex;
		RegexType(String regex) {
			this.regex = regex;
		}

		public String getRegex() {
			return regex;
		}
	}


}
