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
        frame = new JFrame("My Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(415,530);
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
            numberButtons[i].setFocusable(false);
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
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        }
    }

