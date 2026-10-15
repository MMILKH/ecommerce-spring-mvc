<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>Register</title>
</head>
<body class="bg-light min-vh-100 d-flex flex-column justify-content-center align-items-center">

<div style="width: 100%; max-width: 400px;">
    <h2 class="text-center mb-4">Registrati</h2>
    <div class="card border p-4 bg-white ">
        <form action="${pageContext.request.contextPath}/register" method="post">
            <div class="mb-3">
                <label class="form-label" for="nome">nome</label>
                <input class="form-control" id="nome" name="nome" required>
            </div>
            <div class="mb-3">
                <label class="form-label" for="cognome">cognome</label>
                <input class="form-control" id="cognome" name="cognome" required>
            </div>
            <label class="form-label" for="email">Email</label>
            <input class="form-control" type="email" id="email" name="email" required>

            <div class="mb-3">
                <label class="form-label" for="numero">Numero</label>
                <input class="form-control" id="numero" type="tel" pattern="^[0-9]{9,15}$" name="numero" required>
            </div>
            <div class="mb-3">
                <label class="form-label" for="indirizzo">Indirizzo</label>
                <input class="form-control" id="indirizzo" name="indirizzo">
            </div>

            <div class="mb-3">
                <label class="form-label" for="password">Password</label>
                <input class="form-control" type="password" id="password" name="password" required>
            </div>

            <div class="mb-3">
                <label class="form-label" for="passwordconf">Conferma Password</label>
                <input class="form-control" type="password" id="passwordconf" name="passwordconf" required>
            </div>


            <button class="btn btn-dark w-100" type="submit">Registrati</button>
            <div class="text-center mt-3">
                <span class="small text-muted d-block mb-2">Hai già un account?</span>
                <a href="${pageContext.request.contextPath}/login" class="btn btn-outline-dark btn-sm w-100">Accedi</a>
            </div>
        </form>

        <c:if test="${not empty errore}">
            <div class="alert alert-danger mt-3 mb-0 py-2 small" role="alert">
                    ${errore}
            </div>
        </c:if>
    </div>
</div>

</body>
</html>