package com.bridgelabz.test;



class MyNode<T>{
    T data;
    MyNode<T> next;

    public MyNode(T data) {
        this.data = data;
        this.next = null;
    }
    public MyNode(T data, MyNode<T> next) {
        this.data = data;
        this.next = next;
    }
}
class Queue<T>{
    private MyNode<T> front;
    private MyNode<T> rear;

    public Queue() {
        this.front = null;
        this.rear = null;
    }

    public void enqueueElement(T data){
        MyNode<T> newNode = new MyNode<>(data);
        if(isEmpty()){
            front = newNode;
            rear = newNode;
        }
        else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    boolean isEmpty() {
        return front == null && rear == null;
    }

    public void displayElement(){
        MyNode<T> node = front;
        while(node != null){
            System.out.print(node.data + " - ");
            node = node.next;
        }
        System.out.println("End");
    }



}
class Stack<T>{
    private MyNode<T> top;

    public Stack(){
        this.top = null;
    }

    public void pushElement(T data){
        MyNode<T> newNode = new MyNode<>(data);
        if (top == null){
            top = newNode;
        }
        else{
            newNode.next = top;
            top = newNode;
        }
    }
    public T peek(){
        if (isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        return top.data;
    }

    public T pop(){
        if (isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        T data = top.data;
        top = top.next;
        return data;
    }
    boolean isEmpty() {
        return top == null;
    }

    public void displayElement(){
        MyNode<T> temp = top;
        while(temp != null){
            System.out.print(temp.data + " - ");
            temp = temp.next;
        }
        System.out.println("End");
    }





}



public class CustomPush {
    public static void main(String[] args) {
        Stack <Integer> integerList = new Stack<>();
        integerList.pushElement(70);
        integerList.pushElement(30);
        integerList.pushElement(56);
        System.out.println("Displaying Stack: ");
        integerList.displayElement();

        while (!integerList.isEmpty()){
            System.out.println("Peek: " + integerList.peek());
            System.out.println("Pop: " + integerList.pop());
            integerList.displayElement();

        }

        Queue <Integer> integerQueue = new Queue<>();
        integerQueue.enqueueElement(56);
        integerQueue.enqueueElement(30);
        integerQueue.enqueueElement(70);
        System.out.println("Displaying Queue: ");
        integerQueue.displayElement();


    }
}
