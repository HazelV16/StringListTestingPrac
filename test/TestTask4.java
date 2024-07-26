import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestTask4 {
    StringList list = new StringList();

    @Test
    @DisplayName("Test the last occurrence of the specified element")
    void testLastIndexOf() {
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("one");

//        Verify the last index of an existing element
        assertEquals(3, list.lastIndexOf("one"));

//        Verify the last index of a non-existing element
        assertEquals(-1, list.lastIndexOf("four"));
    }

    @Test
    @DisplayName("Test return a StringList of the portion of the list between the speicifed fromIndex and toIndex")
    void testSubList() {
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");

//         Get subList from index 1 to 4 (exclusive)
        StringList subList = list.subList(1, 4);
//         Verify the size and elements of the subList
        assertEquals(3, subList.size());
        assertEquals("two", subList.get(0));
        assertEquals("three", subList.get(1));
        assertEquals("four", subList.get(2));

//         Get subList from index 2 to 2 (empty sublist)
        StringList emptySubList = list.subList(2, 2);
//         Verify the size of the empty subList
        assertEquals(0, emptySubList.size());
    }

    @Test
    @DisplayName("Test invalid range of subList fromIndex and toIndex")
    void testInvalidSubList(){
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");

//        get sublist from index 4 to 2 (indices out of order)
        assertThrows(IllegalArgumentException.class, ()->list.subList(4, 2));
        try {
            list.subList(4, 2);
        } catch (IllegalArgumentException e) {
            assertEquals("Indices out of order", e.getMessage());
        }

//        verify invalid fromIndex and toIndex (fromIndex < 0)
        assertThrows(IllegalArgumentException.class, ()->list.subList(-1, 3));
        try {
            list.subList(-1, 3);
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid index", e.getMessage());
        }

//        verify invalid fromIndex and toIndex (fromIndex >= size)
        assertThrows(IllegalArgumentException.class, ()->list.subList(5, 7));
        try {
            list.subList(5, 7);
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid index", e.getMessage());
        }

//        verify invalid fromIndex and toIndex (toIndex > size)
        assertThrows(IllegalArgumentException.class, ()->list.subList(2, 7));
        try {
            list.subList(2, 7);
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid index", e.getMessage());
        }

    }

    @Test
    @DisplayName("Test remove from the list all the elements whose index is between fromIndex and toIndex" +
            "shift left any succeeding ")
    void testRemoveRange() {
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        list.add("six");

//         Remove elements from index 0 to 3 (exclusive)
        list.removeRange(2, 4);

        assertEquals(4, list.size());
        assertEquals("one", list.get(0));
        assertEquals("five", list.get(2));

        // Attempt to remove with invalid index range
        try {
            list.removeRange(3, 1);
        } catch (IllegalArgumentException e) {
            assertEquals("Indices out of order", e.getMessage());
        }

        try {
            list.removeRange(-3, 1);
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid index", e.getMessage());
        }

        try {
            list.removeRange(1, 10);
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid index", e.getMessage());
        }

        list.removeRange(1, 1);
        assertEquals("Printing List: [one, two, five, six]", list.toString());
    }

    @Test
    @DisplayName("Test compare the specified StringList with this list for equality")
    void testEquals() {
        StringList list1 = new StringList();
        list1.add("one");
        list1.add("two");
        list1.add("three");

        StringList list2 = new StringList();
        list2.add("one");
        list2.add("two");
        list2.add("three");

        StringList list3 = new StringList();
        list3.add("four");
        list3.add("five");

        StringList list4 = new StringList();
        list4.add("four");
        list4.add("five");
        list4.add("one");


//         Equal lists
        assertTrue(list1.equals(list2));
//         Lists with different size
        assertFalse(list1.equals(list3));
//         Lists with different element
        assertFalse(list1.equals(list4));
    }

    @Test
    void testDifSize() {
        StringList list = new StringList();
        list.add("one");
        list.add("two");
        list.add("three");

        StringList list3 = new StringList();
        list3.add("four");
        list3.add("five");

//         Lists with different size
        assertFalse(list.equals(list3));

    }

    @Test
    @DisplayName("Test return an array containing all the elements in the list in proper sequence")
    void testToArray(){
        list.add("one");
        list.add("two");
        list.add("three");

        String[] array = list.toArray();

        assertEquals("one", array[0]);
        assertEquals(3, array.length);
    }

    @Test
    void testListWithParameter() {
        int parameter = 5;
        StringList list = new StringList(parameter);

        // Verify the size of the list matches the parameter
//        assertEquals(parameter, list.size());
//        assertEquals(parameter, list.capacity());
    }

}