<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="format" tagdir="/WEB-INF/tags/shared/format"%>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/responsive/product"%>
<%@ taglib prefix="component" tagdir="/WEB-INF/tags/shared/component"%>

<c:choose>
	<c:when test="${not empty productData}">
		<div class="carousel__component">
			<div class="carousel__component--headline"></div>

			<c:choose>
				<c:when test="${component.popup}">
					<div
						class="carousel__component--carousel js-owl-carousel js-owl-lazy-reference js-owl-carousel-reference">
						<div id="quickViewTitle" class="quickView-header display-none">
							<div class="headline">
								<span class="headline-text"><spring:theme
										code="popup.quick.view.select" /></span>
							</div>
						</div>
						<c:forEach items="${productData}" var="product">

							<c:url value="${product.url}/quickView" var="productQuickViewUrl" />
							<div class="carousel__item">
								<a href="${productQuickViewUrl}" class="js-reference-item">
									<div class="carousel__item--thumb">
										<product:productPrimaryReferenceImage product="${product}"
											format="product" />
									</div>
									<div class="carousel__item--name">${product.name}</div>
									<div class="carousel__item--price">
										<format:fromPrice priceData="${product.price}" />
									</div>
								</a>
							</div>
						</c:forEach>
					</div>
				</c:when>
				<c:otherwise>

					<div id="fresh">
						<div class="container_16">
							<div id="freshCake" class="grid_16">
								<div class="grid_1 alpha">
									<a class="prevButton disabled">«</a>
								</div>
								<div class="headLine grid_14">
									<h3>${title}</h3>
								</div>
								<div class="grid_1 omega">
									<a class="nextButton">»</a>
								</div>
							</div>
							<div class="newCakes">
								<div class="scroller">

									<div class="cake-row">
										<c:forEach items="${productData}" var="product">
											<c:url value="${product.url}" var="productUrl" />
											<div class="newCake">
												<a href="${productUrl}" class="grid_4"> 
													<product:productPrimaryImage product="${product}" format="product" /> 
													${product.name}
													<format:fromPrice priceData="${product.price}" />
												</a>
											</div>
										</c:forEach>
									</div>
								</div>
							</div>
						</div>
						<div class="clear"></div>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</c:when>

	<c:otherwise>
		<component:emptyComponent />
	</c:otherwise>
</c:choose>

