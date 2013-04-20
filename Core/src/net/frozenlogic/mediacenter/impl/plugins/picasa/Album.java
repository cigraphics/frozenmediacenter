package net.frozenlogic.mediacenter.impl.plugins.picasa;

import java.util.ArrayList;
import java.util.List;

public class Album {
    private String idAlbum;
    private List<Photo> photoList = new ArrayList<Photo>();
    private Photo cover;

    public String getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(String idAlbum) {
        this.idAlbum = idAlbum;
    }

    public Photo getCover() {
        return cover;
    }

    public void setCover(Photo cover) {
        this.cover = cover;
    }

    public List<Photo> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<Photo> photoList) {
        this.photoList = photoList;
    }
}
