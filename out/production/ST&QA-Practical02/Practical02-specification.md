## Writing a class and JUnit tests

### Aims and Objectives

This practical has been designed to give you practice in:

- writing a class, given written instructions and JavaDoc output,
- writing JUnit 5 tests to ensure that the class performs as expected,
	- using different annotations to optimise the number of needed tests.
- constructing code, with accompanying JavaDoc comments, that is correctly formatted and meets coding standards.  
  A checkstyle file is provided. Instructions on installing and configuring the CheckStyle-IDEA plugin are available in
  the `CheckStyle_install.md` file located in the `specifications` folder.
	- this will be checked upon submission of your code for marking.

#### Methodology

You should write the class according to the specifications below (Tasks 1 - 4). You can then either:

- write the tests as you go, to ensure each task is complete, before moving on to the next task, or,
- complete all tasks and then write all tests.

> <b><hintfont>IMPORTANT:</hintfont></b> In order for your code to be automatically marked you **_must_** create test
> classes named:
> - TestTask1
> - TestTask2
> - TestTask3
> - TestTask4
>
> **_Failure to adhere to this directive will result in you failing the automatic tests_**

Be mindful of the time that this may take when choosing a strategy, as marks will be only be awarded for those parts
that are completed fully - that is, both the class methods and the tests for them.

### Task 1

1. You are required to complete a new class called `StringList` (minimal skeleton provided).   
   The aim of the class is to represent a list. It is initially empty but can have elements inserted at the end of it.
   Since arrays are not extensible, one way to represent the list is to create an array which is long enough for all
   foreseeable circumstances and to keep track of how much of the array is being used with another variable. Initially
   this variable will be zero and each time a value is inserted it will become one larger. The class includes the
   following:
	1. A private final int named `DEFAULT_CAPACITY` used to create a default list.
	2. A private final int named `GROW` used to determine how much the size of the list should increase when needed.
	3. A private instance variable named `elementData` which refers to a **`String`** array.
	4. A private instance variable called `size` to keep track of how many elements of the array are being used,
	   initialised to 0.
2. You should now include the following:
	1. A default constructor (no parameters) that creates an empty list to hold 4 Strings (use the constant supplied).
	2. A method named `grow()` that increases the size of `elementData` by `GROW`. To do this you will need to create
	   a temporary array, copy all the elements from `elementData` and return the temporary array.
	3. A method named `add(String element)` which appends the specified element to the end of the list and returns
	   _true_ if successful.
	   Prior to appending the element, the method should check that there are unused positions in the array (make use of
	   the `length` attribute of the array and `size`). If there are not, a call to `grow()` should be
	   made and then the insertion should be performed. To do this it should use **`size`** to index the array and
	   assign the element to that position in the array. `size` should then be increased by 1.
	4. A method named `get(int index)` which returns the element at the given index (similar to array indexing). It
	   should check that the index passed as a parameter is that of an index which is being used. For example, after
	   adding two elements to a list (calling `add` twice), the only valid indexes will be 0 and 1. If the index is
	   not valid, an IllegalArgumentException should be thrown with the message: _**"Invalid index: " + index**_.
	5. A method named `toString` which returns a formatted String of the elements in the list. If the list does not
	   contain any elements then **List is empty: []** should be returned, otherwise **Printing List: [e<sub>1</sub>,
	   e<sub>2</sub>, ..., e<sub>n</sub>]** should be returned.


---

### Task 2

1. For this task you will add the following methods to the `StringList` class.
	1. A method named `contains(String element)` that checks to see if the given element is in this list and return
	   _true_ if this list contains the specified element, _false_ otherwise
	2. A method named `indexOf(String element)` that returns the index of the first occurrence of the specified
	   element in this list, or -1 if this list does not contain the element.
	3. A method named `set(int index, String element)` that replaces the element at the specified position in this
	   list with the specified element. The method returns the element previously at the specified position or if index
	   is invalid, an IllegalArgumentException should be thrown with the message: _**"Invalid index: " + index**_.
	4. A method named `size` that returns an `int`, which is the number of elements in the list.

---

### Task 3

1. For this task you will add the following to the `StringList` class.
	1. A constructor which takes a single `int` parameter and creates an empty list of that size.
	2. A method named `add(int index, String element)`. The method does not return anything. The method
	   inserts the specified element at the specified index in the list. Shifts the element currently at that index (if
	   any) and any subsequent elements to the right (adds one to their indices). If the index is invalid an
	   IllegalArgumentException should be thrown with the message: _**"Invalid index: " + index**_.
	   <details>
	   <summary><hintfont><b>Hint</b></hintfont></summary>

	   > Don't forget you need at least one spare space to insert the element, you may have to call <code>grow()
	   </code>  <br>
	   </details>
	3. A method named `remove(int index)` that removes the element at the specified position in the list. Shifts any
	   subsequent elements to the left (subtracts one from their indices). The method returns the element that was
	   removed from the list. If the index is invalid, an IllegalArgumentException should be thrown with the message:
	   _**"Invalid index: " + index**_.
	4. A method named `remove(String element)` that removes the first occurrence of the specified element from the list,
	   if it is present. Shifts any subsequent elements to the left (subtracts one from their indices). If the list does
	   not contain the element it is unchanged. The method returns _true_ if the list contained the element, or _false_
	   otherwise.
	5. A method named `clear` that returns nothing and removes all elements from the list. The list will be empty
	   after the method returns.
	6. A method named `isEmpty` that returns _true_ if the list contains no elements.

---

### Task 4

1. For this task you will add the following methods to the `StringList` class.
	1. A method named `lastIndexOf(String element)` that returns the last occurrence of the specified element, or -1 if
	   the list does not contain the element
	2. A method named `subList(int fromIndex, int toIndex)` that returns a `StringList` of the portion of the list
	   between the specified _fromIndex_, inclusive, and _toIndex_, exclusive.
		- If _fromIndex_ and _toIndex_ are equal, then the returned list is empty.
		- If _toIndex_ is less than _fromIndex_, an IllegalArgumentException should be thrown with the message:
		  _**"Indices out of order"**_.
		- If either index is invalid, an IllegalArgumentException should be thrown with the message:
		  _**"Invalid index: " + index**_.
	3. A method named `removeRange(int fromIndex, int toIndex)`. It Removes from this list all the elements whose index
	   is between _fromIndex_, inclusive, and _toIndex_, exclusive.  
	   Shifts any succeeding elements to the left (reduces their index). This call shortens the list by (_toIndex_ -
	   _fromIndex_) elements. (If _toIndex_ equals _fromIndex_, this operation has no effect.)
		- If _toIndex_ is less than _fromIndex_, an IllegalArgumentException should be thrown with the message:
		  _**"Indices out of order"**_.
		- If either index is invalid, an IllegalArgumentException should be thrown with the message:
		  _**"Invalid index: " + index**_.
	4. A method named `equals(StringList sl)` that compares the specified `StringList` with `this` list for equality.
	   Two lists are defined to be equal if they contain the same elements in the same order.
	5. A method named `toArray` that returns an array containing all the elements in this list in proper sequence (from
	   first to last element).

---

<style>
hintfont {
color: red
}
</style>