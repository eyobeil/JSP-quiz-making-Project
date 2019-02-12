

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Number Quiz  </title>
        <link rel="stylesheet" href="numquiz.css"/>
    </head>
    <body>
        <center>
        <div>
        <form name='myform' method='post' action="NumberQuizServlet">
           
            <h3>Have fun with Number Quiz!</h3>
            <p>Your Age: <input type="text" name="txtage" value=${age}></p>
            <font style='color:red'><b>${ageError}</b></font>
            <font style='color:red'><b>${Flag}</b></font>
            <p>Your current score is ${quiz.score}.</p>
            <p>Question ${quiz.currentquestionindex+1} of 5</br>
                <%-- Displays the number of attempts, obtained from the quiz object --%>
               Attempt ${quiz.attempt} of 3</p>
            <p>Guess the next number in the sequence!</p>
            <p>
                <%-- Displays the question in a formatted form --%>
                ${quiz.getCurrentQuestion()}<font style='color:red'><b> ? </b></font>]</br>
            </p>
            <p>Your answer:<input type='text' name='txtAnswer' value='' /></p>
            <font style='color:red'><b>${wrongAnswer}</b></font>
            <p>
                <input type='submit' name="checkedbutton" value="Next" />
                <input type='submit' name="checkedbutton" value="Restart" />
            </p>
            <p>
                <input type="submit" name="checkedbutton" value="Hint" />
                <font style='color:green'><b>${hint}</b></font>
            </p>
        </form>
            </div>
        </center>
    </body>
</html>
