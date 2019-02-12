
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Grade Report Page</title>
    </head>
    <body style="background-image:url('index.jpg')">
        <h1>Grade Report</h1>
        
	<p style='color:red'>The number quiz is over!</p>
        <p>Age: ${age}</p>
        Grade: ${quiz.getGrade()}
            <form name='myform' method='post' action="TakeQuiz">
                <p><input type='submit' name='btnNext' value='Start Again!' /></p>
            </form>
    </body>
</html>
