package 자료구조.슬라이딩_윈도우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class DNA_비밀번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int passwordCase = 0;
        int[] passwordChecker = new int[4];
        int[] passwordRule = new int[4];

        st = new StringTokenizer(br.readLine());
        int dnaSize = toInt(st.nextToken());
        int windowSize = toInt(st.nextToken());
        Deque<Character> window = new ArrayDeque<>();
        String dnaString = br.readLine();
        char[] dnaChar = dnaString.toCharArray();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < passwordRule.length; i++) {
            passwordRule[i] = toInt(st.nextToken());
        }

        for (int i = 0; i < windowSize; i++) {
            char ch = dnaChar[i];
            addChar(window, passwordChecker, ch);
        }

        if (isCorrectPassword(passwordChecker, passwordRule)) {
            passwordCase++;
        }

        for (int i = windowSize; i < dnaChar.length; i++) {
            removeChar(passwordChecker, window.pollFirst());
            addChar(window, passwordChecker, dnaChar[i]);
            if (isCorrectPassword(passwordChecker, passwordRule)) {
                passwordCase++;
            }
        }

        System.out.println(passwordCase);
    }

    public static int toInt(String s) {
        return Integer.parseInt(s);
    }

    public static void countChar(int[] passwordChecker, char ch) {
        if (ch == 'A') {
            passwordChecker[0]++;
        } else if (ch == 'C') {
            passwordChecker[1]++;
        } else if (ch == 'G') {
            passwordChecker[2]++;
        } else if (ch == 'T') {
            passwordChecker[3]++;
        }
    }

    public static void addChar(Deque<Character> window, int[] passwordChecker, char ch) {
        window.addLast(ch);
        countChar(passwordChecker, ch);
    }

    public static void removeChar(int[] passwordChecker, char ch) {
        if (ch == 'A') {
            passwordChecker[0]--;
        } else if (ch == 'C') {
            passwordChecker[1]--;
        } else if (ch == 'G') {
            passwordChecker[2]--;
        } else if (ch == 'T') {
            passwordChecker[3]--;
        }
    }

    public static boolean isCorrectPassword(int[] passwordChecker, int[] passwordRule) {
        for (int i = 0; i < 4; i++) {
            if (passwordChecker[i] < passwordRule[i]) {
                return false;
            }
        }
        return true;
    }

}
/*
* 입력받은 문자열에서 윈도우를 적용하여
* 해당 윈도우의 문자가 조건에 부합하는지 검사해보자
*
* [의사 코드]
* passwordCase 선언;
* dnaSize 입력 받음;
* windowSize 입력 받음;
* passwordChecker[4] 선언;
* dnaString 입력 받음;
* passwordRule[4] 받음;
* danString을 char배열로 변환해서 dnaChar[]에 넣음;
* for (windowSize 만큼)
*   passwordChecker에 해당 문자열 개수 기록;
*   deq에 해당 문자 addLast;
* while (문자열 끝에 도달할때 까지)
*   passwordChecker가 passwordRule에 맞다면 passwordCase++;
*   deq에 맨 앞 문자 pollFirst; passwordChecker[]에서 해당 문자 뺌;
*   deq에 다음 문자 addLast; passwordChecker[]에서 해당 문자 추가;
* passwordCase 출력;
* */