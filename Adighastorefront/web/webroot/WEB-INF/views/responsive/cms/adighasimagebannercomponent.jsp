<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="${not empty page ? page.label : urlLink}" var="encodedUrl" />

<div class="col-md-6">
	<div id="logo" class="grid_4 alpha">
		<c:choose>
			<c:when test="${empty encodedUrl || encodedUrl eq '#'}">
				<img title="${media.altText}" alt="${media.altText}"
					src="${media.url}">
			</c:when>
			<c:otherwise>
				<a href="${encodedUrl}"><img title="${media.altText}"
					alt="${media.altText}" src="${media.url}"></a>
			</c:otherwise>
		</c:choose>
	</div>
</div>
<div class="col-md-6">
	<c:choose>
		<c:when test="${empty encodedUrl || encodedUrl eq '#'}">
			<div class="tag-line">${headline}</div>
		</c:when>
		<c:otherwise>
			<a href="${encodedUrl}"><span class="tag-line">${headline}</span></a>
		</c:otherwise>
	</c:choose>
</div>

