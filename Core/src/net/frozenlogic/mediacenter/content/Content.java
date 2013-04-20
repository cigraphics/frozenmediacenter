package net.frozenlogic.mediacenter.content;

import java.net.URL;

public interface Content {

    String getTitle();

    String getDescription();

    URL getImageURL();

    ContentStream getContentStream();
}

