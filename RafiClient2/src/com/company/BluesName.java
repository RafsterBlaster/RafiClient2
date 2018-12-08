package com.company;

import java.io.IOException;
import java.io.InputStream;

public class BluesName extends Name{
    public BluesName(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public BluesName(InputStream inputStream) throws IOException {
        super(inputStream);
    }

    String[] BluesName1 = {"Lil", "Big", "Killa", "Shoog", "BangBang", "Stoner", "Diz", "Nuke", "Money", "CrackMaster"};
    String[] BluesName2 = {"Bastard", "Dog", "Daddy", "Fresh", "Sleezer", "Boss", "Sniff", "Diesel", "God", "Crib"};
}
