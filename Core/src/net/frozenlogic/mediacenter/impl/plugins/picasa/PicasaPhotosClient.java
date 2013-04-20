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
import java.util.ArrayList;
import java.util.List;

class PicasaPhotosClient {
        private String apiKey = "AIzaSyDhbUOu5nBkp0AbDltKuU0Y0puo4DQ0eiE";
        private static String sessionToken = null;
        PicasawebService picasawebService = new PicasawebService("MediaCenter");

    private void authenticate(){
        String url = "http://localhost:8080/gapitoken";
        String scope = "https://picasaweb.google.com/data/";

        String subUrl = AuthSubUtil.getRequestUrl(url, scope, false, true);

    }

    private  void authenticate(String singleUseToken) throws GeneralSecurityException, IOException, AuthenticationException {
        sessionToken = AuthSubUtil.exchangeForSessionToken(singleUseToken, null);
        picasawebService.setAuthSubToken(sessionToken, null);
    }

    public List<Photo> getAlbum(String user) throws PicasaPhotosClientException {
        String uri = "https://picasaweb.google.com/data/feed/api/user/" + user + "/albumid/default";
        URL feedUrl;
        try{
            feedUrl = new URL(uri);
            AlbumFeed feed = picasawebService.getFeed(feedUrl, AlbumFeed.class);

            List<Photo> album = new ArrayList<Photo>();

            for (PhotoEntry photoEntry : feed.getPhotoEntries()){
                Photo photo = new Photo();

                photo.setTitle(photoEntry.getTitle().getPlainText());
                photo.setDescription(photoEntry.getDescription().getPlainText());

                List<MediaThumbnail> mediaThumbnails = photoEntry.getMediaThumbnails();
                if (mediaThumbnails.size() > 0){
                    photo.setPhotoThumbnail(photoEntry.getMediaThumbnails().get(0).getUrl());
                    photo.setPhotoContent(photoEntry.getMediaContents().get(0).getUrl());
                }

                album.add(photo);
            }
            return album;
        }

        catch (MalformedURLException ex){
            throw new PicasaPhotosClientException(ex);
        } catch (ServiceException ex) {
            throw new PicasaPhotosClientException(ex);
        } catch (IOException ex) {
            throw new PicasaPhotosClientException(ex);
        }
    }
}
