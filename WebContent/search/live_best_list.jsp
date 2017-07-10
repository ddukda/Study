<%
/************************************************************************/
/*																		*/
/*      프로그램명 : live_best_list.jsp									*/
/*      내      용 : 인기 필링													*/
/*      작  성  일 : 2009.03.25 (ina)										*/
/*      수      정 : 2011.09.07 [통합홈페이지] (홍성일)							*/
/*																		*/
/************************************************************************/
%>
<%@ page language="java" contentType="text/html;charset=euc-kr" %>
<%@ page import="java.util.*, java.net.URLEncoder" %> 
<%-- <%@ page import = "feelring.common.*, feelring.ncms.*" %> --%>
<%response.setHeader("P3P", "CP=NON DSP COR CURa TIA");%>

<%-- <jsp:useBean id="oramgr" scope="application" class="feelring.common.OracleConnectionManager"/> --%>
<%-- <jsp:useBean id="baseHandler" scope="page" class="feelring.feel.MyringDbHandler"/> --%>
<%
// Config conf				= new Config();
// String hpEziCon			= ConvUtil.XSSconvStr(ConvUtil.nullToSpace(request.getParameter("hpEziCon")));
// String szPageNo			= ConvUtil.XSSconvStr(ConvUtil.nullToSpace(request.getParameter("page")));
// String szMid			= ConvUtil.XSSconvStr(ConvUtil.nullToSpace(request.getParameter("mid")));
// String szEvt			= ConvUtil.XSSconvStr(ConvUtil.nullToSpace(request.getParameter("evt")));
String szMode 			= "15";		// Live BEST
String szTemp3  		= "";
String szCpCode 		= "";		// szCpCode
String pFlag 			= "g";		// 선물인지 설정인지 구분하는 플래그 g: 설정, s: 선물
String szCSinger   		= "";   
String szCTitle   		= "";
String szCAlbum			= "";  
String szCAlbumTemp		= "";  
String szCmid			= "";   
String szCUpDown		= "";
String szCUpDownImg		= "";
String szCUpDownAlt		= "";

int nNum        		= 0;		// 리스트 출력 번호
int nTotRow      		= 0;		// 총 컨텐츠 갯수
int nSize				= 0;		// 리스트의 총 수치값 

ArrayList arrHotContent = null;
ArrayList arrContent    = null;
// ContentItem conitem     = null;

/************************************************************************************************/
/*               페이징 변수 초기화                                                             */
/************************************************************************************************/
int nPageSize	= 0;
try{
// 	nPageSize = Integer.parseInt(conf.getConfig("FEEL_COM", "LIST_COUNT_50"));
}catch(Exception e){
	nPageSize = 50;
}
if(nPageSize <= 0){
	nPageSize = 50;
}
int nBlockPage  = 10;
int s_page      = 0;	// 시작 페이지
int e_page      = 0;	// 끝 페이지
int nPageCnt    = 0;	// 페이지 단위 개수
int nPage       = 0;
int i 			= 0;

// if (szPageNo == null || szPageNo.equals("") ) {
//     szPageNo = "0";
// }
// try{
// 	nPage       = Integer.parseInt(szPageNo);
// }catch(Exception e){
// 	nPage = 0;
// }
// if(nPage < 0){
//     nPage = 0;
// }

// String szTabImg01 = "";
// String szTabImg02 = "";

// if( szPageNo.equals("0") ){
// 	szTabImg01 = "class=\"on\"";
// }else if( szPageNo.equals("1") ){
// 	szTabImg02 = "class=\"on\"";
// }

/*******************************************************************************************************/
// 컨텐츠 정보 가져오기
/*******************************************************************************************************/
// 	feelring.ncms.BestContentDbHandler listHandle = new feelring.ncms.BestContentDbHandler(szMid);
// 	arrHotContent  = listHandle.getWapContentList();		// HOT 항목 가져오기 : 0번째 항목
// 	arrContent  = listHandle.getWapContentList(szPageNo, nPageSize);
// 	nTotRow     = listHandle.getTotCnt() -1;				// 첫번째 곡 HOT으로 리스트 개수에서 제외하기위해 -1


%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko" lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=euc-kr" />

<%-- <%@ include file = "./inc/cache_control.jsp" %> --%>
<title>필링 인기TOP 100 | LG U+</title>
	<!-- common Head Start -->
<%-- 	<%@ include file = "./inc/common_head.jsp" %> --%>
	<!-- common Head End -->	
	
	<script type="text/javascript">
	<!-- 
	window.onload = function() { 	fResizeSubInform(); }
	//-->
	</script>

<!-- LDAP_CK Start -->
<%-- <%@ include file = "./inc/ldap_ck.jsp" %> --%>
<!-- LDAP_CK End -->

</head>

<body>

<div id="wrap">
	<!-- Main Popup Start -->
	<!-- %@ include file = "./inc/main_popup.jsp" % -->
	<!-- Main Popup End -->

	<div id="main">
		<div class="main_top"></div>
		<div class="main_body">
		<!-- frame-area -->
		<h1><img src="./images/pc/title/h1_feelring.gif" alt="필링" class="jq_alttext_replace" /></h1>
		
		<!-- Search Start -->
		<%@ include file = "./search.jsp" %>
		<!-- Search End -->
		
		<!-- Menu Start --> 

