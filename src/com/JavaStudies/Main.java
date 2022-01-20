package com.JavaStudies;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        MatchedList list = new MatchedList();
        list.match();
        list.printMatch();
    }
}

class MatchedList {
    public HashMap<String, String> matched;

    public MatchedList() {
        this.matched = new HashMap<>();
    }

    public HashMap match() {
        ArrayList<String> list = new ArrayList();
        addParticipant(list);
        int count = list.size();

        Random generator = new Random();
        for (int i = 0; i < count; i++) {
            String giver = list.get(i);
            int randVal = generator.nextInt(i, count);
            String receiver = list.get(randVal);
            while (giver == receiver || matched.containsKey(giver) || matched.containsValue(receiver)){
                randVal = generator.nextInt(count);
                receiver = list.get(randVal);
            }
            this.matched.put(giver, receiver);
        }
        return this.matched;
    }

    public void addParticipant(ArrayList list){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Would you like to add a participant? (y/n)");
        String response = scanner.nextLine();
        if (response.toLowerCase().equals("n")) return;
        while (response.toLowerCase().equals("y")) {
            System.out.print("Please type in the new participant's name: ");
            response = scanner.nextLine();
            list.add(response);
            System.out.print("Would you like to add another participant? (y/n)");
            response = scanner.nextLine();
        }
    }

    public void printMatch(){
        System.out.println("_________________");
        for(Map.Entry<String, String> entry : matched.entrySet()){
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
        System.out.println("_________________");
    }
}
