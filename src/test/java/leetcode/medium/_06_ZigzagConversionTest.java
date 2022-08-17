package leetcode.medium;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/zigzag-conversion/
 * <p>
 * results
 * https://leetcode.com/submissions/detail/775185992/
 */
@Slf4j
public class _06_ZigzagConversionTest {

//    P   A   H   N
//    A P L S I I G
//    Y   I   R

//    P  I   N
//    A LS  IG
//    YA H R
//    P  I

    @Test
    public void test() {

        String[] strs = {"PAYPALISHIRING", "PAYPALISHIRING", "AB"};
        int[] rows = {3, 4, 1};

        for (int i = 0; i < rows.length; i++) {
            String result = convert(strs[i], rows[i]);
            log.info("## results : {}", result);
        }
    }


    public String convert(String s, int numRows) {

        if (s.length() <= numRows || numRows == 1) return s;

        char[] chrs = s.toCharArray();
        int round = numRows - 1;
//        log.info("## length : {}, round : {}, gap : {}", chrs.length, round, gap);

        List<String> strs = new ArrayList<>();
        int before = 0;
        int cur = 0;
        int count = 0;
        while (cur < chrs.length) {
            int rest = count % round;
            before = cur;
            int target = Math.min(before + numRows, s.length());
            if (rest == 0) {
                strs.add(s.substring(before, target));
                cur += numRows;
            } else {
                StringBuilder sb = new StringBuilder();
                int idx = numRows - rest - 1;
                for (int i = 0; i < numRows; i++) {
                    if (i < idx) {
//                        log.info("## I : {}", idx);
                        sb.append(" ");
                    } else if (i == idx) sb.append(s.charAt(before));
                    else {
//                        log.info("## I : {}", idx);
                        sb.append(" ");
                    }
                }
                strs.add(sb.toString());
                cur += 1;
            }
            count++;

        }

//        log.info("## strs : {}", strs);

        StringBuilder result = new StringBuilder();
        int r = 0;
        while (r < numRows) {
            for (int i = 0; i < strs.size(); i++) {
                String ss = strs.get(i);
                if (ss.length() <= r) break;
//                log.info("## size : {}, I : {}, R : {}",ss.length(), i, r );
                char a = strs.get(i).charAt(r);
                result.append(String.valueOf(a).trim());
            }
            r++;
        }

        return result.toString();

    }
}
