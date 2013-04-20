package net.frozenlogic.mediacenter.impl.plugins.goodreads;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GoodreadsClient {
    private String apiKey = "QetVOVltGrCwRKYLxpbvg";
    private String idUser = "1675997";

    public List<SearchResult> search(String keyword) throws GoodreadsClientException {
        List<SearchResult> resultList = new ArrayList<SearchResult>();
        String uri = "http://www.goodreads.com/search.xml?key=" + this.apiKey + "&q=" + keyword;
        URL url;
        try {
            url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream stream = connection.getInputStream();
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(stream);
            NodeList nodeList = document.getElementsByTagName("work");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node instanceof Element) {
                    Element element = (Element) node;
                    //Node booksCountNode = this.getSingleNode(element, "books_count");
                    Node ratingsCountNode = this.getSingleNode(element, "ratings_count");
                    Node averageRatingNode = this.getSingleNode(element, "average_rating");

                    //Integer booksCount = Integer.parseInt(booksCountNode.getTextContent());
                    Integer ratingsCount = Integer.parseInt(ratingsCountNode.getTextContent());
                    BigDecimal averageRating = new BigDecimal(averageRatingNode.getTextContent());

                    SearchResult searchResult = new SearchResult();
                    searchResult.setAverageRating(averageRating);
                    searchResult.setRatingsCount(ratingsCount);

                    Node bestBookNode = this.getSingleNode(element, "best_book");
                    if (!(bestBookNode instanceof Element))
                        throw new GoodreadsClientException("The given result is not valid.");

                    Element bestBookElement = (Element) bestBookNode;

                    Node bookIdNode = this.getSingleNode(bestBookElement, "id");
                    Node bookTitleNode = this.getSingleNode(bestBookElement, "title");
                    Node fullCoverNode = this.getSingleNode(bestBookElement, "image_url");
                    Node thumbnailCoverNode = this.getSingleNode(bestBookElement, "small_image_url");

                    Integer idBook = Integer.parseInt(bookIdNode.getTextContent());
                    String title = bookTitleNode.getTextContent();
                    String fullCoverUrl = fullCoverNode.getTextContent();
                    String thumbnailCoverUrl = thumbnailCoverNode.getTextContent();

                    Node authorNode = this.getSingleNode(bestBookElement, "author");
                    if (!(authorNode instanceof Element))
                        throw new GoodreadsClientException("The given result is not valid.");

                    Element authorElement = (Element) authorNode;
                    Node authorIdNode = this.getSingleNode(authorElement, "id");
                    Node authorNameNode = this.getSingleNode(authorElement, "name");

                    Integer idAuthor = Integer.parseInt(authorIdNode.getTextContent());
                    String authorName = authorNameNode.getTextContent();

                    Author author = new Author();
                    author.setIdAuthor(idAuthor);
                    author.setName(authorName);

                    Book book = new Book();
                    book.setFullCoverUrl(fullCoverUrl);
                    book.setIdBook(idBook);
                    book.setThumbnailCoverUrl(thumbnailCoverUrl);
                    book.setTitle(title);
                    book.setAuthor(author);

                    searchResult.setBestBook(book);

                    resultList.add(searchResult);
                }
            }
        } catch (MalformedURLException ex) {
            throw new GoodreadsClientException(ex);
        } catch (IOException e) {
            throw new GoodreadsClientException(e);
        } catch (ParserConfigurationException e) {
            throw new GoodreadsClientException(e);
        } catch (SAXException e) {
            throw new GoodreadsClientException(e);
        }

        return resultList;
    }

    public List<GoodreadsUserGroup> getBookGroup() throws GoodreadsClientException {
        List<GoodreadsUserGroup> resultList = new ArrayList<GoodreadsUserGroup>();
        String uri = "http://www.goodreads.com/group/list/" + idUser + ".xml?key=" + apiKey;
        URL url;
        try {
            url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream stream = connection.getInputStream();
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(stream);
            NodeList nodeList = document.getElementsByTagName("group");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node instanceof Element) {
                    Element element = (Element) node;

                    Node groupTitleNode = this.getSingleNode(element, "title");
                    Node groupImageUrlNode = this.getSingleNode(element, "image_url");
                    Node groupTypeNode = this.getSingleNode(element, "access");
                    Node groupLastActivityNode = this.getSingleNode(element, "last_activity_at");

                    String groupTitle = groupTitleNode.getTextContent();
                    String groupImageUrl = groupImageUrlNode.getTextContent();
                    String groupType = groupTypeNode.getTextContent();
                    String groupLastActivity = groupLastActivityNode.getTextContent();


                    GoodreadsUserGroup bookGroup = new GoodreadsUserGroup();
                    bookGroup.setTitle(groupTitle);
                    bookGroup.setThumbnailCoverUrl(groupImageUrl);
                    bookGroup.setType(groupType);
                    bookGroup.setLastActivity(groupLastActivity);
                    resultList.add(bookGroup);

                }
            }
        } catch (MalformedURLException ex) {
            throw new GoodreadsClientException(ex);
        } catch (IOException e) {
            throw new GoodreadsClientException(e);
        } catch (ParserConfigurationException e) {
            throw new GoodreadsClientException(e);
        } catch (SAXException e) {
            throw new GoodreadsClientException(e);
        }

        return resultList;
    }

    private Node getSingleNode(Element parent, String nodeName) {
        NodeList nodeList = parent.getElementsByTagName(nodeName);
        return nodeList.item(0);
    }
}
