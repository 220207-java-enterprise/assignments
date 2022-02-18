public class Rectangle {

    private int _length;
    private int _width;
    private String name;

//Constructor with three args

    Rectangle(String name, int length, int width) {
        //his.name = name;
        this._length = length;
        this._width = width;
        this.name = name;
    }

    // get area and get perimeter functions

    public int Area() {
        return _length * _width;
    }

    public int Perimeter() {
        return 2 * (_length + _width);
    }


    //get area and get perimeter functions



    ;
    //getter and setters for the name,length and width

    public String getName() {
        return name;
    }

    public int get_length() {
        return _length;
    }

    public void set_length(int _length) {
        this._length = _length;
    }

    public void set_width(int _width) {
        this._width = _width;
    }

    public int get_width() {
        return _width;
    }


}
