/**
 * Created by Yang on 2017/5/17.
 */
import java.util.*;

public class q1 {
    public static boolean allStringSetsIdentical(String[][] sets) {

        if (sets == null  || sets.length < 2) return true;

        Set<String> exampleSet = new HashSet<String>(Arrays.asList(sets[0]));
        for (int i = 1; i<sets.length; i++){
            Set<String> testSet = new HashSet<String>(Arrays.asList(sets[i]));
            if (!testSet.equals(exampleSet)) return false;
        }

        return true;
    }

}
