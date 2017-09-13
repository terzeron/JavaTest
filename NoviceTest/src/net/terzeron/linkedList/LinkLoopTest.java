package net.terzeron.linkedList;

/**
 * Created by terzeron on 2016. 11. 14..
 */
public class LinkLoopTest {
    public static void main(String[] args) {
        Node root = new Node(0);
        Node node1 = new Node(1);
        root.setNext(node1);
        Node node2 = new Node(2);
        node1.setNext(node2);
        Node node3 = new Node(3);
        node2.setNext(node3);
        Node node4 = new Node(4);
        node3.setNext(node4);
        Node node5 = new Node(5);
        node4.setNext(node5);
        Node node6 = new Node(6);
        node5.setNext(node6);
        Node node7 = new Node(7);
        node6.setNext(node7);
        Node node8 = new Node(8);
        node7.setNext(node8);
        node8.setNext(root);

        boolean ret = hasLoop2(root);
        System.out.println("ret=" + ret);
    }

    static boolean hasLoop(Node startNode) {
        Node currentNode = startNode;
        Node checkNode = null;
        int since = 0;
        int sinceScale = 2;
        do {
            System.out.println("\nsince=" + since + ", sinceScale=" + sinceScale);
            System.out.println("currentNode=" + currentNode + ", checkNode=" + checkNode);

            if (checkNode == currentNode) {
                System.out.println("checkNode 일치, return true");
                return true;
            }
            if (since >= sinceScale) {
                System.out.println("since가 scale만큼 커졌음, 체크하고, since 초기화, scale 2배");
                checkNode = currentNode;
                since = 0;
                sinceScale = 2 * sinceScale;
            }
            since++;
        } while ((currentNode = currentNode.next()) != null);
        return false;
    }

    static boolean hasLoop2(Node startNode) {
        Node previousNode = null;
        Node currentNode = startNode;
        Node nextNode = null;
        if (currentNode.next() == null) {
            System.out.println("no next, 루프아님");
            return false;
        }
        while (currentNode != null) {
            System.out.println("\nprevNode=" + previousNode + ", currentNode=" + currentNode + ", currentNode.next=" + currentNode.next() + ", nextNode=" + nextNode);
            nextNode = currentNode.next();
            currentNode.setNext(previousNode);
            previousNode = currentNode;
            currentNode = nextNode;
            System.out.println("prevNode=" + previousNode + ", currentNode=" + currentNode + ", currentNode.next=" + currentNode.next() + ", nextNode=" + nextNode);
        }

        return (previousNode == startNode);
    }
}
