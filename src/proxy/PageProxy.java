package proxy;

import lombok.Data;

@Data
public class PageProxy implements Proxy{
	private Pagination page;
	@Override
	public void carryOut(Object o ) {
		this.page = new Pagination();
		setPage((Pagination)o);
	}
}
