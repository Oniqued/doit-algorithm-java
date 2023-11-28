package 자료구조.투_포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 연속된_자연수의_합_구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = toInt(br.readLine());
        int startIndex = 1, endIndex = 1, sum = 1, count = 1; // count = 1 ? << 자기 자신인 경우를 추가한것

        while (endIndex != num) {
            if (sum == num) {
                count++;
                endIndex++;
                sum = sum + endIndex;
            } else if (sum > num) {
                sum = sum - startIndex;
                startIndex++;
            } else {
                endIndex++;
                sum = sum + endIndex;
            }
        }
        System.out.println(count);
    }

    public static int toInt(String s) {
        return Integer.parseInt(s);
    }
}

/*
* [투 포인터 공식]
* startIndex; endIndex;
* sum > N : sum = sum - startIndex; startIndex++;
* sum < N : sum = sum + endIndex; endIndex++;
* sum == N : count++; sum = sum + endIndex; endIndex++;
*
* [의사 코드]
* num을 입력 받는다;
* startIndex, endIndex, sum, count 선언;
* while (endIndex <= N) 공식을 반복;
* */