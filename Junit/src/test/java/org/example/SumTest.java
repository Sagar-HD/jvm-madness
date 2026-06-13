package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class SumTest {
    Sum sum=new Sum();
    @AfterAll
    static void initialBeforeAll(){
        System.out.println("before all test starts");
    }
    @BeforeEach
    void init(){
        System.out.println("before every test");
    }
    @Test
    void sumTest(){

        assertEquals(2,sum.sum(1,1),"sum calculation is wrong");
        assertEquals(5,sum.sum(1,4),"sum calculation is wrong");





    }
    @Test
    void testSum2(){
        //message using suplier efficent way bcs onlt getprocessed on wrong assertion
        assertEquals(6,sum.sum(2,4),()->"sum calculation is wrong");
    }
    @Test
    void testSum3(){
        //assert not equlas just not value of assert
        assertNotEquals(7,sum.sum(2,4),()->"sum calculation is wrong");
    }
    @Test
    void testTrueAndFalse(){
        String str="sagar";
        assertTrue("sagar".equals(str),()->"this is not sagar");
        assertFalse("sagaru".equals(str));
    }
    @Test
    void testArray(){
        int[] arr={1,2,3,4};
        int[] arr2={1,2,3};
        assertArrayEquals(arr,arr2);
        //checks no of elements,array elemnts equality and order
    }

    //assert throws
    @Test
    void checkException(){
        Sum sum2=null;
        assertThrows(NullPointerException.class,()->{sum2.toString();});
        assertThrows(NullPointerException.class,()->{sum.toString();});

    }




    //asert timeouts
    @Test
    void checkTimeLimit(){
        assertTimeout(Duration.ofMillis(10),()->{sum.sum(1,2);});
    }
    @AfterEach
     void cleanUp(){
        System.out.println("after  each test case");
    }
    @AfterAll
    static void end(){
        System.out.println("after  all test case");
    }
}
