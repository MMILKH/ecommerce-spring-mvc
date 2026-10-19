<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Elenco Utenti - E-Commerce</title>
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
    <div class="d-flex justify-content-between align-items-center mb-3">
        <h1 class="m-0">Elenco Utenti</h1>
    </div>

    <div class="card border bg-white shadow-sm">
        <div class="card-body p-0">
            <c:if test="${not empty utenti}">
                <div class="table-responsive">
                    <table class="table table-hover table-striped align-middle mb-0">
                        <thead class="table-dark">
                        <tr>
                            <th scope="col" class="ps-3">ID</th>
                            <th scope="col">Nome</th>
                            <th scope="col">Cognome</th>
                            <th scope="col">Email</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${utenti}" var="u">
                            <tr>
                                <td class="ps-3 fw-bold">${u.id}</td>
                                <td>${u.nome}</td>
                                <td>${u.cognome}</td>
                                <td>${u.email}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:if>

            <c:if test="${empty utenti}">
                <div class="p-4 text-center text-muted">
                    Nessun utente presente nel sistema.
                </div>
            </c:if>
        </div>
    </div>
</div>

</body>
</html>