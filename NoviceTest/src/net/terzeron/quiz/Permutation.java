package net.terzeron.quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by terzeron on 2016. 9. 5..
 */
public class Permutation {
    public static void main(String[] args) {
        int num = 0;
        /*try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line = br.readLine();
            num = Integer.parseInt(line);
        } catch (IOException e) {

        }*/
        ArrayList<String> result = permute(Arrays.asList(0, 1, 2, 3, 4, 5, 6));
        System.out.println(result);
    }

    static ArrayList<String> permute(List<Integer> permList) {
        ArrayList<String> result = new ArrayList<String>();

        if (permList.size() == 2) {
            result.add(permList.get(0) + " "  + permList.get(1));
            result.add(permList.get(1) + " "  + permList.get(0));
        } else {
            // 2개이상
            for (Integer first : permList) {

                ArrayList<Integer> exceptedList = new ArrayList<Integer>();
                for (Integer e : permList) {
                    if (first != e) {
                        exceptedList.add(e);
                    }
                }

                ArrayList<String> subPermList = permute(exceptedList);
                for (String subPerm : subPermList) {
                    result.add(first + " " + subPerm);
                }
            }
        }
        return result;
    }
}
