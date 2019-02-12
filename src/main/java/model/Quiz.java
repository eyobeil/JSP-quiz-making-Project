/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eyobeil
 */
public class Quiz {
    
    private List<QuestionWithAnswer> question=new ArrayList<QuestionWithAnswer>();
    private int attempt;
    private int currentquestionindex=0;
    private int correctCounter=0;
    private int score=0;
    public Quiz(){
        attempt=1;
        question.add(new QuestionWithAnswer("3 1 4 1 5" ,"9"));
        question.add(new QuestionWithAnswer("1 1 2 3 5" ,"8"));
        question.add(new QuestionWithAnswer("1 4 9 16 25" ,"36"));
        question.add(new QuestionWithAnswer("2 3 5 7 11" ,"13"));
        question.add(new QuestionWithAnswer("1 2 4 8 16" ,"32"));
              
    }
    
    
    public void correctAnswer(){
        correctCounter++;
       
         if(attempt==1){
           score+=10;
         }
         else if(attempt==2){
         
         score+=5;
         }
         else
         {
         score+=2;
            }
         
         attempt=1;
        
        if(currentquestionindex==question.size()-1){
           currentquestionindex=0;
        }
        
         currentquestionindex++;

    }
    
    public boolean isAnswerCorrect(String Answer){
      if(question.get(currentquestionindex).getAnswer().equals(Answer))
          return true;
      else
      {
        attempt++;
      }
      return false;
    }
     public String getHint() {
            String hint;
            switch(currentquestionindex) {
                case 0:
                    hint = "Pi";
                    break;
                case 1:
                    hint = "Fibonacci";
                    break;
                case 2:
                    hint = "Squares";
                    break;
                case 3:
                    hint = "Primes";
                    break;
                default:
                    hint = "You're on your own on this one ...";
            }
            return hint;
        }
    
    public String getGrade(){
       if(score>45 && score<50){
           return "A";
       }
       else if(score>35 && score<45){
           return "B";
       }
      else if(score>25 && score<35){
           return "C";
       }
       return "NC";
    }
    
   public int getAttempt(){
       return attempt;
   }

   
    public void setAttempt(int attempt) {
        this.attempt = attempt;
    }



    public String getCurrentQuestion() {
        return question.get(currentquestionindex).getQuestion();
    }
   public String getCurrentAnswer(){   
    return question.get(currentquestionindex).getAnswer();
   }
    public int getCurrentquestionindex() {
        return currentquestionindex;
    }

    public int getCorrectCounter() {
        return correctCounter;
    }

    public int getScore() {
        return score;
    }
    
    
    public int getTotalQestions(){
        return question.size();
    }
    
    
    
}
