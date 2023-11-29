package 그래프.유니온_파인드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 집합_표현하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int numOfData = toInt(st.nextToken());
        int[] parent = makeSequenceArray(numOfData);
        int numOfTest = toInt(st.nextToken());

        for (int i = 0; i < numOfTest; i++) {
            st = new StringTokenizer(br.readLine());
            String option = st.nextToken();
            int x = toInt(st.nextToken());
            int y = toInt(st.nextToken());

            if (option.equals("0")) {
                union(parent, x, y);
            } else if (option.equals("1")) {
                if (isInclude(parent, x, y)) {
                    sb.append("YES").append("\n");
                } else {
                    sb.append("NO").append("\n");
                }
            }
        }
        System.out.print(sb);
        br.close();
    }

    public static void union(int[] parent, int x, int y) {
        int x_ = findParent(parent, x);
        int y_ = findParent(parent, y);

        if (x_ != y_) {
            parent[y_] = x_;
        }
    }

    public static int findParent(int[] parent, int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = findParent(parent, parent[x]);
    }

    public static boolean isInclude(int[] parent, int x, int y) {
        return findParent(parent, x) == findParent(parent, y);
    }

    public static int[] makeSequenceArray(int numOfData) {
        int[] sequence = new int[numOfData + 1];
        for (int i = 0; i <= numOfData; i++) {
            sequence[i] = i;
        }
        return sequence;
    }

    public static int toInt(String s) {
        return Integer.parseInt(s);
    }
}


/*
[의사 코드]
numOfData 입력;
numOfData 만큼 parent[] 초기화;
numOfTest 입력;
for (numOfTest 만큼)
    테스트 입력;
    if (option : 0) union(x, y);
    else if (option : 1) find(x, y);

int find(x) { <- 대표값을 찾는다
    if (x == parent[x]) return x;
    else parent[x] = find(parent[x]);
}
int union(x, y) {
    x = find(x);
    y = find(y);
    if (x != y) return parent[y] = x;
}
*/