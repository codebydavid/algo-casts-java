package me.codebydavid.algocasts;

import java.util.ArrayList;
import java.util.List;

// --- Directions
// Create a stack data structure.  The stack
// should be a class with methods 'push', 'pop', and
// 'peek'.  Adding an element to the stack should
// store it until it is removed.
// --- Examples
//   const s = new Stack();
//   s.push(1);
//   s.push(2);
//   s.pop(); // returns 2
//   s.pop(); // returns 1
public class Stack {

    private List<Object> data;

    public Stack() {
        this.data = new ArrayList<Object>();
    }

    public void push(Object record) {
        this.data.add(record);
    }

    public Object pop() {
        return this.data.size() > 0 ? 
            this.data.remove(this.data.size() - 1) : null;
    }

    public Object peek() {
        return this.data.size() > 0 ? 
            this.data.get(this.data.size() - 1) : null;
    }
    
}