<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<c:forEach items="${model}" var="photoAlbum">
    <a href="nextActivity({ 'idAlbum': <c:out value="${photoAlbum.getPhoto().getPhotoThumbnail()}"/> })"></a><c:out value="${photoAlbum}"/>
</c:forEach>