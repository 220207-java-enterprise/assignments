
import com.revature.challenges.array_list.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.namespace.QName;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {


    ArrayList arraylist = new ArrayList<>();

    @Test
    public void arrayListEmptycheck(){

        assertEquals(true, arraylist.isEmpty());

        assertEquals(0,arraylist.size(), "The size is Zero");
    }
    @Test
    public void addelement(){

        arraylist.add("one");
        arraylist.add("two");
        arraylist.add("three");

        assertEquals("one", arraylist.get(0));
        assertEquals("two", arraylist.get(1));
        assertEquals("three", arraylist.get(2));

    }

    @Test
    public void checkArrayListSize(){

        //assertEquals(3, arraylist.size());
        System.out.println(arraylist.size());
    }

    @Test
    public void ArrayListAddNullValue(){
        arraylist.add(0, null);
    }

    @Test
    public void nullElementTest(){
        assertTrue(arraylist.contains(null));
    }

}