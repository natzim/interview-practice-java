package hackerRank;

import java.util.HashMap;
import java.util.List;

public class NewYearChaos {

    public void minimumBribes(List<Integer> q) {
        // Write your code here
        HashMap<Integer, Integer> bribesUsed = new HashMap<>();

        int minimumBribes = 0;
        for(int i = 0; i < q.size(); i++) {
            int person = q.get(i);
            if (person != i + 1) {
                if (bribesUsed.getOrDefault(person, 0) == 2) {
                    System.out.println("Too chaotic");
                    return;
                } else {
                    minimumBribes += 1;
                    bribesUsed.put(person, bribesUsed.getOrDefault(person, 0) + 1);

                    SwapPlaces(q, i, person > i + 1 ? i + 1 : i - 1);
                }
            }
        }

        System.out.println(minimumBribes);
    }

    private void SwapPlaces(List<Integer> list, int index1, int index2) {
        Integer temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }
}
