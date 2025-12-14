package elastic_search;

import java.util.*;
public class SearchEngine {
    private final InvertedIndex index;

    public SearchEngine(InvertedIndex index){
        this.index = index;
    }

    public List<SearchResult> search(String query){
        Map<String, Integer> scores = new HashMap<>();

        String[] terms = query.toLowerCase().split("\\s+");

        for(String term:terms){
            Map<String,Integer> postings = index.getPostings(term);
            for(Map.Entry<String,Integer> entry: postings.entrySet()){
                scores.put(
                    entry.getKey(),
                    scores.getOrDefault(entry.getKey(),0)+entry.getValue()
                );

            }
        }

        List<SearchResult> results = new ArrayList<>();
        for(Map.Entry<String,Integer> entry: scores.entrySet()){
            results.add(new SearchResult(entry.getKey(),entry.getValue()));
        }


        results.sort((a,b)-> Integer.compare(b.getScore(),a.getScore()));
        return results;
    }
}
