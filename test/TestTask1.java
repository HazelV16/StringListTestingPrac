import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestTask1 {

    StringList list = new StringList();

    @Test
    @DisplayName("Test add elements in the list and get elements")
    void testAddAndGet() {
        assertTrue(list.add("one"));
        assertTrue(list.add("two"));
        assertTrue(list.add("three"));
        assertTrue(list.add("four"));
        assertTrue(list.add("five"));
        assertEquals("one", list.get(0));
        assertEquals("two", list.get(1));
        assertEquals("three", list.get(2));
        assertEquals("four", list.get(3));
        assertEquals("five", list.get(4));
    }


    @Test
    @DisplayName("Test add more element than default capacity and grow method")
    void testAddAndGrow(){
//        add more elements than the assigned capacity
        for (int i=0;i<20;i++) {
            list.add("test " + i);
        }
        assertEquals("test 0", list.get(0));
        assertEquals("test 19", list.get(19));
    }

    @Test
    @DisplayName("Test get invalid index")
    void testGetInvalidIndex() {
        list.add("one");
        assertThrows(IllegalArgumentException.class, () -> list.get(2));
        try {
            list.get(2);
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid index: 2", e.getMessage());
        }
    }

    @Test
    @DisplayName("Test the string output for empty list")
    void testEmptyString() {
        assertEquals("List is empty: []", list.toString());
    }

    @Test
    @DisplayName("Test the string output with elements in the list")
    void testStringHasValue() {
        list.add("one");
        list.add("two");
        list.add("three");
        assertEquals("Printing List: [one, two, three]", list.toString());
    }

    @Test
    @DisplayName("Test add null to the list")
    public void testAddNull() {
//         Test adding null element
        assertTrue(list.add(null));

//         Verify null element was added correctly
        assertNull(list.get(0));
        assertEquals("Printing List: [null]", list.toString());
    }

    @Test
    public void testContains() {
        StringList list = new StringList();
        list.add("one");
        list.add("two");
        list.add("three");

        // Test for element that exists in the list
        assertTrue(list.contains("two"));

        // Test for element that does not exist in the list
        assertFalse(list.contains("four"));
    }
}