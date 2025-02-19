package com.example.myapplication3;

public class Path { //linked list (Path)
    private int pathNum = 0; // 선택시만 DB에서 마지막 넘버 가져와서 +1로 설정
    private String recdate; //recommend date
    private Node head; // start brand Node
    private Node tail; // end brand Node
    private int pathsize = 0; //path size = brand num

    private class Node {

        private Object brandname;
        private Node next;


        public Node(Object input) {
            this.brandname = input;
            this.next = null;
        }

        //print brand name
        public String toString() {
            return String.valueOf(this.brandname);
        }

    }//node class end


    public void addFirst(Object input) {
        // generate node
        Node newNode = new Node(input);

        newNode.next = head;

        head = newNode;

        pathsize++;
        // first node = last node
        if (head.next == null) {
            tail = head;
        }
    }

    public void addBrandLast(Object input){
            Node newNode = new Node(input);
            if(pathsize == 0){
                addFirst(input);
            } else {
                tail.next = newNode;
                tail = newNode;
                pathsize++;
            }
        }
//print
    public String toString() {
        if(head == null){
            return "[]";
        }
        Node temp = head;
        String str = "[";
        while(temp.next != null){
            str += temp.brandname + ",";
            temp = temp.next;
        }
        str += temp.brandname;
        return str+"]";
    }


    public String getRecdate() {
        return String.valueOf(this.recdate);

    }

    public int getPathsize() {

        return this.pathsize;

    }

    public void setPathNum(int pathNum){
        this.pathNum = pathNum;
    }



    public Path(String recdate) {
        this.recdate = recdate;
    }
}//path class end



