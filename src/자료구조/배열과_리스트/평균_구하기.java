package 자료구조.배열과_리스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.Instant;
import java.util.Collections;
import java.util.StringTokenizer;

public class 평균_구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfSubject = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        int maxScore = 0;
        for (int i = 0; i < numOfSubject; i++) {
            int score = Integer.parseInt(st.nextToken());
            if (score > maxScore) {
                maxScore = score;
            }
            sum += score;
        }

        System.out.println(calculate(sum, maxScore, numOfSubject));

        br.close();
    }

    public static float calculate(int sum, int maxScore, int numOfSubject) {
        return (float) sum / 100 * maxScore / numOfSubject;
    }
}

/*
* 점수들을 입력받아 최댓값을 구하고, 총합을 구한다.
* 해당 공식으로 나온 값을 통해 평균을 구한다
* 공식 : (총합) * (100 / 최댓값) 평균 : 공식 / 길이
*
* [의사 코드]
* numOfSubject 입력;
* scoresInput 입력;
* 점수 총합 sum 선언;
* for (numOfSubject 만큼) st를 자르면서 sum 갱신;
* 공식 호출;
* 결과 출력;
*/
