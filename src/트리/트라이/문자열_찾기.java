package 트리.트라이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 문자열_찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int count = 0;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Node root = new Node();
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            addWordTo(root, word);
        }

        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            if (isContain(root, input)) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static void addWordTo(Node root, String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            node = node.add(word.charAt(i));
            node.setEnd();
        }
    }

    private static boolean isContain(Node root, String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            node = node.get(word.charAt(i));
            if (node == null) {
                return false;
            }
        }
        if (!node.isEnd()) {
            return false;
        }
        return true;
    }

    static class Node {
        private Map<Character, Node> childNode = new HashMap<>();
        private boolean isEnd;

        public Node add(char ch) {
            return childNode.computeIfAbsent(ch, key -> new Node());
        }

        public Node get(char ch) {
            return childNode.getOrDefault(ch, null);
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }
}
