package com.company;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


public class PhoneChatAvg {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //Set up HashMap and ArrayList for conversion in order to sort
        HashMap<String, String> hmap = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();

        System.out.print("Enter the number of phone numbers below:\n>> ");
        int numOfPhoneNum = in.nextInt();
        System.out.println();

        for (int i = 0; i < numOfPhoneNum; i++) {

            //Get user input for phone number and ensure it is 10-digits
            System.out.print("Enter phone number:\n>> ");
            String a = in.next();
            while (a.length() != 10) {
                System.out.println("You need to enter a 10-digit phone number!");
                a = in.next();
                System.out.println();
            }

            //Get user input for the amount of minutes
            System.out.print("Enter the amount of minutes for this " +
                    "phone number:\n>> ");
            String b = in.next();

            //Put values into HashMap, and continue until the for-loop is done
            hmap.put(a, b);
            System.out.println();
        }


        //Convert HashMap values into ArrayList for sorting
        for (Map.Entry<String, String> entry : hmap.entrySet()) {
            list.add(entry.getValue());
        }

        //Sort the ArrayList in ascending order
        list.sort(String::compareTo);

        //Print the list
        System.out.println("Phone Numbers           Minutes");
        for (String str : list) {
            for (Entry<String, String> entry : hmap.entrySet()) {
                if (entry.getValue().equals(str)) {
                    System.out.println(entry.getKey() + "              " + entry.getValue() );
                    System.out.println();
                }
            }
        }


        //Convert HashMap values into integers in order to get average
        //Initialize the convert variable and the take-average variable
        int convertMinutes = 0;
        int avgMinutes;

        for (Entry<String, String> entry : hmap.entrySet()) {
            convertMinutes += Integer.parseInt(entry.getValue());
        }

        avgMinutes = convertMinutes / numOfPhoneNum;
        System.out.print("The average time for calls is: ");
        System.out.println(avgMinutes + " Minutes");

    }
}//END-OF-FILE