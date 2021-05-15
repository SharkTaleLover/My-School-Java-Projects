import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exercise2 extends JFrame implements ActionListener
{
    final int SIZE = 180;
    JButton button = new JButton("Press me");
    int count = 0;
    final int MAX = 8;
    JLabel label = new JLabel("That's enough!");
    public Exercise2()
    {
        super();
        setSize(SIZE, SIZE);
        setLayout(new FlowLayout());
        add(button);
        add(label);
        label.setVisible(false);
        button.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        count++;
        if(count == 8)
        {
            label.setVisible(true);
        }
    }

    public static void main(String[] args)
    {
        Exercise2 window = new Exercise2();
    }
}
