import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        CircularLinkedList playerList = new CircularLinkedList();
        Random random = new Random();
        int names = 0;
        System.out.println("How many players:");
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();
        try (Scanner scanner = new Scanner(new File("src/names.txt"))) {
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                names++;
            }
        } catch (FileNotFoundException e) {
            System.err.println("Dosya bulunamadı.");
            return;
        }
        for (int j = 0 ; j < N ; j++) {
            if (names > 0) {
                int randomLine = random.nextInt(names);
                try (Scanner scanner = new Scanner(new File("src/names.txt"))) {
                    for (int i = 0; i <= randomLine; i++) {
                        String line = scanner.nextLine();
                        if (i == randomLine) {
                            playerList.add(line);
                        }
                    }

                } catch (FileNotFoundException e) {
                    System.err.println("File not found.");
                }
            }
        }

            while (playerList.countPlayers() > 1) {
                int k = random.nextInt(playerList.countPlayers()) + 1;
                playerList.display();

                NameNode current = playerList.head;
                for (int i = 0; i < k - 1; i++) {
                    current = current.next;
                }

                System.out.println("Seçilen k: -------->" + k);
                System.out.println("Their name is------> "+current.name);
                if (current.characterList.isEmpty()) {
                    System.out.println(current.name + " kaybetti!");
                    playerList.remove(current);
                } else {

                    current.characterList.removeLastCharacter();
                    System.out.print(current.name + " bir harf kaybetti ");
                    System.out.println();
                }
            }


            System.out.println("Kazanan: " + playerList.head.name);
        }
    }

