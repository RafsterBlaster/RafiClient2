package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Scanner;

public class Name implements Writable{
    private String firstName;
    private String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Name(InputStream inputStream) throws IOException {
        read(inputStream);
    }

    @Override
    public void write(OutputStream outputStream) throws IOException {
        byte[] contentBytes = firstName.getBytes();
        outputStream.write(contentBytes.length);
        outputStream.write(contentBytes);

        byte[] contentBytes1 = lastName.getBytes();
        outputStream.write(contentBytes1.length);
        outputStream.write(contentBytes1);
        /*outputStream.write(firstName.length());



        outputStream.write(firstName.getBytes());

        outputStream.write(lastName.getBytes());*/


    }

    @Override
    public void read(InputStream inputStream) throws IOException {
        int actuallyRead;
        int stringLength = inputStream.read();
        if(stringLength == -1)
            throw new IOException("no message");
        byte[] contentBytes = new byte[stringLength];
        actuallyRead = inputStream.read(contentBytes);
        if(actuallyRead != stringLength)
            throw new IOException("not the expected number of bytes");
        firstName=new String(contentBytes);
        System.out.println(firstName);

        int actuallyRead1;
        int stringLength1 = inputStream.read();
        if(stringLength1 == -1)
            throw new IOException("no message");
        byte[] contentBytes1 = new byte[stringLength1];
        actuallyRead1 = inputStream.read(contentBytes1);
        if(actuallyRead1 != stringLength1)
            throw new IOException("not the expected number of bytes");
        lastName=new String(contentBytes1);
        System.out.println(lastName);

        /*byte[] buffer = new byte[2];
        int actuallyRead;
        StringBuilder stringBuilder = new StringBuilder();
        int firstNameLength= inputStream.read();
        while ((actuallyRead = inputStream.read(buffer)) != -1) {
            stringBuilder.append(new String(buffer, 0, actuallyRead));
        }
        String s= stringBuilder.toString();
        firstName=s.substring(0,firstNameLength);

        lastName=s.substring(firstNameLength);*/

    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Name{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
