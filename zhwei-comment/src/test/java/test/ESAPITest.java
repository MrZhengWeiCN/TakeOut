package test;

import org.owasp.esapi.ESAPI;

public class ESAPITest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String safe = ESAPI.encoder().encodeForHTML("<script>alert('xxx')</script>");
		System.out.println(safe);
	}

}
