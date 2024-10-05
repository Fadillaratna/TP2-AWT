package tp2gui;

import java.awt.*;
import java.awt.event.*;

public class BMICalcAWTFadilla extends Frame implements ActionListener, ComponentListener {

    private Label heightLabel, weightLabel, resultLabel, titleLabel;
    private TextField heightField, weightField;
    private Button calculateButton, resetButton;

    public BMICalcAWTFadilla() {
        setTitle("BMI Calculator");
        setSize(500, 350);  
        setLayout(null);  
        titleLabel = new Label("BMI Calculator");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBounds(150, 30, 200, 30); 
        add(titleLabel);

        heightLabel = new Label("Height (m):");
        heightLabel.setBounds(50, 80, 100, 30);
        add(heightLabel);

        heightField = new TextField();
        heightField.setBounds(150, 80, 200, 30); 
        add(heightField);

        weightLabel = new Label("Weight (kg):");
        weightLabel.setBounds(50, 130, 100, 30); 
        add(weightLabel);

        weightField = new TextField();
        weightField.setBounds(150, 130, 200, 30); 
        add(weightField);

        calculateButton = new Button("Calculate BMI");
        calculateButton.setBounds(50, 180, 140, 40); 
        calculateButton.setBackground(Color.decode("#847cec"));
        calculateButton.setForeground(Color.WHITE);
        add(calculateButton);

        resetButton = new Button("Reset");
        resetButton.setBounds(210, 180, 140, 40); 
        resetButton.setBackground(Color.decode("#847cec"));
        resetButton.setForeground(Color.WHITE);
        add(resetButton);

        resultLabel = new Label("Your BMI will be shown here.");
        resultLabel.setBounds(50, 240, 300, 30); 
        add(resultLabel);

        calculateButton.addActionListener(this);
        resetButton.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        addComponentListener(this);
    }

    @Override
    public void componentResized(ComponentEvent e) {
        int currentWidth = getWidth();
        int currentHeight = getHeight();
        setSize(currentWidth, currentHeight);

        titleLabel.setBounds((currentWidth - 200) / 2, 30, 200, 30);
        heightField.setBounds((currentWidth - 200) / 2, 80, 200, 30);
        weightField.setBounds((currentWidth - 200) / 2, 130, 200, 30);
        calculateButton.setBounds((currentWidth - 300) / 2, 180, 140, 40);
        resetButton.setBounds((currentWidth + 20) / 2, 180, 140, 40);
        resultLabel.setBounds((currentWidth - 300) / 2, 240, 300, 30);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            try {
                double heightInCm = Double.parseDouble(heightField.getText());
                double weight = Double.parseDouble(weightField.getText());

                double height = heightInCm / 100;

                double bmi = weight / (height * height);

                String category;
                if (bmi < 18.5) {
                    category = "Underweight";
                } else if (bmi >= 18.5 && bmi < 24.9) {
                    category = "Normal weight";
                } else if (bmi >= 25 && bmi < 29.9) {
                    category = "Overweight";
                } else {
                    category = "Obesity";
                }

                resultLabel.setText(String.format("Your BMI: %.2f (%s)", bmi, category));

            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers!");
            }
        } else if (e.getSource() == resetButton) {
            heightField.setText("");
            weightField.setText("");
            resultLabel.setText("Your BMI will be shown here.");
        }
    }

    @Override
    public void componentMoved(ComponentEvent e) {
    }

    @Override
    public void componentShown(ComponentEvent e) {
    }

    @Override
    public void componentHidden(ComponentEvent e) {
    }

    public static void main(String[] args) {
        BMICalcAWTFadilla app = new BMICalcAWTFadilla();
        app.setVisible(true);
    }
}
