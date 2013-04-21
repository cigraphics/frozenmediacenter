package net.frozenlogic.mediacenter.impl.plugins.goodreads;

import net.frozenlogic.mediacenter.activities.UiContext;

import java.util.List;

class GoodreadsUtils {
    public boolean isSearch(UiContext context) {
        return context.isParameterSet("action") && context.getParameter("action").equals("search");
    }

    public List<SearchResult> getSearchResults(UiContext context) {
        String term = context.getParameter("term");

        GoodreadsClient client = new GoodreadsClient();
        try {
            return client.search(term);
        } catch (GoodreadsClientException ex) {
            throw new RuntimeException(ex);
        }
    }
}
