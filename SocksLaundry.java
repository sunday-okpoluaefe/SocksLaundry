import java.util.*;

public class SocksLaundry {

    public int getMaximumPairOfSocks(int noOfWash, int[] cleanPile, int[] dirtyPile){

        int noCleanPairs = 0;
        int noAllDirtyPairs = 0;
        int noOfWatchInClean_Dirty = 0;
        Set<Integer> a = new HashSet<Integer>();
        Set<Integer> b = new HashSet<Integer>();
        Set<Integer> noRemainingDirtySocks = new HashSet<Integer>();

        Arrays.sort(cleanPile);
        // get number of clean pairs
        for (int value : cleanPile) {

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

        Arrays.sort(dirtyPile);
        while(noOfWash > 0){
            for (int i : dirtyPile) {

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
