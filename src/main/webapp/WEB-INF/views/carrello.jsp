<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Carrello - E-Commerce</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="p-4">

<nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-4 p-3 border">
    <div class="container">
        <a class="navbar-brand fw-bold" href="${pageContext.request.contextPath}/catalogo">E-Commerce</a>
        <div>
            <span class="me-3 text-white">Benvenuto, <strong>${utenteLoggato.nome}</strong></span>
            <a href="${pageContext.request.contextPath}/login?azione=logout"
               class="btn btn-outline-light btn-sm">Logout</a>
        </div>
    </div>
</nav>

<div class="container">
    <h1 class="mb-4">Carrello Acquisti</h1>

    <div class="row">
        <div class="col-lg-8">
            <c:forEach items="${listaRighe}" var="r">
                <div class="card mb-3 p-3">
                    <div class="row align-items-center">
                        <div class="col-md-7">
                            <h3>${r.prodotto.nome}</h3>
                            <p class="text-muted mb-1">${r.prodotto.descrizioneBreve}</p>
                            <p class="fw-bold">&euro; ${r.prodotto.prezzo}</p>
                        </div>

                        <div class="col-md-5 text-md-end mt-3 mt-md-0">
                            <form action="${pageContext.request.contextPath}/carrello" method="post"
                                  class="d-inline-flex align-items-center gap-2 mb-2">
                                <input type="hidden" name="azione" value="aggiornaq"/>
                                <input type="hidden" name="rigaCarrelloId" value="${r.id}"/>
                                <input type="number" name="quantita" value="${r.quantita}" min="1" max="99"
                                       class="form-control form-control-sm text-center" style="width: 60px;"/>
                                <button type="submit" class="btn btn-outline-secondary btn-sm">Aggiorna</button>
                            </form>

                            <form action="${pageContext.request.contextPath}/carrello" method="post" class="d-inline">
                                <input type="hidden" name="azione" value="rimuovi"/>
                                <input type="hidden" name="rigaCarrelloId" value="${r.id}"/>
                                <button type="submit" class="btn btn-outline-danger btn-sm">Rimuovi</button>
                            </form>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>

        <div class="col-lg-4">
            <div class="p-4 border bg-white">
                <h3>Riepilogo</h3>
                <hr>
                <div class="d-flex justify-content-between align-items-center mb-3">
                    <span>Totale:</span>
                    <span class="fw-bold fs-5 text-success">&euro; ${totale}</span>
                </div>
                <div class="p-4">
                    <form action="${pageContext.request.contextPath}/ordine" method="post">

                        <div class="mb-3">
                            <label class="form-label fw-bold" for="indirizzoS">Indirizzo di Spedizione</label>
                            <input class="form-control" type="text" id="indirizzoS" name="indirizzoS" required>
                        </div>
                        <input type="hidden" name="totale" value="${totale}"/>
                        <div class="mb-3">
                            <label class="form-label fw-bold" for="indirizzoF">Indirizzo di Fatturazione</label>
                            <input class="form-control" type="text" id="indirizzoF" name="indirizzoF">
                        </div>

                        <button type="submit" class="btn btn-success w-100 fw-bold  text-light">
                            Conferma Ordine
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>