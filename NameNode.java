class NameNode {
    String name;
    CharacterLinkedList characterList;
    NameNode next;

    NameNode(String name) {
        this.name = name;
        this.characterList = new CharacterLinkedList();
        for (int i = 0; i < name.length(); i++) {
            this.characterList.addCharacter(name.charAt(i));
        }
        this.next = null;
    }
}