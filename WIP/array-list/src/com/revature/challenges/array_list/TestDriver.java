package com.revature.challenges.array_list;

public class TestDriver {

    public static void main(String[] args)
    {
        ArrayList <Object> myarraylist = new ArrayList<>();
        myarraylist.add("A, B, C");
        //System.out.println(" my size of array is : " +myarraylist.size());
        System.out.println(myarraylist.add("D"));
        System.out.println(myarraylist.add("D"));
        System.out.println(myarraylist.add("Hello"));
        System.out.println(myarraylist.add(2147483647));
        System.out.println("Contains: " + myarraylist.contains("Hello"));
        System.out.println("IsEmpty: " + myarraylist.isEmpty());
        System.out.println("remove: "+ myarraylist.remove("Hello"));
        System.out.println("size: " + myarraylist.size());
        System.out.println("get: " + myarraylist.get(1));
        myarraylist.add(1,327);
        System.out.println("set: " + myarraylist.set(1 ,"NotWanted"));
        System.out.println("remove2 at index: " + myarraylist.remove(1));
        System.out.println("indexof \"D\": " + myarraylist.indexOf("D"));
        System.out.println("last indexof \"D\": " + myarraylist.lastIndexOf("D"));

        System.out.println(myarraylist);
    }
}
