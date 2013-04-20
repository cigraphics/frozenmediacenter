package net.frozenlogic.mediacenter.impl;

import java.io.Serializable;

class HtmlResponse implements Serializable {
    private String html;

    public HtmlResponse(String html) {
        this.html = html;
    }

    String getType() {
        return "html";
    }

    String getHtml() {
        return html;
    }
}
