// Problem: Baseball Game
// Link: https://leetcode.com/problems/baseball-game/description/

package Miscellaneous;
import java.util.*;

class Solution {
    public int calPoints(String[] operations) {
        int record = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<operations.length; i++){
            if(operations[i].equals("+")){
                int last = list.get(list.size()-1);
                int secondLast = list.get(list.size()-2);
                record = last + secondLast;
                list.add(record);
            }
            else if(operations[i].equals("C")){
                list.remove(list.size()-1);
            }
            else if(operations[i].equals("D")){
                record = 2 * list.get(list.size()-1);
                list.add(record);
            }
            else{
                record = Integer.parseInt(operations[i]);
                list.add(record);
            }
        }
        int sum = 0;
        for(int i : list){
            sum += i;
        }
        return sum;
    }
}