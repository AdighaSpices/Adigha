<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>

<template:page pageTitle="${pageTitle}">




	<%-- 	<div id="warp">
		<div id="main" class="container_16">
			<div class="products grid_16">
				<div class="productsWarp">
					<cms:pageSlot position="Section1" var="feature">
						<cms:component component="${feature}" />
					</cms:pageSlot>
				</div>
			</div>
		</div>
	</div> --%>


	<div id="fresh">
		<div class="container_16">
			<div id="freshCake" class="grid_16">
				<div class="grid_1 alpha">
					<a class="prevButton disabled">«</a>
				</div>
				<div class="headLine grid_14">
					<h3>Fresh from the oven</h3>
				</div>
				<div class="grid_1 omega">
					<a class="nextButton">»</a>
				</div>
			</div>
			<div class="newCakes">
				<div class="scroller">

					<div class="cake-row">
						<div class="newCake">
							<a href="product-details.html" class="grid_4"><img
								src="images/freshCake1.jpg" alt="" width="220" height="120"></a>
						</div>
						<div class="newCake">
							<a href="product-details.html" class="grid_4"><img
								src="images/freshCake2.jpg" alt="" width="220" height="120"></a>
						</div>
						<div class="newCake">
							<a href="product-details.html" class="grid_4"><img
								src="images/freshCake3.jpg" alt="" width="220" height="120"></a>
						</div>
						<div class="newCake">
							<a href="product-details.html" class="grid_4"><img
								src="images/freshCake4.jpg" alt="" width="220" height="120"></a>
						</div>
					</div>
					<div class="cake-row">
						<div class="newCake">
							<a href="product-details.html" class="grid_4"><img
								src="images/freshCake2.jpg" alt="" width="220" height="120"></a>
						</div>
						<div class="newCake">
							<a href="product-details.html" class="grid_4"><img
								src="images/freshCake3.jpg" alt="" width="220" height="120"></a>
						</div>
						<div class="newCake">
							<a href="product-details.html" class="grid_4"><img
								src="images/freshCake4.jpg" alt="" width="220" height="120"></a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="clear"></div>
	</div>

</template:page>
