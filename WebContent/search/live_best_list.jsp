<%
/************************************************************************/
/*																		*/
/*      ���α׷��� : live_best_list.jsp									*/
/*      ��      �� : �α� �ʸ�													*/
/*      ��  ��  �� : 2009.03.25 (ina)										*/
/*      ��      �� : 2011.09.07 [����Ȩ������] (ȫ����)							*/
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
String pFlag 			= "g";		// �������� �������� �����ϴ� �÷��� g: ����, s: ����
String szCSinger   		= "";   
String szCTitle   		= "";
String szCAlbum			= "";  
String szCAlbumTemp		= "";  
String szCmid			= "";   
String szCUpDown		= "";
String szCUpDownImg		= "";
String szCUpDownAlt		= "";

int nNum        		= 0;		// ����Ʈ ��� ��ȣ
int nTotRow      		= 0;		// �� ������ ����
int nSize				= 0;		// ����Ʈ�� �� ��ġ�� 

ArrayList arrHotContent = null;
ArrayList arrContent    = null;
// ContentItem conitem     = null;

/************************************************************************************************/
/*               ����¡ ���� �ʱ�ȭ                                                             */
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
int s_page      = 0;	// ���� ������
int e_page      = 0;	// �� ������
int nPageCnt    = 0;	// ������ ���� ����
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
// ������ ���� ��������
/*******************************************************************************************************/
// 	feelring.ncms.BestContentDbHandler listHandle = new feelring.ncms.BestContentDbHandler(szMid);
// 	arrHotContent  = listHandle.getWapContentList();		// HOT �׸� �������� : 0��° �׸�
// 	arrContent  = listHandle.getWapContentList(szPageNo, nPageSize);
// 	nTotRow     = listHandle.getTotCnt() -1;				// ù��° �� HOT���� ����Ʈ �������� �����ϱ����� -1


%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko" lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=euc-kr" />

<%-- <%@ include file = "./inc/cache_control.jsp" %> --%>
<title>�ʸ� �α�TOP 100 | LG U+</title>
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
		<h1><img src="./images/pc/title/h1_feelring.gif" alt="�ʸ�" class="jq_alttext_replace" /></h1>
		
		<!-- Search Start -->
		<%@ include file = "./search.jsp" %>
		<!-- Search End -->
		
		<!-- Menu Start --> 

<%--         <%@ include file = "./inc/menu.jsp" %> --%>
        <!-- Menu End -->		
		<!-- Common Event Start -->
<%-- 		<%@ include file = "./inc/common_event.jsp" %> --%>
		<!-- Common Event End -->
		<!-- �������  -->
		<h2><img src="./images/pc/title/h2_feelring_top100.gif" alt="�ʸ� �α� TOP100" class="jq_alttext_replace" /></h2>
		<div class="section pc_phoneserviceapp">
			<div class="appcategory jq_appcategory_select_transform_ty3">
				<ul class="cboth">
<%-- 					<li class="first"><a href="./live_best_list.jsp?hpEziCon=<%=URLEncoder.encode(hpEziCon, "EUC-KR")%>&amp;mid=<%=szMid%>&amp;page=0&amp;evt=<%=szEvt %>" <%=szTabImg01 %> title="1��~50��"><span>1��~50��</span></a></li> --%>
<%-- 					<li><a href="./live_best_list.jsp?hpEziCon=<%=URLEncoder.encode(hpEziCon, "EUC-KR")%>&amp;mid=<%=szMid%>&amp;page=1&amp;evt=<%=szEvt %>" <%=szTabImg02 %> title="51��~100��"><span>51��~100��</span></a></li> --%>
				</ul>
			</div>	
			
<%-- 			<h3 class="blind">�ʸ� �α�TOP <% if(szPageNo.equals("0")){	%>1�� ~ 50��<%} else if(szPageNo.equals("1")) {%>51�� ~ 100��<% } %></h3> --%>
		
			<div class="section">
				<table summary="�ʸ��α� TOP 100 ����Ʈ�Դϴ�. ����, ����, ����, �ٹ�, ���� �׸��� �ֽ��ϴ�." class="pc_boardlist" border="1"> <!-- summary�� �������� -->
					<caption>�ʸ� �α� TOP 100 ������ ��� ǥ</caption>
					<colgroup>
						<col width="8%" />
						<col width="45%" />
						<col width="16%" />
						<col width="16%" />
						<col width="15%" />
					</colgroup>
					<thead>		
					<tr>
						<th scope="col" class="first">����</th>
						<th scope="col">����</th>
						<th scope="col">����</th>
						<th scope="col">�ٹ�</th>
						<th scope="col">����</th>
					</tr>
					</thead>
					<tbody>
 
		<tr class="firstline recom">
<!-- 			<td class="num"><span class="rank"><img src="./images/layout/txtcon_recom.gif" alt="��õ"/></span></td> -->
<%-- 			<td class="title"><a href="#none" onclick="javascript:{fLoginCk('feelSetup', '<%=hpEziCon%>','<%=szCmid%>', '<%=szMode%>','<%=szMid %>','<%=szCpCode %>','<%=pFlag %>','<%=szEvt %>')}" title="<%=szCTitle%> ����:��â����"><%=szCTitle%></a></td> --%>
<%-- 			<td class="left"><a href="#none" onclick="javascript:{fLoginCk('feelSetup', '<%=hpEziCon%>','<%=szCmid%>', '<%=szMode%>','<%=szMid %>','<%=szCpCode %>','<%=pFlag %>','<%=szEvt %>')}" title="<%=szCSinger%> ����:��â����"><%=szTemp3%></a></td> --%>
<%-- 			<td class="left"><span title="<%=szCAlbum%>"><%=szCAlbumTemp%></span></td> --%>
<!-- 			<td> -->
<%-- 				<a href="#none" onclick="javascript:{feelPreListen('<%=hpEziCon%>','<%=szCmid%>', '<%=szMode%>','<%=szMid %>','<%=szCpCode %>','<%=pFlag %>','<%=szEvt %>')}" title="�̸����:��â����"><img src="./images/pc/icon/txtcon_listen.gif" alt="���" /></a> --%>
<%-- 				<a href="#none" onclick="javascript:{fLoginCk('feelSetup', '<%=hpEziCon%>','<%=szCmid%>', '<%=szMode%>','<%=szMid %>','<%=szCpCode %>','<%=pFlag %>','<%=szEvt %>')}" title="����:��â����"><img src="./images/pc/icon/txtcon_setting.gif" alt="����" /></a> --%>
<%-- 				<a href="#none" onclick="javascript:{fLoginCk('feelGift','<%=hpEziCon%>','<%=szCmid%>', '<%=szMode%>','<%=szMid %>','<%=szCpCode %>','<%=pFlag %>','<%=szEvt %>')}" title="����:��â����"><img src="./images/pc/icon/txtcon_gift.gif" alt="����" /></a> --%>
<!-- 			</td> -->
		</tr>
	<tr class="firstline lastline">
			<td align="center" colspan="5">��ϵ� ���� �����ϴ�.</td>
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