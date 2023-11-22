package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간_합_구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int[] sum;

        st = new StringTokenizer(br.readLine());
        int numOfData = Integer.parseInt(st.nextToken());
        sum = new int[numOfData + 1];
        int numOfCase = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= numOfData; i++) {
            if (i == 0) {
                sum[i] = 0;
            } else {
                sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
            }
        }

        int begin;
        int end;
        for (int i = 0; i < numOfCase; i++) {
            st = new StringTokenizer(br.readLine());
            begin = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            sb.append(getSum(sum, begin, end)).append("\n");
        }

        System.out.print(sb);
    }

    public static int getSum(int[] sum, int begin, int end) {
        return sum[end] - sum[begin-1];
    }
}

/*
 * 구간합 공식 : S[end] - S[begin - 1] (S[0] = 0)
 *   1 ~ 3 : S[3] - S[0] // S[0] = 0
 *   5 ~ 5 : S[5] - S[4]
 *   ...
 *
 * [의사 코드]
 * numOfData, numOfTest 받기; <- 문자열 잘라야함
 * for (numOfData 만큼) {
 *   data 받기;
 *   if (i = 0) {
 *       S[i] = 0;
 *   }
 *   구간 합 구성하기 : S[i] = S[i - 1] + data;
 * }
 *
 * for (numOfCase 만큼) {
 *   answer = S[end] - S[begin - 1];
 *   스트링 빌더.append(answer);
 * }
 * 스트링 빌더 출력
 * */

