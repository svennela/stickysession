<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Session Test</title>
</head>
<body>
<h2>Session [${id}]</h2>
<h4>Host Header: ${hostHeader}</h4>
<h4>Forwarded Header: ${forwardedHost}</h4>
<h4>Host Remote: ${hostRemote}</h4>
<h4>Host Local: ${hostLocal}</h4>
<h4>Local Port: ${portLocal}</h4>
<h4>Remote Port: ${portRemote}</h4>
<p>Current count is ${count}</p>
<p><a href="<c:url value="/reset" />">Reset Counter</a></p>
<p><a href="<c:url value="/session-store-test" />">Session Store Test</a></p>
</body>
</html>
