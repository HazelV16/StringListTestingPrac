//import java.lang.reflect.Array;

/**
 * Class that simulates a list for storing Strings.
 *
 * @author Hazel Vuong (vuon0044)
 * @version v10
 */
public class StringList {

    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 4;

    /**
     * The amount to grow this {@code StringList} when {@code grow()} is called.
     */
    private static final int GROW = 5;
    /**
     * The size of the {@code StringList} (the number of elements it contains).
     */
    private int size = 0;
    /**
     * The array buffer into which the elements of the {@code StringList} are stored.
     */
    private String[] elementData;

    /**
     * A default constructor (no parameters) that creates an empty list to hold 4 Strings.
     */
    public StringList() {
        elementData = new String[DEFAULT_CAPACITY];
    }

    /**
     * A constructor which takes a single int parameter and creates an empty list of that size.
     * @param parameter
     */
    public StringList(int parameter) {
        elementData = new String[parameter];
    }

    /**
     * A method named grow() that increases the size of elementData by GROW.
     * @return temp
     */
    public String[] grow() {
        String[] temp = new String[elementData.length + GROW];
        for (int i = 0; i < elementData.length; i++) {
            temp[i] = elementData[i];
        }
        return temp;
    }

    /**
     * A method named add(String element) which appends the specified element
     * to the end of the list.
     * @param element
     * @return boolean
     */
    public boolean add(String element) {
        if (size < elementData.length) {
            elementData[size] = element;
            size++;
            return true;
        } else {
            elementData = grow();
            elementData[size] = element;
            size++;
            return true;
        }
    }

    /**
     * Check that the index passed as a parameter is that of an index which is being used.
     * @param index
     * @return the element at the given index
     */
    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Invalid index: " + index);
        } else {
            return elementData[index];
        }
    }

    /**
     * A method named toString which returns a formatted String of the elements in the list.
     * @return string output
     */
    public String toString() {
        if (size == 0) {
            return "List is empty: []";
        } else {
            String output = "Printing List: [" + elementData[0];
            for (int i = 1; i < size; i++) {
                output += ", " + elementData[i];
            }
            output += "]";
            return output;
        }
    }

    /**
     * A method named contains(String element) that checks to see
     * if the given element is in this list.
     * @param element
     * @return boolean
     */
    public boolean contains(String element) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * A method named indexOf(String element) that returns the index of the first occurrence
     * of the specified element in this list.
     * @param element
     * @return index of the first occurrence
     */
    public int indexOf(String element) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * A method that replaces the element at the specified position in this list
     * with the specified element.
     * @param index
     * @param element
     * @return element previously at the specified position
     */
    public String set(int index, String element) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Invalid index: " + index);
        }

        String newElement = elementData[index];
        elementData[index] = element;

        return newElement;

    }

    /**
     * A method that shows the number of elements in the list.
     * @return size
     */
    public int size() {
        return size;
    }

    /**
     * The method inserts the specified element at the specified index in the list.
     * Shifts the element currently at that index (if any)
     * and any subsequent elements to the right (adds one to their indices).
     * @param index
     * @param element
     */
    public void add(int index, String element) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Invalid index: " + index);
        }
            if (size >= elementData.length) {
                grow();
            }
        String[] tempList = new String[size + 1];
            for (int i = 0; i < size; i++) {
                tempList[i] = elementData[i];
            }

            // Insert the new element at the specified index
            tempList[index] = element;
            for (int a = index; a < size; a++) {
                tempList[a + 1] = elementData[a];
            }

            elementData = tempList;
            size++;
    }

    /**
     * A method that removes the element at the specified position in the list.
     * Shifts any subsequent elements to the left (subtracts one from their indices).
     * @param index
     * @return the element that was removed from the list
     */
    public String remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Invalid index: " + index);
        }

        String removedElement = elementData[index];

        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
//        set the last element to null and reduce the size
        elementData[size - 1] = null;
        size--;
//        return the element that was removed from the list
        return removedElement;
    }

    /**
     * A method that removes the first occurrence of the specified element from the list,
     * if it is present.
     * Shifts any subsequent elements to the left (subtracts one from their indices).
     * @param element
     * @return boolean
     */
    public boolean remove(String element) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(element)) {
                for (int j = i; j < size - 1; j++) {
                    elementData[j] = elementData[j + 1];
                }
                elementData[size - 1] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    /**
     * A method that returns nothing and removes all elements from the list.
     * The list will be empty after the method returns.
     */
    public void clear() {
        elementData = new String[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * A method that returns true if the list contains no elements.
     * @return boolean
     */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    /**
     * A method that returns the last occurrence of the specified element.
     * @param element
     * @return last occurrence of the specified element
     */
    public int lastIndexOf(String element) {
        for (int i = size - 1; i >= 0; i--) {
            if (elementData[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * A method that returns a StringList of the portion of the list
     * between the specified fromIndex, inclusive, and toIndex, exclusive.
     * @param fromIndex
     * @param toIndex
     * @return sub list
     */
    public StringList subList(int fromIndex, int toIndex) {
        if (fromIndex == toIndex) {
            return new StringList();
        } else if (fromIndex < 0 || fromIndex >= size) {
            throw new IllegalArgumentException("Invalid index");
        } else if (toIndex > size || toIndex < 0) {
            throw new IllegalArgumentException("Invalid index");
        } else if (toIndex < fromIndex) {
            throw new IllegalArgumentException("Indices out of order");
        }
        StringList subList = new StringList();
        for (int i = fromIndex; i < toIndex; i++) {
            subList.add(elementData[i]);
        }
        return subList;
    }

    /**
     * A method that removes from this list all the elements whose index
     * is between fromIndex, inclusive, and toIndex, exclusive.
     * Shifts any succeeding elements to the left (reduces their index).
     * @param fromIndex
     * @param toIndex
     */
    public void removeRange(int fromIndex, int toIndex) {
        int removeNum = toIndex - fromIndex;
        if (fromIndex == toIndex) {
            new StringList();
        } else if (fromIndex < 0) {
            throw new IllegalArgumentException("Invalid index");
        } else if (toIndex > size || toIndex < 0) {
            throw new IllegalArgumentException("Invalid index");
        } else if (toIndex < fromIndex) {
            throw new IllegalArgumentException("Indices out of order");
        }
        for (int i = toIndex; i < size; i++) {
            elementData[i - removeNum] = elementData[i];
        }
        size -= removeNum;
    }

    /**
     * A method that compares the specified StringList with this list for equality.
     * @param sl
     * @return boolean
     */
    public boolean equals(StringList sl) {
        if (sl == null || size != sl.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!elementData[i].equals(sl.get(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * A method that returns an array containing all the elements in this list in proper sequence
     * (from first to last element).
     * @return array
     */
    public String[] toArray() {
        String[] array = new String[size];
        for (int i = 0; i < size; i++) {
            array[i] = elementData[i];
        }
        return array;
    }

}

