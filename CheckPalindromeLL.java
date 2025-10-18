public class CheckPalindromeLL {
    Node head;
    class Node{
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    //add first last
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return;
        }

        Node currNode = head;
        while(currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }
    public void printList() {
        Node currNode = head;
        while(currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("Null");
    }
    public void deleteFirst() {
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next;
    }
    public void deleteLast() {
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        if(head.next == null) {
            head = null;
            return;
        }
        Node prevNode = head;
        Node currNode = head.next;
        while(currNode.next != null) {
            prevNode = currNode;
            currNode = currNode.next;
        }
        prevNode.next = null;
    }
    public Node reverseList(Node head) {
        Node prev = head; 
        Node curr = head.next;
        while(curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head.next = null;
        return prev;
    }
    public Node checkMid(Node head) {
        Node hare = head;
        Node turtle = head;

        while(hare.next != null && hare.next.next != null) {
            turtle = turtle.next;
            hare = hare.next.next;
        }

        return turtle;
    }

    public Boolean checkPali() {
        if(head == null && head.next == null) {
            return true;
        }

        Node middle = checkMid(head);
        Node secondHead = reverseList(middle.next);
        Node firstHead = head;

        while(secondHead != null) {
            if(firstHead.data != secondHead.data) {
                return false;
            }
            firstHead = firstHead.next;
            secondHead = secondHead.next;
        }

        return true;
    }

    public static void main(String args[]) {
        CheckPalindromeLL list = new CheckPalindromeLL();
        list.addFirst(1);
        list.addLast(3);
        list.addLast(3);
        list.addLast(3);
        list.addLast(1);
        

        list.printList();

        if(list.checkPali())
        System.out.print("Palindrome");
        else
        System.out.print("Not Palindrome");
    }
}
