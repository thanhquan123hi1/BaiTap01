<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<table border="1" cellpadding="10">
  <tr>
    <th>STT</th>
    <th>Hình ảnh</th>
    <th>CategoryID</th>
    <th>CategoryName</th>
    <th>Thao tác</th>
  </tr>

  <c:forEach items="${listcate}" var="cate" varStatus="STT">
    <tr>
      <!-- STT -->
      <td>${STT.index + 1}</td>

      <!-- Ảnh -->
      <c:url value="/image?fname=${cate.images}" var="imgUrl"></c:url>
      <td>
        <img height="150" width="200" src="${imgUrl}" />
      </td>

      <!-- CategoryID -->
      <td>${cate.categoryid}</td>

      <!-- CategoryName -->
      <td>${cate.categoryname}</td>

      <!-- Action -->
      <td>
        <a href="<c:url value='/admin/category/edit?id=${cate.categoryid}'/>" class="center">
            Sửa
        </a> |
        <a href="<c:url value='/admin/category/delete?id=${cate.categoryid}'/>" class="center">
            Xóa
        </a>
      </td>
    </tr>
  </c:forEach>

</table>
