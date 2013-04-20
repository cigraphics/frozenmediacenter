package net.frozenlogic.mediacenter.impl.plugins.picasa;

import com.google.gdata.client.http.AuthSubUtil;
import com.google.gdata.client.photos.PicasawebService;
import com.google.gdata.data.media.mediarss.MediaThumbnail;
import com.google.gdata.data.photos.AlbumFeed;
import com.google.gdata.data.photos.PhotoEntry;
import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ServiceException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

class PicasaClient {
    private String apiKey = "AIzaSyDhbUOu5nBkp0AbDltKuU0Y0puo4DQ0eiE";
    private static String sessionToken = null;
    PicasawebService picasawebService = new PicasawebService("MediaCenter");

    private void authenticate() throws GeneralSecurityException, IOException, AuthenticationException {
        String url = "http://localhost:8080/gapitoken";
        String scope = "https://picasaweb.google.com/data/";

        String singleUseToken = AuthSubUtil.getRequestUrl(url, scope, false, true);

        sessionToken = AuthSubUtil.exchangeForSessionToken(singleUseToken, null);
        picasawebService.setAuthSubToken(sessionToken, null);
    }

    public List<Album> getAlbums(String user) throws PicasaClientException {
        try {
            this.authenticate();
        } catch (Exception ex) {
            throw new PicasaClientException(ex);
        }
        String uri = "https://picasaweb.google.com/data/feed/api/user/" + user + "/albumid/default";
        URL feedUrl;
        List<Album> albumList = new ArrayList<Album>();
        try {
            feedUrl = new URL(uri);
            AlbumFeed feed = picasawebService.getFeed(feedUrl, AlbumFeed.class);

            Album album = new Album();

            for (PhotoEntry photoEntry : feed.getPhotoEntries()) {
                Photo photo = new Photo();

                photo.setTitle(photoEntry.getTitle().getPlainText());
                photo.setDescription(photoEntry.getDescription().getPlainText());

                List<MediaThumbnail> mediaThumbnails = photoEntry.getMediaThumbnails();

                if (mediaThumbnails.size() > 0) {
                    photo.setPhotoThumbnail(photoEntry.getMediaThumbnails().get(0).getUrl());
                    photo.setPhotoContent(photoEntry.getMediaContents().get(0).getUrl());
                }

                album.getPhotoList().add(photo);
            }

            if (album.getPhotoList().size() > 0) {
                album.setCover(album.getPhotoList().get(0));
            }

            albumList.add(album);

            return albumList;
        } catch (Exception ex) {
            throw new PicasaClientException(ex);
        }
    }
}
