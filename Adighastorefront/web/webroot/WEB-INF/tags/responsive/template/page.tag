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
						<cms:pageSlot position="Section1" var="feature">
							<cms:component component="${feature}" />
						</cms:pageSlot>
					</div>
				</div>
				
				
				
				<div class="productThumb grid_10 prefix_3 suffix_3">
			      <ul>
			        <li class="grid_2 alpha"><a href="#" class=""><img src="images/thumb1.jpg" alt="" width="100" height="60"></a></li>
			        <li class="grid_2"><a href="#" class=""><img src="images/thumb2.jpg" alt="" width="100" height="60"></a></li>
			        <li class="grid_2"><a href="#" class=""><img src="images/thumb1.jpg" alt="" width="100" height="60"></a></li>
			        <li class="grid_2"><a href="#" class=""><img src="images/thumb2.jpg" alt="" width="100" height="60"></a></li>
			        <li class="grid_2 omega"><a href="#" class="current"><img src="images/thumb1.jpg" alt="" width="100" height="60"></a></li>
			      </ul>
			    </div>
    
			</div>
		 	<div class="clear"></div>
		</div>
		<div>
			<common:globalMessages />
			<jsp:doBody />
		</div>




			<footer:footer />

	</jsp:body>

</template:master>
