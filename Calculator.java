import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{

    JFrame frame;
    JTextField text;
    JButton[] number_Buttons = new JButton[10];
    JButton[] operation_Buttons = new JButton[9];
    JButton addition_Button, subtraction_Button, multiplication_Button, division_Button, decimal_Button, equal_Button, delete_Button, clear_Button, negative_Button;
    JPanel panel;

    Font myFont = new Font("Ink Free",Font.BOLD,30);

    double x=0, y=0, result=0;
    char operator;

    Calculator(){

        frame = new JFrame("Aleks' Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        text = new JTextField();
        text.setBounds(50, 25, 300, 50);
        text.setFont(myFont);
        text.setEditable(false);

        addition_Button = new JButton("+");
        subtraction_Button = new JButton("-");
        multiplication_Button = new JButton("*");
        division_Button = new JButton("/");
        decimal_Button = new JButton(".");
        equal_Button = new JButton("=");
        delete_Button = new JButton("Del");
        clear_Button = new JButton("Clr");
        negative_Button = new JButton("(-)");

        operation_Buttons[0] = addition_Button;
        operation_Buttons[1] = subtraction_Button;
        operation_Buttons[2] = multiplication_Button;
        operation_Buttons[3] = division_Button;
        operation_Buttons[4] = decimal_Button;
        operation_Buttons[5] = equal_Button;
        operation_Buttons[6] = delete_Button;
        operation_Buttons[7] = clear_Button;
        operation_Buttons[8] = negative_Button;

        for(int i = 0; i < 9; i++) {
            operation_Buttons[i].addActionListener(this);
            operation_Buttons[i].setFont(myFont);
            operation_Buttons[i].setFocusable(false);
        }

        for(int i = 0; i < 10; i++) {
            number_Buttons[i] = new JButton(String.valueOf(i));
            number_Buttons[i].addActionListener(this);
            number_Buttons[i].setFont(myFont);
            number_Buttons[i].setFocusable(false);
        }

        negative_Button.setBounds(50,430,100,50);
        delete_Button.setBounds(150,430,100,50);
        clear_Button.setBounds(250,430,100,50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4,4,10,10));

        panel.add(number_Buttons[1]);
        panel.add(number_Buttons[2]);
        panel.add(number_Buttons[3]);
        panel.add(addition_Button);
        panel.add(number_Buttons[4]);
        panel.add(number_Buttons[5]);
        panel.add(number_Buttons[6]);
        panel.add(subtraction_Button);
        panel.add(number_Buttons[7]);
        panel.add(number_Buttons[8]);
        panel.add(number_Buttons[9]);
        panel.add(multiplication_Button);
        panel.add(decimal_Button);
        panel.add(number_Buttons[0]);
        panel.add(equal_Button);
        panel.add(division_Button);

        frame.add(panel);
        frame.add(negative_Button);
        frame.add(delete_Button);
        frame.add(clear_Button);
        frame.add(text);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i = 0; i < 10; i++) {
            if(e.getSource() == number_Buttons[i]) {
                text.setText(text.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == decimal_Button) {
            text.setText(text.getText().concat("."));
        }
        if(e.getSource() == addition_Button) {
            x = Double.parseDouble(text.getText());
            operator ='+';
            text.setText("");
        }
        if(e.getSource() == subtraction_Button) {
            x = Double.parseDouble(text.getText());
            operator ='-';
            text.setText("");
        }
        if(e.getSource() == multiplication_Button) {
            x = Double.parseDouble(text.getText());
            operator ='*';
            text.setText("");
        }
        if(e.getSource() == division_Button) {
            x = Double.parseDouble(text.getText());
            operator ='/';
            text.setText("");
        }
        if(e.getSource() == equal_Button) {
            y = Double.parseDouble(text.getText());

            switch(operator) {
                case'+':
                    result = x+y;
                    break;
                case'-':
                    result = x-y;
                    break;
                case'*':
                    result = x*y;
                    break;
                case'/':
                    result = x/y;
                    break;
            }
            text.setText(String.valueOf(result));
            x = result;
        }
        if(e.getSource() == clear_Button) {
            text.setText("");
        }
        if(e.getSource() == delete_Button) {
            String string = text.getText();
            text.setText("");
            for(int i=0;i<string.length()-1;i++) {
                text.setText(text.getText()+string.charAt(i));
            }
        }
        if(e.getSource() == negative_Button) {
            double temp = Double.parseDouble(text.getText());
            temp*=-1;
            text.setText(String.valueOf(temp));
        }
    }
}
