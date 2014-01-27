<%@ page import="gmt.domain.MyGrailsDomain; gmt.domain.MyJpaDomain" contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<title>Transactional method-level test</title>
</head>

<body>
    <div>
        <g:form action="${params.action}">
            <div>
                <div>
                    <label for="myJpaProperty">myJpaProperty:</label>
                    <g:textField name="myJpaProperty" value="${myJpaProperty}" />
                </div><div>
                    <label for="myJpaProperty-readOnly">myJpaProperty value on server:</label>
                    <span id="myJpaProperty-readOnly"> ${MyJpaDomain.withNewSession {MyJpaDomain.first().myProperty}}</span>
                </div>
            </div><div>
                <div>
                    <label for="myGrailsProperty">myGrailsProperty:</label>
                    <g:textField name="myGrailsProperty" value="${myGrailsProperty}" />
                </div><div>
                    <label for="myGrailsProperty-readOnly">myGrailsProperty value on server:</label>
                    <span id="myGrailsProperty-readOnly"> ${MyGrailsDomain.withNewSession {MyGrailsDomain.first().myProperty}}</span>
                </div>
            </div><div>
                <g:checkBox name="writeMethodFirst" /><label for="writeMethodFirst">Use write method before calling method-scoped service</label>
            </div><div>
                <g:checkBox name="readMethodFirst" /><label for="readMethodFirst">Use readOnly type-scoped service before calling writable type-scoped service</label>
            </div><div>
                <g:submitButton name="Submit" />
            </div>
        </g:form>
    </div>
</body>
</html>
