<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<script type="text/javascript">
    function getSearchTerm() {
        return $('#goodreads-searchterm').value();
    }
</script>

<form onsubmit="return nextActivity({ 'term': document.getElementById('goodreads-searchterm').value})">
    <input type="text" id="goodreads-searchterm" name="goodreads-searchterm"/>

    <input type="submit" value="Cauta"/>
</form>