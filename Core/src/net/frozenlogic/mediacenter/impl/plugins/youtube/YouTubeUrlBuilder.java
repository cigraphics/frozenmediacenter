package net.frozenlogic.mediacenter.impl.plugins.youtube;

class YouTubeUrlBuilder {

    public String createYouTubeUrl(String videoId) {
        StringBuilder sb = new StringBuilder("http://www.youtube.com/watch?v=");
        sb.append(videoId);
        return sb.toString();
    }
}
