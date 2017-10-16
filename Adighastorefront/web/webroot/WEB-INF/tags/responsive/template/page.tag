<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ attribute name="pageTitle" required="false" rtexprvalue="true"%>
<%@ attribute name="pageCss" required="false" fragment="true"%>
<%@ attribute name="pageScripts" required="false" fragment="true"%>
<%@ attribute name="hideHeaderLinks" required="false"%>

<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="header"
	tagdir="/WEB-INF/tags/responsive/common/header"%>
<%@ taglib prefix="footer"
	tagdir="/WEB-INF/tags/responsive/common/footer"%>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/responsive/common"%>
<%@ taglib prefix="cart" tagdir="/WEB-INF/tags/responsive/cart"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>

<!-- Google Analytics -->
<!-- Adding Tracking code Mandatory -->
<script type="text/javascript">
		var gaJsHost = (("https:" == document.location.protocol) ? "https://ssl." : "http://www.");
		document.write(unescape("%3Cscript src='" + gaJsHost + "google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));
	</script>
<script type="text/javascript">
		var pageTracker = _gat._getTracker("UA-xxxxxx-x");
		pageTracker._initData();
		pageTracker._trackPageview();
	</script>
<!-- Adding Tracking code Mandatory -->

<!-- Enabling e-Commerce Transaction Tracking  -->
<script type="text/javascript">
		var gaJsHost = (("https:" == document.location.protocol) ? "https://ssl." : "http://www.");
		document.write(unescape("%3Cscript src='" + gaJsHost + "google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));
	</script>
<script type="text/javascript">
		var pageTracker = _gat._getTracker("UA-xxxxxx-x");
		; var pageTracker = _gat._getTracker("UA-XXXXX-1"); pageTracker._initData(); pageTracker._addTrans( "1234", // Order ID "Mountain View", // Affiliation "11.99", // Total "1.29", // Tax "5", // Shipping "San Jose", // City "California", // State "USA" // Country ); pageTracker._addItem( "1234", // Order ID "DD44", // SKU "T-Shirt", // Product Name "Green Medium", // Category "11.99", // Price "1" // Quantity ); pageTracker._trackTrans(); 
	</script>
<!-- Enabling e-Commerce Transaction Tracking  -->
<!-- Google Analytics -->

<template:master pageTitle="${pageTitle}">

	<jsp:attribute name="pageCss">
		<jsp:invoke fragment="pageCss" />
	</jsp:attribute>

	<jsp:attribute name="pageScripts">
		<jsp:invoke fragment="pageScripts" />
	</jsp:attribute>

	<jsp:body>
		<div id="warp">
		  	<div id="main" class="container_16">
				<header:header hideHeaderLinks="${hideHeaderLinks}" />
				
				
				
				<div class="products grid_16">
					<div class="productsWarp">
						<cms:pageSlot position="Main" var="feature">
							<cms:component component="${feature}" />
						</cms:pageSlot>
					</div>
					<jsp:doBody />
				</div>
				
				
	<div id="fresh">
		<div class="container_16">
			<div id="freshCake" class="grid_16">
				<div class="grid_1 alpha">
					<a class="prevButton disabled">«</a>
				</div>
				<div class="headLine grid_14">
					<h3>Select a product from below</h3>
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
											src="images/freshCake1.jpg" alt="" width="220" height="120">Product 1</a>
						</div>
						<div class="newCake">
							<a href="product-details.html" class="grid_4"><img
											src="images/freshCake2.jpg" alt="" width="220" height="120">Product 2</a>
						</div>
						<div class="newCake">
							<a href="product-details.html" class="grid_4"><img
											src="images/freshCake3.jpg" alt="" width="220" height="120">Product 3</a>
						</div>
						<div class="newCake">
							<a href="product-details.html" class="grid_4"><img
											src="images/freshCake4.jpg" alt="" width="220" height="120">Product 4</a>
						</div>
					</div>
					<div class="cake-row">
						<div class="newCake">
							<a href="product-details.html" class="grid_4"><img
											src="images/freshCake2.jpg" alt="" width="220" height="120">Product 5</a>
						</div>
						<div class="newCake">
							<a href="product-details.html" class="grid_4"><img
											src="images/freshCake3.jpg" alt="" width="220" height="120">Product 6</a>
						</div>
						<div class="newCake">
							<a href="product-details.html" class="grid_4"><img
											src="images/freshCake4.jpg" alt="" width="220" height="120">Product 7</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	
	
	
			</div>
		 	<div class="clear"></div>
		</div>
		<div>
			<common:globalMessages />
		</div>




			<footer:footer />

	</jsp:body>

</template:master>
