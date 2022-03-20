package Linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songlist;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songlist=new ArrayList<Song>();
    }

    public void addsong(String title,double duration){
         if(findsong(title)==null){
            this.songlist.add(new Song(title,duration));
        }
    }
    private Song findsong(String title){
        for(Song checksong : this.songlist)
        {
            if(checksong.getTitle().equals(title))
                return checksong;
        }
        return null;
    }

public boolean addtoplaylist(int tracknumber , LinkedList<Song> playlist ){
        int index =tracknumber-1;
        if((index>0) && (index<=this.songlist.size())){
            playlist.add(this.songlist.get(index));
            return true;
        }
    System.out.println("there is no tracknumber: "+tracknumber+" in this album");
        return false;
}
    public boolean addtoplaylist(String title , LinkedList<Song> playlist ){
        Song checksong=findsong(title);
        if(checksong!=null){
            playlist.add(checksong);
            return true;
        }
        System.out.println("there is no song with name: "+title+" in this album");
        return false;
    }


}
