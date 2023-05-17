<%--
  Created by IntelliJ IDEA.
  User: KTC
  Date: 5/17/2023
  Time: 3:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Thêm mới</title>
</head>
<body>
<h1>Thêm mới khách hàng</h1>
<a <c:if test="${message != null}">
    <span class="message">${message}</span>
</c:if>
<p><a href="/khachhang">Trở lại</a></p>
<form method="post">
    <fieldset>
        <legend>Thông tin khách hàng</legend>
        <table>
            <tr>
                <td>Tên</td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="text" name="email" id="email"></td>
            </tr>
            <tr>
                <td>Địa chỉ</td>
                <td><input type="text" name="address" id="address"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Lưu lại"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
