package CCI.StacksNQueues;

public class CCI_3_5 {
}


/*
* Implement a MyQueue class which implements a queue using two stacks.
* */

/*
* Use two stacks s1, s2
* for push:
*   push everything to s1
* for pop:
*   if s2 is empty:
*       pop everything from s1 to s2
*       pop top element and return
*   else:
*       just return the top element
*
* */