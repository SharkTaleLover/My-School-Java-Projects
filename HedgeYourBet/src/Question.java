public class Question
{
    String question;
    String[] possibleAnswers;
    int answerIndex;

    public Question(String question, String[] possibleAnswers, int answerIndex)
    {
        this.question = question;
        this.possibleAnswers = possibleAnswers;
        this.answerIndex = answerIndex;
    }

    public String getQuestion()
    {
        return question;
    }

    public void setQuestion(String question)
    {
        this.question = question;
    }

    public String getPossibleAnswer(int i)
    {
        return possibleAnswers[i];
    }

    public void setPossibleAnswers(String[] possibleAnswers)
    {
        this.possibleAnswers = possibleAnswers;
    }

    public int getAnswerIndex()
    {
        return answerIndex;
    }

    public void setAnswerIndex(int answerIndex)
    {
        this.answerIndex = answerIndex;
    }
}
