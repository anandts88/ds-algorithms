# Stack
* Stack follows last in first out.
* Recently added element from Stack has to be removed from Stack. 
* Recently added element will be on top of Stack.

## Algorithm

1. Initialize an array with provided size.
2. Declare a variable pointer which indicates position where next element can be added in array.
3. Initially pointer will be 0.
4. When pointer is 0 basically means stack is empty.

### Push

1. Add an element into an array on index defined by pointer.
2. Increment the pointer by 1.
3. If the pointer reaches the size of the stack then 
   1. increase the size of array by half.
   2. This is called auto array resizing.

### Pop

1. Decrement the pointer by 1
2. Get the element at the pointer position.
3. Nullify the array at the index of pointer so that it will be garbage collected.
4. If the pointer reaches 1 / 4 of the stack size then
   1. Reduce the size of array by half.
5. Return the element.

## Execution

* Create Stack with size 2.
```
Index       0       1
Element     null    null
Pointer     ^
```

* Push 5 to stack

```
Index       0       1
Element     5       null
Pointer             ^
```

* Push 3 to stack
```
Index       0       1       2       3
Element     5       3       null    null    
Pointer                     ^
```

* Pop 3 from stack
```
Index       0       1
Element     5       null    
Pointer             ^
```

* Pop 5 from stack

```
Index       0       1
Element     null    null    
Pointer     ^
```

* Now the stack is empty.