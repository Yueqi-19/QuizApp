<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en-US">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quiz Page</title>
    <!-- CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet">
    <%--<link rel="stylesheet" type="text/css" href="css/styles.css">--%>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/styles-quiz.css">
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
                <p class="fw-bold">Welcome ${user.firstName},</p>
                <h1>${category.name} Quiz</h1>
            </div>
            <div class="p-2 m-4">
                <form:form method="post" action="/quiz" modelAttribute="selectedOption">
                    <div class="m-1">
                        <p>${questionNumber + 1}. ${tenQuestions.get(questionNumber).content}</p>
                    </div>
                    <div class="row">
                        <div class="col">
                        </div>
                        <div class="col-6">
                            <c:forEach var="option" items="${tenQuestionsOptions.get(questionNumber)}" varStatus="loop">
                                <div class="text-start m-1">
                                        <%--<form:radiobutton path="id" value="${option.id}" label="${option.content}"/>--%>
                                    <form:radiobutton path="id" value="${option.id}"/> ${option.content}
                                </div>
                            </c:forEach>
                        </div>
                        <div class="col">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <c:if test="${questionNumber > 0}">
                                <div class="m-1">
                                    <button class="p-1" type="submit" name="prev">Prev</button>
                                </div>
                            </c:if>
                        </div>
                        <div class="col-9">
                            <div class="pt-5 m-1">
                                <button class="p-1" type="submit" name="submit">Submit Quiz</button>
                            </div>
                        </div>
                        <div class="col">
                            <c:if test="${questionNumber < 9}">
                                <div class="m-1">
                                    <button class="p-1" type="submit" name="next">Next</button>
                                </div>
                            </c:if>
                        </div>
                    </div>
                </form:form>
            </div>
            <%--<div class="p-2 m-4">--%>
            <%--    <a class="btn btn-primary" href="/result" role="button">Submit Quiz</a>--%>
            <%--</div>--%>
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
