<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forgot Password</title>
<style>
form {
    width: 350px;
    margin: 100px auto;
    padding: 25px;
    background: white;
    border-radius: 10px;
}
</style>
</head>
<body>

<form action="${pageContext.request.contextPath}/forget" method="post">
    <h2>🔑 Forgot Password</h2>

    <c:if test="${alert != null}">
        <div style="background:red;color:white;padding:8px;border-radius:5px;text-align:center;">
            ${alert}
        </div>
    </c:if>

    <label>Email</label>
    <input type="email" name="email" required style="width:100%;padding:10px">

    <button type="submit" style="margin-top:15px;width:100%;">Send reset link</button>

    <div style="margin-top:12px;text-align:center;">
        <a href="${pageContext.request.contextPath}/login">Back to Login</a>
    </div>
</form>

</body>
</html>
