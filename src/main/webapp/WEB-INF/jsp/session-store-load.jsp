<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Session Store Test</title>
</head>
<body>
<h2>Test Object</h2>
<h4>Name: ${testObject.name}</h4>
<h4>Age: ${testObject.age}</h4>
<p><a href="<c:url value="/session-store-test" />">Reset Session Store Test</a></p>
<p><a href="<c:url value="/" />">Home</a></p>
</body>
</html>
