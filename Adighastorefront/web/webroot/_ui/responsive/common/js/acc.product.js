/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2016 SAP SE or an SAP affiliate company.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
ACC.product = {

   /* _autoload: [
        "bindToAddToCartForm",
        "enableStorePickupButton",
        "enableVariantSelectors",
        "bindFacets"
    ],*/


    bindFacets: function () {
        $(document).on("click", ".js-show-facets", function (e) {
            e.preventDefault();
            var selectRefinementsTitle = $(this).data("selectRefinementsTitle");
            ACC.colorbox.open(selectRefinementsTitle, {
                href: ".js-product-facet",
                inline: true,
                width: "480px",
                onComplete: function () {
                    $(document).on("click", ".js-product-facet .js-facet-name", function (e) {
                        e.preventDefault();
                        $(".js-product-facet  .js-facet").removeClass("active");
                        $(this).parents(".js-facet").addClass("active");
                        $.colorbox.resize()
                    })
                },
                onClosed: function () {
                    $(document).off("click", ".js-product-facet .js-facet-name");
                }
            });
        });
        enquire.register("screen and (min-width:" + screenSmMax + ")", function () {
        	alert('1');
            $("#cboxClose").click();
        });
    },


    enableAddToCartButton: function () {
        $('.js-enable-btn').each(function () {
            if (!($(this).hasClass('outOfStock') || $(this).hasClass('out-of-stock'))) {
                $(this).removeAttr("disabled");
            }
        });
    },

    enableVariantSelectors: function () {
        $('.variant-select').removeAttr("disabled");
    },

    bindToAddToCartForm: function () {
        var addToCartForm = $('.add_to_cart_form');
        addToCartForm.ajaxForm({success: ACC.product.displayAddToCartPopup});
    },

    bindToAddToCartStorePickUpForm: function () {
        var addToCartStorePickUpForm = $('#colorbox #add_to_cart_storepickup_form');
        addToCartStorePickUpForm.ajaxForm({success: ACC.product.displayAddToCartPopup});
    },

    enableStorePickupButton: function () {
        $('.js-pickup-in-store-button').removeAttr("disabled");
    },

    displayAddToCartPopup: function (cartResult, statusText, xhr, formElement) {
        $('#addToCartLayer').remove();

        if (typeof ACC.minicart.updateMiniCartDisplay == 'function') {
            ACC.minicart.updateMiniCartDisplay();
        }
        var titleHeader = $('#addToCartTitle').html();

        ACC.colorbox.open(titleHeader, {
            html: cartResult.addToCartLayer,
            width: "460px"
        });

        var productCode = $('[name=productCodePost]', formElement).val();
        var quantityField = $('[name=qty]', formElement).val();

        var quantity = 1;
        if (quantityField != undefined) {
            quantity = quantityField;
        }

        var cartAnalyticsData = cartResult.cartAnalyticsData;

        var cartData = {
            "cartCode": cartAnalyticsData.cartCode,
            "productCode": productCode, "quantity": quantity,
            "productPrice": cartAnalyticsData.productPostPrice,
            "productName": cartAnalyticsData.productName
        };
        ACC.track.trackAddToCart(productCode, quantity, cartData);
    }
};

$(document).ready(function () {
    ACC.product.enableAddToCartButton();
});