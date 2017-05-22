<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="hideHeaderLinks" required="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="nav" tagdir="/WEB-INF/tags/responsive/nav"%>
<%@ taglib prefix="footer"
	tagdir="/WEB-INF/tags/responsive/common/footer"%>


<header class="header">
	<div id="header" class="grid_16">
		<div id="logo" class="grid_4 alpha">

			<cms:pageSlot position="SiteLogo" var="logo" limit="1">
				<cms:component component="${logo}" element="div"
					class="yComponentWrapper" />
			</cms:pageSlot>
		</div>
		<div id="headright" class="grid_7 prefix_5 omega">
			<h3 class="login">
				<!-- <a href="login.html">Sign up</a> / <a href="login.html">Login</a> -->
			
				<cms:pageSlot position="Login" var="feature" element="div" class="footer-banner">
			        <cms:component component="${feature}"/>
			    </cms:pageSlot>
			    <cms:pageSlot position="Register" var="feature" element="div" class="footer-banner">
			        <cms:component component="${feature}"/>
			    </cms:pageSlot>
			  </h3>
			<p>Subtotal: $ 00.00</p>
			<p>
				<span class="vChart"><a href="shoppingcart.html">View
						Cart</a></span> <span class="cOut"><a href="checkout.html">Checkout</a></span>
			</p>
		</div>
	</div>



	<!-- TODO Header Navigation Nodes -->
	<div id="mainMenu" class="grid_16">
		<ul>
			<li><a href="index.html" class="aActive">
			<cms:pageSlot position="Home" var="feature" element="div" class="login-right-content-slot">
				<cms:component component="${feature}"  element="div" class="login-right-content-component"/>
			</cms:pageSlot>
			</a></li>
			
			<li><a href="#">Cakes</a></li>
			<li><a href="#">Order &amp; Delivery</a></li>
			<li><a href="#">Blog</a></li>
			<li><a href="#">About</a></li>
			<li><a href="#">Contact</a></li>
		</ul>
	</div>

	<!-- TODO Discounts and Search Integration -->
	<div id="stickySearch" class="grid_16">
		<div class="stickyNews grid_12 alpha">
			<p>
				Promotions and Discouts will display here <em>Free Delivery.</em> <a
					href="#" class="bookMan">More</a>
			</p>
		</div>
		<div class="search grid_4 omega">
			<form action="#" method="get">
				<input type="text" value="Type your keyword" id="s" name="s"
					onfocus="if (this.value == 'Type your keyword') {this.value = '';}"
					onblur="if (this.value == '') {this.value = 'Type your keyword';}">
			</form>
		</div>
	</div>
	<nav:topNavigation />
</header>