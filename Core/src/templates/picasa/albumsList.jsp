<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<ul>
    <c:forEach items="${model}" var="album">
        <li>
            <a href="nextActivity({ 'idAlbum': '<c:out value="${album.getIdAlbum()}"/>' })"><c:out
                    value="${album.getCoverPhoto().getPhotoThumbnail()}"/></a>
        </li>
    </c:forEach>
</ul>