import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator implements ActionListener {
    private JFrame frame;
    private JTextField textField;
    private JButton[] buttons;
    private JPanel buttonPanel;
    private String currentInput;
    private double memory;
    private char lastOperator;
    private boolean newInput;

    public Calculator() {
        frame = new JFrame(" Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setBackground(Color.BLUE);

        textField = new JTextField();
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setFont(new Font("Arial", Font.PLAIN, 24));
        textField.setEditable(false);
        frame.add(textField, BorderLayout.NORTH);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        buttons = new JButton[16];
        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        for (int i = 0; i < 16; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttons[i].addActionListener(this);
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 24));
            buttonPanel.add(buttons[i]);
        }

        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);

        currentInput = "";
        memory = 0;
        lastOperator = ' ';
        newInput = true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (newInput) {
            currentInput = "";
            newInput = false;
        }

        if (command.matches("[0-9]")) {
            currentInput += command;
            textField.setText(currentInput);
        } else if (command.equals(".")) {
            if (!currentInput.contains(".")) {
                currentInput += ".";
                textField.setText(currentInput);
            }
        } else if (command.equals("C")) {
            currentInput = "";
            memory = 0;
            lastOperator = ' ';
            textField.setText("");
            newInput = true;
        } else if (command.matches("[+\\-*/]")) {
            if (!currentInput.isEmpty()) {
                double currentValue = Double.parseDouble(currentInput);
                applyOperator(currentValue);
                lastOperator = command.charAt(0);
                textField.setText(Double.toString(memory));
                newInput = true;
            }
        } else if (command.equals("=")) {
            if (!currentInput.isEmpty()) {
                double currentValue = Double.parseDouble(currentInput);
                applyOperator(currentValue);
                lastOperator = ' ';
                textField.setText(Double.toString(memory));
                newInput = true;
            }
        }
    }

    private void applyOperator(double currentValue) {
        switch (lastOperator) {
            case ' ':
                memory = currentValue;
                break;
            case '+':
                memory += currentValue;
                break;
            case '-':
                memory -= currentValue;
                break;
            case '*':
                memory *= currentValue;
                break;
            case '/':
                if (currentValue != 0) {
                    memory /= currentValue;
                } else {
                    textField.setText("Error");
                    newInput = true;
                    return;
                }
                break;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Calculator());
    }
}
