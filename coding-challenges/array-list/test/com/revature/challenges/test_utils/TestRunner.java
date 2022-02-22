package com.revature.challenges.test_utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

public class TestRunner {
    public static void main(String[] args) {
        System.out.println("Running Tests...");
        int passed=0, failed=0, error=0;

        try{
            // get test suite class
            Class<?> testSuiteClass = Class.forName("com.revature.challenges.array_list.ArrayListTest");

            if (!testSuiteClass.isAnnotationPresent(Describe.class)){
                throw new RuntimeException("Test Suite " +
                        "class must have one @Describe");
            }

            //store methods inside testSuiteClass
            List<Method> testMethods = new LinkedList<>();

            Method beforeEachMethod = null;

            //iterate over all methods in testSuiteClass
            for(Method classMethod: testSuiteClass.getDeclaredMethods()){
                System.out.println("Inspecting method: " +
                        classMethod.toString());

                // scan for @Test methods
                if (classMethod.isAnnotationPresent(Test.class)){
                    //add @Test method to testMethods List
                    testMethods.add(classMethod);
                }

                // scan for @BeforeEach method inside
                // testMethods list
                if (classMethod.isAnnotationPresent(BeforeEach.class)){
                    if (beforeEachMethod != null){
                        System.out.println("TestRunner " +
                                "expected only one " +
                                "@BeforeEach class. Test " +
                                "failed.");
                    }
                    beforeEachMethod = classMethod;
                }

                // instantiate testSuiteClass
                Object testSuiteInstance =
                        testSuiteClass.newInstance();

                for (Method testMethod: testMethods) {
                    try {
                        if (beforeEachMethod != null) {
                            beforeEachMethod.invoke(testSuiteInstance);
                        }
                        testMethod.invoke(testSuiteInstance);
                        passed++;
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                        failed++;
                    } catch (Throwable t) {
                        error++;
                    }
                }
            }

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.printf("Passed: %d, Failed: %d, Error:" +
                " %d", passed, failed, error);
    }
}
