<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<ul>
    <c:forEach items="${model}" var="book">
        <li>
            <c:out value="${book.getTitle()}"/> - <strong><c:out value="${book.getAuthor()}"/></strong>
        </li>
    </c:forEach>
</ul>