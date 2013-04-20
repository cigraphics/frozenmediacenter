<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<form onsubmit="return performActivity({ 'term': document.getElementById('goodreads-searchterm').value})">
    <input type="text" id="goodreads-searchterm" name="goodreads-searchterm"/>

    <input type="submit" value="Cauta"/>
</form>