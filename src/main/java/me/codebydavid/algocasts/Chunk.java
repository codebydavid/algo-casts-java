package me.codebydavid.algocasts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Chunk
 */
public class Chunk {

    private static Integer[][] toArray(List<List<Integer>> list) {
        Integer[][] result = new Integer[list.size()][0];
        for (int i = 0; i < list.size(); i++) {
            List<Integer> chunk = list.get(i);
            result[i] = chunk.toArray(new Integer[chunk.size()]);
        }
        return result;
    }

    public static Integer[][] chunk1(Integer[] array, int size) {
        // Java arrays are fixed in size, use List for dynamic sizing
        List<List<Integer>> chunked = new ArrayList<List<Integer>>();
    
        for (Integer e : array) {
            // Add a new chunk if the last chunk in chunked list doesn't
            // exist or if the last chunk is at the size limit.
            // NOTE: Java throws ArrayIndexOutOfBound exception if the index
            // is not in index range of the list. Check list is not empty
            // before retrieving last chunk
            if (chunked.size() == 0 || 
                chunked.get(chunked.size() - 1).size() == size) {
                List<Integer> chunk = new ArrayList<Integer>();
                chunk.add(e);
                chunked.add(chunk);
            } else {
                chunked.get(chunked.size() - 1).add(e);
            }
        }

        return toArray(chunked);
    }

    // solution 2: using subList to "slice" the input array
    public static Integer[][] chunk2(Integer[] array, int size) {
        List<List<Integer>> chunked = new ArrayList<List<Integer>>();
        List<Integer> input = Arrays.asList(array);

        int fromIndex = 0;
        while (fromIndex < input.size()) {
            // guard against out of bound index
            int toIndex = Math.min(fromIndex + size, input.size());
            chunked.add(input.subList(fromIndex, toIndex));
            fromIndex += size;
        }

        return toArray(chunked);
    }

}