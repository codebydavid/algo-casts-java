package me.codebydavid.algocasts;

// --- Directions
// Implement a Queue datastructure using two stacks.
// *Do not* create an array inside of the 'Queue' class.
// Queue should implement the methods 'add', 'remove', and 'peek'.
// For a reminder on what each method does, look back
// at the Queue exercise.
// --- Examples
//     const q = new Queue();
//     q.add(1);
//     q.add(2);
//     q.peek();  // returns 1
//     q.remove(); // returns 1
//     q.remove(); // returns 2
public class QueueFromStack {

    private Stack data;

    public QueueFromStack() {
        this.data = new Stack();
    }

    public void add(Object record) {
        this.data.push(record);
    }

    public Object remove() {
        Stack temp = new Stack();
        while (this.data.peek() != null) {
            temp.push(this.data.pop());
        }
        Object record = temp.pop();
        while (temp.peek() != null) {
            this.data.push(temp.pop());
        }
        return record;
    }

    public Object peek() {
        Stack temp = new Stack();
        while (this.data.peek() != null) {
            temp.push(this.data.pop());
        }
        Object record = temp.peek();
        while (temp.peek() != null) {
            this.data.push(temp.pop());
        }
        return record;
    }
}