package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class HipHopName extends Name {

    String[] HipName1 = {"Lil", "Big", "Killa", "Shoog", "BangBang", "Stoner", "Diz", "Nuke", "Money", "CrackMaster"};
    String[] HipName2 = {"Bastard", "Dog", "Daddy", "Fresh", "Sleezer", "Boss", "Sniff", "Diesel", "God", "Crib"};

    public HipHopName(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public HipHopName(InputStream inputStream) throws IOException {
        super(inputStream);
    }


}
