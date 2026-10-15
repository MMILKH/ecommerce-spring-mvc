<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Catalogo - E-Commerce</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="p-4">

<nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-4 p-3 border">
    <div class="container">
        <a class="navbar-brand  fw-bold" href="${pageContext.request.contextPath}/catalogo">E-Commerce</a>
        <div>
            <c:choose>
                <c:when test="${not empty utenteLoggato}">
                    <span class="me-3 text-white">Benvenuto, <strong>${utenteLoggato.nome}</strong></span>
                    <a href="${pageContext.request.contextPath}/login?azione=logout"
                       class="btn btn-outline-light btn-sm">Logout</a>
                </c:when>
                <c:otherwise>
                    <a href="${pageContext.request.contextPath}/login" class="btn btn-outline-primary btn-sm">Accedi</a>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</nav>

<div class="container">
    <h1 class="mb-4">Catalogo Prodotti</h1>

    <div class="row">

        <div class="col-lg-8">

            <div class="mb-4 p-3 border bg-white">
                <form action="${pageContext.request.contextPath}/catalogo" method="get" class="d-flex gap-2">
                    <select name="categoria" class="form-select form-select-sm">
                        <option value="">Tutti i prodotti</option>
                        <option value="Elettronica">Elettronica</option>
                        <option value="Abbigliamento">Abbigliamento</option>
                        <option value="Accessori">Accessori</option>
                    </select>
                    <button type="submit" class="btn btn-dark btn-sm">Filtra</button>
                </form>
            </div>

            <c:forEach items="${listaProdotti}" var="p">
                <div class="card mb-3 p-3">
                    <div class="row align-items-center">
                        <div class="col-md-7">
                            <h3>${p.nome}</h3>
                            <p class="text-muted mb-1">${p.descrizioneBreve}</p>
                            <p class="fw-bold">&euro; ${p.prezzo}</p>
                        </div>

                        <div class="col-md-5 text-md-end">
                            <div class="col-md-5 text-md-end">
                                <c:if test="${not empty utenteLoggato}">
                                    <form action="${pageContext.request.contextPath}/aggiungiCarrello" method="post"
                                          class="d-inline-flex gap-2 align-items-center">
                                        <input type="hidden" name="prodottoId" value="${p.id}"/>
                                        <input type="number" name="quantita" value="1" min="1"
                                               class="form-control form-control-sm text-center"/>
                                        <button type="submit" class="btn btn-primary btn-sm">Aggiungi</button>
                                    </form>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>

        <div class="col-lg-4">
            <div class="p-4 border bg-white">
                <h3>Carrello</h3>
                <p class="text-muted">Accedi al tuo carrello per visualizzare gli articoli.</p>
                <a href="${pageContext.request.contextPath}/carrello" class="btn btn-warning w-100">
                    Vai al Carrello
                </a>
            </div>
        </div>
    </div>
</div>

</body>
</html>