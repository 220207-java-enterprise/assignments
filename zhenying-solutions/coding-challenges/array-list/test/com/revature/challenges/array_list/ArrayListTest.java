package com.revature.challenges.array_list;

import java.util.Arrays;

public class ArrayListTest {
    public static  ArrayList<Object> ArrayListTest = new ArrayList<>();

    public static void main(String[] args){
        checkArrayListIsEmptyMethod();
        checkArrayListAddedMethod();
        checkArrayListContainsMethod(3);
        checkArrayListContainsMethod(56);
        checkArrayListContainsMethod(null);
        checkArrayListIsEmptyMethod();
        System.out.println("There are " + ArrayListTest.currentSize + " items in the container");
        display();

        checkArrayListRemove(3);
        System.out.println("Now, there are " + ArrayListTest.currentSize + " items in the container");
        checkArrayListContainsMethod(3);
        display();

        checkArrayListRemove(null);
        System.out.println("Now, there are " + ArrayListTest.currentSize + " items in the container");
        checkArrayListContainsMethod(null);
        display();

        checkArrayListRemove(7);
        System.out.println("Now, there are " + ArrayListTest.currentSize + " items in the container");
        checkArrayListContainsMethod(7);
        display();

        System.out.println("CurrentSize: "+ArrayListTest.size());
        int position = 8;
        Object e = ArrayListTest.get(8);
        System.out.println("In position " +position +": "+ e +"\n");

        checkArrayListAddwithIndex();
        checkArrayListSetMethod();
        checkArrayListRemoveIndexMethod();
        checkArrayListIndexOfMethod();
        checkArrayListLastIndexOfMethod();
    }
    public static  void  display (){
        System.out.println(Arrays.toString(ArrayListTest.elementContainer) + '\n');
    }

    public static  void checkArrayListLastIndexOfMethod(){
        System.out.println("A is in the Last position: "+ ArrayListTest.lastIndexOf('A'));
        display();
        System.out.println("5 is in the Last position: "+ ArrayListTest.lastIndexOf(5));
        display();
        System.out.println("B is in the Last position: "+ ArrayListTest.lastIndexOf('B'));
        display();
    }

    public static  void checkArrayListIndexOfMethod(){
        System.out.println("A is in the First position: "+ ArrayListTest.indexOf('A'));
        display();
        System.out.println("5 is in the First position: "+ ArrayListTest.indexOf(5));
        display();
        System.out.println("B is in the First position: "+ ArrayListTest.indexOf('B'));
        display();
    }

    public  static  void checkArrayListRemoveIndexMethod(){
        System.out.println("remove index0-" +ArrayListTest.remove(0));
        display();

        System.out.println("remove index5-" +ArrayListTest.remove(5));
        display();
    }

    public  static  void checkArrayListSetMethod(){
        System.out.println("set 77 to index0-" +ArrayListTest.set(0,77));
        display();

        System.out.println("set 35 to index4-" +ArrayListTest.set(4,35));
        display();

        System.out.println("set 'A' to index10-" +ArrayListTest.set(10,'A'));
        display();
    }
    public static void checkArrayListAddwithIndex(){
        System.out.println("Add 5 to index 2: ");
        ArrayListTest.add(2,5);
        display();

        System.out.println("Add 99 to index 0: ");
        ArrayListTest.add(0,99);
        display();

        System.out.println("Add 88 to index 11: ");
        ArrayListTest.add(11,88);
        display();
    }

    public static void checkArrayListRemove(Object Any){
        if(ArrayListTest.remove(Any)){
            System.out.println(Any + " has been removed");
        }else
            System.out.println(Any + " doesn't exist");
    }
    public  static  void  checkArrayListIsEmptyMethod(){
        if (ArrayListTest.isEmpty())
            System.out.println("The Container is Empty");
        else
            System.out.println("There is something in the Container");
    }
    public static  void checkArrayListContainsMethod(Object Any){
        if (ArrayListTest.contains(Any)){
            System.out.println("Yes, " + Any + " is in here");
        }else {
            System.out.println(Any + " doesn't exist  in this container");
        }
    }

    public static  void checkArrayListAddedMethod (){
        System.out.println(ArrayListTest.currentSize);

        ArrayListTest.add(null);
        System.out.println("added null " + ArrayListTest.currentSize);


        ArrayListTest.add(1);
        System.out.println(ArrayListTest.currentSize);
        ArrayListTest.add(2);
        System.out.println(ArrayListTest.currentSize);
        ArrayListTest.add(3);
        System.out.println(ArrayListTest.currentSize);
        ArrayListTest.add(4);
        System.out.println(ArrayListTest.currentSize);
        ArrayListTest.add(5);
        System.out.println(ArrayListTest.currentSize);
        ArrayListTest.add(6);
        System.out.println(ArrayListTest.currentSize);
        ArrayListTest.add(7);
        System.out.println(ArrayListTest.currentSize);
        ArrayListTest.add(8);
        System.out.println(ArrayListTest.currentSize);
        ArrayListTest.add(9);
        System.out.println(ArrayListTest.currentSize);
        ArrayListTest.add(10);
        System.out.println(ArrayListTest.currentSize);
        ArrayListTest.add(11);
        System.out.println(ArrayListTest.currentSize);
    }
}
