package StacksNQueues;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class SetOfStacks extends Stack {

    private int thisStackCtr;
    private int stackCtr;
    private int stackMaxSize;
    private Set<Stack> setOfStacks;

    SetOfStacks(){
        this.setOfStacks = new HashSet<Stack>();
        this.thisStackCtr = 0;
        this.stackCtr = 0;
    }

    public void setSingleStackMaxSize(int size){
        this.stackMaxSize = size;
    }

    public boolean isSetOfStackEmpty(){
        return setOfStacks.isEmpty();
    }

    public void push(int val){

        if(isSetOfStackEmpty()){
            Stack<Integer> stack = new Stack<Integer>();
            stack.push(val);
            setOfStacks.add(stack);
            thisStackCtr++;
        }

        if(thisStackCtr > stackMaxSize){
            thisStackCtr = 0;
            Stack<Integer> stack = new Stack<Integer>();
            stack.push(val);
            thisStackCtr++;
        }
    }
}
