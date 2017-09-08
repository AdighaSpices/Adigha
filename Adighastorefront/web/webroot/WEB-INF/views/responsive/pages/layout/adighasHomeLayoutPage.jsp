<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
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



</template:page>
