package com.revature.challenges.array_list;

public class ArrayListTest {
    public static  ArrayList<Object> ArrayListTest = new ArrayList<>();

    public static void main(String[] args){
        checkArrayListIsEmptyMethod();
        checkArrayListAddedMethod();
        checkArrayListContainsMethod(10);
        checkArrayListContainsMethod(5);
        checkArrayListContainsMethod(null);
        checkArrayListIsEmptyMethod();
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

        Integer objectInt = 10;
        ArrayListTest.add(objectInt);
        System.out.println(ArrayListTest.currentSize);
        ArrayListTest.add(objectInt);
        System.out.println(ArrayListTest.currentSize);
        ArrayListTest.add(objectInt);
        System.out.println(ArrayListTest.currentSize);
        ArrayListTest.add(objectInt);
        System.out.println(ArrayListTest.currentSize);
        ArrayListTest.add(objectInt);
        System.out.println(ArrayListTest.currentSize);
        ArrayListTest.add(objectInt);
        System.out.println(ArrayListTest.currentSize);
        ArrayListTest.add(objectInt);
        System.out.println(ArrayListTest.currentSize);
        ArrayListTest.add(objectInt);
        System.out.println(ArrayListTest.currentSize);
        ArrayListTest.add(objectInt);
        System.out.println(ArrayListTest.currentSize);
        ArrayListTest.add(objectInt);
        System.out.println(ArrayListTest.currentSize);
        ArrayListTest.add(objectInt);
        System.out.println(ArrayListTest.currentSize);
    }
}
