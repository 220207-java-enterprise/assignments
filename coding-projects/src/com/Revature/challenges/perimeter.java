package com.Revature.challenges;

public class perimeter {
    public boolean isLessThan(Rectangle obj1, Rectangle obj2) {
        boolean flag = false;
        if (obj1.perimeter() < obj2.perimeter())
            flag = true;

        return flag;
    }
}
