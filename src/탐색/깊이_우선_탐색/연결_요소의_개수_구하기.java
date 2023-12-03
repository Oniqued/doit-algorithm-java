package 탐색.깊이_우선_탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 연결_요소의_개수_구하기 {
    private static NodeGroup[] nodeGroup;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int numOfNode = toInt(st.nextToken());
        int numOfConnectedComponent = toInt(st.nextToken());
        nodeGroup = new NodeGroup[numOfNode + 1];
        visited = new boolean[numOfNode + 1];
        for (int i = 1; i <= numOfNode; i++) {
            nodeGroup[i] = new NodeGroup(new ArrayList<>());
        }

        for (int i = 0; i < numOfConnectedComponent; i++) {
            st = new StringTokenizer(br.readLine());
            int startNode = toInt(st.nextToken());
            int endNode = toInt(st.nextToken());

            nodeGroup[startNode].add(endNode);
            nodeGroup[endNode].add(startNode);
        }

        int count = 0;
        for (int i = 1; i <= numOfNode; i++) {
            if (!visited[i]) {
                find(i);
                count++;
            }
        }
        System.out.println(count);

    }

    public static void find(int nodeIndex) {
        if (visited[nodeIndex]) {
            return;
        }
        visited[nodeIndex] = true;
        for (int index : nodeGroup[nodeIndex].getConnectedNodes()) {
            find(index);
        }
    }

    public static int toInt(String s) {
        return Integer.parseInt(s);
    }

    private static class NodeGroup {
        private List<Integer> connectedNodes;

        public NodeGroup(List<Integer> connectedNodes) {
            this.connectedNodes = connectedNodes;
        }

        public void add(int nodeIndex) {
            connectedNodes.add(nodeIndex);
        }
        public List<Integer> getConnectedNodes() {
            return connectedNodes;
        }
    }
}

/*
노드 그룹이 필요함;

[의사 코드]
numOfNode, numOfConnectedComponent 입력;
numOfNode 만큼 방문 배열 초기화;
numOfNode 만큼 nodes 배열 초기화;


* */
