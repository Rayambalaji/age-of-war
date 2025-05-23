package com.org.war;

import com.org.war.model.Platoon;
import com.org.war.processor.InputProcessor;
import com.org.war.service.War;

import java.util.*;


public class Main {
    public static void main(String[] args) {

        InputProcessor inputProcessor= new InputProcessor();
        System.out.println("Welcome to Age of war!");

        Scanner sc = new Scanner(System.in);
        String choice ="N";
        while(!choice.equalsIgnoreCase("Y")) {
            System.out.println("Enter the List of platoons from own and opponent side");

            try{
                String yourPlatoons = sc.next();

                String opponentPlatoons = sc.next();

                List<Platoon> ownArmy = inputProcessor.processInput(yourPlatoons);

                List<Platoon> opponentArmy = inputProcessor.processInput(opponentPlatoons);

                War war= new War();
                war.beginBattle(ownArmy ,opponentArmy);
                System.out.println("Wish to Stop war Y/N?");

                choice = sc.next();
                sc.nextLine();

            } catch(Exception e){
                System.out.println("Exception occured , enter correct inputs" + e);
                System.out.println("Wish to Stop war Y/N?");

                choice = sc.next();
                sc.nextLine();
            }


//            Spearmen#10;Militia#30;FootArcher#20;LightCavalry#1000;HeavyCavalry#120
//            Militia#10;Spearmen#10;FootArcher#1000;LightCavalry#120;CavalryArcher#100
        }
    }
}