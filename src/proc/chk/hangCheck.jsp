<%
 java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyyMMddHHmmss");
 String today = formatter.format(new java.util.Date());

 //Thread.currentThread().sleep(1000000);
 out.println(today);
%>

