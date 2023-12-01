package 자료구조.스택_큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 스택으로_오름차순_수열_만들기 {
    private static StringBuilder sb;
    private static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        stack = new Stack<>();

        int numOfData = toInt(br.readLine());
        int[] arr = new int[numOfData];
        for (int i = 0; i < numOfData; i++) {
            arr[i] = toInt(br.readLine());
        }

        int index = 1;
        for (int i = 0; i < numOfData; i++) {
            while (index <= arr[i]) {
                push(index++);
            }
            if (arr[i] == stack.peek()) {
                pop();
            } else {
                System.out.println("NO");
                return;
            }
        }

        System.out.println(sb);
    }

    public static void push(int num) {
        sb.append("+").append("\n");
        stack.push(num);
    }

    public static void pop() {
        stack.pop();
        sb.append("-").append("\n");
    }

    public static int toInt(String s) {
        return Integer.parseInt(s);
    }
}

/*
[의사 코드]
numOfData 입력;
array[] 입력;
for (

* */