package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    private final InputStream originalIn = System.in;

    @AfterEach
    void restoreSystemInput() {
        System.setIn(originalIn);
    }

    @Test
    @DisplayName("Test if equilateral triangle is correctly identified from user input")
    void getUserInputTestEquilateral() {
        ByteArrayInputStream testIn = new ByteArrayInputStream("2,2,2\n".getBytes());
        System.setIn(testIn);

        Triangle triangle = new Triangle();
        triangle.getUserInput();

        assertEquals(Triangle.TYPE.EQUILATERAL, triangle.getCurrent_type());
    }

    @Test
    @DisplayName("Test if scalene triangle is correctly identified from user input")
    void getUserInputTestScalene() {
        ByteArrayInputStream testIn = new ByteArrayInputStream("3,4,5\n".getBytes());
        System.setIn(testIn);
        Triangle triangle = new Triangle();
        triangle.getUserInput();
        assertEquals(Triangle.TYPE.SCALENE, triangle.getCurrent_type());
    }

    @Test
    @DisplayName("Test if isosceles triangle is correctly identified from user input")
    void getUserInputTestIsosceles() {
        ByteArrayInputStream testIn = new ByteArrayInputStream("2,2,3\n".getBytes());
        System.setIn(testIn);
        Triangle triangle = new Triangle();
        triangle.getUserInput();
        assertEquals(Triangle.TYPE.ISOSCELES, triangle.getCurrent_type());
    }

    @Test
    @DisplayName("Test user input resulting in a non-triangle")
    void getUserInputTestNonTriangle() {
        ByteArrayInputStream testIn = new ByteArrayInputStream("1,2,3\n".getBytes());
        System.setIn(testIn);
        Triangle triangle = new Triangle();
        triangle.getUserInput();
        assertNull(triangle.getCurrent_type());
    }

    @Test
    @DisplayName("Ensure enum values are correctly set for different triangle types")
    void enumValuesTest() {
        assertEquals("SCALENE", Triangle.TYPE.SCALENE.toString());
        assertEquals("ISOSCELES", Triangle.TYPE.ISOSCELES.toString());
        assertEquals("EQUILATERAL", Triangle.TYPE.EQUILATERAL.toString());
    }

    @Test
    @DisplayName("Initialize triangle with numeric side lengths")
    void initTriangleWithNumbers(){
        Triangle triOne = new Triangle(1,2,3);
        assertNotNull(triOne);
    }

    @Test
    @DisplayName("Initialize triangle with string array of numeric values")
    void initTriangleWithStringsListNumbers(){
        String[] numbers = {"1", "1", "1"};
        Triangle triOne = new Triangle(numbers);

        assertNotNull(triOne);
        assertNotNull(triOne.getCurrent_type());
    }


    @Test
    @DisplayName("Initialize triangle with string array of non-numeric values")
    void initTriangleWithStringsListWithThreeChars(){
        String[] numbers = {"a", "b", "c"};
        Triangle triOne = new Triangle(numbers);

        assertNotNull(triOne);
        assertNull(triOne.getCurrent_type());
    }

    @Test
    @DisplayName("Initialize triangle with string array of invalid size (bigger)")
    void initTriangleWithStringsListFourChars(){
        String[] numbers = {"a", "b", "c","d"};
        Triangle triOne = new Triangle(numbers);

        assertNotNull(triOne);
        assertNull(triOne.getCurrent_type());
    }

    @Test
    @DisplayName("Initialize triangle with string array of invalid size (smaller)")
    void initTriangleWithStringsListTwoChars(){
        String[] numbers = {"a", "b"};
        Triangle triOne = new Triangle(numbers);

        assertNotNull(triOne);
        assertNull(triOne.getCurrent_type());
    }

    @Test
    @DisplayName("Set current type to null for invalid triangles")
    void setCurrentTypeToNull(){

        Triangle triOne = new Triangle(1,1,1);
        triOne.setCurrent_type(0,0,0);
        assertNull(triOne.getCurrent_type());

        triOne.setCurrent_type(1, 2, 3);
        assertNull(triOne.getCurrent_type());
    }

    @Test
    @DisplayName("Set current type to equilateral triangle")
    void setCurrentTypeToEquilateral() {

        Triangle triOne = new Triangle(0,0,0);
        triOne.setCurrent_type(1,1,1);

        assertEquals("EQUILATERAL", triOne.getCurrent_type().toString());
    }

    @Test
    @DisplayName("Set current type to isosceles triangle")
    void setCurrentTypeToISOSCELES() {

        Triangle triOne = new Triangle(0,0,0);
        triOne.setCurrent_type(5, 5, 3);

        assertEquals("ISOSCELES", triOne.getCurrent_type().toString());
    }

    @Test
    @DisplayName("Set current type to scalene triangle")
    void setCurrentTypeToSCALENE() {

        Triangle triOne = new Triangle(0,0,0);
        triOne.setCurrent_type(3, 4, 5);

        assertEquals("SCALENE", triOne.getCurrent_type().toString());
    }

    @Test
    @DisplayName("ToString method output for a non-triangle")
    void toStringNotATriangle() {
        Triangle triangle = new Triangle(0, 1, 2);
        String expected = "0, 1, 2, This is not a triangle";
        assertEquals(expected, triangle.toString());
    }

    @Test
    @DisplayName("ToString method output for a scalene triangle")
    void toStringScaleneTriangle() {
        Triangle triangle = new Triangle(2, 3, 4);
        String expected = "2, 3, 4, This is a Scalene triangle";
        assertEquals(expected, triangle.toString());
    }

    @Test
    @DisplayName("ToString method output for an isosceles triangle")
    void toStringIsoscelesTriangle() {
        Triangle triangle = new Triangle(2, 2, 3);
        String expected = "2, 2, 3, This is a Isosceles triangle";
        assertEquals(expected, triangle.toString());
    }

    @Test
    @DisplayName("ToString method output for an equilateral triangle")
    void toStringEquilateralTriangle() {
        Triangle triangle = new Triangle(2, 2, 2);
        String expected = "2, 2, 2, This is a Equilateral triangle";
        assertEquals(expected, triangle.toString());
    }
}