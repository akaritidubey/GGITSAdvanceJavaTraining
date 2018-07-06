<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleCalculatorProxyid" scope="session" class="webDynamic.CalculatorProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleCalculatorProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleCalculatorProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleCalculatorProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        webDynamic.Calculator getCalculator10mtemp = sampleCalculatorProxyid.getCalculator();
if(getCalculator10mtemp == null){
%>
<%=getCalculator10mtemp %>
<%
}else{
        if(getCalculator10mtemp!= null){
        String tempreturnp11 = getCalculator10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String name_1id=  request.getParameter("name16");
            java.lang.String name_1idTemp = null;
        if(!name_1id.equals("")){
         name_1idTemp  = name_1id;
        }
        java.lang.String hello13mtemp = sampleCalculatorProxyid.hello(name_1idTemp);
if(hello13mtemp == null){
%>
<%=hello13mtemp %>
<%
}else{
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(hello13mtemp));
        %>
        <%= tempResultreturnp14 %>
        <%
}
break;
case 18:
        gotMethod = true;
        String a_2id=  request.getParameter("a21");
        int a_2idTemp  = Integer.parseInt(a_2id);
        String b_3id=  request.getParameter("b23");
        int b_3idTemp  = Integer.parseInt(b_3id);
        int multiply18mtemp = sampleCalculatorProxyid.multiply(a_2idTemp,b_3idTemp);
        String tempResultreturnp19 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(multiply18mtemp));
        %>
        <%= tempResultreturnp19 %>
        <%
break;
case 25:
        gotMethod = true;
        String a_4id=  request.getParameter("a28");
        int a_4idTemp  = Integer.parseInt(a_4id);
        String b_5id=  request.getParameter("b30");
        int b_5idTemp  = Integer.parseInt(b_5id);
        int subtract25mtemp = sampleCalculatorProxyid.subtract(a_4idTemp,b_5idTemp);
        String tempResultreturnp26 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(subtract25mtemp));
        %>
        <%= tempResultreturnp26 %>
        <%
break;
case 32:
        gotMethod = true;
        String a_6id=  request.getParameter("a35");
        int a_6idTemp  = Integer.parseInt(a_6id);
        String b_7id=  request.getParameter("b37");
        int b_7idTemp  = Integer.parseInt(b_7id);
        int divide32mtemp = sampleCalculatorProxyid.divide(a_6idTemp,b_7idTemp);
        String tempResultreturnp33 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(divide32mtemp));
        %>
        <%= tempResultreturnp33 %>
        <%
break;
case 39:
        gotMethod = true;
        String a_8id=  request.getParameter("a42");
        int a_8idTemp  = Integer.parseInt(a_8id);
        String b_9id=  request.getParameter("b44");
        int b_9idTemp  = Integer.parseInt(b_9id);
        int add39mtemp = sampleCalculatorProxyid.add(a_8idTemp,b_9idTemp);
        String tempResultreturnp40 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(add39mtemp));
        %>
        <%= tempResultreturnp40 %>
        <%
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>