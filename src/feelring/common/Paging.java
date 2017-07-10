package feelring.common;

public class Paging {
	public String PagingPrint(int nTotRow, int nPage, String szUrl, int nStartPage){
		StringBuffer sbPaging = new StringBuffer();
		int nBlockPage		= 5;
		int nPageSize 		= 10;
		
		int nDivide = nTotRow / nPageSize;
		int nRest	= nTotRow % nPageSize;
		int p 		= 0;
		
		if(nRest > 0) nDivide ++;
		
		String szPageFirstGif = "<img src='../images/common/btn_pageFirst.gif' alt='start' />";
		String szPagePrevGif = "<img src='../images/common/btn_pagePrev.gif' alt='prev' />";
		
		sbPaging.append(" <div class='paging'> ");
		
		if((nPage+1) != 1){
			sbPaging.append("<a href='").append(szUrl);
			sbPaging.append("&resPage=0&resStartPage=0'>"+ szPageFirstGif +"</a>");
		}else{
			sbPaging.append(szPageFirstGif);
		}
		
		
		if(nDivide > nBlockPage){
			if(nStartPage == 0){
				sbPaging.append(szPagePrevGif);
			}else{
				sbPaging.append("<a href='").append(szUrl);
				sbPaging.append("&resPage=").append(nStartPage-nBlockPage);
				sbPaging.append("&resStartPage=").append(nStartPage-nBlockPage).append("'>");
				sbPaging.append(szPagePrevGif);
			}
		
		
			sbPaging.append("<div class='pageNo'");
			
			for(p=nStartPage; p<(nStartPage+nBlockPage); p++){
				if(p >= nDivide) break;
				if(p == nPage){
					sbPaging.append("<span class='on'>").append(p+1).append("</span>");
				}else{
					sbPaging.append("<span><a href='").append(szUrl).append("&resPage=").append(p);
					sbPaging.append("&resStartPage=").append(nStartPage).append("'>").append(p+1).append("</a></span>");
				}
			}
			
			sbPaging.append("</div>");
			
			
			if (((nStartPage/nBlockPage)==(nDivide/nBlockPage)) || (nDivide==(nStartPage+nBlockPage))) {
				sbPaging.append("<img src='../images/common/btn_pageNext.gif' alt='next' />");
		    }else{
		    	sbPaging.append("<a href='"+ szUrl + "&resPage=" + p + "&resStartPage=" + p + "'><img src='../images/common/btn_pageNext.gif' alt='next' /></a>");
		    }
			
		}else{
				sbPaging.append("<img src='../images/common/btn_pagePrev.gif' alt='prev' />");
				sbPaging.append("<div class='pageNo'>");
			for (p=nStartPage; p<(nStartPage+nBlockPage); p++) {
			    if (p >= nDivide) break;
				if (p==nPage) {
					sbPaging.append("<span class='on'>" + (p+1) + "</span>");
				} else {
					sbPaging.append("<span><a href='"+ szUrl + "&resPage=" + p + "&resStartPage=" + nStartPage + "'>" + (p+1) + "</a></span>");
				}
			}
				sbPaging.append("</div>");
				sbPaging.append("<img src='../images/common/btn_pageNext.gif' alt='next' />");
		}
		
		if((nDivide > 1) && ((nPage+1) != nDivide) && (nDivide != nStartPage)) {
		    if(nDivide==(nStartPage+nBlockPage)) {
				sbPaging.append("<a href='"+ szUrl + "&resPage=" + (nDivide-1) + "&resStartPage=" + nStartPage + "'><img src='../images/common/btn_pageLast.gif' alt='last' /></a>");
		    } else {
		        if((nDivide%nBlockPage)==0) {
		            nStartPage = nDivide - nBlockPage;
		        } else {
		            nStartPage = (nDivide)-(nDivide%nBlockPage);
		        }
				sbPaging.append("<a href='"+ szUrl + "&resPage=" + (nDivide-1) + "&resStartPage=" + nStartPage + "'><img src='../images/common/btn_pageLast.gif' alt='last' /></a>");
		    }
		}
		else {
				sbPaging.append("<img src='../images/common/btn_pageLast.gif' alt='last' />");
		}
		sbPaging.append("</div>");
		
		return sbPaging.toString();
	}
}
