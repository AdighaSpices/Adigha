<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="products grid_16">
      <div class="productsWarp">
		<ul>
			<c:forEach items="${banners}" var="banner" varStatus="status">
					<c:url value="${banner.urlLink}" var="encodedUrl" />
					<li><a tabindex="-1" href="${encodedUrl}"<c:if test="${banner.external}"> target="_blank"</c:if>><img src="${banner.media.url}" alt="${not empty banner.headline ? banner.headline : banner.media.altText}" title="${not empty banner.headline ? banner.headline : banner.media.altText}" width="938" height="398"/></a></li>
			</c:forEach>
		</ul>
	</div>
</div>
