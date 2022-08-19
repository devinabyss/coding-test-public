package hackerrank;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/cats-and-a-mouse/
 * <p>
 * <p>
 * results
 * https://www.hackerrank.com/challenges/cats-and-a-mouse/submissions/code/285578239
 */
@Slf4j
public class CatsAndMouseTest {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> strs = new ArrayList<>();
        while (sc.hasNext()) {
            String cur = sc.nextLine();
            strs.add(cur);

        }

        StringBuilder result = new StringBuilder();

        for (int i = 1; i < strs.size(); i++) {

            String[] splited = strs.get(i).split(" ");

            int catA = Integer.parseInt(splited[0]);
            int catB = Integer.parseInt(splited[1]);
            int mouseC = Integer.parseInt(splited[2]);

            int compare = Integer.compare(Math.abs(mouseC - catA), Math.abs(mouseC - catB));

            switch (compare) {
                case 0:
                    result.append("Mouse C");
                    break;
                case 1:
                    result.append("Cat B");
                    break;
                default:
                    result.append("Cat A");
                    break;
            }

            if (i < strs.size() - 1) result.append("\n");

        }

        System.out.print(result);
    }
}
