/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.example.clientserver;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

/**
 *
 * @author Hamza
 *
 */
public class Server {


    public static ServerSocket ss;
    static String correct=" ";
    static String incorrect="";
    static String lettre_correcte="";
    static String question_Send = " ";
    static String question_total_Send =" ";
    static boolean question_rahi_dakhla=false;
    static boolean sa9ssit_lClient=false;
    static boolean maditScor=false;
    static User client =new User();
    static int NmbrQuestion=10;




    public static void main(String[] args) {

        System.out.println("server is running");
        try {
            ss = new ServerSocket(1842);
            while (true) {
                new Handler(ss.accept()).start();
            }
        }
        catch (IOException ex) {
            System.out.println(ex);

        }


    }
    private static class Handler extends Thread {
        private String name;
        private Socket socket;
        private ObjectInputStream in;
        private ObjectOutputStream out;
        private String[] messagerRecu;


        public Handler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                in = new ObjectInputStream(socket.getInputStream());
                out = new ObjectOutputStream(socket.getOutputStream());
                while (true) {
                    String s = (String) in.readObject();
                    messagerRecu = s.split("/");
                    switch (messagerRecu[0]) {
                        case "name":
                            out.writeObject("name/accepted");
                          client.addUser(String.valueOf(messagerRecu[1]), 0, String.valueOf(socket.getInetAddress().getHostAddress()));
                            new Thread(new QuestionThread(socket,out)).start();
                            break;
                        case "/quit":
                            client.setUserName(".");
                            break;
                        case "test":
                            System.out.println("ok!!");
                            break;
                        case "reponse":
                            if (messagerRecu[1].toLowerCase().equals(lettre_correcte)) {
                                if (question_rahi_dakhla== false) {

                                    System.out.println("CORRECT : " + correct);

                                    client.addScore(String.valueOf(socket.getInetAddress().getHostAddress()));
                                    client.printUserScor();


                                }
                                question_rahi_dakhla= true;



                            }
                            maditScor=false;
                            sa9ssit_lClient=false;
                            break;
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
            //QUESTION THREAD
            //Create  question djidida
            static class QuestionThread extends Thread {
                Timer timer = new Timer();
                private Socket socket;
                private ObjectOutputStream out;
                public QuestionThread(Socket socket,ObjectOutputStream out) {
                    this.socket=socket;
                    this.out=out;
                }
                @Override
                public void run() {
                    System.out.println("Start:");

                        TimerTask myTask = new TimerTask() {
                            @Override
                            public void run() {
                                if(maditScor==false)
                                {
                                    try {
                                        out.writeObject("score/"+client.score);
                                        maditScor=true;
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }

                                }

                                if(sa9ssit_lClient==false){
                                    if(NmbrQuestion<10){

                                        Question theQuestion = new Question();
                                        theQuestion.newQuestion(NmbrQuestion);
                                        NmbrQuestion++;
                                        Random ran = new Random();
                                        int randomNumber = ran.nextInt(2);
                                        if (randomNumber == 0) {
                                            try {
                                                lettre_correcte="a";
                                                out.writeObject("question/"+question_Send+"/"+correct+"/"+incorrect);
                                                sa9ssit_lClient=true;
                                                question_rahi_dakhla = false;
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                        } else {
                                            try {
                                                lettre_correcte="b";
                                                out.writeObject("question/"+question_Send+"/"+incorrect+"/"+correct);
                                                sa9ssit_lClient=true;
                                                question_rahi_dakhla = false;
                                                //return;
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    }

                                }
                            }
                        };
                        timer.schedule(myTask, 0, 150);

                }

            }

            //QUESTION CLASS
            //Random question
            private static class Question extends Server {

                private void question(int Nmb) {
                    Nmb++;
                    switch (Nmb) {
                        case 1:
                            question_Send = "une @IPv6 tient sur:";
                            correct = "128 bits";
                            incorrect = "32 bits";
                            break;
                        case 2:
                            question_Send = "un numéro de port sert a : ";
                            correct = "Identifier une application";
                            incorrect = "Identifier une machine";
                            break;
                        case 3:
                            question_Send = "L'API Socket est au niveau :";
                            correct = "Transport";
                            incorrect = "Application";
                            break;
                        case 4:
                            question_Send = "TCP fonctionne en mode";
                            correct = "connecté";
                            incorrect = "non connecté ";
                            break;
                        case 5:
                            question_Send = "UDP";
                            correct = "NON Fiable";
                            incorrect = " Fiable";
                            break;
                        case 6:
                            question_Send = "10.0.0.1 est une @IPv4";
                            correct = "privée";
                            incorrect = "public";
                            break;
                        case 7:
                            question_Send = "197.0.0.1 est une @ IPv4:";
                            correct = "Classe C";
                            incorrect = "Classe D";
                            break;
                        case 8:
                            question_Send = "ServerSocket est la classe Java qui implémente:";
                            correct = "Les Sockets d'écoute";
                            incorrect = "Les Sockets de transfert";
                            break;
                        case 9:
                            question_Send = "la classe Date est définie dans :";
                            correct = "Java.util";
                            incorrect = "Java.io";
                            break;
                        case 10:
                            question_Send = "La classe InetAddress correspond a : ";
                            correct = "Adresse IP ";
                            incorrect = "Adresse URL";
                            break;
                    }
                }


                public void newQuestion(int NembrQ) {
                    question(NembrQ);
                    System.out.println("question : " + question_Send);

                }
            }

            //USER CLASS
            public static class User extends Server {
                String userName = "";
                int score = 0;
                String hostName = "";

                //Getters and setters
                public String getUserName() {
                    return userName;
                }

                public int getScore() {
                    return score;
                }

                public String getHostName() {
                    return hostName;
                }

                public void setHostName(String x) {
                    hostName = x;
                }

                public void setUserName(String x) {
                    userName = x;
                }

                public void setScore(int x) {
                    score = x;
                }

                //Adds a new user
                public void addUser(String x, int y, String z) {

                    client.setUserName(x);
                    client.setScore(y);
                    client.setHostName(z);
                    NmbrQuestion=0;
                    printUserScor();
                }

                //Prints out userslist to users
                public void printUserScor() {

                    String userscor =client.getUserName() + " " + String.valueOf(client.getScore()) + ";";
                    System.out.println( userscor);

                }

                //Adds a point to the user printing the correct answer
                public void addScore(String x) {
                    String userScore = x;
                    int theScore = client.getScore();
                    theScore++;
                    client.setScore(theScore);
                    checkWinner();
                }
                public void checkWinner() {
                        if (client.getScore() == 10) {
                            System.out.println("There is a winner!");
                            System.out.println("MESSAGE :" + client.getUserName() + " has won the match!...");
                        }
                }
            }

}
