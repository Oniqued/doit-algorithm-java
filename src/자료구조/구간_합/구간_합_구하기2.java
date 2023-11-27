package 자료구조.구간_합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간_합_구하기2 {
    private static int[][] matrix;
    private static int[][] matrixSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int matrixLength = toInt(st.nextToken());
        int indexFromOne = matrixLength + 1;

        matrix = new int[indexFromOne][indexFromOne];
        matrixSum = new int[indexFromOne][indexFromOne];
        int numOfTest = toInt(st.nextToken());

        for (int i = 1; i <= matrixLength; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= matrixLength; j++) {
                matrix[i][j] = toInt(st.nextToken());
                matrixSum[i][j] = prefixSum(i, j);
            }
        }

        for (int i = 0; i < numOfTest; i++) {
            st = new StringTokenizer(br.readLine());
            int fromX = toInt(st.nextToken());
            int fromY = toInt(st.nextToken());
            int toX = toInt(st.nextToken());
            int toY = toInt(st.nextToken());

            int result = prefixSum(fromX, fromY, toX, toY);
            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }

    public static int prefixSum(int i, int j) {
        return matrixSum[i][j - 1] + matrixSum[i - 1][j] - matrixSum[i - 1][j - 1] + matrix[i][j];
    }

    public static int prefixSum(int fromX, int fromY, int toX, int toY) {
        return matrixSum[toX][toY] - matrixSum[fromX - 1][toY] - matrixSum[toX][fromY - 1] + matrixSum[fromX - 1][fromY - 1];
    }

    public static int toInt(String str) {
        return Integer.parseInt(str);
    }
}

/*
* 2차원 배열의 구간합을 구하는 공식 : D[i][j] = D[i-1][j] + D[i][j-1] - D[i-1][j-1] + A[i][j]
* from ~ to 구간합을 구하는 공식 : D[toX][toY] - D[fromX-1][toY-1] - D[toX][fromY-1] + D[fromX-1][fromY-1]
*
* [의사 코드]
* matrixLength를 입력 받는다;
* 테스트 케이스 갯수 numOfTest를 입력 받는다;
* matrix와 martix의 구간합을 저장할 matrixSum을 선언한다.
* for (matrixLength 만큼) <- 인덱스는 1부터
*   for (matrixLength 만큼) <- ''
*       matrix[i][j]를 입력 받음;
*       matrixSum[i][j]을 구한다;
*
* fromX, fromY, toX, toY를 입력 받는다;
* 공식을 이용해 구한답을 출력한다;
* */
