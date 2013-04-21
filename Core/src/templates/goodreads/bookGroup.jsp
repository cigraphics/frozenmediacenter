<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<c:import url="/templates/goodreads/search.jsp"/>
<table id="goodreads">
    <thead>
    <tr>
        <th>Coperta</th>
        <th>Group</th>
        <th>Tip</th>
        <th>Ultima activitate</th>
    </tr>
    </thead>
    <c:forEach items="${model}" var="bookGroup">
        <tbody>
        <tr>
            <td><img src="<c:out value="${bookGroup.getThumbnailCoverUrl()}"/>"/> </td>
            <td><c:out value="${bookGroup.getTitle()}"/></td>
            <td><c:out value="${bookGroup.getType()}"/></td>
            <td><c:out value="${bookGroup.getLastActivity()}"/></td>
        </tr>
        </tbody>
    </c:forEach>
</table>