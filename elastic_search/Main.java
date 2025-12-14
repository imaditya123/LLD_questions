package elastic_search;

public class Main {

    public static void main(String[] args) {
        InvertedIndex index = new InvertedIndex();

        index.indexDocument(new Document("1", "Java is a powerful programming language"));
        index.indexDocument(new Document("2", "Elasticsearch is built in Java"));
        index.indexDocument(new Document("3", "Java is used for backend development"));

        SearchEngine searchEngine = new SearchEngine(index);

        System.out.println("Search results:");
        searchEngine.search("backend").forEach(System.out::println);
    }
}