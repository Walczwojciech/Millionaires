package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Millionaries {

    String[] questionAndAnswers;
    JFrame frameMillionaries;
    JTextArea question;

    JButton buttonAnswerA;
    JButton buttonAnswerB;
    JButton buttonAnswerC;
    JButton buttonAnswerD;
    JButton start;

    JPanel mainPanel;
    JPanel bottomPanel;
    JPanel eastPanel;
    static int questionNumber = 0;

    public static void main(String[] args) {
        QuestionList.questionInitializer();
        Millionaries game = new Millionaries();
        game.makeQuestion();
        game.createGui();
        questionNumber++;

    }
        void makeQuestion() {
        questionAndAnswers = QuestionList.question.get(questionNumber).split("/");
        }

        void createGui() {
            frameMillionaries = new JFrame("Millionaries");
            frameMillionaries.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            mainPanel = new JPanel();
            bottomPanel = new JPanel();
            eastPanel = new JPanel();

            frameMillionaries.getContentPane().add(BorderLayout.EAST, eastPanel);
            frameMillionaries.getContentPane().add(BorderLayout.CENTER, mainPanel);
            frameMillionaries.getContentPane().add(BorderLayout.SOUTH, bottomPanel);

            question = new JTextArea(10, 20);
            Font bigFont = new Font("sanserif", Font.BOLD, 24);
            question.setFont(bigFont);
            question.setLineWrap(true);
            question.setEditable(false);
            question.setEnabled(true);
            question.setVisible(false);
            question.setText(questionAndAnswers[0]);

            JScrollPane scrollPane = new JScrollPane(question);
            scrollPane.setVisible(true);
            scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);



            JMenuBar menuBar = new JMenuBar();
            mainPanel.add(scrollPane);
            frameMillionaries.setJMenuBar(menuBar);
            frameMillionaries.getContentPane().add(BorderLayout.CENTER, mainPanel);
            frameMillionaries.getContentPane().add(BorderLayout.SOUTH, bottomPanel);
            frameMillionaries.setSize(800, 600);
            frameMillionaries.setVisible(true);

            start = new JButton("Start");
            buttonAnswerA = new JButton("A." + questionAndAnswers[1]);
            buttonAnswerB = new JButton("B." + questionAndAnswers[2]);
            buttonAnswerC = new JButton("C." + questionAndAnswers[3]);
            buttonAnswerD = new JButton("D." + questionAndAnswers[4]);

            bottomPanel.add(buttonAnswerA);
            bottomPanel.add(buttonAnswerB);
            bottomPanel.add(buttonAnswerC);
            bottomPanel.add(buttonAnswerD);
            eastPanel.add(start);

            buttonAnswerA.addActionListener(new ButtonListiener());
            buttonAnswerB.addActionListener(new ButtonListiener());
            buttonAnswerC.addActionListener(new ButtonListiener());
            buttonAnswerD.addActionListener(new ButtonListiener());
            start.addActionListener(new ButtonListiener());

            buttonAnswerA.setVisible(false);
            buttonAnswerB.setVisible(false);
            buttonAnswerC.setVisible(false);
            buttonAnswerD.setVisible(false);
        }
        void buttonsEnabled()     {
        buttonAnswerA.setEnabled(false);
        buttonAnswerB.setEnabled(false);
        buttonAnswerC.setEnabled(false);
        buttonAnswerD.setEnabled(false);
        }
        void updateGui(){
            question.setText(questionAndAnswers[0]);
            buttonAnswerA.setText("A." + questionAndAnswers[1]);
            buttonAnswerB.setText("B." + questionAndAnswers[2]);
            buttonAnswerC.setText("C." + questionAndAnswers[3]);
            buttonAnswerD.setText("D." + questionAndAnswers[4]);
        }
        void wrongAnswer()   {
        System.out.println("Game over");
            buttonsEnabled();
            question.setText("Game over");
        }
        void correctAnswer(){

            questionNumber++;
            makeQuestion();
            updateGui();
        }
        void setStart(){
            buttonAnswerA.setVisible(true);
            buttonAnswerB.setVisible(true);
            buttonAnswerC.setVisible(true);
            buttonAnswerD.setVisible(true);
            start.setVisible(false);
            question.setVisible(true);
        }
        void viewQuestionValue{

    }
class ButtonListiener implements ActionListener{
    public void actionPerformed(ActionEvent click){
        Object source = click.getSource();
        if(source.equals(start)) setStart();
        else{
        if(source.equals(buttonAnswerA)&&questionAndAnswers[5].equals("A"))      correctAnswer();
        else if(source.equals(buttonAnswerB)&&questionAndAnswers[5].equals("B")) correctAnswer();
        else if(source.equals(buttonAnswerC)&&questionAndAnswers[5].equals("C")) correctAnswer();
        else if(source.equals(buttonAnswerD)&&questionAndAnswers[5].equals("D")) correctAnswer();
        else {
            wrongAnswer();
        }
            }
    }
}
}





