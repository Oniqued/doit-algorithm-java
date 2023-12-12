package 탐색.이진_탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 원하는_정수_찾기 {
    private static int[] data;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int numOfData = toInt(br.readLine());
        data = new int[numOfData];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numOfData; i++) {
            data[i] = toInt(st.nextToken());
        }

        Arrays.sort(data);

        int numOfQuery = toInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numOfQuery; i++) {
            int targetNumber = toInt(st.nextToken());
            if (Arrays.binarySearch(data, targetNumber) >= 0) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    public static boolean hasNumber(int targetNumber) {
        int begin = 0;
        int end = data.length - 1;
        while (begin <= end) {
            int middle = getMiddleIndex(begin, end);
            int median = data[middle];
            if (median == targetNumber) {
                return true;
            } else if (median < targetNumber) {
                begin = middle + 1;
            } else if (median > targetNumber) {
                end = middle - 1;
            }
        }
        return false;
    }

    public static int getMiddleIndex(int begin, int end) {
        return (end + begin) / 2;
    }

    public static int toInt(String s) {
        return Integer.parseInt(s);
    }
}



/*
[의사 코드]
numOfData 입력;
int[] data;
for (i ~ numOfData 만큼)
    data[i] 입력;
data[] 정렬;

numOfQuery 입력;
for (numOfQuery)
    targetNumber가 있는지 이진 탐색;

boolean findNumber(int n) {
    int begin = 0;
    int end = data.length - 1;
    int median = end / 2;
    while (true) {
        if (data[median] == n)
            return true;
        else if (data[median] < n)
            begin = median;
        else if (data[median] > n)
            end = median;
        else
            return false;
        median = (end - begin) / 2;
    }
    return false;
}

* */