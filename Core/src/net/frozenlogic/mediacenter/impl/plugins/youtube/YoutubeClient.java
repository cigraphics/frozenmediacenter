package net.frozenlogic.mediacenter.impl.plugins.youtube;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.ResourceId;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;
import com.google.api.services.youtube.model.Thumbnail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class YoutubeClient {

    private String apiKey = "AIzaSyCAW5u0j2pz6RoavNbTYTsbn-VqWFLR0uk";
    private String baseUri = "https://www.googleapis.com/youtube/v3";

    private YouTube createYouTube() {
        YouTube youTube = new YouTube.Builder(new NetHttpTransport(), new JacksonFactory(), new HttpRequestInitializer() {
            @Override
            public void initialize(HttpRequest request) throws IOException {
            }
        }).setApplicationName("Frozen MediaCenter").build();

        return youTube;
    }

    public List<YouTubeVideo> search(String keyword) throws YouTubeClientException {
        YouTube youTube = this.createYouTube();
        YouTube.Search.List search;
        try {
            search = youTube.search().list("id,snippet");
        } catch (IOException ex) {
            throw new YouTubeClientException(ex);
        }
        search.setKey(this.apiKey);
        search.setQ(keyword);
        search.setType("video");

        search.setFields("items(id/videoId,snippet/title,snippet/thumbnails/default/url)");
        search.setMaxResults(Long.valueOf(10));

        try {
            SearchListResponse searchResponse = search.execute();
            List<SearchResult> searchResultList = searchResponse.getItems();

            List<YouTubeVideo> videos = new ArrayList<YouTubeVideo>();

            if (searchResultList != null) {
                for (SearchResult result : searchResultList) {
                    ResourceId resourceId = result.getId();
                    Thumbnail thumbnail = result.getSnippet().getThumbnails().getDefault();

                    String title = result.getSnippet().getTitle();
                    String videoId = resourceId.getVideoId();

                    YouTubeVideo video = new YouTubeVideo();
                    video.setUrl(videoId);
                    video.setThumbnailUrl(thumbnail.getUrl());
                    video.setTitle(title);
                    videos.add(video);
                }
            }

            return videos;
        } catch (Exception ex) {
            throw new YouTubeClientException(ex);
        }
    }
}
