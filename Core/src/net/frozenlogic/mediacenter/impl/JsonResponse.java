package net.frozenlogic.mediacenter.impl;

import java.io.Serializable;

class JsonResponse implements Serializable {
    private String html;

    public JsonResponse(String html) {
        this.html = html;
    }

    String getType() {
        return "html";
    }

    String getHtml() {
        return html;
    }
}
