package proxy;

import javax.servlet.http.HttpServletResponse;

import lombok.Data;

@Data
public class ResponseProxy implements Proxy{
	HttpServletResponse response;
	@Override
	public void carryOut(Object o) {
			System.out.println("=====4 ResponseProxy=======");
			setResponse((HttpServletResponse) o);
	}
}
