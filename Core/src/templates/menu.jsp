<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<ul>
    <c:forEach items="${model.getInteractionPlugins().keySet()}" var="idPlugin">

        <li>
            <a href="javascript:performActivity({ 'idPlugin': <c:out value='${idPlugin}'/> })">
                <c:out value="${model.getInteractionPlugins().get(idPlugin).getPluginInfo().getName()}"/>
            </a>
        </li>

    </c:forEach>
</ul>