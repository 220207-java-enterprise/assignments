package com.revature.rectangle;

public class Rectangle{
    int length;
    int width;
    String name;
    public Rectangle(String name, int length, int width){
        this.length = length;
        this.width = width;
        this.name = name;
    }
    public int getArea(){
        return length*width;
    }
    public int getPerimeter(){
        return 2*(length+width);
    }
}