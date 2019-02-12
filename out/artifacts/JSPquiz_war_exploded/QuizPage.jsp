<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Number Quiz - JSP Version</title>
    </head>
    <body>
        <form name='myform' method='post' action="TakeQuiz">
            <h3>Have fun with Number Quiz!</h3>
<!--            <p>Your Age: <input type="text" name="age" value=${age}></p>
            <font style='color:red'><b>${ageError}</b></font>
            <font style='color:red'><b>${correction}</b></font>-->
            <p>Your current score is ${quiz.score}.</p>
            <p>Question ${quiz.currentQuestionIndex+1} of 5</br>
                <%-- Displays the number of attempts, obtained from the quiz object --%>
               Attempt ${quiz.attempt} of 3</p>
            <p>Guess the next number in the sequence!</p>
            <p>
                <%-- Displays the question in a formatted form --%>
                ${quiz.currentQuestionPartial}<font style='color:red'><b> ? </b></font>]</br>
            </p>
            <p>Your answer:<input type='text' name='txtAnswer' value='' /></p>
            <font style='color:red'><b>${wrongAnswer}</b></font>
            <p>
                <input type='submit' name='btnNext' value='Next' />
                <input type='submit' name='btnNext' value='Restart!' />
            </p>
            <p>
                <input type="submit" name="btnNext" value="Hint" />
                <font style='color:green'><b>${hint}</b></font>
            </p>
        </form>
    </body>
</html>
