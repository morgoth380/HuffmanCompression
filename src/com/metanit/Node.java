package com.metanit;

public class Node {
    private Node leftChildNode = null; //ссылка на левый узел
    private Node rightChildNode = null; //ссылка на правый узел
    private Node parrentNode = null; //ссылка на родительский узел. Зачем?
    private int weight;      //вес узла
    private String nodeName; //уникальное имя узла

    public int getWeight() {
        return weight;
    }

    public Node(String nodeName) {
        this.nodeName = nodeName;
    }

    public Node(int weight) {
        this.weight = weight;
    }

    public Node getRightChildNode() {
        return rightChildNode;
    }

    public Node getLeftChildNode() {
        return leftChildNode;
    }

    public String getNodeName() {
        return nodeName;
    }

    public Node(String nodeName, int weight) {
        this.weight = weight;
        this.nodeName = nodeName;
    }
    public void setParrentNode(Node parrentNode) {
        this.parrentNode = parrentNode;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public void setRightChildNode(Node rightChildNode) {
        this.rightChildNode = rightChildNode;
    }

    public void setLeftChildNode(Node leftChildNode) {
        this.leftChildNode = leftChildNode;
    }
}
