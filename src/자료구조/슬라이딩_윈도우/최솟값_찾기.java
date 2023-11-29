package 자료구조.슬라이딩_윈도우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 최솟값_찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Deque<Node> window = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        int numOfData = toInt(st.nextToken());
        int windowSize = toInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numOfData; i++) {
            int num = toInt(st.nextToken());
            while (!window.isEmpty() && isSmallerThanLastNode(window, num)) {
                window.pollLast();
            }
            window.addLast(new Node(i, num));
            if (isOutOfWindow(window, windowSize)) {
                window.pollFirst();
            }
            sb.append(window.peekFirst()).append(" ");
        }

        System.out.print(sb);
        br.close();
    }

    private static boolean isSmallerThanLastNode(Deque<Node> window, int num) {
        return num < window.peekLast().getValue();
    }

    public static boolean isOutOfWindow(Deque<Node> window, int windowSize) {
        Node lastNode = window.peekLast();
        Node firstNode = window.peekFirst();
        return lastNode.getIndex() - firstNode.getIndex() >= windowSize;
    }

    public static int toInt(String s) {
        return Integer.parseInt(s);
    }

    public static class Node {
        private int index;
        private int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            return Integer.toString(this.value);
        }
    }
}

/*
* 범위 내의 최솟값을 찾는 방법 (덱 이용)
* 1. 넣으려는 노드와 마지막 노드를 비교한다.
*   1-1. (넣으려는 노드 < 마지막 노드) 마지막 노드는 버린다.
*   1-2. 넣는다.
* 2. 윈도우 사이즈를 벗어나지 않는지 확인하고, 벗어났다면 맨 앞노드를 제거한다.
*   2.1 윈도우 사이즈를 벗어나는지 체크 : window.peekLast() - window.peekFirst() >= windowSize ? 벗어남
* 3. 맨 앞 노드 값을 출력한다.(최솟값임)
*
* [의사 코드]
* Deq<Node> window 생성;
* numOfData 입력;
* windowSize 입력;
* for (i -> numOfData)
*   if (window 가 비었다면) addLast(num);
*   if (넣으려는 노드 값 < 마지막 노드 값) 마지막 값은 pollLast();
*   addLast(노드);
*   if (윈도우를 벗어나는가?) 맨 처음 노드를 버린다.
*   맨 처음 노드 출력;
* */
