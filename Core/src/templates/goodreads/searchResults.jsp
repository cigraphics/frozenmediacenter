<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<c:import url="/templates/goodreads/search.jsp"/>
<table id="goodreads">
    <thead>
    <tr>
        <th>Coperta</th>
        <th>Titlu</th>
        <th>Autor</th>
        <th>Rating</th>
    </tr>
    </thead>
    <c:forEach items="${model}" var="searchResult">
        <tbody>
        <tr>
            <td><img src="<c:out value="${searchResult.getBestBook().getThumbnailCoverUrl()}"/>"/></td>
            <td><c:out value="${searchResult.getBestBook().getTitle()}"/></td>
            <td><c:out value="${searchResult.getBestBook().getAuthor().getName()}"/></td>
            <td><c:out value="${searchResult.getAverageRating()}"/></td>
        </tr>
        </tbody>
    </c:forEach>
</table>