<%--         <%@ include file = "./inc/menu.jsp" %> --%>
        <!-- Menu End -->		
		<!-- Common Event Start -->
<%-- 		<%@ include file = "./inc/common_event.jsp" %> --%>
		<!-- Common Event End -->
		<!-- 여기부터  -->
		<h2><img src="./images/pc/title/h2_feelring_top100.gif" alt="필링 인기 TOP100" class="jq_alttext_replace" /></h2>
		<div class="section pc_phoneserviceapp">
			<div class="appcategory jq_appcategory_select_transform_ty3">
				<ul class="cboth">
<%-- 					<li class="first"><a href="./live_best_list.jsp?hpEziCon=<%=URLEncoder.encode(hpEziCon, "EUC-KR")%>&amp;mid=<%=szMid%>&amp;page=0&amp;evt=<%=szEvt %>" <%=szTabImg01 %> title="1위~50위"><span>1위~50위</span></a></li> --%>
<%-- 					<li><a href="./live_best_list.jsp?hpEziCon=<%=URLEncoder.encode(hpEziCon, "EUC-KR")%>&amp;mid=<%=szMid%>&amp;page=1&amp;evt=<%=szEvt %>" <%=szTabImg02 %> title="51위~100위"><span>51위~100위</span></a></li> --%>
				</ul>
			</div>	
			
<%-- 			<h3 class="blind">필링 인기TOP <% if(szPageNo.equals("0")){	%>1위 ~ 50위<%} else if(szPageNo.equals("1")) {%>51위 ~ 100위<% } %></h3> --%>
		
			<div class="section">
				<table summary="필링인기 TOP 100 리스트입니다. 순위, 제목, 가수, 앨범, 설정 항목이 있습니다." class="pc_boardlist" border="1"> <!-- summary값 수정안함 -->
					<caption>필링 인기 TOP 100 순위순 목록 표</caption>
					<colgroup>
						<col width="8%" />
						<col width="45%" />
						<col width="16%" />
						<col width="16%" />
						<col width="15%" />
					</colgroup>
					<thead>		
					<tr>
						<th scope="col" class="first">순위</th>
						<th scope="col">제목</th>
						<th scope="col">가수</th>
						<th scope="col">앨범</th>
						<th scope="col">설정</th>
					</tr>
					</thead>
					<tbody>
 
		<tr class="firstline recom">
<!-- 			<td class="num"><span class="rank"><img src="./images/layout/txtcon_recom.gif" alt="추천"/></span></td> -->
<%-- 			<td class="title"><a href="#none" onclick="javascript:{fLoginCk('feelSetup', '<%=hpEziCon%>','<%=szCmid%>', '<%=szMode%>','<%=szMid %>','<%=szCpCode %>','<%=pFlag %>','<%=szEvt %>')}" title="<%=szCTitle%> 설정:새창열림"><%=szCTitle%></a></td> --%>
<%-- 			<td class="left"><a href="#none" onclick="javascript:{fLoginCk('feelSetup', '<%=hpEziCon%>','<%=szCmid%>', '<%=szMode%>','<%=szMid %>','<%=szCpCode %>','<%=pFlag %>','<%=szEvt %>')}" title="<%=szCSinger%> 설정:새창열림"><%=szTemp3%></a></td> --%>
<%-- 			<td class="left"><span title="<%=szCAlbum%>"><%=szCAlbumTemp%></span></td> --%>
<!-- 			<td> -->
<%-- 				<a href="#none" onclick="javascript:{feelPreListen('<%=hpEziCon%>','<%=szCmid%>', '<%=szMode%>','<%=szMid %>','<%=szCpCode %>','<%=pFlag %>','<%=szEvt %>')}" title="미리듣기:새창열림"><img src="./images/pc/icon/txtcon_listen.gif" alt="듣기" /></a> --%>
<%-- 				<a href="#none" onclick="javascript:{fLoginCk('feelSetup', '<%=hpEziCon%>','<%=szCmid%>', '<%=szMode%>','<%=szMid %>','<%=szCpCode %>','<%=pFlag %>','<%=szEvt %>')}" title="설정:새창열림"><img src="./images/pc/icon/txtcon_setting.gif" alt="설정" /></a> --%>
<%-- 				<a href="#none" onclick="javascript:{fLoginCk('feelGift','<%=hpEziCon%>','<%=szCmid%>', '<%=szMode%>','<%=szMid %>','<%=szCpCode %>','<%=pFlag %>','<%=szEvt %>')}" title="선물:새창열림"><img src="./images/pc/icon/txtcon_gift.gif" alt="선물" /></a> --%>
<!-- 			</td> -->
		</tr>
	<tr class="firstline lastline">
			<td align="center" colspan="5">등록된 곡이 없습니다.</td>
		</tr>


				</tbody>
			</table>
			<!-- Paging Start -->
<%-- 			<%@ include file = "./inc/list_pageing_inc.jsp" %> --%>
			<!-- Paging End -->
			</div>
			</div>			
			<div></div>		
			<!-- //contents -->
		</div>
		<div class="main_btm"></div>
	</div>
</div>
</body>
</html>