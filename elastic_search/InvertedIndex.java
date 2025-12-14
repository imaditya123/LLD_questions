package elastic_search;

import java.util.*;

public class InvertedIndex {
    private final Map<String,Map<String,Integer>> index = new HashMap<>();

    public void indexDocument(Document doc){
        String[] tokens = tokenize(doc.getContent());

        for(String token:tokens){
            index.putIfAbsent(token,new HashMap<>());
            Map<String,Integer> postings = index.get(token);
            postings.put(doc.getId(),postings.getOrDefault(doc.getId(),0)+1);
        }
    }

    public Map<String,Integer> getPostings(String term){
        return index.getOrDefault(term,Collections.emptyMap());
    }

    private String[] tokenize(String text){
        return text.toLowerCase().replaceAll("[^a-z0-9 ]","").split("\\s+");
    }



}
