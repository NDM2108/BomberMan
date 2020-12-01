package bomberman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LevelLoader {
    private int level;
    private int width, height;
    private char[][] board;

    public LevelLoader(int level) throws FileNotFoundException {
        File file = new File("res/levels/Level" + Integer.toString(level) + ".txt");
        System.out.println("res/levels/Level" + Integer.toString(level) + ".txt");
        Scanner scanner = new Scanner(file);
        height = scanner.nextInt();
        width = scanner.nextInt();
        scanner.nextLine();
        board = new char[height][width];
        for(int i = 0; i < height; i++) {
            String temp = scanner.nextLine();
            for(int j = 0; j < width; j++) {
                board[i][j] = temp.charAt(j);
            }
        }
    }

    public char[][] getBoard() {
        return board;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
