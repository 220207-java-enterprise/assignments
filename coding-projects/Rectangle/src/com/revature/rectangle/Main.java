package com.revature.rectangle;
import java.util.*;

public class Main {
    public static void main(String[] args) {
     String [] array = {"A","B","C","D","E","F","G","H","I","J"};
     Scanner myObj = new Scanner(System.in);
     int count = 0;
     Rectangle [] objects = new Rectangle[10];
     while(count <10){
         System.out.println("Enter Length of Rectangle: "+(array[count]));
         int a = myObj.nextInt();
         System.out.println("Enter Width of Rectangle: "+(array[count]));
         int b = myObj.nextInt();
         objects[count] = new Rectangle(array[count],a,b);
         count++;
     }
     System.out.println(maxArea(objects) + " has the largest area");
     System.out.println(maxPerimeter(objects) + " has the largest perimeter");   
    }
    public static String maxArea(Rectangle[] a){
         int max_area = a[0].getArea();
         int count = 0;
         for (int i=0; i<a.length; i++){
            if (a[i].getArea() > max_area){
                max_area = a[i].getArea();
                count = i;
            }
        }
        return a[count].name;
    }
    public static String maxPerimeter(Rectangle[] a){
         int max_perimeter = a[0].getPerimeter();
         int count = 0;
         for (int i=0; i<a.length; i++){
            if (a[i].getPerimeter() > max_perimeter){
                max_perimeter = a[i].getPerimeter();
                count = i;
            }
        }
        return a[count].name;
    }
}