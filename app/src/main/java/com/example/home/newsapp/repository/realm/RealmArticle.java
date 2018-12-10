//package com.example.home.newsapp.repository.realm;
//
//import io.realm.RealmList;
//import io.realm.RealmObject;
//import io.realm.annotations.PrimaryKey;
//
///**
// * Created by SopheC on 27/02/2018
// */
//
//public class RealmArticle extends RealmObject {
//
//    @PrimaryKey
//    private int id;
//
//    private String albumImg;
//    private String artistName;
//    private String albumTitle;
//    private String year;
//    private RealmList<RealmSong> songsList;
//
//    public RealmAlbum(){
//
//    }
//
//    public RealmAlbum(RealmAlbum realmAlbum){
//
//        this.id = realmAlbum.getId();
//        this.albumImg = realmAlbum.getAlbumImg();
//        this.artistName = realmAlbum.getArtistName();
//        this.albumTitle = realmAlbum.getAlbumTitle();
//        this.year = realmAlbum.getYear();
//        this.songsList = realmAlbum.getSongsList();
//
//    }
//
//    public RealmAlbum(int id, String albumImg, String artistName, String albumTitle, String year, RealmList<RealmSong> songsList){
//
//        this.id = id;
//        this.albumImg = albumImg;
//        this.artistName = artistName;
//        this.albumTitle = albumTitle;
//        this.year = year;
//        this.songsList = songsList;
//    }
//
//
//    public int getId() {
//        return id;
//    }
//
//    public String getAlbumImg() {
//        return albumImg;
//    }
//
//    public String getArtistName() {
//        return artistName;
//    }
//
//    public String getAlbumTitle() {
//        return albumTitle;
//    }
//
//    public String getYear() {
//        return year;
//    }
//
//    public RealmList<RealmSong> getSongsList() {
//        return songsList;
//    }
//}
