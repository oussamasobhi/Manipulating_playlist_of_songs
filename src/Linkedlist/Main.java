package Linkedlist;

import java.util.*;

public class Main {
         private static ArrayList<Album> albums=new ArrayList<Album>();
    public static void main(String[] args) {
        Album album=new Album("cameleon","toto");
        album.addsong("la vie",3.02);
        album.addsong("l'amour",2.50);

        albums.add(album);

        Album album2=new Album("wow","7liwa");
        album2.addsong("yay",2.60);
        album2.addsong("lili",3.40);
        albums.add(album2);

        LinkedList<Song> playlist=new LinkedList<Song>();
        albums.get(0).addtoplaylist("la vie",playlist);
        albums.get(1).addtoplaylist("yay",playlist);
     play(playlist);

    }
    private static void play(LinkedList<Song> playlist){
        printmenu();
        Scanner sc=new Scanner(System.in);
        boolean quit=false;
        boolean forward=true;
        ListIterator<Song> listIterator=playlist.listIterator();
        if(playlist.size()==0)
            System.out.println("no songs in playlist");
        else
        {
            System.out.println("now playing "+listIterator.next().toString());
        }
        while(!quit){
            int action=sc.nextInt();
            sc.nextLine();

            switch(action){
                case 0:
                    System.out.println("playlist complete");
                    quit=true;
                    break;
                case 1:
                    if(!forward){
                           if(listIterator.hasNext())
                               listIterator.next();
                           forward=true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("now playing "+listIterator.next().toString());
                    }
                    else {
                        System.out.println("we have reached the end of playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward){
                        if(listIterator.hasPrevious())
                            listIterator.previous();

                        forward=false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("now playing "+listIterator.previous().toString());
                    }
                    else {
                        System.out.println("we have reached the bottom ");
                    }
                    break;
                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("now replaying "+listIterator.previous().toString());
                            forward=false;
                        }
                        else
                            System.out.println("we are at the start");
                    }
                    else
                    {
                        if(listIterator.hasNext()){
                            System.out.println("now replaying "+listIterator.next().toString());
                            forward=true;
                        }
                        else{
                            System.out.println("we reached the last song");
                        }
                    }
                    break;
                case 4:
                    printlist(playlist);
                    break;
                case 5:
                    printmenu();
                    break;
                case 6:
                    if(playlist.size()>0)
                    listIterator.remove();
                    if(listIterator.hasNext())
                        System.out.println("now playing "+listIterator.next());
                    else if(listIterator.hasPrevious())
                        System.out.println("now playing "+listIterator.previous());
                    else
                        System.out.println("there is no songs left");
            }
        }
    }
    private static void printmenu(){
        System.out.println("available actions: ");
        System.out.println("0-to quit \n"+"1-to play next song\n"+"2-to play previous song\n "+"3-to replay the current song\n"+"4-list songs in the playlist\n"+"5-print available actions\n"+"6-delete the current song");
    }
    private static void printlist(LinkedList<Song> ls){
        Iterator<Song> iterator= ls.iterator();
        System.out.println("=================================");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("=================================");
    }
}
