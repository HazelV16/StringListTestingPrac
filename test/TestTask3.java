import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestTask3 {
    StringList list = new StringList();
    @Test
    @DisplayName("Test adding new element at the specified index in the list and shift any subsequent elements to the right")
    void testAddAtIndexNewString() {
        list.add("one");
//        list.add("two");
//        list.add("three");

        list.add(0, "newOne");
        list.add(1, "newTwo");
        assertEquals("Printing List: [newOne, newTwo, one]", list.toString());
    }

    @Test
    @DisplayName("Test invalid index for adding new element at the specified index")
    void testInvalidAddStringByIndex() {
        list.add("one");
        list.add("two");
        list.add("three");

        assertThrows(IllegalArgumentException.class, () -> list.add(5, "newFive"));
        try {
            list.add(5, "newFive");
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid index: 5", e.getMessage());
        }

        assertThrows(IllegalArgumentException.class, () -> list.add(-2, "newFive"));
        try {
            list.add(-2, "newFive");
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid index: -2", e.getMessage());
        }
    }

    @Test
    @DisplayName("Test remove the element at the specified position in the list")
    void testRemoveIndex() {
        list.add("one");
        list.add("two");
        list.add("three");

        assertEquals("two", list.remove(1));
        assertEquals(2, list.size());

//         Verify the elements after removal
        assertEquals("one", list.get(0));
        assertEquals("three", list.get(1));

//        verify output
        assertEquals("Printing List: [one, three]", list.toString());
    }

    @Test
    @DisplayName("Test invalid index for remove elements")
    void testInvalidRemoveIndex() {
        list.add("one");
        list.add("two");
        list.add("three");

        assertThrows(IllegalArgumentException.class, ()-> list.remove(5));

        try {
            list.remove(5);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid index: 5", e.getMessage());
        }

        assertThrows(IllegalArgumentException.class, ()-> list.remove(-2));

        try {
            list.remove(-2);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid index: -2", e.getMessage());
        }
    }

    @Test
    @DisplayName("Test remove the first occurrence of the specified element from the list, " +
            "shift left any subsequent elements")
    void testRemoveString() {
        list.add("one");
        list.add("two");
        list.add("three");

//         Remove an existing element
        assertTrue(list.remove("two"));
//         Remove a non-existing element
        assertFalse(list.remove("five"));
    }

    @Test
    @DisplayName("Test clear all elements from the list")
    void testClear() {
        list.add("one");
        list.add("two");
        list.add("three");

//         Verify the size before clearing
        assertEquals(3, list.size());

//         Clear the list
        list.clear();

        assertEquals("List is empty: []", list.toString());
    }

    @Test
    @DisplayName("Test if the list contain no elements")
    void testIsEmpty() {
        assertTrue(list.isEmpty());

        list.add("one");
        list.add("two");
        list.add("three");
        assertFalse(list.isEmpty());
        // Clear the list
        list.clear();
        assertTrue(list.isEmpty());
    }

@Test
    public void testAddGrow() {
    // Create a StringList with initial capacity 3
    StringList list = new StringList(3);

    // Add three elements to fill the list to its capacity
    list.add("one");
    list.add("two");
    list.add("three");

    // At this point, the size of the list should be equal to its capacity
    // Adding another element should trigger the growth of the internal array
    list.add(2, "four");

    // Verify that the size has increased and the internal array has grown
    assertEquals(4, list.size());
}
}

