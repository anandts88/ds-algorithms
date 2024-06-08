# Dijiktra's Two Stack Algorithm

* Evaluate arithmetic expression

```
(1 + (( 2 + 3 ) * (4 * 3)))
```

## Algorithm

1. Create Stack 1 = Value Stack
2. Create Stack 2 = Operator Stack
3. If left parenthesis ignore.
4. If value push to value stack
5. If operator push to operator stack
6. If right parenthesis 
   1. pop last two values from value stack.
   2. pop last operator from operator stack.
   3. now apply operator between 2nd popped element with 1st popped element
   4. push the result into value stack.

## Execution

* Ignore left parenthesis.
```
(1 + (( 2 + 3 ) * (4 * 3)))
^
```
```
Value Stack 

Operator Stack
```
* push value 1 to value stack

```
(1 + (( 2 + 3 ) * (4 * 3)))
 ^
```
```
Value Stack 
1

Operator Stack

```

* push operator + to operator stack

```
(1 + (( 2 + 3 ) * (4 * 3)))
   ^
```
```
Value Stack 
1

Operator Stack
+

```
* ignore left parenthesis

```
(1 + (( 2 + 3 ) * (4 * 3)))
     ^
```
```
Value Stack 
1

Operator Stack
+

```
* ignore left parenthesis

```
(1 + (( 2 + 3 ) * (4 * 3)))
      ^
```
```
Value Stack 
1

Operator Stack
+

```
* push value 2 to value stack

```
(1 + (( 2 + 3 ) * (4 * 3)))
        ^
```
```
Value Stack 
1   2

Operator Stack
+

```

* push operator + to operator stack

```
(1 + (( 2 + 3 ) * (4 * 3)))
          ^
```
```
Value Stack 
1   2

Operator Stack
+   +

```

* push value 3 to value stack

```
(1 + (( 2 + 3 ) * (4 * 3)))
            ^
```
```
Value Stack 
1   2   3

Operator Stack
+

```

* Right parenthesis.
* pop last 2 value from value stack, which is 3 and 2.
* pop last operator from operator stack, which is +
* now apply operator between 2nd poped element (2) with 1st poped element (3)
* 2 + 3 = 5
* Push result 5 into value stack

```
(1 + (( 2 + 3 ) * (4 * 3)))
              ^
```
```
Value Stack 
1   5

Operator Stack
+

```

* Push operator * to operator stack

```
(1 + (( 2 + 3 ) * (4 * 3)))
                ^
```
```
Value Stack 
1   5

Operator Stack
+   *

```

* Ignore left parenthesis

```
(1 + (( 2 + 3 ) * (4 * 3)))
                  ^
```
```
Value Stack 
1   5

Operator Stack
+   *

```

* Push operator * to operator stack

```
(1 + (( 2 + 3 ) * (4 * 3)))
                     ^
```
```
Value Stack 
1   5   4

Operator Stack
+  *  *

```

* Push value 3 to value stack

```
(1 + (( 2 + 3 ) * (4 * 3)))
                       ^
```
```
Value Stack 
1   5   4   3

Operator Stack
+  *  *

```

* Right parenthesis.
* pop last 2 value from value stack, which is 4 and 3.
* pop last operator from operator stack, which is *
* now apply operator between 2nd poped element (4) with 1st poped element (3)
* 4 * 3 = 12
* Push result 12 into value stack


```
(1 + (( 2 + 3 ) * (4 * 3)))
                        ^
```
```
Value Stack 
1   5   12

Operator Stack
+   *
```

* Right parenthesis.
* pop last 2 value from value stack, which is 5 and 12.
* pop last operator from operator stack, which is *
* now apply operator between 2nd poped element (5) with 1st poped element (12)
* 5 * 12 = 60
* Push result 60 into value stack


```
(1 + (( 2 + 3 ) * (4 * 3)))
                         ^
```
```
Value Stack 
1   60

Operator Stack
+
```

* Right parenthesis.
* pop last 2 value from value stack, which is 1 and 60.
* pop last operator from operator stack, which is *
* now apply operator between 2nd poped element (1) with 1st poped element (60)
* 1 + 60 = 61
* Push result 61 into value stack


```
(1 + (( 2 + 3 ) * (4 * 3)))
                          ^
```
```
Value Stack 
61

Operator Stack

```
* Finally pop last element of stack 61

```
Result is 61

Value Stack 

Operator Stack

```



