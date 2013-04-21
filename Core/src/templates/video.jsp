<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<script type="text/javascript" src="/resources/js/osmplayer.compressed.js"></script>
<script type="text/javascript" src="/resources/js/osmplayer.default.js"></script>
<link rel="stylesheet" href="/resources/css/osmplayer_default.css"/>
<script type="text/javascript">
    $("video#video").osmplayer({
        width: '100%',
        height: '100%',
        autostart: true
    }).fullscreen(true);
</script>

<link rel="stylesheet" href="/resources/css/osmplayer_default.css"/>
<video id="video" src="<c:out value="${model.getUrl()}"/>"></video>