import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame myBox = getFrame();
        JPanel myStartPanel = getStartingPanel();
        JPanel myCalculatorPanel = getCalculatorPanel();
        // Resolution
        Dimension myDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int width = myDimension.width;
        int height = myDimension.height;

        // Button
        JButton startButton = new JButton("Start Calculate");
        startButton.setBounds(width / 5 - 10, height / 5 - 10, 150, 25);


        myBox.add(myStartPanel);
        myStartPanel.add(startButton);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myStartPanel.setVisible(false);
                myBox.add(myCalculatorPanel);
                myCalculatorPanel.setVisible(true);
            }
        });

        myBox.setVisible(true);
    }

    static JFrame getFrame() {
        int width, height;
        JFrame myBox = new JFrame();
        Dimension myDimension = Toolkit.getDefaultToolkit().getScreenSize();
        width = myDimension.width;
        height = myDimension.height;
        Image myImage = Toolkit.getDefaultToolkit().getImage("source/logo.jpg");
        myBox.setIconImage(myImage);
        myBox.setSize(width / 2, height - 320);
        myBox.setLocation(width / 4, height / 6);
        myBox.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        myBox.setTitle("Calculator");
        myBox.setResizable(false);

        return myBox;
    }

    static JPanel getStartingPanel() {
        char rightsSymbol = 0x00A9;
        Dimension myDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int width, height;
        width = myDimension.width;
        height = myDimension.height;

        Border bottomBorder = BorderFactory.createEtchedBorder();

        // Create panel
        JPanel myPanel = new JPanel();
        myPanel.setLayout(null);
        myPanel.setBackground(Color.GRAY);

        // Labels
        JLabel welcomeLabel = new JLabel("This programm is created by Daniel");
        welcomeLabel.setBounds(width / 2 - 250, height / 2 - 80, 350, 20);
        JLabel rightsLabel = new JLabel(" Copyright " + rightsSymbol + " All right reserved.");
        rightsLabel.setBounds(width / 2 - 225, height / 2 - 63, 180, 20);

        // Panel adding
        myPanel.add(welcomeLabel);
        myPanel.add(rightsLabel);
        rightsLabel.setBorder(bottomBorder);
        myPanel.setVisible(true);

        return myPanel;
    }

    static JPanel getCalculatorPanel() {
        final int[] operationCode = new int[1];
        final double[] x = new double[1];
        final double[] y = new double[1];
        operationCode[0] = 0;
        // Font
        Font resultFont = new Font("Verdana", Font.BOLD, 50);

        // Resolution
        Dimension myDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int width = myDimension.width;
        int height = myDimension.height;
        int frameWidth = width / 2;
        int frameHeight = height / 2;

        // Create panel
        JPanel myPanel = new JPanel();
        myPanel.setLayout(null);
        myPanel.setBackground(Color.GRAY);

        // Text Area
        JTextArea note = new JTextArea();
        note.setLineWrap(true);

        // ScrollBar
        JScrollPane noteScroll = new JScrollPane(note);
        noteScroll.setBounds(445,215,frameWidth - 475,180);
        myPanel.add(noteScroll);

        // Text Field
        JTextField resultField = new JTextField();
        resultField.setBounds(25, 25, frameWidth - 65, 75);
        resultField.setFont(resultFont);
        resultField.setHorizontalAlignment(SwingConstants.RIGHT);
        myPanel.add(resultField);

        // Text Labels
        JLabel noteLabel = new JLabel("Notepad");
        noteLabel.setBounds(445,180,50,50);
        myPanel.add(noteLabel);

        // Buttons
        JButton clearButton = new JButton("C");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultField.setText("");
            }
        });
        JButton oneButton = new JButton("1");
        oneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultField.setText(resultField.getText() + "1");
            }
        });

        JButton twoButton = new JButton("2");
        twoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultField.setText(resultField.getText() + "2");
            }
        });

        JButton treeButton = new JButton("3");
        treeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultField.setText(resultField.getText() + "3");
            }
        });

        JButton fourButton = new JButton("4");
        fourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultField.setText(resultField.getText() + "4");
            }
        });

        JButton fiveButton = new JButton("5");
        fiveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultField.setText(resultField.getText() + "5");
            }
        });

        JButton sixButton = new JButton("6");
        sixButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultField.setText(resultField.getText() + "6");
            }
        });

        JButton sevenButton = new JButton("7");
        sevenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultField.setText(resultField.getText() + "7");
            }
        });

        JButton eightButton = new JButton("8");
        eightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultField.setText(resultField.getText() + "8");
            }
        });

        JButton nineButton = new JButton("9");
        nineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultField.setText(resultField.getText() + "9");
            }
        });

        JButton zeroButton = new JButton("0");
        zeroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultField.setText(resultField.getText() + "0");
            }
        });
        JButton plusButton = new JButton("+");
        plusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (resultField.getDocument().getLength() > 0) {
                    operationCode[0] = 1;
                    x[0] = Double.valueOf(resultField.getText());
                    resultField.setText("");
                }
            }
        });
        JButton equalButton = new JButton("=");
        equalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (operationCode[0]) {
                    case 0: {
                        return;
                    }
                    case 1: {
                        y[0] = Double.valueOf(resultField.getText());
                        resultField.setText("" + (x[0] + y[0]));
                        break;
                    }
                    case 2: {
                        y[0] = Double.valueOf(resultField.getText());
                        resultField.setText("" + (x[0] - y[0]));
                        break;
                    }
                    case 3: {
                        y[0] = Double.valueOf(resultField.getText());
                        resultField.setText("" + (x[0] * y[0]));
                        break;
                    }
                    case 4: {
                        y[0] = Double.valueOf(resultField.getText());
                        resultField.setText("" + (x[0] / y[0]));
                        break;
                    }
                    case 5:{
                        y[0]=Double.valueOf(resultField.getText());
                        resultField.setText(""+(x[0]*(y[0]/100)));
                    }
                }
            }
        });
        JButton minusButton = new JButton("-");
        minusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (resultField.getDocument().getLength() > 0) {
                    operationCode[0] = 2;
                    x[0] = Double.valueOf(resultField.getText());
                    resultField.setText("");
                }
            }
        });
        JButton pointButton = new JButton(".");
        pointButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultField.setText(resultField.getText() + ".");
            }
        });
        JButton multiplyButton = new JButton("*");
        multiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operationCode[0] = 3;
                x[0] = Double.valueOf(resultField.getText());
                resultField.setText("");
            }
        });
        JButton divideButton = new JButton("/");
        divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operationCode[0] = 4;
                x[0] = Double.valueOf(resultField.getText());
                resultField.setText("");
            }
        });
        JButton percentageButton = new JButton("%");
        percentageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operationCode[0]=5;
                x[0]=Double.valueOf(resultField.getText());
                resultField.setText("");
            }
        });


        // Adding to panel
        myPanel.add(clearButton);
        myPanel.add(oneButton);
        myPanel.add(twoButton);
        myPanel.add(treeButton);
        myPanel.add(fourButton);
        myPanel.add(fiveButton);
        myPanel.add(sixButton);
        myPanel.add(sevenButton);
        myPanel.add(eightButton);
        myPanel.add(nineButton);
        myPanel.add(zeroButton);
        myPanel.add(plusButton);
        myPanel.add(equalButton);
        myPanel.add(minusButton);
        myPanel.add(pointButton);
        myPanel.add(divideButton);
        myPanel.add(multiplyButton);
        myPanel.add(percentageButton);

        // Coordinates
        clearButton.setBounds(500, 125, 50, 50);
        oneButton.setBounds(25, 125, 50, 50);
        twoButton.setBounds(100, 125, 50, 50);
        treeButton.setBounds(175, 125, 50, 50);
        fourButton.setBounds(25, 200, 50, 50);
        fiveButton.setBounds(100, 200, 50, 50);
        sixButton.setBounds(175, 200, 50, 50);
        sevenButton.setBounds(25, 275, 50, 50);
        eightButton.setBounds(100, 275, 50, 50);
        nineButton.setBounds(175, 275, 50, 50);
        zeroButton.setBounds(100, 350, 50, 50);
        plusButton.setBounds(270, 125, 50, 50);
        equalButton.setBounds(285, 350, 100, 50);
        minusButton.setBounds(270, 200, 50, 50);
        pointButton.setBounds(175, 350, 50, 50);
        multiplyButton.setBounds(345, 125, 50, 50);
        divideButton.setBounds(345, 200, 50, 50);
        percentageButton.setBounds(300,275,75,50);

        return myPanel;
    }

}