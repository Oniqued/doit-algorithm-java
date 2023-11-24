package 자료구조.투_포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 좋은_수_구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int count = 0;

        int numOfData = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[numOfData];
        for(int i = 0; i < numOfData; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        for (int cursor = 0; cursor < numOfData; cursor++) {
            int i = 0;
            int j = numOfData - 1;
            int find = arr[cursor];

            while (i < j) {
                if (arr[i] + arr[j] == find) {
                    if (i != cursor && j != cursor) {
                        count++;
                        break;
                    } else if (i == cursor) {
                        i++;
                    } else if (j == cursor) {
                        j--;
                    }
                } else if (arr[i] + arr[j] < find) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        System.out.println(count);
        br.close();
    }
}

/*
* 좋은 수 ?
* 1. 입력을 받는다
* 2. 정렬을 한다.
* 투 포인터 : 두 포인터 i와 j는 각각 양쪽 끝에 위치 시킨다.
*   A[i] + A[j] < K 면, i++
*   A[i] + A[j] > K 면, j--
*   A[i] + A[j] == K 면, cnt++, i = 0, j = K의 인덱스 -1로 초기화
*
*   [의사 코드]
*   numOfData 입력 받기;
*   int[] arr;
*   for (numOfData 만큼) {
*       data 입력 받기;
*   }
*   arr[] 정렬;
*   for (int cursor = 0; cursor < arr.length; cursor++) {
*       찾고자 하는 값, i, j를 초기화;
*       while (i < j) {
*           if (arr[i] + arr[j] == 찾고자 하는 값)
*               count++ 후, while 문 종료
*           else if (arr[i] + arr[j] < 찾고자 하는 값) i++;
*           else j--;
*       }
*   }
*   출력(count);
* */

