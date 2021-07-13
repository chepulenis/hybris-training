<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>

<template:page pageTitle="${pageTitle}">
    <div id="globalMessages">
        <common:globalMessages/>
    </div>

    <cms:pageSlot position="currentNumberOfUsers" var="feature" >
        <cms:component component="${feature}" />
    </cms:pageSlot>
    <cms:pageSlot position="currentNumberOfOrders" var="feature" >
        <cms:component component="${feature}" />
    </cms:pageSlot>

</template:page>
