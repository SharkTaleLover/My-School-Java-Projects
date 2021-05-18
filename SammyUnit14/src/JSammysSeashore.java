import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

public class JSammysSeashore extends JFrame implements ActionListener, ItemListener
{
    static List<JCheckBox> boxes = new ArrayList<JCheckBox>();
    static JTextField rentalHours = new JTextField("Hours");
    static double price = 0;
    static int userHours = 0;
    static ButtonGroup equipmentButtons = new ButtonGroup();
    static JLabel rentalDetails = new JLabel("Price is $" + price);
    static JCheckBox equipmentLesson = new JCheckBox("Add Equpiment Lesson");
    static JSammysSeashore inputFrame = new JSammysSeashore();
    static double dollarsPerHour = 0;
    static double addonPrice = 0;

    public JSammysSeashore()
    {
        setLayout(new FlowLayout());
        add(rentalHours);
        rentalHours.addActionListener(this);
        for(int i = 0; i < Equipment.equipmentNames.length - 1; i++)
        {
            JCheckBox box = new JCheckBox(Equipment.equipmentNames[i]);
            boxes.add(box);
            equipmentButtons.add(box);
            add(box);
        }
        add(equipmentLesson);
        add(rentalDetails);
        pack();
    }

    public static void main(String[] args)
    {
        inputFrame.setVisible(true);
        inputFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        try
        {
            userHours = Integer.parseInt(rentalHours.getText());
        }
        catch (Exception exc)
        {
            rentalDetails.setText("Please enter a number");
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e)
    {
        Object check = e.getSource();
        if(check.equals(boxes.get(0)) || check.equals(boxes.get(1)))
            dollarsPerHour = 40;
        if(check.equals(boxes.get(2)) || check.equals(boxes.get(3)) || check.equals(boxes.get(4)))
            dollarsPerHour = 20;
        if(check.equals(boxes.get(5)) || check.equals(6))
            dollarsPerHour = 7;
        if(check.equals(equipmentLesson))
            if(e.getStateChange() == ItemEvent.SELECTED)
                addonPrice += 5;
            else
                addonPrice -= 5;
        updateLabel();
    }

    public static void updateLabel()
    {
        price = (userHours*dollarsPerHour) + addonPrice;
        rentalDetails.setText("Price is $" + price);
        inputFrame.pack();
    }
}
