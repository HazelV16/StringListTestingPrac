import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestTask2 {

    StringList list = new StringList();

    @Test
    @DisplayName("Test if the list contains the specified element")
    void testContains() {
        assertFalse(list.contains("one"));
        list.add("one");
        list.add("two");
        list.add("three");
        assertTrue(list.contains("one"));
        assertTrue(list.contains("two"));
        assertFalse(list.contains("four"));
    }

    @Test
    @DisplayName("Test if the index of the first occurrence of the specified element in this list, " +
            "-1 if list does not contain element")
    void testIndexOf() {
        assertEquals(-1, list.indexOf("One"));
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("one");
        assertEquals(0, list.indexOf("one"));
        assertEquals(1, list.indexOf("two"));
        assertEquals(-1, list.indexOf("Two"));
    }

    @Test
    @DisplayName("Test replace the element at the specified position in the list with the specified element")
    void testSet() {
        list.add("one");
        list.add("two");
        list.add("three");
        assertEquals("three", list.set(2, "newOne"));
        assertEquals("newOne", list.get(2));
    }

    @Test
    @DisplayName("Test set method with out of bound index")
    void testSetOutOfBound() {
        list.add("one");
        list.add("two");
        list.add("three");
        assertThrows(IllegalArgumentException.class, () -> list.set(5, "newNegativeOne"));
        try {
            list.set(5,"newFive");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid index: 5", e.getMessage());
        }
    }

    @Test
    @DisplayName("Test set method with negative index")
    void testSetNegative() {
        list.add("one");
        list.add("two");
        list.add("three");
        assertThrows(IllegalArgumentException.class, () -> list.set(-1, "newNegativeOne"));
        try {
            list.set(-1, "newNegativeOne");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid index: -1", e.getMessage());
        }
    }

    @Test
    @DisplayName("Test number of elements in the list")
    void testSize(){
//        no element in the list, should return 0
        assertEquals(0, list.size());
//        add some elements in the list
        list.add("One");
        list.add("Two");

        assertEquals(2, list.size());
    }


}