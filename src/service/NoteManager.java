package service;
import Model.Note;
import java.util.ArrayList;
import java.util.HashMap;

public class NoteManager{
    private ArrayList<Note> notes = new ArrayList<>();

    public void addNote(Note note){
        notes.add(note);
    }

    public void printAllNotes(){
        if (notes.isEmpty()) {
            System.out.println("Nav nevienas piezimes");
            return;
        }

        for (Note n : notes){
            n.print();
        }
    }

    public void search(String keyword){
        boolean found = false;

        for (Note n: notes){
            if(n.getTitle().toLowerCase().contains(keyword.toLowerCase())||

            n.getContent().toLowerCase().contains(keyword.toLowerCase())){

                 n.print();
                 found = true;
            }
        }

        if(!found){
            System.out.println("Nekas netika atrasts.");
        }
    }

    public void groupByCategory(){
        HashMap<String, ArrayList<Note>> map = new HashMap<>();

        for(Note n : notes){
            map.putIfAbsent(n.getCategory(), new ArrayList<>());
            map.get(n.getCategory()).add(n);
        }
        for(String category : map.keySet()){
            System.out.println("\nKategorija:" + category);
            for(Note n : map.get(category)){
                n.print();
            }
        }
    }
}