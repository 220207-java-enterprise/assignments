package com.revature.challenges.array_list;


// test suite that encapsulates one or more test cases
// (methods)

import com.revature.challenges.test_utils.BeforeEach;
import com.revature.challenges.test_utils.Describe;
import com.revature.challenges.test_utils.Test;

@Describe
public class ArrayListTest {

    private ArrayList sut; // System Under Test

    @BeforeEach
    public void setup(){
        System.out.println("Inside @BeforeEach--> " +
                "instantiating sut class object");
        sut = new ArrayList();
    }

    // Arrange, Act, Assert on each test method
    @Test
    public void test_didElementAddToArray(
            Object[] elementContainer,
            Object element){
        //Arrange
        boolean expected = false;
        element = 1;

        //Act
        boolean result = sut.add(element);

        //Assert
        if (result != expected){
            throw new RuntimeException("Test failed! Add " +
                    "returns false!");
        }
    }


}
