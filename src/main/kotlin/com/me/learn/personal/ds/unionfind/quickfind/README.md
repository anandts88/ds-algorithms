# Quick Union
* Solves dynamic connectivity problem.
* Lazy approach.
* Use array[N] data structure for maintaining roots.
* Root represents parent node of the tree.

## Algorithm
* While doing union we will
  1. Find root of both elements  i and j.
  2. Connect root of j with root of i.

## Execution

* Tree with size 10
```
            0   1   2   3   4   5   6   7   8   9
Root        0   1   2   3   4   5   6   7   8   9
```

* Union 4 and 3
* Root of 4 is 4 and Root of 3 is 3
* Connect 4 to root of 3 which is 3.

```
            0   1   2   3   4   5   6   7   8   9
Root        0   1   2   3   3   5   6   7   8   9
```

```
        3
       /
      4 
```

* Union 3 and 8
* Root of 3 is 3 and Root of 8 is 8
* Connect 3 to root of 8 which is 8.

```
            0   1   2   3   4   5   6   7   8   9
Root        0   1   2   8   3   5   6   7   8   9
```

```
          8
         / 
        3
       /
      4 
```

* Union 6 and 5
* Root of 6 is 6 and Root of 5 is 5
* Connect 6 to root of 5 which is 5.

```
            0   1   2   3   4   5   6   7   8   9
Root        0   1   2   8   3   5   5   7   8   9
```

```
          5
         /
        6 

          8
         / 
        3
       /
      4 
```

* Union 9 and 4
* Root of 9 is 9 and Root of 4 is 8
* Connect 9 to root of 4 which is 8.

```
            0   1   2   3   4   5   6   7   8   9
Root        0   1   2   8   3   5   5   7   8   8
```

```
          5
         /
        6 

          8
         / \
        3   9
       /
      4 
```

* Union 2 and 1
* Root of 2 is 2 and Root of 1 is 1
* Connect 2 to root of 1 which is 1.

```
            0   1   2   3   4   5   6   7   8   9
Root        0   1   1   8   3   5   5   7   8   8
```

```
          1
         /
        2 

          5
         /
        6 

          8
         / \
        3   9
       /
      4 
```

* Union 5 and 0
* Root of 5 is 5 and Root of 0 is 0
* Connect 5 to root of 0 which is 0.

```
            0   1   2   3   4   5   6   7   8   9
Root        0   1   1   8   3   0   5   7   8   8
```

```
          1
         /
        2 

            0
           / 
          5
         /
        6 

          8
         / \
        3   9
       /
      4 
```

* Union 7 and 2
* Root of 7 is 7 and Root of 2 is 1
* Connect 7 to root of 2 which is 1.

```
            0   1   2   3   4   5   6   7   8   9
Root        0   1   1   8   3   0   5   1   8   8
```

```
          1
         / \
        2   7

            0
           / 
          5
         /
        6 

          8
         / \
        3   9
       /
      4 
```

* Union 6 and 1
* Root of 6 is 0 and Root of 1 is 1
* Connect 0 to root of 1 which is 1.

```
            0   1   2   3   4   5   6   7   8   9
Root        1   1   1   8   3   0   5   1   8   8
```

```
            1
          / | \
         0  2  7
        /
       5
      /  
     6       
 
          8
         / \
        3   9
       /
      4 
```


* Union 7 and 3
* Root of 7 is 1 and Root of 3 is 8
* Connect 1 to root of 3 which is 8.

```
            0   1   2   3   4   5   6   7   8   9
Root        1   8   1   8   3   0   5   1   8   8
```

```
                    8
                  / | \
                1   9  3
              / | \     \
             0  2  7     4
            /
           5
          /
         6
```
