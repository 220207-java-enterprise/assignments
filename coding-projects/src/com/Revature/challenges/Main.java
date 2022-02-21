package com.Revature.challenges;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle("rect1",7, 7);
        Rectangle rect2 = new Rectangle("rect2", 4, 7);
        Rectangle rect3 = new Rectangle("rect3", 3, 9);
        Rectangle rect4 = new Rectangle("rect4",2, 3);
        Rectangle rect5 = new Rectangle("rect5",4, 3);
        Rectangle rect6 = new Rectangle("rect6",5, 5);
        Rectangle rect7 = new Rectangle("rect7",6, 6);
        Rectangle rect8 = new Rectangle("rect8", 8, 1);
        Rectangle rect9 = new Rectangle("rect9", 1, 9);
        Rectangle rect10 = new Rectangle("rect10",2, 12);
        ArrayList<Rectangle> mylist = new ArrayList<Rectangle>();
        mylist.add(rect1);
        mylist.add(rect2);
        mylist.add(rect3);
        mylist.add(rect4);
        mylist.add(rect5);
        mylist.add(rect6);
        mylist.add(rect7);
        mylist.add(rect8);
        mylist.add(rect9);
        mylist.add(rect10);
        System.out.println(mylist);
        area action1 = new area();
        System.out.println(action1.isLessThan(rect1, rect2));
        System.out.println(action1.isLessThan(rect2, rect1));

        perimeter action2 = new perimeter();
        System.out.println(action2.isLessThan(rect1, rect2));
        System.out.println(action2.isLessThan(rect2, rect1));

        findMax(mylist);


    }

    public static void findMax(ArrayList<Rectangle> thelist){
        area action1 = new area();
        perimeter action2 = new perimeter();
        for(int i = 0; i < thelist.size(); i ++){
            int counter = 0;
            for(int j = 0; j < thelist.size(); j++){
                if (!action1.isLessThan(thelist.get(i), thelist.get(j)))
                    counter++;
                action2.isLessThan(thelist.get(i), thelist.get(j));
            }
            if (counter == 10) {
                System.out.println("Max area is : " +thelist.get(i).area());
                return;
            }
        }
        for(int i = 0; i < thelist.size(); i ++){
            int counter = 0;
            for(int j = 0; j < thelist.size(); j++){
                if (!action2.isLessThan(thelist.get(i), thelist.get(j)))
                    counter++;
            }
            if (counter == 10) {
                System.out.println("Max perimeter is: " + thelist.get(i).perimeter());
                return;
            }
        }
    }
}
