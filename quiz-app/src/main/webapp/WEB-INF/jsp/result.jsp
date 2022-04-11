<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en-US">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Result Page</title>
    <!-- CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet">
    <%--<link rel="stylesheet" type="text/css" href="css/styles.css">--%>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/styles-result.css">
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
                <h1>Quiz Result</h1>
                <h2>${category.name}</h2>
            </div>
            <div class="p-2 m-4">
                <div class="row">
                    <div class="col">
                    </div>
                    <div class="col-10">
                        <p><b>Quiz name: </b>${db_quiz.name}</p>
                        <p><b>User full name: </b>${user.firstName} ${user.lastName}</p>
                        <p><b>Start time: </b>${db_submission.startTime}</p>
                        <p><b>End time: </b>${db_submission.endTime}</p>
                        <p><b>Score: </b>${db_submission.score}</p>
                        <c:choose>
                            <c:when test="${db_submission.score > 6}">
                                <span style="color:green"><b>Pass the quiz!</b></span>
                            </c:when>
                            <c:otherwise>
                                <span style="color:red"><b>Fail the quiz!</b></span>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div class="col">
                    </div>
                </div>
            </div>


            <c:forEach var="question" items="${tenQuestions}" varStatus="loop">
                <div class="p-2 m-4">
                    <div class="row">
                        <div class="col">
                        </div>
                        <div class="col-8">
                            <div class="text-start m-1">
                                <p>${loop.index + 1}. ${tenQuestions.get(loop.index).content}</p>
                            </div>
                        </div>
                        <div class="col">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                        </div>
                        <div class="col-6">
                            <c:forEach var="option" items="${tenQuestionsOptions.get(loop.index)}" varStatus="loop2">
                                <div class="text-start m-1">


                                    <c:choose>
                                        <c:when test="${option.id == db_quizQuestionList.get(loop.index).selectedOptionId}">
                                            <input type="radio"> <span style="background-color:lightgreen"><b>${option.content}</b></span>
                                        </c:when>
                                        <c:when test="${option.isCorrect == true}">
                                            <input type="radio"> <span style="background-color:lightcoral">${option.content}</span>
                                        </c:when>
                                        <c:otherwise>
                                            <input type="radio"> ${option.content}
                                        </c:otherwise>
                                    </c:choose>


                                        <%--<input type="radio"> ${option.content}--%>
                                </div>
                            </c:forEach>
                        </div>
                        <div class="col">
                        </div>
                    </div>
                </div>
            </c:forEach>


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
