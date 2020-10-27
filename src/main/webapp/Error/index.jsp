<%--
  Created by IntelliJ IDEA.
  User: johansvartdal
  Date: 27/10/2020
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1><%= request.getParameter("title")%></h1>
<p><%= request.getParameter("description")%></p>
<br/>
<br/>
<a href = "<%= request.getParameter("backlink")%>">Tilbake</a>

</body>
</html>
