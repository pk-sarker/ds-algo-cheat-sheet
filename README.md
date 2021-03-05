# Data Structure and Algorithm Cheat Sheet
Data Structure &amp; Algorithm cheat sheet

## Data Structures
Data structure is about organizing data, management, and storage format that enables efficient access and modification.
More precisely, a data structure is a collection of data values, the relationships among them, and the functions or 
operations that can be applied to the data. 

Here are some data structures that are used mostly.

* [Array](#array)


#### Array
**Definition:**
Array is a data structure consisting of a collection of elements, each identified 
by at least one array index or key. An array is stored such that the position of each element can 
be computed from its index tuple by a mathematical formula.

**Key points:**
* Data stored in consecutive memory blocks. Each block is identified by index.
* Need to know start memory location/index to access elements.
* Array is homogeneous, store same type of data in each memory block.
* Good for indexing; 
* Bad at searching, 
* Not efficient where insertion happens more frequently at random position inserting - need to shift elements to right after insert position, 
* Not efficient where deletion happens more often - need to shift the elements to left after delete position (except at the end).
* One dimensional or **linear arrays** are static in size, that means size of the array is fixed which needs to be declared on initialization.
* There are one dimensional **Dynamic arrays**, where it have reserves space for additional elements. If a dynamic array is full, it copies its contents to a larger array.

**When it is good to use:**
* Available data is of same type, like `integer`, `string`, `character`... 
* When ordering is required
* Good for indexing 


**When it is bad to use:**
* Available data is not same type.

**Time Complexity:**
* Indexing: 
    * Linear array: `O(1)`
    * Dynamic array: `O(1)`
* Search: 
    * Linear array: `O(n)`
    * Dynamic array: `O(n)`
* Optimized Search: 
    * Linear array: `O(log n)`
    * Dynamic array: `O(log n)`
* Insertion: 
    * Linear array: `n/a` 
    * Dynamic array: `O(n)`
    
**Space  Complexity:**\
`O(n)`





