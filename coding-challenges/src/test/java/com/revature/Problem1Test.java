package com.revature;

import org.junit.Assert;
import org.junit.Test;

public class Problem1Test {
    @Test
    public void problem1Test() {
        int[] arr = {1, 2, 3, 4, 5};
        Problem1 p1 = new Problem1();

        Assert.assertEquals(15, p1.sumOfArray(arr));
    }

    @Test
    public void test1() {
        int[] arr = {1, 1, 2, 2, 3};
        Problem1 p1 = new Problem1();

        Assert.assertEquals(9, p1.sumOfArray(arr));
    }

    @Test
    public void test2() {
        int[] arr = {0, 0, 0, 0};
        Problem1 p1 = new Problem1();

        Assert.assertEquals(0, p1.sumOfArray(arr));
    }

    @Test
    public void test3() {
        int[] arr = {1};
        Problem1 p1 = new Problem1();

        Assert.assertEquals(1, p1.sumOfArray(arr));
    }

    @Test
    public void test4() {
        int[] arr = {-1, -2, -3};
        Problem1 p1 = new Problem1();

        Assert.assertEquals(-6, p1.sumOfArray(arr));
    }
}