# Data Structure and Algorithm Cheat Sheet
Data Structure &amp; Algorithm cheat sheet

## Data Structures
Data structure is about organizing data, management, and storage format that enables efficient access and modification.
More precisely, a data structure is a collection of data values, the relationships among them, and the functions or 
operations that can be applied to the data. 

Here are some data structures that are used mostly.

* [Array](#array)
* [Linked List](#linked-list)
* [Hash Table](#hash-table)
* [Heap](#heap)
* [Stack](#stack)
* [Queue](#queue)
* [Binary Tree](#binary-tree)
* [Binary Search Tree-BST](#binary-search-tree-bst)
* [Segment Tree](#segment-tree)


### Array
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
* Indexing is required

**When it is bad to use:**
* Available data is not same type.

**Time Complexity:**
* Indexing: 
    * Linear array & Dynamic array: `O(1)`
* Search: 
    * Linear array & Dynamic array: `O(n)`
* Optimized Search: 
    * Linear array & Dynamic array: `O(log n)`
* Insertion: 
    * Linear array: `n/a` 
    * Dynamic array: `O(n)`
    
**Space  Complexity:**\
`O(n)`

### Linked List
**Definition:**
Linked list is a linear collection of data. Each element is represented by `node`. Linked list 
doesn't store data in consecutive memory location. Each node stores data and a reference/pointer
to next node. For a linked list the type of data in each node has to be same. Data element  could be
a primitive or composite/object. 

**Key points:**
* Linked list may be circular where last node points to the first node.
* Linked list could be doubly where each node contains the reference of next node and previous node.
* Data is not stored consecutive memory blocks, unlike array. 
* Nodes in a linked list must be read in order from the beginning as linked lists are inherently sequential access.
* Not efficient where insertion happens any location other than start and end. It will need to search the position from beginning.  
* Efficient where deletion happens more often, just need to change the next reference of previous node.

**When it is good to use:**
* When there are heavy insertion & deletion, Linked list provides constant time insertion & deletion.
* By nature memory allocation is dynamic, if not sure about the size of data then linked list is a good choice.
* Don't need random access to data, unlike array, searching starts from beginning/head.
* Insertion in the middle doesn't happen too frequent, complexity is searching the insert position.

**Time Complexity:**
- Indexing: `O(n)`
- Search: `O(n)`
- Optimized Search: `O(n)`
- Append: `O(1)`
- Prepend: `O(1)`
- Insertion: `O(n)`

**Space  Complexity:**\
`O(n)`





