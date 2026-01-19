import java.util.*;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        // Step 1: banned words into a set
        Set<String> bannedSet = new HashSet<>();
        for (String word : banned) {
            bannedSet.add(word);
        }

        // Step 2: normalize paragraph
        paragraph = paragraph.toLowerCase().replaceAll("[^a-z]", " ");

        // Step 3: split words
        String[] words = paragraph.split("\\s+");

        // Step 4: count frequency
        Map<String, Integer> freqMap = new HashMap<>();
        String result = "";
        int maxCount = 0;

        for (String word : words) {
            if (word.length() == 0 || bannedSet.contains(word)) {
                continue;
            }

            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);

            if (freqMap.get(word) > maxCount) {
                maxCount = freqMap.get(word);
                result = word;
            }
        }

        return result;
    }
}
