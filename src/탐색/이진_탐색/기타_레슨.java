package 탐색.이진_탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 기타_레슨 {
    private static int[] videos;
    private static int begin = 0;
    private static int end = 0;
    private static int numberOfVideos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        numberOfVideos = Integer.parseInt(st.nextToken());
        videos = new int[numberOfVideos];
        int numberOfAvailableBluRay = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfVideos; i++) {
            videos[i] = Integer.parseInt(st.nextToken());
            begin = Math.max(begin, videos[i]);
            end = end + videos[i];
        }

        findMinimumBluRaySize(numberOfAvailableBluRay);

        System.out.println(begin);
    }

    public static void findMinimumBluRaySize(int numberOfAvailableBluRay) {
        while (begin <= end) {
            int videoGroupSize = 0;
            int currentBluRayCount = 0;
            int middle = (begin + end) / 2;
            for (int i = 0; i < numberOfVideos; i++) {
                if (videoGroupSize + videos[i] > middle) {
                    currentBluRayCount++;
                    videoGroupSize = 0;
                }
                videoGroupSize = videoGroupSize + videos[i];
            }
            if (videoGroupSize > 0) {
                currentBluRayCount++;
            }
            if (currentBluRayCount > numberOfAvailableBluRay) {
                begin = middle + 1;
            } else {
                end = middle - 1;
            }
        }
    }
}

/*
[의사 코드]
numberOfVideos, numberOfAvailableBluRay 입력;
for (비디오 갯수 만큼) videoRuntime 입력;
최댓값 구하기;
총합 구하기;

int findMinimumBluRaySize(int numberOfAvailableBluRay) {
    sum (현재 블루레이 그룹의 합계를 저장할 변수) 선언;
    count (현재까지 사용한 블루레이 갯수) 선언;
    begin = 최댓값;
    end = 총합;
    while (begin <= end)
        mid = (begin + end) / 2;
        for (비디오 갯수 만큼)
            if (그룹 합계 + 비디오[i] > mid)
                사용한 블루레이++;
                그룹 합계 초기화;
            그룹 합계 = 그룹 합계 + 비디오[i];
        if (그룹 합계 > 0)
            사용한 블루레이++;
        if (사용한 블루레이 > 목표 블루레이) // 블루레이를 많이 썼다.. 그룹 사이즈를 너무 작게 잡았다... 그룹 사이즈를 늘린다
            begin = mid + 1;
        else
            end = mid - 1;
    return begin;
}

* */