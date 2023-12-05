package 탐색.깊이_우선_탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ABCDE {
    private static final int DEPTH = 5;
    private static ConnectedNode[] connectedNodes;
    private static boolean[] visited;
    private static boolean isArrived;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int numOfNode = toInt(st.nextToken());
        connectedNodes = new ConnectedNode[numOfNode];
        visited = new boolean[numOfNode];

        for (int i = 0; i < numOfNode; i++) {
            connectedNodes[i] = new ConnectedNode(new ArrayList<>());
        }

        int numOfEdge = toInt(st.nextToken());

        for (int i = 0; i < numOfEdge; i++) {
            st = new StringTokenizer(br.readLine());
            int nodeX = toInt(st.nextToken());
            int nodeY = toInt(st.nextToken());

            connectedNodes[nodeX].add(nodeY);
            connectedNodes[nodeY].add(nodeX);
        }

        for (int i = 0; i < numOfNode; i++) {
            findFriend(i, 1);
            if (isArrived) {
                break;
            }
        }

        if (!isArrived) {
            System.out.println("0");
            return;
        }
        System.out.println("1");
    }

    public static void findFriend(int node, int currentDepth) {
        if (currentDepth == DEPTH) {
            isArrived = true;
            return;
        }
        visited[node] = true;
        for (int eachNode : connectedNodes[node].getNodes()) {
            if (!visited[eachNode]) {
                findFriend(eachNode, currentDepth + 1);
            }
        }
        visited[node] = false;
    }

    public static int toInt(String s) {
        return Integer.parseInt(s);
    }

    public static class ConnectedNode {
        private List<Integer> nodes;

        public ConnectedNode(List<Integer> nodes) {
            this.nodes = nodes;
        }

        public void add(int node) {
            nodes.add(node);
        }

        public List<Integer> getNodes() {
            return nodes;
        }
    }
}

/*
깊이가 5까지 도달할 수 있는지 찾는다.

[의사 코드]
DEPTH = 5;
numOfNode, numOfEdge 입력;
nunOfNode 만큼 방문 배열 초기화;
isArrived 선언;
for (numOfEdge 만큼)
    노드 추가 (양방향이므로 서로 추가)
for (i ~ numOfNode 만큼)
    visited = new visited[numOfNode];
    if (!isArrived)
        i번노드 부터 재귀적으로 방문;
if (!isArrived)
    출력(0);


void dfs(int node, int currentDepth) {
    if (currentDepth == DEPTH)
        출력(1)
        isArrived = true;
        return;
    for (int eachNode : connectedNodes[node].getNodes())
        if (eachNode가 방문했던 노드기 아니면)
            visited[eachNode] = true;
            dfs(eachNode, currentDepth + 1);
}
* */

