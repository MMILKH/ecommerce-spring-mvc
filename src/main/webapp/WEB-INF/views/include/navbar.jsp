<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>



<nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-4 p-3 border">
    <div class="container">
        <a class="navbar-brand  fw-bold" href="${pageContext.request.contextPath}/catalogo">E-Commerce</a>
        <div>
            <c:choose>
                <c:when test="${not empty utenteLoggato}">
                    <span class="me-3 text-white">Benvenuto, <strong>${utenteLoggato.nome}</strong></span>
                    <a href="${pageContext.request.contextPath}/login?azione=logout"
                       class="btn btn-outline-light btn-sm">Logout</a>
                    <a href="${pageContext.request.contextPath}/carrello"
                       class="btn btn-outline-light btn-sm me-2">
                        Carrello
                        <span id="badgeCarrello" class="badge bg-danger ms-1">
                                ${totaleE}
                        </span>
                    </a>
                </c:when>
                <c:otherwise>
                    <a href="${pageContext.request.contextPath}/login" class="btn btn-outline-primary btn-sm">Accedi</a>
                </c:otherwise>
            </c:choose>
        </div>

    </div>
</nav>