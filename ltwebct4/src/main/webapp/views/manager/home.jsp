<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manager Page</title>

<style>
    body {
        margin: 0;
        padding: 0;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: linear-gradient(135deg, #5563DE, #74ABE2);
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .container {
        background: white;
        width: 450px;
        padding: 40px;
        border-radius: 15px;
        box-shadow: 0 6px 30px rgba(0,0,0,0.25);
        text-align: center;
        animation: fadeIn 0.7s ease-in-out;
    }

    @keyframes fadeIn {
        from { opacity: 0; transform: translateY(-20px); }
        to   { opacity: 1; transform: translateY(0); }
    }

    h1 {
        margin: 0 0 20px;
        font-size: 26px;
        color: #333;
    }

    .btn {
        display: inline-block;
        padding: 12px 20px;
        margin-top: 15px;
        background: #5563DE;
        color: white;
        text-decoration: none;
        border-radius: 8px;
        font-size: 16px;
        font-weight: bold;
        transition: background 0.25s, transform 0.25s;
    }

    .btn:hover {
        background: #3c4bc5;
        transform: translateY(-3px);
    }

    .footer {
        margin-top: 20px;
        color: #666;
        font-size: 14px;
    }
</style>

</head>
<body>

<div class="container">
    <h1>👑 Manager Page</h1>

    <p>
        Chào mừng 
        <b>${sessionScope.account.fullname}</b> 
        đến với chúng tôi!
    </p>

    <a href="${pageContext.request.contextPath}/logout" class="btn">🚪 Logout</a>

    <div class="footer">
        Hệ thống quản lý © 2025
    </div>
</div>

</body>
</html>
