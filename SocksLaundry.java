import java.util.*;

public class SocksLaundry {

    public static void main(String[] args) {
        System.out.println(solution(2, new int[] {1,2,1,1}, new int[]{1,4,3,2,4}));

    }

    static int solution(int noOfWash, int[] cleanPair, int[] dirtyPair){
        
        int noCleanPairs = 0;
        int noAllDirtyPairs = 0;
        int noOfWatchInClean_Dirty = 0;
        Set<Integer> a = new HashSet<Integer>();
        Set<Integer> b = new HashSet<Integer>();
        Set<Integer> noRemainingDirtySocks = new HashSet<Integer>();

        if(noOfWash > 50 || noOfWash < 0) return 0;
        
        // get number of clean pairs
        Arrays.sort(cleanPair);
        for (int value : cleanPair) {

            if (a.isEmpty())
                a.add(value);
             else if (!a.contains(value)) {
                a.add(value);

            } else if (a.contains(value)) {
                noCleanPairs++;
                a.remove(value);
            }
        }

        if(noOfWash == 0){
            return noCleanPairs;
        }

        Arrays.sort(dirtyPair);
        while(noOfWash > 0){
            for (int i : dirtyPair) {

                if (a.contains(i)) {
                    noOfWash--;
                    noOfWatchInClean_Dirty++;
                    a.remove(i);
                } else if (!a.contains(i))//allDirtyPairs.
                    noRemainingDirtySocks.add(i);
                //ensure no of washes no exceeded
                if(noOfWash == 0) break;
            }

                for (int i : noRemainingDirtySocks) {
                    //ensure no of washes no exceeded
                    if(noOfWash == 0) break;

                    if (b.isEmpty())
                        b.add(i);
                    else if (!b.contains(i)) {
                        b.add(i);

                    } else if (b.contains(i)) {
                        noOfWash--;
                        noAllDirtyPairs++;
                        b.remove(i);
                    }

                }

        }

        return noCleanPairs + noOfWatchInClean_Dirty + noAllDirtyPairs;
    }

}
