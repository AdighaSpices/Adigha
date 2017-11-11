<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/responsive/product"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/responsive/product"%>

<style type="text/css">
table, th, td {
}
.description{
color: #3E1C10; font-weight: 900; font-size: 20px; line-height: 50px;
}
.price{
color: #3E1C10; font-weight: 900; font-size: 20px; line-height: 50px;
}
</style>
<table>
	<tr >
		<th colspan="2">
			<ycommerce:testId code="productDetails_productNamePrice_label_${product.code}">
				<div style="color: #3E1C10; font-weight: 900; font-size: 20px; line-height: 50px;">
					${product.code}|| ${product.name}
				</div>
			</ycommerce:testId>
		</th>
	</tr>
	<tr>
		<td colspan="2"><product:productImagePanel galleryImages="${galleryImages}" product="${product}" /></td>
	</tr>
		<tr>
		<td><ycommerce:testId code="productDetails_productNamePrice_label_${product.code}">
				<div class="price">
					<product:productPricePanel product="${product}" />
				</div>
			</ycommerce:testId></td>
		<td>
			<div class="description"> ${product.description}</div>
		</td>
	</tr>
	
</table>




