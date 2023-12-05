package 탐색.깊이_우선_탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 신기한_소수_찾기 {
    private static int lengthOfPrimeNumber;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        lengthOfPrimeNumber = toInt(br.readLine());

        findPrimeNumber(2, 1);
        findPrimeNumber(3, 1);
        findPrimeNumber(5, 1);
        findPrimeNumber(7, 1);

    }

    public static void findPrimeNumber(int num, int currentLength) {
        if (isFitLength(currentLength)) {
            if (isPrimeNumber(num)) {
                System.out.println(num);
            }
            return;
        }
        for (int i = 1; i < 10; i++) {
            if (isEven(i)) continue;
            if (isPrimeNumber(num * 10 + i)) {
                findPrimeNumber(num * 10 + i, currentLength + 1);
            }
        }

    }

    public static boolean isPrimeNumber(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static boolean isFitLength(int length) {
        return length == lengthOfPrimeNumber;
    }


    public static int toInt(String s) {
        return Integer.parseInt(s);
    }
}

/*
[의사 코드]
lengthOfPrimeNumber 입력;
primeList 선언;
(2,3,5,7로 시작되는 수만 정답이 될 수 있음)
findPrimeNumber(2,1);
findPrimeNumber(3,1);
findPrimeNumber(5,1);
findPrimeNumber(7,1);

void findPrimeNumber(int num, int length) << 소수면, 계속 진행해도 됨. 소수이고, 길이가 맞으면 정답 추가
    if (isPrimeNumber(num))
        if (isFitLength(length))
            primeNumbers.add(num);
            return;
        for (int i = 1; i < 10; i++)
            if (isEven(i)) continue;
            findPrimeNumber(num * 10 + i, length++);

boolean isPrimeNumber(int num) {
    for (int i = 2; i < sqrt(num); i++)
        if (num % i == 0) return false;
    return true;
}

boolean isFitLength(length) {
    return length > lengthOfPrimeNumber;
}

boolean isEven(int num) {
    return num % 2 == 0
}
* */