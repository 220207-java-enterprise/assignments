package com.revature.challenges.array_list;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> soccerPlayers = new ArrayList<>();
        soccerPlayers.add("ronaldinho");
        soccerPlayers.add("aubameyang");
        soccerPlayers.add("messi");
        soccerPlayers.add("cristiano");
        soccerPlayers.add("beckham");
        soccerPlayers.add("saka");
        
        System.out.println();
        soccerPlayers.contains("federer");
        soccerPlayers.isEmpty();
        soccerPlayers.size();

        soccerPlayers.set(3, "ronaldinho");

        soccerPlayers.get(1);

        soccerPlayers.lastIndexOf("ronaldinho");

        soccerPlayers.lastIndexOf("tendulkar");

        soccerPlayers.indexOf("saka");

        System.out.println("\n"+soccerPlayers.toString());

    }
}
