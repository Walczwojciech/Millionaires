package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Millionaries implements ActionListener {
private JTextArea question;
private JButton buttonAnswerA;
private JButton buttonAnswerB;
private JButton buttonAnswerC;
private JButton buttonAnswerD;
private JFrame frameMillionaries;
private String[] questionAndAnswers;
private static int questionNumber = 0;
private static boolean nextQuerstion = false;
private static boolean correctAnswer = true;


    public static void main(String[] args) {
    Millionaries game = new Millionaries();
        QuestionList.questionInitializer();
        game.makeQuestion();
        game.guiBuilder();

            while(correctAnswer!=false&&questionNumber<QuestionList.question.size()) {
                if (nextQuerstion = true){
                    game.makeQuestion();
                    game.updateGui();
                }
            }
     }
public void guiBuilder() {
    frameMillionaries = new JFrame("Millionaries");
    frameMillionaries.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel mainPanel = new JPanel();
    JPanel bottomPanel = new JPanel();
    Font bigFont = new Font("sanserif",Font.BOLD,24);

    question = new JTextArea(10,20);
    question.setFont(bigFont);
    question.setLineWrap(true);
    question.setEditable(false);
    question.setEnabled(true);
    question.setText(questionAndAnswers[0]);

    JScrollPane scrollPane = new JScrollPane(question);
    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

    buttonAnswerA = new JButton("A."+ questionAndAnswers[1]);
    buttonAnswerB = new JButton("B."+ questionAndAnswers[2]);
    buttonAnswerC = new JButton("C."+ questionAndAnswers[3]);
    buttonAnswerD = new JButton("D."+ questionAndAnswers[4]);

    bottomPanel.add(buttonAnswerA);
    bottomPanel.add(buttonAnswerB);
    bottomPanel.add(buttonAnswerC);
    bottomPanel.add(buttonAnswerD);

    buttonAnswerA.addActionListener(this);
    buttonAnswerB.addActionListener(this);
    buttonAnswerC.addActionListener(this);
    buttonAnswerD.addActionListener(this);



        JMenuBar menuBar = new JMenuBar();
    mainPanel.add(scrollPane);
    frameMillionaries.setJMenuBar(menuBar);
    frameMillionaries.getContentPane().add(BorderLayout.CENTER,mainPanel);
    frameMillionaries.getContentPane().add(BorderLayout.SOUTH,bottomPanel);
    frameMillionaries.setSize(800,600);
    frameMillionaries.setVisible(true);
}
private void updateGui(){
    buttonAnswerA.setText("A."+ questionAndAnswers[1]);
    buttonAnswerB.setText("B."+ questionAndAnswers[2]);
    buttonAnswerC.setText("C."+ questionAndAnswers[3]);
    buttonAnswerD.setText("D."+ questionAndAnswers[4]);
    question.setText(questionAndAnswers[0]);

}


private void makeQuestion(){
         questionAndAnswers = QuestionList.question.get(questionNumber).split("/");

}

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

            if (source==(buttonAnswerA)&&(questionAndAnswers[1].equals(questionAndAnswers[5]))){
                System.out.println("Correct answer");
                questionNumber++;
                nextQuerstion=true;

            }
            else if (source==(buttonAnswerB)&&(questionAndAnswers[2].equals(questionAndAnswers[5]))) {
                System.out.println("Correct answer");
                questionNumber++;
                nextQuerstion=true;
            }
            else if (source==(buttonAnswerC)&&(questionAndAnswers[3].equals(questionAndAnswers[5]))){
                System.out.println("Correct answer");
                questionNumber++;
                nextQuerstion=true;
            }
            else if (source==(buttonAnswerD)&&(questionAndAnswers[4].equals(questionAndAnswers[5]))){
                System.out.println("Correct answer");
                questionNumber++;
                nextQuerstion=true;
            }
            else {
                System.out.println("Wrong Answer, GAME OVER");
                correctAnswer = false;

            }

        }

    }




