package proxy;


import javax.servlet.http.HttpServletRequest;

import command.Receiver;
import lombok.Data;
import service.CustomerServiceImpl;

@Data
public class Pagination implements Proxy{
	private int  pageNum, pageSize, blockSize,startRow
	,endRow,startPage,endPage,prevBlock,nextBlock,rowCount;
	private boolean existPrev, existNext;
	@Override
	public void carryOut(Object o) {
		System.out.println("페이지네이션 캐리아웃 내부");
		HttpServletRequest request = (HttpServletRequest)o;
		String _pageNum = request.getParameter("page_num");
		pageNum = (_pageNum == null) ? 1 : Integer.parseInt(_pageNum);
		System.out.println("페이지번호: "+pageNum);
		String _pageSize = request.getParameter("page_Size");
		pageSize = (_pageSize == null) ? 5 : Integer.parseInt(_pageSize);
		System.out.println("페이지사이즈: "+pageSize);
		String _blockSize = request.getParameter("block_size");
		blockSize = (_blockSize == null) ? 5 : Integer.parseInt(_blockSize);
		System.out.println("블록사이즈: "+blockSize);
		rowCount = CustomerServiceImpl.getInstance()
					.countCustomers(null);
		System.out.println("전체 카운트: "+rowCount);
		int pageCount = rowCount / pageSize;
		System.out.println("전체 페이지수: "+pageCount);
		startRow= (pageNum -1)*pageSize +1;
		System.out.println("스타트로우: "+startRow);
		endRow = (rowCount > endRow)? pageSize*pageNum : rowCount;
		System.out.println("엔드로우: "+endRow);
	}
}