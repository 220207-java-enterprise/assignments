package com.Revature.challenges;

public class Rectangle {
    private String name;
    private int length;
    private int width;

    public Rectangle(String name, int length, int width) {
        this.name = name;
        this.length = length;
        this.width = width;
    }

    public int length() {
        return length;
    }

    public int width() {
        return width;
    }

    public int area(){
        return (width*length);
    }
    public int perimeter(){
        return (width*2) + (2*length);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "name='" + name + '\'' +
                ", length=" + length +
                ", width=" + width +
                "}\n";
    }
}

//
//    public boolean isLessThan(){
//        return true;
//    }
//}
