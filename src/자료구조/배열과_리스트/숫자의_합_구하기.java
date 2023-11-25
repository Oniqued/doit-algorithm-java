package 자료구조.배열과_리스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숫자의_합_구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String length = br.readLine();
        String stringNum = br.readLine();
        char[] charNum = stringNum.toCharArray();

        int sum = 0;
        for (char num : charNum) {
            sum += Character.getNumericValue(num);
        }
        System.out.println(sum);
    }
}

/*
* 문자열로 숫자를 입력 받고, 문자열을 char로 잘라 (toCharArray()를 사용) char을 순회하며 숫자로 바꾼후, 전부 더한다.
*
* [의사 코드]
* length를 입력;
* stringNum을 입력;
* char배열에 stringNum을 char로 잘라서 저장;
* sum 선언;
* for (length 만큼) 숫자로 바꾼후, sum에 더한다;
* 출력(sum);
* */