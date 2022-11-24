import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Calculator implements ActionListener {
    JFrame frame;

    JTextField textField;

    JButton[] numberButtons;
    JButton[] functionButtons;
    JButton addButton;
    JButton subButton;
    JButton mulButton;
    JButton divButton;
    JButton equButton;
    JButton delButton;
    JButton clrButton;
    JButton negButton;
    JButton decButton;

    JPanel panel;

    Font myFont = new Font("TimesRoman",Font.BOLD,30);

    double num1 = 0;
    double num2 = 0;
    double result = 0;
    char operator;

    public Calculator() {
//        super();

        frame = new JFrame("My Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension frameDimension = new Dimension(415,530);
//        Dimension frameDimensionMax = new Dimension(615,630);
        frame.setSize(frameDimension);
//        frame.setMaximumSize(frameDimensionMax);
//        frame.setMinimumSize(frameDimension);
        frame.setResizable(false);
        frame.setLayout(null); // посмотреть зачем нужен Layout

        textField = new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setFont(myFont);
        textField.setEditable(false);

        numberButtons = new JButton[10];
        for (int i = 0;i < numberButtons.length; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(myFont);
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFocusable(false);
        }

        functionButtons = new JButton[9];
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("\u00D7");
        divButton = new JButton("\u00F7");
        equButton = new JButton("=");
        delButton = new JButton("\u232B");
        clrButton = new JButton("Clear");
        negButton = new JButton("\u00B1");
        decButton = new JButton(".");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = equButton;
        functionButtons[5] = delButton;
        functionButtons[6] = clrButton;
        functionButtons[7] = negButton;
        functionButtons[8] = decButton;

        for (int i = 0;i < functionButtons.length; i++){
            functionButtons[i].setFont(myFont);
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFocusable(false);
        }

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
//        panel.setBackground(Color.GRAY);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        negButton.setBounds(50,410,65,50);
        delButton.setBounds(125,410,80,50);
        clrButton.setBounds(215,410,135,50);


        panel.setVisible(true);

        frame.add(textField);
        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.setVisible(true);


    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<10;i++) {
            if (e.getSource() == numberButtons[i]) {
//               textField.setText(textField.getText().concat(String.valueOf(i))); // text = text + "i"
                textField.setText(textField.getText() + i);
            }
        }
//        if(e.getSource() == numberButtons[0]){
//            textField.setText(textField.getText() + 0);
//        }
//        if(e.getSource() == numberButtons[1]){
//            textField.setText(textField.getText() + 1);
//        }

        if(e.getSource() == negButton){
//            double myDec = Double.parseDouble(textField.getText());
//            myDec = myDec * (-1.0);
//            textField.setText(String.valueOf(myDec));
            if(textField.getText().length() != 0 && textField.getText().charAt(0) == '-'){
                textField.setText(textField.getText().substring(1));
            }
            else {
                textField.setText("-" + textField.getText());
            }
        }

        if(e.getSource() == decButton && textField.getText().length() != 0 && !textField.getText().contains(".")){
                textField.setText(textField.getText() + ".");
        }

        if(e.getSource() == addButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }

        if(e.getSource() == subButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }

        if(e.getSource() == mulButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }

        if(e.getSource() == divButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }

        if(e.getSource() == clrButton){
            textField.setText("");
        }

        if (e.getSource() == delButton && textField.getText().length() != 0){
            textField.setText(textField.getText().substring(0,textField.getText().length()-1));
        }

        if(e.getSource() == equButton){
            num2 = Double.parseDouble(textField.getText());
            switch (operator){
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;

        }












        }
    }

