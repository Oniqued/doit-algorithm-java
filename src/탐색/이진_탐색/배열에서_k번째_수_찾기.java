package 탐색.이진_탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 배열에서_k번째_수_찾기 {
    private static long arraySize;
    private static long indexOfAnswer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arraySize = Long.parseLong(br.readLine());
        indexOfAnswer = Long.parseLong(br.readLine());

        long begin = 1;
        long end = indexOfAnswer;

        System.out.println(binarySearch(begin, end));
    }

    public static long binarySearch(long begin, long end) {
        long answer = 0;

        while (begin <= end) {
            long middle = (begin + end) / 2;
            long countOfSmallerThanMiddle = 0;
            for (int i = 1; i <= arraySize; i++) {
                countOfSmallerThanMiddle += Math.min(middle / i, arraySize);
            }
            if (countOfSmallerThanMiddle < indexOfAnswer) {
                begin = middle + 1;
            } else {
                end = middle - 1;
                answer = middle;
            }
        }

        return answer;
    }
}

/*
[의사 코드]
arraySize 입력;
indexOfAnswer 입력;
begin 선언;
end = indexOfAnswer 선언;

while (begin <= end)
    countOfSmallerThanMiddle 선언;
    middle 선언;
    for (arraySize 만큼)
        countOfSmallerThanMiddle += min(middle/i, arraySize);
    if (countOfSmallerThanMiddle < indexOfAnswer)
        begin = middle + 1;
    else
        end = middle - 1;
        정답 변수에 저장;
정답 출력
* */