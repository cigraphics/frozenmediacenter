package net.frozenlogic.mediacenter.impl.plugins.goodreads;

import net.frozenlogic.mediacenter.activities.UiActivityContext;

import java.util.List;

class GoodreadsUtils {
    public boolean isSearch(UiActivityContext context) {
        return context.getParameters().containsKey("action") && context.getParameters().get("action")[0].equals("search");
    }

    public List<SearchResult> getSearchResults(UiActivityContext context) {
        String term = context.getParameters().get("term")[0];

        GoodreadsClient client = new GoodreadsClient();
        try {
            return client.search(term);
        } catch (GoodreadsClientException ex) {
            throw new RuntimeException(ex);
        }
    }
}
