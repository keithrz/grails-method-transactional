<%@ page import="gmt.domain.MyDomain" contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<title>Transactional method-level test</title>
</head>

<body>
    <g:form action="${params.action}">
        <label for="myProperty">myProperty:</label>
        <g:textField name="myProperty" value="${myProperty}" />
    </g:form>
    <label for="myProperty-readOnly">myProperty value on server:</label>
    <span id="myProperty-readOnly"> ${MyDomain.withNewSession {MyDomain.first().myProperty}}</span>
</body>
</html>
