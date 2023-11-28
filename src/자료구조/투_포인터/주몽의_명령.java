package 자료구조.투_포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 주몽의_명령 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int numOfMaterial = toInt(br.readLine());
        int fitCount = 0;
        int sum = 0;
        int startIndex = 0;
        int endIndex = numOfMaterial - 1;

        int fitRatio = toInt(br.readLine());
        int[] material = new int[numOfMaterial];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numOfMaterial; i++) {
            material[i] = toInt(st.nextToken());
        }

        Arrays.sort(material);
        while (startIndex < endIndex) {
            sum = material[startIndex] + material[endIndex];
            if (sum == fitRatio) {
                startIndex++;
                fitCount++;
            } else if (sum < fitRatio) {
                startIndex++;
            } else {
                endIndex--;
            }
        }
        System.out.println(fitCount);
        br.close();
    }

    public static int toInt(String s) {
        return Integer.parseInt(s);
    }
}

/*
* [배열에서 투 포인터 알고리즘]
* 1. 정렬 수행
* 2. 정렬된 배열에서 두개를 뽑아 원하는 숫자가 나오는지 포인터를 옮겨 가면서 연산
* a[]
* s = 0; e = a.length-1;
* sum = a[s] + a[e]
* - sum == ratio : s++;
* - sum < ratio : s++;
* - sum > ratio : e--;
*
* [의사 코드]
* material의 갯수 입력;
* ratio 입력;
* material[]에 삽입;
* material[] 정렬;
* fitCount 선언;
* while (s < e 인 동안) 투 포인터 알고리즘 수행
* fitCount 출력;
* */
