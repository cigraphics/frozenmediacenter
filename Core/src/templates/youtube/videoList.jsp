<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<table id="youtube">
    <c:forEach items="${model}" var="youtubeVideo">
        <tr>
            <td>
                <img src="<c:out value="${youtubeVideo.getThumbnailUrl()}"/>"/>
            </td>
            <td>
                <a href="javascript:performActivity({'videoId': '<c:out value="${youtubeVideo.getUrl()}"/>'})"><c:out
                        value="${youtubeVideo.getTitle()}"/> </a>
            </td>
        </tr>
    </c:forEach>
</table>