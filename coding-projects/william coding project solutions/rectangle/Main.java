import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void findMax(){

        //create list of randomly generated Rectangle objects
        Rectangle [] rectangles = new Rectangle[10];
        Random numGen = new Random();
        for (int i = 0; i < 10; i++) {
            Rectangle a = new Rectangle(String.valueOf(i), numGen.nextInt(100), numGen.nextInt(10));
            System.out.println("Rectangle " + (i+1) + " -" +
                    " name: "  + a.name + " area: " + a.getArea() + " perimeter: " + a.getPerimeter());
            rectangles[i] = a;
        }
        //System.out.println("ran findMax()");

        //find the rectangle with the greatest area
        AreaComparator findArea = new AreaComparator();
        int indexOfGreatest = 0;
        for (int i=1; i < 9; i++) {
            if(findArea.isLessThan(rectangles[indexOfGreatest], rectangles[i])) {
                indexOfGreatest = i;
            }
        }

        System.out.println("The Rectangle with the greatest Area is - " + "Name: " + rectangles[indexOfGreatest].name
                + " Area: " + rectangles[indexOfGreatest].getArea()
                + " Perimeter: " + rectangles[indexOfGreatest].getPerimeter());


        //find the rectangle with the greatest perimeter
        PerimeterComparator findPeri = new PerimeterComparator();
        indexOfGreatest = 0;
        for (int i=1; i < 9; i++) {
            if(findPeri.isLessThan(rectangles[indexOfGreatest], rectangles[i])) {
                indexOfGreatest = i;
            }
        }

        System.out.println("The Rectangle with the greatest Perimeter is - " + "Name: " + rectangles[indexOfGreatest].name
                + " Area: " + rectangles[indexOfGreatest].getArea()
                + " Perimeter: " + rectangles[indexOfGreatest].getPerimeter());

    }

    public static void main(String[] args) {
        findMax();
    }
}
