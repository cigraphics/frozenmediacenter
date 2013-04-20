<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<table>
    <thead>
    <tr>
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