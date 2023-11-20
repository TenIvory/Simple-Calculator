import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Main implements ActionListener {

    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10]; //Button with an array to hold all our numbers
    JButton[] functionButtons = new JButton[9]; //Button with an array to hold all the maths operation buttons
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, eqButton, delButton, clrButton, negButton;

    JPanel panel;

    Font myFont = new Font("Ink Free", Font.BOLD, 30);

    double num1 =0, num2=0, result=0;
    char operator;

    Main(){ //Constructor
        frame = new JFrame("Calculator");

        ImageIcon calcIcon = new ImageIcon(ClassLoader.getSystemResource("icons/img.png"));
        Image icon = calcIcon.getImage();
        frame.setIconImage(icon);

        JMenuBar menubar = new JMenuBar(); //Creates a Menubar class called menubar
        menubar.setBackground(Color.white); //Sets the background color of the menubar to white
        frame.setJMenuBar(menubar); //adds menubar to the screen

        JMenu helpmenu = new JMenu("Help");
       helpmenu.setFont(new Font("AERIAL",Font.BOLD, 14));
        menubar.add(helpmenu);

        JMenuItem about = new JMenuItem("About");
        about.addActionListener(this);
        helpmenu.add(about);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myFont);
        textfield.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        eqButton = new JButton("=");
        delButton = new JButton("DEL");
        clrButton = new JButton("CLR");
        negButton = new JButton("(-)");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = eqButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] =negButton;

        for(int i=0; i<9;i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
            functionButtons[i].setFont(myFont);
        }

        for(int i=0;i<10;i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFocusable(false);
            numberButtons[i].setFont(myFont);
            numberButtons[i].addActionListener(this);

        }

        negButton.setBounds(50,430,100, 50);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

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
        panel.add(delButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(eqButton);
        panel.add(divButton);





        frame.add(panel);
        frame.add(textfield);
        frame.add(negButton);
        frame.add(clrButton);
        frame.add(delButton);
        frame.add(menubar);
        frame.setVisible(true);


    }
    public static void main(String[] args) {
        Main main = new Main();
        }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("About")){
            new About().setVisible(true);
        }


        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == decButton) {
            textfield.setText((textfield.getText().concat(".")));
        }

        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }

        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }

        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }

        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }

        if (e.getSource() == eqButton) {
            num2 = Double.parseDouble(textfield.getText());

            switch (operator) {
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

            textfield.setText(String.valueOf(result));
            num1 = result;
        }

        if (e.getSource() == clrButton) {
            textfield.setText(" ");
        }

        if (e.getSource() == delButton) {
            String string = textfield.getText();
            textfield.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textfield.setText(textfield.getText() + string.charAt(i));
            }
        }

        if (e.getSource() == negButton) {
            double temp = Double.parseDouble(textfield.getText());
            temp *= -1;
            textfield.setText(String.valueOf(temp));
        }



    }
    }

