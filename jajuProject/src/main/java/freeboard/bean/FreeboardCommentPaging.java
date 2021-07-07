package freeboard.bean;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class FreeboardCommentPaging {
	private int currentPage;
	private int pageBlock;
	private int pageSize;
	private int totalA;
	private StringBuffer pagingHTML;
	
	public void makePagingHTML() {
		pagingHTML = new StringBuffer();
		
		int totalP = (totalA+pageSize-1)/pageSize;
		
		int startPage = (currentPage-1) / pageBlock * pageBlock + 1;
		
		int endPage = startPage + pageBlock - 1;
		if(endPage > totalP) endPage = totalP;
		
		if(startPage > pageBlock) {
			pagingHTML.append("<span id='paging' class='paging prevPaging' onclick='freeboardCommentPaging("+(startPage-1)+")'></span>");
		}
		
		for(int i=startPage; i<=endPage; i++) {
			if(i == currentPage) {
				pagingHTML.append("<span id='currentPaging' class='paging currentPaging' onclick='freeboardCommentPaging("+ i +")'><strong>"+i+"</strong></span>");
			} else {
				pagingHTML.append("<span id='paging' class='paging thisPaging' onclick='freeboardCommentPaging("+ i +")'><strong>"+i+"<strong></span>");
			}
		}
		
		if(endPage < totalP) { 
			pagingHTML.append("<span id='paging' class='paging nextPaging' onclick='freeboardCommentPaging("+(endPage+1)+")'></span>");
		}
		
	}
}
