package com.Revature.challenges;

public class area {
    public boolean isLessThan(Rectangle obj1, Rectangle obj2) {
        boolean flag = false;
        if (obj1.area() < obj2.area())
            flag = true;
        return flag;
        }
}
