<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %>


<footer>
    <cms:pageSlot position="Footer" var="feature">
        <cms:component component="${feature}"/>
    </cms:pageSlot>
    
    <!-- Footer 1 : Load from Component -->
    <div id="richContent">
	  <div class="container_16">
	    <div class="popularCakes grid_4">
	      <h4>Popular Cakes</h4>
	      <ul>
	        <li><a href="#">Ultimate Choco Brownie</a></li>
	        <li><a href="#">Mokakokoa Brownie</a></li>
	        <li><a href="#">CoffeeBrown</a></li>
	        <li><a href="#">Delicacheese</a></li>
	        <li><a href="#">Berries Cheesecake</a></li>
	      </ul>
	    </div>
	    <div class="recommended grid_4">
	      <h4>Recommended</h4>
	      <ul>
	        <li><a href="#">Ultimate Choco Brownie</a></li>
	        <li><a href="#">Mokakokoa Brownie</a></li>
	        <li><a href="#">CoffeeBrown</a></li>
	        <li><a href="#">Delicacheese</a></li>
	        <li><a href="#">Berries Cheesecake</a></li>
	      </ul>
	    </div>
	    <div class="specialOffer grid_4">
	      <h4>Special Offer</h4>
	      <ul>
	        <li><a href="#">Ultimate Choco Brownie</a></li>
	        <li><a href="#">Mokakokoa Brownie</a></li>
	        <li><a href="#">CoffeeBrown</a></li>
	        <li><a href="#">Delicacheese</a></li>
	        <li><a href="#">Berries Cheesecake</a></li>
	      </ul>
	    </div>
	    <div class="orderPhone grid_4">
	      <h4><em>Order by Phone</em> <span>987-654-321</span></h4>
	    </div>
	    <div class="clear"></div>
	  </div>
	</div>


    <!-- Footer 2 : Load from Component -->
	<div id="richContent2">
	  <div class="container_16">
	    <div class="fromBlog grid_4">
	      <h4>From the blog</h4>
	      <h5>New Recipes in Our Basket</h5>
	      <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. vivamus tempor justo sit amet metus cursus consequat. Nulla viverra, felis vel accumsan fermentum... <a href="#" class="bookMan">more »</a></p>
	    </div>
	    <div class="corporateInfo grid_4">
	      <h4>Corporate Info</h4>
	      <ul>
	        <li><a href="#">Privacy Policy</a></li>
	        <li><a href="#">Term &amp; Conditions</a></li>
	        <li><a href="#">Franchise</a></li>
	        <li><a href="#">About us</a></li>
	        <li><a href="#">FAQ</a></li>
	      </ul>
	    </div>
	    <div class="storeDelivery grid_4">
	      <h4>Store &amp; Delivery</h4>
	      <ul>
	        <li><a href="#">Store Locator</a></li>
	        <li><a href="#">Delivery Terms &amp; Pricing</a></li>
	        <li><a href="#">Delivery Coverage</a></li>
	        <li><a href="#">Gift Services</a></li>
	        <li><a href="#">Track my order</a></li>
	      </ul>
	    </div>
	    <div class="socialNet grid_4">
	      <h4>Keep in touch</h4>
	      <ul>
	        <li><a href="#" class="facebook">Facebook</a></li>
	        <li><a href="#" class="twitter">Twitter</a></li>
	        <li><a href="#" class="feed">Feed</a></li>
	      </ul>
	    </div>
	    <div class="clear"></div>
	  </div>
	</div>
	
	
    <!-- Footer 3 : Load from Component -->
	<div id="footer">
	  <div class="container_16">
	    <div class="copyright grid_16">
	      <p class="left">Copyright © 2010, Your Company Here, All Rights Reserved</p>
	      <p class="right">Design by <a href="http://tokokoo.com/">Tokokoo</a> &amp; <a href="http://www.instantshift.com/">instantShift</a></p>
	      <div class="clear"></div>
	    </div>
	    <div class="clear"></div>
	  </div>
	</div>
</footer>

