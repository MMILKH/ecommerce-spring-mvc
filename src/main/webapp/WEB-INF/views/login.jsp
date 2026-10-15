<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>Login</title>
</head>
<body class="bg-light min-vh-100 d-flex flex-column justify-content-center align-items-center">

<div style="width: 100%; max-width: 400px;">
    <h2 class="text-center mb-4">Accedi</h2>

    <div class="card border p-4 bg-white ">
        <form action="${pageContext.request.contextPath}/login" method="post">
            <div class="mb-3">
                <label class="form-label" for="email">Email</label>
                <input class="form-control" type="email" id="email" name="email" required>
            </div>

            <div class="mb-3">
                <label class="form-label" for="password">Password</label>
                <input class="form-control" type="password" id="password" name="password" required>
            </div>


            <button class="btn btn-dark w-100 mb-3" type="submit">Accedi</button>

            <div class="text-center mt-3">
                <span class="small text-muted d-block mb-2">Non hai un account?</span>
                <a href="${pageContext.request.contextPath}/register" class="btn btn-outline-dark btn-sm w-100">Registrati</a>
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