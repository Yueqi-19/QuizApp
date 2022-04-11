<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en-US">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <!-- CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet">
    <%--<link rel="stylesheet" type="text/css" href="css/styles.css">--%>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/styles-login.css">
    <!-- JavaScript -->
    <%--<script type="text/javascript" src="js/script.js" defer></script>--%>
</head>
<body>
<header>
    <jsp:include page="./header.jsp"/>
</header>
<main>
    <section class="bg-light text-dark text-center p-4 mt-5">
        <div class="container">
            <div class="p-2 m-4">
                <h1>Please Login</h1>
            </div>
            <div class="p-2 m-4">
                <form method="post" action="/login">
                    <div class="m-1">
                        <label>Username: </label>
                        <input type="text" name="username" value="" placeholder="Username" required>
                    </div>
                    <div class="m-1">
                        <label>Password: </label>
                        <input type="password" name="password" value="" placeholder="Password" required>
                    </div>
                    <div class="m-1">
                        <button class="p-1" type="submit">Login</button>
                    </div>
                    <div>
                        <%--<c:if test="${not empty test1}">--%>
                        <%--<span style='color:red'>${errorMessage1}</span>--%>
                        <%--<br>--%>
                        <%--</c:if>--%>
                        <span style='color:red'>${errorMessage1}</span>
                        <br>
                        <span style='color:red'>${errorMessage2}</span>
                        <br>
                    </div>
                </form>
            </div>
            <div class="p-2 m-4">
                <a href="/register">Register/Create New Account</a>
            </div>
        </div>
    </section>

</main>
<footer>
    <jsp:include page="./footer.jsp"/>
</footer>
<!-- JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
