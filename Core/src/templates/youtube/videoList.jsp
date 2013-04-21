<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<c:forEach items="${model}" var="youtubeVideo">
    <a href="javascript:performActivity({'videoId': '<c:out value="${youtubeVideo.getUrl()}"/>'})"><c:out
            value="${youtubeVideo.getTitle()}"/> </a>
</c:forEach>