<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: KTC
  Date: 5/17/2023
  Time: 10:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Danh Sách KH</title>
</head>
<body>
<h1>Danh sách khách hàng</h1>
<p>
    <a href="/khachhang?action=create">Thêm mới</a>
</p>
<table border="1px">
    <tr>
        <td>STT</td>
        <td>Tên</td>
        <td>Email</td>
        <td>Địa chỉ</td>
        <td>Sửa</td>
        <td>Xóa</td>
    </tr>
    <c:forEach var="abc" items="${khachhang}" varStatus="i" step="1">
        <tr>
            <td>${i.index+1}</td>
            <td><a href="/khachhang?action=view&id=${abc.getId()}">${abc.getName()}</a></td>
            <td>${abc.getEmail()}</td>
            <td>${abc.getAddress()}</td>
            <td><a href="/khachhang?action=edit&id=${abc.getId()}">Sửa</a> </td>
            <td><a href="/khachhang?action=delete&id=${abc.getId()}">Xóa</a> </td>
        </tr>

    </c:forEach>
</table>

</body>
</html>
