package 탐색.너비_우선_탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 트리의_지름 {
    private static Node[] tree;
    private static int[] distance;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int numOfNodes = toInt(br.readLine());
        tree = new Node[numOfNodes + 1];
        for (int i = 1; i <= numOfNodes; i++) {
            tree[i] = new Node(new ArrayList<>());
        }

        for (int i = 0; i < numOfNodes; i++) {
            st = new StringTokenizer(br.readLine());
            int nodeIndex = toInt(st.nextToken());
            while (true) {
                int connectedNode = toInt(st.nextToken());
                if (connectedNode == -1) {
                    break;
                }
                int weight = toInt(st.nextToken());
                tree[nodeIndex].add(new Edge(connectedNode, weight));
            }
        }

        distance = new int[numOfNodes + 1];
        visited = new boolean[numOfNodes + 1];
        findDiameter(1);
        int indexOfMaxDistance = getIndexOfMaxDistance();

        distance = new int[numOfNodes + 1];
        visited = new boolean[numOfNodes + 1];
        findDiameter(indexOfMaxDistance);

        System.out.println(Arrays.stream(distance).max().getAsInt());
    }

    public static void findDiameter(int nodeIndex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(nodeIndex);
        visited[nodeIndex] = true;
        while (!queue.isEmpty()) {
            int currentNode = queue.remove();
            for (Edge eachEdge : tree[currentNode].edges) {
                int connectedNode = eachEdge.getConnectedNode();
                int weight = eachEdge.getWeight();
                if (!visited[connectedNode]) {
                    queue.add(connectedNode);
                    visited[connectedNode] = true;
                    distance[connectedNode] = distance[currentNode] + weight;
                }
            }
        }
    }

    public static int getIndexOfMaxDistance() {
        int maxIndex = 0;
        int maxValue = 0;
        for (int i = 1; i < distance.length; i++) {
            if (distance[i] > maxValue) {
                maxIndex = i;
                maxValue = distance[i];
            }
        }
        return maxIndex;
    }

    public static int toInt(String s) {
        return Integer.parseInt(s);
    }

    private static class Node {
        private List<Edge> edges;

        public Node(List<Edge> edges) {
            this.edges = edges;
        }

        public void add(Edge edge) {
            edges.add(edge);
        }
    }

    private static class Edge {
        private int connectedNode;
        private int weight;

        public Edge(int connectedNode, int weight) {
            this.connectedNode = connectedNode;
            this.weight = weight;
        }

        public int getConnectedNode() {
            return connectedNode;
        }

        public int getWeight() {
            return weight;
        }
    }
}

/*
!! 아이디어 : 임의의 노드에서 가장 긴 경로로 연결되어 있는 노드는 트리의 지름에 해당하는 두 노드 중 하나이다.
[의사 코드]
numOfNodes 입력;
Node[] tree = new Node[numOfNodes + 1];
distance[] 선언;
visited[] 선언;

for (int i = 1; i <= numOfNodes; i++)
    tree[i] = new Node(new ArrayList<>());
for (numOfNodes 만큼)
    int nodeIndex 입력;
    while (true)
        int connectedNode 입력;
        if (connectedNode가 -1이면)
            break;
        int weight 입력;
        tree[nodeIndex].add(new Edge(connectedNode, weight));

findDiameter(1);
int maxIndex = findMaxIndex();
visited, distance 초기화;
findDiameter(maxIndex);
출력(distance[findMaxIndex()]);

void findDiameter(int nodeIndex) {
    큐 선언;
    큐.add(nodeIndex);
    visited[nodeIndex] = true;
    while (큐가 빌때까지)
        뺀노드 = 큐.remove();
        for (Edge edge : tree[뺀노드].edges)
            int connectedNode = edge.getConnectedNode();
            int weight = edge.getWeight();
            if (!visited[connectedNode])
                큐.add(connectedNode);
                visited[connectedNode] = true;
                distance[connectedNode] = distance[뺀노드] + weight;
}

int findMaxIndex() {

}



* */
