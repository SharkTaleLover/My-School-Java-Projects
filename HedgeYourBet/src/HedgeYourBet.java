import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.CREATE;

public class HedgeYourBet extends JFrame implements ActionListener, ItemListener
{
    static String[] stringQuestions = {
            "What do .java files compile into?",
            "Who created Java?",
            "When was Java created?",
            "What was Java originally called?",
            "What class do all Java classes inherit from?"
    };
    static String[][] possibleAnswers = {
            {"Binary", "Bytecode", "Assembly"},
            {"James Gosling", "Dennis Ritchie", "Bill Gates"},
            {"1994", "1995", "1996"},
            {"Oak", "Spruce", "Tea"},
            {"Java", "Class", "Object"}
    };
    static int[] answersIndex = {
            1,
            0,
            2,
            0,
            2
    };
    static int index = 0;
    static Question[] questions = new Question[stringQuestions.length];
    private static JLabel questionLabel;
    private static JCheckBox checkBox1;
    private static JCheckBox checkBox2;
    private static JCheckBox checkBox3;
    private static JButton submitButton;
    private static JLabel scoreLabel;
    static int wrongAnswers = 0;
    static int rightAnswers = 0;
    static int score = 0;
    static int lastScore = 0;
    static Path scoreFile = Paths.get("ScoreFile.txt");

    public HedgeYourBet()
    {
        super("Hedge Your Bet");
        for(int i = 0; i < questions.length; i++)
            questions[i] = new Question(stringQuestions[i], possibleAnswers[i], answersIndex[i]);
        setLayout(new FlowLayout());
        questionLabel = new JLabel(questions[index].getQuestion());
        checkBox1 = new JCheckBox(questions[index].getPossibleAnswer(0));
        checkBox2 = new JCheckBox(questions[index].getPossibleAnswer(1));
        checkBox3 = new JCheckBox(questions[index].getPossibleAnswer(2));
        submitButton = new JButton("Submit");
        add(questionLabel);
        add(checkBox1);
        add(checkBox2);
        add(checkBox3);
        add(submitButton);
        lastScore = getLastScore();
        scoreLabel = new JLabel("Last score was " + lastScore);
        add(scoreLabel);

        checkBox1.addItemListener(this);
        checkBox2.addItemListener(this);
        checkBox3.addItemListener(this);
        submitButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(index != 4)
            index++;
        else
            submitAnswers();
            scoreLabel.setText(getAndWriteScore());
        submitAnswers();
        refreshNames(questions[index]);
    }

    @Override
    public void itemStateChanged(ItemEvent e)
    {
        Object check = e.getSource();
        if(check.equals(checkBox1))
            if(e.getStateChange() == ItemEvent.SELECTED)
                switch(index)
                {
                    case 1:
                    case 3:
                        rightAnswers++;
                        break;
                    default:
                        wrongAnswers++;
                        break;
                }
        if(check.equals(checkBox2))
            if(e.getStateChange() == ItemEvent.SELECTED)
                switch(index)
                {
                    case 0:
                        rightAnswers++;
                        break;
                    default:
                        wrongAnswers++;
                        break;
                }
        if(check.equals(checkBox3))
            if(e.getStateChange() == ItemEvent.SELECTED)
                switch(index)
                {
                    case 2:
                    case 4:
                        rightAnswers++;
                        break;
                    default:
                        wrongAnswers++;
                        break;
                }
    }

    public void refreshNames(Question question)
    {
        questionLabel.setText(question.getQuestion());
        checkBox1.setText(question.getPossibleAnswer(0));
        checkBox1.setSelected(false);
        checkBox2.setText(question.getPossibleAnswer(1));
        checkBox2.setSelected(false);
        checkBox3.setText(question.getPossibleAnswer(2));
        checkBox3.setSelected(false);
    }

    public static String getAndWriteScore()
    {
        try
        {
            OutputStream output = new BufferedOutputStream(Files.newOutputStream(scoreFile, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
            writer.write(String.valueOf(score));
            writer.close();
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
        return "Your score was " + score;
    }

    public static int getLastScore()
    {
        try
        {
            scoreFile.toFile().createNewFile();
            InputStream input = new BufferedInputStream(Files.newInputStream(scoreFile, CREATE));
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            String s = reader.readLine();
            if(s != null)
                lastScore = Integer.parseInt(s);
            reader.close();
            scoreFile.toFile().delete();
            scoreFile.toFile().createNewFile();
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
        return lastScore;
    }

    public void submitAnswers()
    {
        if(rightAnswers == 1 && wrongAnswers == 0)
            score += 3;
        else if(rightAnswers == 1 && wrongAnswers == 1)
            score += 2;
        else if(rightAnswers == 1 && wrongAnswers == 2)
            score += 1;
        rightAnswers = 0;
        wrongAnswers = 0;
    }

    public static void main(String[] args)
    {
        HedgeYourBet bet = new HedgeYourBet();
        bet.setVisible(true);
        bet.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bet.pack();
    }
}