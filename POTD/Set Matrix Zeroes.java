// Problem: Set Matrix Zeroes
// Link: https://leetcode.com/problems/set-matrix-zeroes/description/
// Date : 21-May-2025

package POTD;
import java.util.*;

class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
    public int hashCode() {
        return Objects.hash(first, second);
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair p = (Pair) o;
        return this.first == p.first && this.second == p.second;
    }
}
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Pair, Integer> map = new HashMap<>();
        for(int i=0; i<dominoes.length; i++){
            if(dominoes[i][0]<dominoes[i][1]){
                map.put(new Pair(dominoes[i][0], dominoes[i][1]), map.getOrDefault(new Pair(dominoes[i][0], dominoes[i][1]), 0)+1);
            }
            else{
                map.put(new Pair(dominoes[i][1], dominoes[i][0]), map.getOrDefault(new Pair(dominoes[i][1], dominoes[i][0]), 0)+1);
            }
        }
        int count =0;
        for(Map.Entry<Pair, Integer> entry : map.entrySet()){
            int x = entry.getValue();
            if(x>1){
                count += x*(x-1)/2;
            }

        }
        return count;
    }
}