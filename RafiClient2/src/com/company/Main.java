package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Scanner;

public class Main {
    public static final int PORT = 3003;
    private static String content;

    public static void main(String[] args) {


        Socket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        int choice=0;
        boolean go=true;

        try {





                socket = new Socket("127.0.0.1", PORT);



                inputStream = socket.getInputStream();
                outputStream = socket.getOutputStream();

            while (go) {

                choice = printMenu();
                if (choice == 3) {
                    System.out.println("bye bye");
                    return;
                }
                //System.out.println(choice);
                outputStream.write(choice);


                //קריאת הודעה ומספר בחירה מהסרבר
                readMessgae(inputStream);
                choice = inputStream.read();
                /*System.out.println("server returned " + choice);*/

                switch (choice) {
                    case 1:
                        Name name = new Name("", "");
                        name = readNameHiphop();
                        //System.out.println(name);
                        name.write(outputStream);
                        break;
                    case 2:
                        Name name1 = new Name("", "");
                        name1 = readNameBlues();
                        //System.out.println(name1);
                        name1.write(outputStream);
                        break;


                }

                readMessgae(inputStream);


                choice = printMenu2();
                if (choice == 5) {
                    System.out.println("bye bye");
                    return;
                }
                //System.out.println("you chose " + choice);
                if (choice == 1) {
                    outputStream.write(choice);


                } else {
                    outputStream.write(choice);
                }

                readMessgae(inputStream);
                System.out.println();
                System.out.println("play again or quit");
                System.out.println();



            }





            /*sendInt(outputStream,7);
            readInt(inputStream);

            readMessgae(inputStream);
            sendMessage(outputStream,"hello2");

            Name name2= new Name(inputStream);

            Name name3= new Name(inputStream);

            sendMessage(outputStream,"hello2");

            Name name4= new Name("fff","sss");
            name4.write(outputStream);

            outputStream.write(7);*/

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null)
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (inputStream != null)
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (outputStream != null)
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }




    }

    public static void sendInt(OutputStream outputStream,int num) throws IOException {

        byte[] buffer = new byte[4];
        ByteBuffer.wrap(buffer).putInt(num);
        outputStream.write(buffer);


    }

    public static void readInt(InputStream inputStream) throws IOException {
        byte[] intBytes = new byte[4];
        int actuallyRead = inputStream.read(intBytes);
        if(actuallyRead != 4)
            throw new IOException("expected four bytes but received " + actuallyRead + " bytes..  :-(");
        int number = ByteBuffer.wrap(intBytes).getInt();
        System.out.println("you recevied the num"+number);
    }

    public static void sendMessage(OutputStream outputStream,String message) throws IOException {
        byte[] contentBytes = message.getBytes();
        outputStream.write(contentBytes.length);
        outputStream.write(contentBytes);
    }

    public static void readMessgae(InputStream inputStream) throws IOException{


        int actuallyRead;
        int stringLength = inputStream.read();
        if(stringLength == -1)
            throw new IOException("no message");
        byte[] contentBytes = new byte[stringLength];
        actuallyRead = inputStream.read(contentBytes);
        if(actuallyRead != stringLength)
            throw new IOException("didn't get expected bytes number");
        content=new String(contentBytes);
        System.out.println(content);

    }

    public static int printMenu() {
        System.out.println("hello and welcome to NameGenerator");
        System.out.println("choose 1 for HipHopNameGenerator");
        System.out.println("choose 2 for BluesNameGenerator");
        System.out.println("choose 3 to quit Program");

        int choice = readIntegerFromConsole();

        if (choice < 1 || choice > 3) {
            System.out.println("invalid number, try again");
            return readIntegerFromConsole();

        }

        return choice;

    }

    private static int readIntegerFromConsole() {
        /*System.out.print(instruction);*/
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        int x = -1;

        try {

            x = Integer.valueOf(input);


        } catch (Exception ex) {
            System.out.println("this is not an integer!");
            return readIntegerFromConsole();
        }
        return x;
    }

    public static Name readNameHiphop() {
        System.out.println("HipHop Name Generator");
        Name name = new Name("", "");
        Scanner s = new Scanner(System.in);
        System.out.println("enter first name");
        String firstname = s.nextLine();
        name.setFirstName(firstname);

        System.out.println("enter last name");
        String lastname = s.nextLine();
        name.setLastName(lastname);


        //System.out.println("you typed "+name.toString());
        return name;


    }

    public static Name readNameBlues() {
        System.out.println("Blues Name Generator");
        Name name = new Name("", "");
        Scanner s = new Scanner(System.in);
        System.out.println("enter first name");
        String firstname = s.nextLine();
        name.setFirstName(firstname);

        System.out.println("enter last name");
        String lastname = s.nextLine();
        name.setLastName(lastname);


        //System.out.println("you typed "+name.toString());
        return name;


    }

    public static int printMenu2() {
        System.out.println();
        System.out.println("Now what you wanna do?");
        System.out.println("choose 1 to play again");
        System.out.println("choose 2 to check how many others got the same name so far this Client session");
        System.out.println("choose 3 to get a list of all the names user got this client session (and how many times)");
        System.out.println("choose 4 to get just the list of all names user got this session");
        System.out.println("choose 5 to quit Program");


        int choice = readIntegerFromConsole();

        if (choice < 1 || choice > 5) {
            System.out.println("invalid number, try again");
            return readIntegerFromConsole();

        }

        return choice;

    }






}


