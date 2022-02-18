import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {


    static ArrayList<Rectangle> rectangleList = new ArrayList<Rectangle>();

    public static void main(String[] args) {
        int width;
        int length;
        String name;
        Scanner in = new Scanner(System.in);
        Scanner textScanner = new Scanner(System.in);
        System.out.println("So it begins.......");
        System.out.println("Welcome to the Rectangle Factory");
        while (rectangleList.size() < 10) {
            System.out.print("Name your rectangle ");
            name = textScanner.next();
            System.out.print("Please enter your desired length ");
            length = in.nextInt();
            System.out.print("Please enter your desired width ");
            width = in.nextInt();
            Rectangle newRectangle = new Rectangle(name, length, width);
            rectangleList.add(newRectangle);
        }


        System.out.println("****THE RECTANGLES ARE LISTED BELOW*****");

        System.out.println(rectangleList);

        //display a list of all the rectangles (one rectangle per line)

        for (int i = 0; i < rectangleList.size(); i++)
            System.out.println(rectangleList.get(i).getName());

        //Instantiate an object of comparator class for comparing rects by area
        // ComparatorbyArea ebe = new ComparatorbyArea();

        Collections.sort(rectangleList, new ComparatorbyArea());
        System.out.println(rectangleList);
        System.out.println("*********");

        //Largest rect by Area
        System.out.println(rectangleList.get(rectangleList.size()-1).getName() +" is the rectangle with largest Area.");
        //System.out.println(rectangleList.get(rectangleList.size()-1).getName());

        //Instantiate an object of comparator class for comparing rects by Perimeter
        // ComparatorbyPerimeter tom = new ComparatorbyPerimeter();
        Collections.sort(rectangleList,new ComparatorbyPerimeter());
        System.out.println(rectangleList);

        //Find the largest rectangle by Perimeter and display the result
        System.out.println(rectangleList.get(rectangleList.size()-1).getName() + " is the rectangle with largest perimeter.");
        //System.out.println(rectangleList.get(rectangleList.size()-1).getName());
       /*
       System.out.println("The maximum area rectangle in the list is " + findMaxName(rectangleList) + " and has an area of "
               + findMaxArea(rectangleList) + " cm^2");
       System.out.println("The maximum perimeter rectangle in the list has " + findMaxPerimeter(rectangleList) + " cm");
       */

    }

















/*
   public static int findMaxArea(ArrayList<Rectangle> param) {
       int max = param.get(0).Area();
       for (int i = 1; i < param.size(); i++) {
           if (param.get(i).Area() > max) {
               max = param.get(i).Area();
           }
       }
       return max;
   }

   public static String findMaxName(ArrayList<Rectangle> param) {
       int maxArea = findMaxArea(param);
       String maxName = "";
       for (int i = 1; i < param.size(); i++)
           if (param.get(i).Area() == maxArea) {
               maxName = param.get(i).getName();
               return maxName;
           }
       return maxName;
   }

   ;


   public static int findMaxPerimeter(ArrayList<Rectangle> param) {
       int max = param.get(0).Perimeter();
       for (int i = 1; i < param.size(); i++) {
           if (param.get(i).Perimeter() > max) {
               max = param.get(i).Perimeter();
           }
       }
       return max;
   }

*/

}
