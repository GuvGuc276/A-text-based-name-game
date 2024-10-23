class CircularLinkedList {
    NameNode head;

    public void add(String name) {
        NameNode newNode = new NameNode(name);
        if (head == null) {
            head = newNode;
            newNode.next = newNode;
        } else {
            NameNode temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
    }

    public void display() {
        if (head == null)
            return;
        NameNode current = head;
        do {
            System.out.print(current.name + "---");
            current = current.next;
        } while (current != head);
        System.out.println();
    }

    public NameNode remove(NameNode node) {
        if (head == null) return null;
        NameNode current = head;
        if (head == node) {
            if (head.next == head) {
                head = null;
            } else {

                NameNode tail = head;
                while (tail.next != head) {
                    tail = tail.next;
                }
                head = head.next;
                tail.next = head;
            }
            return node;
        }
        while (current.next != head) {
            if (current.next == node) {

                current.next = current.next.next;
                return node;
            }
            current = current.next;
        }

        return null;
    }

    public int countPlayers() {
        if (head == null) return 0;

        int count = 0;
        NameNode current = head;
        do {
            count++;
            current = current.next;
        } while (current != head);
        return count;
    }
}

