import java.util.Scanner;

import Model.Note;
import service.NoteManager;
import util.Validator;

public class Main {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("======================");
        System.out.println("   PIEZĪMJU SISTĒMA   ");
        System.out.println("**********************");

        if(!login(scanner)) return;

        NoteManager manager = new NoteManager();

        while (true) {
            System.out.println("Izvēlne:");
            System.out.println("1 - Pievienot piezīmi");
            System.out.println("2 - Apskatīt visas piezīmes");
            System.out.println("3 - Meklēt piezīmes");
            System.out.println("4 - Iziet");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addNote(scanner, manager);
                    break;
                case "2":
                    manager.printAllNotes();
                    break;
                case "3":
                    System.out.println("Ievadiet meklējamo tekstu");
                    String keyword = scanner.nextLine();
                    manager.search(keyword);
                    break;
                case "4":
                    System.out.println("Programma beidzas");
                    return;
                default:
                    System.out.println("Nepareiza izvēle");
            }
        }
    }
    private static boolean login(Scanner scanner) {
        String USER = "admin";
        String PASS = "1234";

        System.out.print("Lietotajvārds: ");
        String user = scanner.nextLine();

        System.out.print("Parole: ");
        String pass = scanner.nextLine();

        if (!user.equals(USER) || !pass.equals(PASS)){
            System.out.println("Nepareizi dati");
            return false;
        }
        System.out.println("Veiksmīga pieslēgšanās");
        return true;
    }
    private static void addNote(Scanner scanner, NoteManager manager){
        System.out.println("Nosaukums:");
        String title = scanner.nextLine();

        if (!Validator.notEmpty(title)) return;

        System.out.println("Kategorija:");
        String category = scanner.nextLine();

        System.out.println("Saturs:");
        String content = scanner.nextLine();

        Note note = new Note(title, category, content);
        manager.addNote(note);

        System.out.println("Piezīme pievienota");
    }
}