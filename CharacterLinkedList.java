class CharacterLinkedList {
    CharacterNode head;

    public void addCharacter(char c) {
        CharacterNode newNode = new CharacterNode(c);
        if (head == null) {
            head = newNode;
        } else {
            CharacterNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void removeLastCharacter() {
        if (head == null)
            return;
        if (head.next == null) {
            head = null;
            return;
        }

        CharacterNode current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void display() {
        CharacterNode current = head;
        while (current != null) {
            System.out.print(current.character+"-");
            current = current.next;
        }
    }
}
