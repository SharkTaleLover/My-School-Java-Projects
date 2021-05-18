import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SmarterLastManStanding extends JFrame implements ItemListener, ActionListener
{
    static List<JCheckBox> boxes = new ArrayList<JCheckBox>();
    static List<JCheckBox> selectionsList = new ArrayList<JCheckBox>();
    static JButton button = new JButton("Submit");
    static JLabel debugLabel = new JLabel();
    static SmarterLastManStanding panel = new SmarterLastManStanding();
    static int selections = 0;

    public SmarterLastManStanding()
    {
        setLayout(new FlowLayout());
        for(int i = 0; i < 10; i++)
        {
            boxes.add(new JCheckBox());
            add(boxes.get(i));
            boxes.get(i).addItemListener(this);
        }
        add(button);
        button.addActionListener(this);
        add(debugLabel);
    }

    public static void main(String[] args)
    {
        panel.setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.pack();
        panel.setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e)
    {
        JCheckBox checkBox = (JCheckBox)e.getSource();
        if(e.getStateChange() == ItemEvent.SELECTED)
        {
            selections++;
            selectionsList.add(checkBox);
        }
        else
        {
            selections--;
            selectionsList.remove(checkBox);
        }
        if(selections > 3)
        {
            checkBox.setSelected(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(selections > 0)
        {
            for (int i = 0; i < selections; i++)
            {
                panel.remove(boxes.get(0));
                boxes.remove(0);
            }
            for (JCheckBox box : boxes) box.setSelected(false);
            if(boxes.size() == 0)
            {
                debugLabel.setText("Game over! You won!");
                button.setEnabled(false);
                panel.pack();
                return;
            }
            selections = 0;
            panel.pack();
            getComputerChecks();
        }
    }

    public static void getComputerChecks()
    {
        Random random = new Random();
        int checkNum = random.nextInt(3) + 1;
        if(boxes.size() < 4)
            checkNum = boxes.size();
        debugLabel.setText("AI selected " + checkNum + " boxes.");
        panel.pack();
        for(int i = 0; i < checkNum; i++)
        {
            panel.remove(boxes.get(0));
            boxes.remove(0);
        }
        if(boxes.size() == 0)
        {
            debugLabel.setText("Game over! AI won!");
            button.setEnabled(false);
            panel.pack();
        }
    }
}