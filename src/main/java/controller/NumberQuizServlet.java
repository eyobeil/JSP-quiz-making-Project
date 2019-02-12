
package controller;
import model.Quiz.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Quiz;


public class NumberQuizServlet extends HttpServlet {




    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession();
        Quiz  newquiz=(Quiz)session.getAttribute("quiz");
        String checkedbutton=request.getParameter("checkedbutton");
        RequestDispatcher dis=request.getRequestDispatcher("NumberQuizTakingJSPPage.jsp");

        if(newquiz==null || (checkedbutton!=null && checkedbutton.equals("Restart")) ){
            newquiz=new Quiz();
            session.setAttribute("quiz", newquiz);
            session.setAttribute("age", null);
            dis.forward(request, response);
        }
        else{

            if(checkedbutton!=null && checkedbutton.equals("Hint")){
                request.setAttribute("hint", newquiz.getHint());
                session.setAttribute("age", request.getParameter("txtage"));
                dis.forward(request, response);
                return ;
            }

            try{

                int age=Integer.parseInt(request.getParameter("txtage"));
                if(age<4 || age>100){
                    request.setAttribute("ageError", "The Age You Give is Illogical");
                    dis.forward(request, response);
                    return;
                }

            }
            catch(NumberFormatException e){
                request.setAttribute("ageError","oops! for the Age only Number are Allowed; please Try Again");
                dis.forward(request, response);
                return;

            }



            String answer=request.getParameter("txtAnswer");

            try{


                if(newquiz.isAnswerCorrect(answer)==true || newquiz.getAttempt()>3){
                    if(newquiz.getAttempt()>3)
                    {
                        request.setAttribute("Flag", "You missed 3 times. "
                                + "The correct Answer was "+newquiz.getCurrentAnswer()+".");

                    }
                    if(newquiz.getCurrentquestionindex()==newquiz.getTotalQestions()-1){
                        dis = request.getRequestDispatcher("QuizOverJSPPage.jsp");
                        dis.forward(request, response);
                        return;
                    }
                    newquiz.correctAnswer();


                }
                else  if(newquiz.getAttempt()>3){
                    if(newquiz.getAttempt()>3)
                    {
                        request.setAttribute("Flag", "You missed 3 times. "
                                + "The correct Answer was "+newquiz.getCurrentAnswer()+".");

                    }

                    if(newquiz.getCurrentquestionindex()==newquiz.getTotalQestions()-1){
                        dis = request.getRequestDispatcher("QuizOverJSPPage.jsp");
                        dis.forward(request, response);
                        return;
                    }
                    dis.forward(request, response);
                    return;

                }
                else
                {
                    request.setAttribute("wrongAnswer", "Your last answer was not correct! Please try again.");
                }

            }
            catch(NumberFormatException e){
                request.setAttribute("wrongAnswer", "Invalid or blank (NaN) answer. This won't count. Try again.");

            }

            session.setAttribute("age", request.getParameter("txtage"));
            dis.forward(request, response);

        }


    }


}
