package 탐색.너비_우선_탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 미로_탐색 {
    private static int[][] maze;
    private static final int[] moveX = {1, 0, -1, 0};
    private static final int[] moveY = {0, 1, 0, -1};
    private static int height;
    private static int width;
    private static boolean[][] visited;
    private static int movement = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        height = toInt(st.nextToken());
        width = toInt(st.nextToken());

        maze = new int[height+1][width+1];
        visited = new boolean[height+1][width+1];

        for (int x = 1; x <= height; x++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int y = 1; y <= width; y++) {
                maze[x][y] = toInt(line.substring(y-1, y));
            }
        }
        findPath(1, 1);
        System.out.println(maze[height][width]);
    }

    public static void findPath(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int[] currentPosition = queue.remove();
            for (int i = 0; i < 4; i++) {
                int nextX = currentPosition[0] + moveX[i];
                int nextY = currentPosition[1] + moveY[i];
                if (canMoveTo(nextX, nextY)) {
                    visited[nextX][nextY] = true;
                    maze[nextX][nextY] = maze[currentPosition[0]][currentPosition[1]] + 1;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
    }

    public static boolean canMoveTo(int x, int y) {
        return !isOutOfMaze(x, y) && !visited[x][y] && !isWall(x, y);
    }

    public static boolean isWall(int x, int y) {
        return maze[x][y] == 0;
    }

    public static boolean isOutOfMaze(int x, int y) {
        return x > height || y > width || x <= 0 || y <= 0;
    }

    public static boolean isFinish(int x, int y) {
        return x == height && y == width;
    }

    public static int toInt(String s) {
        return Integer.parseInt(s);
    }
}

/*
이동?
int[] moveX = {1, 0, -1, 0};
int[] moveY = {0, 1, 0, -1};

[의사 코드]
movement 선언;
width, height 입력;
visited[height][width] 선언;
    maze[x][y] 입력;
findPath(1, 1);

void findPath(int x, int y) {
    movement++;
    visited[x][y] = true;
    if (isFinish(x, y)) {
        출력(movement);
        return;
    }
    for (int i = 0; i < 4; i++) {
        int nextX = x + moveX[i];
        int nextY = y + moveY[i];
        if (visited[nextX][nextY] || isOutOfMaze(nextX, nextY)) {
            return;
        }
        findPath(nextX, nextY);
    }
}

boolean isOutOfMaze(int x, int y) {
    return x > height || y > weight || x <= 0 || y <= 0;
}

boolean isFinish(int x, int y) {
    return x == height && y == width;
}
* */
