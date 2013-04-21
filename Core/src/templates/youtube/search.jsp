<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<script type="text/javascript">
    function getSearchTerm() {
        return $('#youtube-searchterm').val();
    }
</script>

<form onsubmit="return performActivity({'term': getSearchTerm()})">
    <div><img src="/resources/images/icons/youtube-logo.png"/></div>
    <input type="text" id="youtube-searchterm" name="youtube-searchterm"/>
    <input type="submit" value="Search"/>
</form>