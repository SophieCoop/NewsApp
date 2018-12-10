package com.example.home.newsapp.repository;

import android.content.Context;


public class LocalData {

    private Context context;

    public LocalData(Context context){

        this.context = context;
    }


//    public Completable saveAlbumRx(ArticleModel album) {
//        return Completable.fromAction(() -> saveAlbum(album))
//                .subscribeOn(Schedulers.io());
//    }
//
//    private void saveAlbum(ArticleModel album) {
//
//        Realm realmObj = Realm.getDefaultInstance();
//        realmObj.executeTransaction(realm -> {
//
//            RealmList<RealmSong> realmSongList = new RealmList<>();
//            for (SongModel song : album.getSongsList().getSongsList()) {
//                realmSongList.add(new RealmSong(song.getSongId(), song.getSongtitle(), song.getSongLyrics()));
//            }
//
//            RealmAlbum realmAlbum = new RealmAlbum(album.getAlbumId(), album.getAlbumImage(), album.getArtistName(),
//                    album.getAlbumTitle(), album.getYearPublished(),
//                    realmSongList);
//
//            realm.copyToRealmOrUpdate(realmAlbum);
//
//        });
//
//
//        realmObj.close();
//    }




}
