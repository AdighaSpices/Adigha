<%@ page trimDirectiveWhitespaces="true"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:url value="/search/" var="searchUrl" />
<c:url value="/search/autocomplete/${component.uid}"
	var="autocompleteUrl" />

<div class="adighaui-front">
	<form name="search_form_${component.uid}" method="get"
		action="${searchUrl}">
		<div class="adighainput-group">
			<spring:theme code="search.placeholder" var="searchPlaceholder" />

				<input type="text" id="js-site-search-input"
					class="form-control js-site-search-input" name="text" value=""
					maxlength="100" placeholder="${searchPlaceholder}"
					data-options='{"autocompleteUrl" : "${autocompleteUrl}","minCharactersBeforeRequest" : "${component.minCharactersBeforeRequest}","waitTimeBeforeRequest" : "${component.waitTimeBeforeRequest}","displayProductImages" : ${component.displayProductImages}}'>

			<span class="input-group-btn">
					<button class="btn btn-link" type="submit">
						<span class="glyphicon glyphicon-search"></span>
					</button>
			</span>
		</div>
	</form>
</div>
