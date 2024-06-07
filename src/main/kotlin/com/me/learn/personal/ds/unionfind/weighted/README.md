# Weighted Quick Union
* Quick find end up in very large tree. Traversing long tree is costly.
* So we use weighted tree.
* Use array[N] data structure for maintaining roots.
* Use array[N] data structure for maintaining weights.
* Root represents parent node of the tree.
* Weights are nothing but no of elements in tree.

## Prerequisite
* Understand Quick Union before this algorithm.

## How it works?
* Implementation is almost same as QuickUnion.
* Difference is we will maintain weight of tree. No of elements in the tree in separate array.

## Algorithm
* While doing union we will
  1. Find root of both elements  i and j.
  2. Get weight of both elements  i and j.
  3. Smaller tree go under bigger tree.
     1. if the weight of i root is smaller than weight of j root then
            1. i root goes under j root.
            2. weight of j root has to be incremented to calculate new weight by summing with weight of i root.
     2. else
         1. j root goes under i root.
         2. weight of i root has to be incremented to calculate new weight by summing with weight of j root.

## Execution

* Tree with size 10
```
            0   1   2   3   4   5   6   7   8   9
Root        0   1   2   3   4   5   6   7   8   9
Weight      1   1   1   1   1   1   1   1   1   1
```

* Union 4 and 3.
* Root of 4 is 4 and Root of 3 is 3.
* Weight of 4 root is 1 and Weight of 3 root is 1
* 4 and 3 has same weight. So connect 3 to 4. So root of 3 is 4. 
* Weight of 4 is 2
```
            0   1   2   3   4   5   6   7   8   9
Root        0   1   2   4   4   5   6   7   8   9
Weight      1   1   1   1   2   1   1   1   1   1
```

```
         4
        /
       3
```

* Union 3 and 8.
* Root of 3 is 4 and Root of 8 is 8.
* Weight of 3 root is 2 and Weight of 8 root is 1
* 8 root weight is smaller than 3 root weight. So connect 8 to root of 3 which is 4. 
* Weight of 4 is 3
```
            0   1   2   3   4   5   6   7   8   9
Root        0   1   2   4   4   5   6   7   4   9
Weight      1   1   1   1   3   1   1   1   1   1
```

```
         4
        / \
       3   8
```

* Union 6 and 5.
* Root of 6 is 6 and Root of 5 is 5.
* Weight of 6 root is 1 and Weight of 5 root is 1
* 6 and 5 has same weight. So connect 5 to 6. So root of 5 is 6.
* Weight of 6 is 2
```
            0   1   2   3   4   5   6   7   8   9
Root        0   1   2   4   4   6   6   7   4   9
Weight      1   1   1   1   3   1   2   1   1   1
```

```
        6
       /
      5

         4
        / \
       3   8
```

* Union 2 and 1.
* Root of 2 is 2 and Root of 1 is 1.
* Weight of 2 root is 1 and Weight of 2 root is 1
* 2 and 1 has same weight. So connect 1 to 2. So root of 1 is 2.
* Weight of 6 is 2
```
            0   1   2   3   4   5   6   7   8   9
Root        0   2   2   4   4   6   6   7   4   9
Weight      1   1   2   1   3   1   2   1   1   1
```

```
        2
       /
      1

        6
       /
      5

         4
        / \
       3   8
```

* Union 9 and 4.
* Root of 9 is 9 and Root of 4 is 4.
* Weight of 9 root is 1 and Weight of 4 root is 3
* 9 root weight is smaller than 4 root weight. So connect 9 to root of 4 which is 4.
* Weight of 4 is 4
```
            0   1   2   3   4   5   6   7   8   9
Root        0   2   2   4   4   6   6   7   4   4
Weight      1   1   2   1   4   1   2   1   1   1
```

```
        2
       /
      1

        6
       /
      5

          4
        / | \
       3  8  9
```

* Union 5 and 0.
* Root of 5 is 6 and Root of 0 is 0.
* Weight of 5 root is 2 and Weight of 0 root is 1
* 0 root weight is smaller than 5 root weight. So connect 0 to root of 5 which is 6.
* Weight of 6 is 3
```
            0   1   2   3   4   5   6   7   8   9
Root        6   2   2   4   4   6   6   7   4   4
Weight      1   1   2   1   4   1   3   1   1   1
```

```
        2
       /
      1

        6
       / \
      5   0

          4
        / | \
       3  8  9
```

* Union 7 and 2.
* Root of 7 is 7 and Root of 2 is 2.
* Weight of 7 root is 1 and Weight of 2 root is 2
* 7 root weight is smaller than 2 root weight. So connect 7 to root of 2 which is 2.
* Weight of 2 is 3
```
            0   1   2   3   4   5   6   7   8   9
Root        6   2   2   4   4   6   6   2   4   4
Weight      1   1   3   1   4   1   3   1   1   1
```

```
        2
       / \
      1   7

        6
       / \
      5   0

          4
        / | \
       3  8  9
```

* Union 6 and 1.
* Root of 6 is 6 and Root of 1 is 2.
* Weight of 6 root is 3 and Weight of 1 root is 3
* 6 root weight is same as 1 root weight. So connect 6 to root of 1 which is 2.
* Weight of 2 is 6
```
            0   1   2   3   4   5   6   7   8   9
Root        6   2   2   4   4   6   6   2   4   4
Weight      1   1   6   1   4   1   3   1   1   1
```

```
         2
       / |  \
      1  7   6
            / \
           5   0

          4
        / | \
       3  8  9
```

* Union 7 and 3.
* Root of 7 is 2 and Root of 3 is 4.
* Weight of 7 root is 6 and Weight of 3 root is 4
* 3 root weight is same as 7 root weight. So connect 4 to root of 7 which is 2.
* Weight of 2 is 10
```
            0   1   2   3   4   5   6   7   8   9
Root        6   2   2   4   4   6   6   2   4   4
Weight      1   1   10  1   4   1   3   1   1   1
```

```
          2
     /  / |  \
   4   1  7   6
 / | \       /  \
3  8  9      5   0

```