# Data-Structures

#### Sorting Algorithms
* Random Data Range
	* Bubble Sort
	* Insertion Sort
	* Merge Sort
	* Quick Sort
	* Selection Sort
	* Shell Sort
* Fixed Data Range
	* Counting Sort
	* Radix Sort

#### General Issues
* Following inheritance without planning how testing can be done, makes the application untestable or unnecessary difficult to testing

#### Lists
* ArrayLists
* Vector
* LinkedList
* Doubly-LinkedList
* Challenge 1 : Insert a node in LinkedList which is between node A and node B
* Challenge 2 : Implement a LinkedList which stores the integer data type

#### Stacks
* Implement Stack ADT using an array
* Implement Stack ADT using a LinkedList (JDK method)
* Challenge 1 : Check if a given string is a palindrome

#### Queues
* Implement Queue ADT using an array
* Implement Circular Queue ADT using an array
* Challenge 1 : Check if a given string is a palindrome

#### HashTable
* Implement HashTable ADT using an array
* Implement HashTable ADT using a LinkedList (also called Chained HashTable)
* Practicing HashTable ADT from LinkedList JDK class

#### Binary Search Tree
* Create a class called TreeNode and instantiate its member variables and methods
* This TreeNode is scalable and extensible enough to implement BST, RB Trees, AVL Trees.
* Create a class called BST
* Insert a node in the tree
* Traversals of the tree
	* Level-Order
	* In-Order
	* Pre-Order
	* Post-Order
	*	![Traversals](/docs/traversals.png?raw=true "traversals")
* Get a node in the tree
* find the min value in the tree
* find the max value in the tree
* Delete operations (Complex to solve! - check source code for documentation)
	* Case 0: when the deleteNode has no children
	* Case 1: when the deleteNode has one child
	* Case 2: when the deleteNode has two children

#### Heap Tree
* Introduction
	* Heap Tree is a complete binary tree, hence this Data-Structure can be backed by an array (any complete binary tree can be backed by array)
	* Implement max heap (min heap is nothing but a mirror image of max-heap)
	* For a node at array[i]
		* left child = 2i + 1;
		* right child = 2i + 2;
		* parent = floor((i-1)/2); (int datatype implicitly gives the floor value)
* Insertion
	* Always add at the end of the array
	* Every insertion is followed by heapify process
* heapifyTree
	* Compare the new element against it's parent
	* if the new element is greater than the parent, then swap it with its parent
	* Rinse and repeat
* DeleteanElement
	* replace the deleteElement with last element from the array (heapTree)
	* then heapify the whole tree
