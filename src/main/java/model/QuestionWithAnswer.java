package model;

public class QuestionWithAnswer {
    
      public String Question="";
      public String Answer="";
    public QuestionWithAnswer( String ques,String ans){
                     this.Question=ques;
                     this.Answer=ans;
             }
    
   public String getQuestion(){
       return Question;
   }
    public String getAnswer(){
        return Answer;
    }
    
}
