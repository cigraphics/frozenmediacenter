package net.frozenlogic.mediacenter.impl.plugins.goodreads;

public class GoodreadsUserGroup {
    private String title;
    private String thumbnailCoverUrl;
    private String type;
    private String lastActivity;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnailCoverUrl() {
        return thumbnailCoverUrl;
    }

    public void setThumbnailCoverUrl(String thumbnailCoverUrl) {
        this.thumbnailCoverUrl = thumbnailCoverUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLastActivity() {
        return lastActivity;
    }

    public void setLastActivity(String lastActivity) {
        this.lastActivity = lastActivity;
    }
}
