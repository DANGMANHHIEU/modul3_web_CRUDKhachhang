<%--
  Created by IntelliJ IDEA.
  User: KTC
  Date: 5/17/2023
  Time: 4:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sửa</title>
</head>
<body>
<h1> Sửa thông tin khách hàng</h1>
<a <c:if test="${message != null}">
    <span class="message">${message}</span>
</c:if>
<p><a href="/khachhang">Trở lại</a> </p>
<form method="post">
    <fieldset>
        <legend>Thông tin</legend>
        <table>
            <tr>
                <td>Tên</td>
                <td><input type="text" name="name" id="name" value="${khachhang.getName()}"></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="text" name="email" id="email" value="${khachhang.getEmail()}"></td>
            </tr>
            <tr>
                <td>Địa chỉ</td>
                <td><input type="text" name="address" id="address" value="${khachhang.getAddress()}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Cập nhập"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
