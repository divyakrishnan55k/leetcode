

class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {

        int n = indices.length;
        int[][] order = new int[n][2];

        // store index and original position
        for (int i = 0; i < n; i++) {
            order[i][0] = indices[i];
            order[i][1] = i;
        }

        // sort by index
        Arrays.sort(order, (a, b) -> a[0] - b[0]);

        StringBuilder result = new StringBuilder();
        int i = 0;

        for (int[] o : order) {
            int idx = o[0];
            int pos = o[1];

            // copy characters before replacement index
            while (i < idx) {
                result.append(s.charAt(i));
                i++;
            }

            // check if source matches
            if (s.startsWith(sources[pos], idx)) {
                result.append(targets[pos]);
                i += sources[pos].length();
            }
        }

        // append remaining characters
        while (i < s.length()) {
            result.append(s.charAt(i));
            i++;
        }

        return result.toString();
    }
}

