<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title></title>
<%@ page  import="java.util.*, java.text.*, org.json.simple.*, org.json.simple.parser.*"%>
<%

// request get JsonArrayString
String jsStr = request.getParameter("list");
jsStr = new String(jsStr.getBytes("ISO-8859-1"),"EUC-KR");

// JsonArrayString -> JsonArray
JSONParser parser = new JSONParser();
JSONArray jsArray = (JSONArray)parser.parse(jsStr);

// JsonArray > Data
JSONObject jsObj1 = new JSONObject();
for(int i = 0; i < jsArray.size(); i++){
        jsObj1 = (JSONObject)jsArray.get(i);
        System.out.println(jsObj1.get("name"));
        System.out.println(jsObj1.get("age"));
}

%>
<script src="../common/googleAnalytics.js"></script></head>
<body>

</body>
</html>