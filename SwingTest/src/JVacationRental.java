import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class JVacationRental extends JFrame implements ItemListener {
    FlowLayout flow = new FlowLayout();
    String companyName = new String("Lambert's Vacation Rentals");
    Font bigFont = new Font("Arial", Font.PLAIN, 24);
    final int PARKPRICE = 600, POOLPRICE = 750, LAKEPRICE = 825;
    int totalPrice = 0;
    ButtonGroup locationGrp = new ButtonGroup();
    JCheckBox parkBox = new JCheckBox("Parkside", false);
    JCheckBox poolBox = new JCheckBox("Poolside", false);
    JCheckBox lakeBox = new JCheckBox("Lakeside", false);
    final int ONEPRICE = 0, TWOPRICE = 75, THREEPRICE = 150;
    ButtonGroup bdrmGrp = new ButtonGroup();
    JCheckBox oneBox = new JCheckBox("1 bedroom", false);
    JCheckBox twoBox = new JCheckBox("2 bedrooms", false);
    JCheckBox threeBox = new JCheckBox("3 bedrooms", false);
    final int NOMEALSPRICE = 0, MEALSPRICE = 200;
    ButtonGroup mealGrp = new ButtonGroup();
    JCheckBox noMealsBox = new JCheckBox("No meals", false);
    JCheckBox mealsBox = new JCheckBox("Meals included", false);
    JTextField totPrice = new JTextField(10);
    String output = "$" + totalPrice;
    public JVacationRental()
    {
        super("Vacation rentals");
        setLayout(flow);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(parkBox);
        add(poolBox);
        add(lakeBox);

        add(oneBox);
        add(twoBox);
        add(threeBox);

        add(noMealsBox);
        add(mealsBox);

        locationGrp.add(parkBox);
        locationGrp.add(poolBox);
        locationGrp.add(lakeBox);
        bdrmGrp.add(oneBox);
        bdrmGrp.add(twoBox);
        bdrmGrp.add(threeBox);
        mealGrp.add(noMealsBox);
        mealGrp.add(mealsBox);

        add(totPrice);
        totPrice.setText(output);

        parkBox.addItemListener(this);
        poolBox.addItemListener(this);
        lakeBox.addItemListener(this);
        oneBox.addItemListener(this);
        twoBox.addItemListener(this);
        threeBox.addItemListener(this);
        noMealsBox.addItemListener(this);
        mealsBox.addItemListener(this);
    }
    public static void main(String[] arguments)
    {
        JVacationRental aFrame = new JVacationRental();
        aFrame.setSize(320, 200);
        aFrame.setVisible(true);
    }
    @Override
    public void itemStateChanged(ItemEvent check)
    {
        Object source = check.getSource();
        int select = check.getStateChange();
        if (parkBox.equals(source))
        {
            if (select == ItemEvent.SELECTED)
                totalPrice += PARKPRICE;
            else
                totalPrice -= PARKPRICE;
        } else if (poolBox.equals(source))
        {
            if (select == ItemEvent.SELECTED)
                totalPrice += POOLPRICE;
            else
                totalPrice -= POOLPRICE;
        } else if (lakeBox.equals(source))
        {
            if (select == ItemEvent.SELECTED)
                totalPrice += LAKEPRICE;
            else
                totalPrice -= LAKEPRICE;
        } else if (oneBox.equals(source))
        {
            if (select == ItemEvent.SELECTED)
                totalPrice += ONEPRICE;
            else
                totalPrice -= ONEPRICE;
        } else if (twoBox.equals(source))
        {
            if (select == ItemEvent.SELECTED)
                totalPrice += TWOPRICE;
            else
                totalPrice -= TWOPRICE;
        } else if (threeBox.equals(source))
        {
            if (select == ItemEvent.SELECTED)
                totalPrice += THREEPRICE;
            else
                totalPrice -= THREEPRICE;
        } else if (noMealsBox.equals(source))
        {
            if (select == ItemEvent.SELECTED)
                totalPrice += NOMEALSPRICE;
            else
                totalPrice -= NOMEALSPRICE;
        } else if (mealsBox.equals(source))
        {
            if (select == ItemEvent.SELECTED)
                totalPrice += MEALSPRICE;
            else
                totalPrice -= MEALSPRICE;
        }
        output = "$" + totalPrice;
        totPrice.setText(output);
    }
}
