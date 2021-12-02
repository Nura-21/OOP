class Node {
    int val; 
    Node next; 
    Node(int x) {
        val = x;
    }
}

class CustomLinkedList {
    Node head;
    public void insert(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
        }else {
            Node n = head;
            while(n.next != null) {
                n = n.next;
            }
            n.next = newNode;
        }
    }

    //function to add an element at the start of the list
    public void insertAtStart(int data) {
        Node newNode = new Node(data);

        newNode.next = head;
        head = newNode;
    }

    //function to add an element at a given index
    public void insertAt(int index, int data) {
        if(index == 0){
            insertAtStart(data); //We already have a function to do this.
        }else{
            Node newNode = new Node(data);

            Node currentNode = head;
            for(int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }
    }

    //function to delete an element at the given index
    public void deleteAt(int index) {
        if(index == 0) {
            head = head.next;
        }else{
            Node currentNode = head;
            for(int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }
            currentNode.next = currentNode.next.next;
        }
    }

    //function to show the list
    public void show() {
        Node currentNode = head;
        if(currentNode == null){
            System.out.println("Linked list is empty");
        }
        else {
            while(currentNode != null) {
                System.out.print(currentNode.val + " ");
                currentNode = currentNode.next;
            }
        }
    }
}

public class LL {
    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();
        list.insert(12); //12
        list.insertAtStart(191); //191 12 43
        list.insertAt(2, 2222); //191 12 2222 43
        list.deleteAt(2); //191 12 43
        list.show();
    }
}
