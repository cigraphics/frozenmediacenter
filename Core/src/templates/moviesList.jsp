<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<ul>
    <c:forEach items="${model.getMovieNames()}" var="movieName">

        <li>
            <c:out value="${movieName}"/>
        </li>

    </c:forEach>
</ul>