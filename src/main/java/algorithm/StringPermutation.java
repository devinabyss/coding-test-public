package algorithm;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Slf4j
public class StringPermutation {

    public static String[] permutation(String str) {

        Set<String> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            String cur = str.substring(i, i + 1);

            //log.info("## Current : {}", cur);


            if (cur.length() == str.length())
                set.add(cur);

            String first = str.substring(0, i);
            String second = str.substring(i + 1, str.length());

            String rest = first + second;
            //log.info("## First : {}, Second : {}, Rest : {}", first, second, rest);

            String[] restResult = permutation(rest);

            //log.info("## RestResult : {}", Arrays.toString(restResult));

            for (int j = 0; j < restResult.length; j++) {
                if (cur.length() + restResult[j].length() == str.length())
                    set.add(cur + restResult[j]);

            }
        }

        return set.toArray(String[]::new);
    }


}
