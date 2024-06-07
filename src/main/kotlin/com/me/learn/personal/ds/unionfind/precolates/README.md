# Precolation

## Prerequisite
* Weighted Quick Union Algorithm. 
* Weighted Quick Union alogrithm is used to connect the elements.

## How it works?
* Precolation means a 2D matrix. With a tap on top of matrix and drain on bottom of matrix.
* When you open a tap we need to find a way for water at top to drain at bottom.
* At first all the martix will be closed.
* We need to open element of matix one by one to check if the water drains.
* Open means the element of matrix is just open.
* Full means the element of matrix is filled with water, basically it is connected to tap.
* Precolates means water from tab is connected to drain.

## Algorithm

1. Open a matrix element 
2. If the element is in first row of matrix then connect it to top(tap).
      1. If the siblings on right, left or bottom are open then connect to them
3. If the element is in last row of matrix then connect it to bottom(drain).
      1. If the siblings on right, left or top are open then connect to them
4. If the element if in any other row then just open it
      1. If the siblings on right, left, top or bottom are open then connect to them
5. Repeat by randomly supplying the matrix element to open.
6. If top and bottom are connected then it means it precolates.

* Note
    1. (C) means closed
    2. (O) means opened
    3. (F) means opened and full

### Example for 3x3 matrix.
```
      (0, 0)(C)  (0, 1)(C)  (0,2)(C)
      (1, 0)(C)  (1, 1)(C)  (1,2)(C)
      (2, 0)(C)  (2, 1)(C)  (2,2)(C)
```

### Execution

* Convert the matrix to nodes. Also will introduce notes for tap and drain.
```
                (0)(Tap)

          (1)(C)  (2)(C)  (3)(C)
          (4)(C)  (5)(C)  (6)(C)
          (7)(C)  (8)(C)  (9)(C)

                (10)(Drain)
```
* Open Matrix element (1, 1) which is node (5)
* Node 5 is in middle row and there is not siblings are open, so no further connection required
```
                (0)(Tap)

          (1)(C)  (2)(C)  (3)(C)
          (4)(C)  (5)(O)  (6)(C)
          (7)(C)  (8)(C)  (9)(C)

                (10)(Drain)
```

* Open Matrix element (0, 1) which is node (2)
* Node 2 is in first row so connect to tap and node 5 at bottom of 2 is open so connect to 5
```
                 (0)(Tap)
                     |
          (1)(C)  (2)(O)  (3)(C)
                     |
          (4)(C)  (5)(O)  (6)(C)
          (7)(C)  (8)(C)  (9)(C)
                (10)(Drain)
```

* Open Matrix element (2, 2) which is node (9)
* Node 9 is in last row so connect to drain and there is not siblings are open, so no further connection required
```
                 (0)(Tap)
                     |
          (1)(C)  (2)(O)  (3)(C)
                     |
          (4)(C)  (5)(O)  (6)(C)
          (7)(C)  (8)(C)  (9)(O)
                          /
                (10)(Drain)
```
* Open Matrix element (1, 2) which is node (6)
* Node 6 is in middle row and siblings 5 and 9 are already open so connect to them.
* Now the matrix precolates, since node 0 and 10 are connected.
```
                 (0)(Tap)
                     |
          (1)(C)  (2)(O)   (3)(C)
                     |
          (4)(C)  (5)(O) _ (6)(O)
                             |
          (7)(C)  (8)(C)   (9)(O)
                           /
                (10)(Drain)
```