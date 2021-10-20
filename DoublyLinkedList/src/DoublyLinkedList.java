public class DoublyLinkedList {

    // Representation of a node
    class Node{
        int data;
        Node previous;
        Node next;

        // Constructor
        public Node(int data){
            this.data = data;
        }
    }

    // Represent the head and tail of the doubly linked list
    Node head, tail = null;

    //addNode() will add a new node to the doubly linked list
    public void addNode(int data){
        // Create a new node
        Node newNode = new Node(data);

        // if list is empty
        if (head == null){
            // Both head and tail will point to newNode
            head = tail = newNode;
            // head's previous will point to null cuz it is the first node of the list
            head.previous = null;
            // tail's next will point to null, as it is the last node of the list
            tail.next = null;
        }else{
            // newNode will be added after tail such that tail's next will point to newNode
            tail.next = newNode;
            // newNode's previous will point to tail
            newNode.previous = tail;
            // Update newNode to be the new tail of the list
            tail = newNode;
            // As it is the new tail, tail's next will point to null
            tail.next = null;
        }
    }

    //display() will display all the nodes in the doubly linked list
    public void display(){
        // First lets create a node current that will point to the node head
        Node current = head;

        if(current == null){
            System.out.println("The list is empty");
            return;
        }
        System.out.println("The nodes of the doubly linked list are: ");
        while(current != null){
            System.out.print(current.data +" ");
            current = current.next;
        }
        if(current == null)
            System.out.print("null\n");
    }

    public boolean SearchDLL(int element){
        Node P = head;
        Node Q = tail;
        boolean sw = false;
        boolean sw1 = false;

        while(sw == false && sw1 == false){
            if (P.data == element || Q.data == element){
                sw = true;
                System.out.println("Element found");
                return true;
            }else{
                if (P.next == Q){
                    sw1 = true;
                    System.out.println("Element NOT found");
                    return false;
                }else{
                    P = P.next;
                    Q = Q.previous;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        DoublyLinkedList dList = new DoublyLinkedList();
        dList.addNode(1);
        dList.addNode(2);
        dList.addNode(3);
        dList.addNode(4);
        dList.display();
        dList.SearchDLL(0);
    }
}
