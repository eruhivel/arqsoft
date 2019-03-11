package edu.upc.swarch.stackcalc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorImplTest {

    @Test
    public void testPushPop() throws Exception {
        // Given a calculator
        Calculator c = new CalculatorImpl();

        // When several numbers are pushed to the stack
        c.push(1.0);
        c.push(2.0);
        c.push(3.0);
        c.push(4.0);

        // The numbers are popped in a "Last-In, First-Out" way
        final double delta = 0.00001;
        assertEquals(4.0, c.pop(), delta);
        assertEquals(3.0, c.pop(), delta);
        assertEquals(2.0, c.pop(), delta);
        assertEquals(1.0, c.pop(), delta);
    }

    @Test
    public void testAdd() throws Exception {
        // GIVEN a stack calculator 
        Calculator c = new CalculatorImpl();
        //      with at least 2 numbers in the stack
        c.push(15);
        c.push(8);
        // WHEN the add() method is invoked
        c.add();
        // THEN the top of the stack now contains
        //      the addition of those two numbers
        final double delta = 0.000001;
        assertEquals(23.0, c.pop(), delta);
        
    }
    
    @Test(expected = StackSizeException.class)
    public void testPopInEmptyStack() throws Exception {
        // GIVEN a calculator
        //      with an empty stack
        Calculator c = new CalculatorImpl();
        // WHEN pop() is invoked
        c.pop();
        // THEN a StackSizeException is thrown
                
    }
}
