package programmers.graph;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class NetworkTest {


    @Test
    public void test() {

        int[][][] computerArr = {
                {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}},
                {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}},
                {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}
        };

        Arrays.stream(computerArr).forEach(arr -> {
            int result = solution(arr.length, arr);
            log.info("## result : {}", result);
        });

    }

    public int solution(int n, int[][] computers) {
        Network network = new Network(computers);
        return network.getIndependentNetworksNumber2();
    }


    @ToString
    static class Computer {

        Computer(int no, int[] connectedInfo) {
            this.checked = false;
            this.no = no;
            this.connected = IntStream.range(0, connectedInfo.length)
                    .filter(n -> n != no && connectedInfo[n] == 1)
                    .boxed().collect(Collectors.toSet());
        }

        int no;
        boolean checked;
        Collection<Integer> connected;

    }

    static class Network {
        Network(int[][] arr) {

            Map<Integer, Computer> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                map.put(i, new Computer(i, arr[i]));
            }
            this.computers = map;
        }

        Map<Integer, Computer> computers;

        int getIndependentNetworksNumber() {
            Stack<Computer> stack = new Stack<>();
            int count = 0;
            for (Computer current : computers.values()) {
                if (!current.checked) {
                    count++;
                    current.checked = true;
                    stack.push(current);
                }

                while (!stack.isEmpty()) {
                    Computer cur = stack.pop();

                    for (Integer connectedNo : cur.connected) {
                        Computer com = computers.get(connectedNo);
                        if (!com.checked) {
                            com.checked = true;
                            stack.push(computers.get(connectedNo));
                        }
                    }
                }
            }
            return count;
        }

        int getIndependentNetworksNumber2() {


            return recursive(0, computers.values().iterator());
        }

        //
        private int recursive(int count, Iterator<Computer> iterator) {

            if (!iterator.hasNext()) return count;

            Computer computer = iterator.next();
            if (!computer.checked) {
                count += 1;
                computer.checked = true;
            }

            for (Integer connectedNo : computer.connected) {
                Computer com = computers.get(connectedNo);
                if (!com.checked) {
                    com.checked = true;
                }
            }

            return recursive(count, iterator);

        }
    }
}
