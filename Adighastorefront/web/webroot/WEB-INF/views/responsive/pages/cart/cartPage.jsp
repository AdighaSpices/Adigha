<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="cart" tagdir="/WEB-INF/tags/responsive/cart" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/responsive/common" %>
<template:page pageTitle="${pageTitle}">
<%-- 	<cart:cartValidation/>
	<cart:cartPickupValidation/>

	<div class="cart-top-bar">
        <div class="text-right">
            <a href="" class="help js-cart-help" data-help="<spring:theme code="text.help" />"><spring:theme code="text.help" text="Help" />
                <span class="glyphicon glyphicon-info-sign"></span>
            </a>
            <div class="help-popup-content-holder js-help-popup-content">
                <div class="help-popup-content">
                    <strong>${cartData.code }</strong>
                    <spring:theme code="basket.page.cartHelpContent" text="Need Help? Contact us or call Customer Service at 1-###-###-####. If you are calling regarding your shopping cart, please reference the Shopping Cart ID above." />
                </div>
            </div>
		</div>
	</div> --%>

	<div>
		<div>
			<h2 style="color: blue; "> Cart Items Table Start</h2>
            <cms:pageSlot position="TopContent" var="feature">
                <cms:component component="${feature}" element="div" class="yComponentWrapper"/>
            </cms:pageSlot>
            <h2 style="color: blue;">Cart Items Table End</h2>
		</div>
		
		
	   <c:if test="${not empty cartData.entries}">
	   <h2 style="color: blue; "> CenterLeftContentSlot Start</h2>
           <cms:pageSlot position="CenterLeftContentSlot" var="feature">
                <cms:component component="${feature}" element="div" class="yComponentWrapper"/>
           </cms:pageSlot>
           <h2 style="color: blue; "> CenterLeftContentSlot End</h2>
        </c:if>
		
		
		 <c:if test="${not empty cartData.entries}">
		 <h2 style="color: blue; "> Promotion and CartTotals Start</h2>
            <cms:pageSlot position="CenterRightContentSlot" var="feature">
                <cms:component component="${feature}" element="div" class="yComponentWrapper"/>
            </cms:pageSlot>
            <h2 style="color: blue; "> Promotion and CartTotals Start</h2>
             <h2 style="color: blue; "> Checkout Start</h2>
            <cms:pageSlot position="BottomContentSlot" var="feature">
                <cms:component component="${feature}" element="div" class="yComponentWrapper"/>
            </cms:pageSlot>
             <h2 style="color: blue; "> Checkout Ends</h2>
		</c:if>
				
		<c:if test="${empty cartData.entries}">
            <cms:pageSlot position="EmptyCartMiddleContent" var="feature">
                <cms:component component="${feature}" element="div" class="yComponentWrapper content__empty"/>
            </cms:pageSlot>
		</c:if>
	</div>
</template:page>