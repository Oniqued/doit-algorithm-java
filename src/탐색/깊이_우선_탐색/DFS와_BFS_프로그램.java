package 탐색.깊이_우선_탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFS와_BFS_프로그램 {
    private static ConnectedNode[] connectedNodes;
    private static Queue<Integer> queue = new LinkedList<>();
    private static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int numOfNode = toInt(st.nextToken());
        int numOfEdge = toInt(st.nextToken());
        int startNode = toInt(st.nextToken());

        connectedNodes = new ConnectedNode[numOfNode + 1];
        for (int i = 1; i <= numOfNode; i++) {
            connectedNodes[i] = new ConnectedNode(new ArrayList<>());
        }

        for (int i = 0; i < numOfEdge; i++) {
            st = new StringTokenizer(br.readLine());
            int nodeX = toInt(st.nextToken());
            int nodeY = toInt(st.nextToken());

            connectedNodes[nodeX].addNode(nodeY);
            connectedNodes[nodeY].addNode(nodeX);
        }

        for (int i = 1; i <= numOfNode; i++) {
            Collections.sort(connectedNodes[i].getNodes());
        }

        visited = new boolean[numOfNode + 1];
        findWithDFS(startNode);

        System.out.println();

        visited = new boolean[numOfNode + 1];
        findWithBFS(startNode);
    }

    public static int toInt(String s) {
        return Integer.parseInt(s);
    }

    public static void findWithDFS(int node) {
        if (visited[node]) return;
        visited[node] = true;
        System.out.print(node + " ");
        for (int eachNode : connectedNodes[node].getNodes()) {
            findWithDFS(eachNode);
        }
    }

    public static void findWithBFS(int node) {
        visited[node] = true;
        queue.add(node);
        while (!queue.isEmpty()) {
            int removedNode = queue.remove();
            System.out.print(removedNode + " ");
            for (int eachNode : connectedNodes[removedNode].getNodes()) {
                if (visited[eachNode]) continue;
                queue.add(eachNode);
                visited[eachNode] = true;
            }
        }
    }

    private static class ConnectedNode {
        private List<Integer> nodes;

        public ConnectedNode(List<Integer> nodes) {
            this.nodes = nodes;
        }

        public void addNode(int node) {
            nodes.add(node);
        }

        public List<Integer> getNodes() {
            return nodes;
        }
    }
}

/*
[의사 코드]
numOfNode, numOfEdge, startNode 입력;
visited[] 선언;
for (간선 갯수 만큼)
    nodeX, nodeY 입력;
    서로 연결;

for (노드 갯수 만큼) 노드에 연결된 리스트 정렬;

new visited[numOfNode];
findWithDFS(startNode);

new visited[numOfNode];
findWithBFS(startNode);

void findWithDFS(int node) {
    if (visited[node] == true) return;
    visited[node] = true;
    출력(node);
    for (int eachNode : connectedNodes[node].getNodes())
        findWithDFS(eachNode);
}

void findWithBFS(int node) {
    if (visited[node] == true) return;
    visited[node] = true;
    큐에 node 삽입;
    while (큐가 빌때 까지)
        출력(큐 peek);
        for (int eachNode : connectedNodes[큐.remove()].getNods())
            큐에 eachNode 삽입;
            eachNode 방문 처리;
}
* */
