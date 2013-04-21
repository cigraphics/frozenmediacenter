<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<div id="main-menu">
    <c:forEach items="${model.getPlugins()}" var="plugin">
        <c:if test="${plugin.isCore()}">
            <div class="core-item" id="${plugin.getName()}"
                 style="background: url(<c:out value="${plugin.getBackgroundUrl()}"/>);">
                <div class="text">
                    <a href="javascript:performActivity({ 'idPlugin': <c:out value='${plugin.getIdPlugin()}'/>})">
                        <c:out value="${plugin.getName()}"/>
                    </a>
                </div>
            </div>
        </c:if>
    </c:forEach>
</div>

<div id="applications-menu">
    <h2>Aplicatii</h2>
    <ul id="apps">
        <c:forEach items="${model.getPlugins()}" var="plugin">
            <c:if test="${!plugin.isCore()}">
                <li>
                    <a href="javascript:performActivity({ 'idPlugin': <c:out value='${plugin.getIdPlugin()}'/>})">
                        <img src="<c:out value="${plugin.getBackgroundUrl()}"/>"/>
                    </a>
                </li>
            </c:if>
        </c:forEach>
    </ul>
</div>