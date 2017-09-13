package net.terzeron.quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by terzeron on 2016. 9. 2..
 */
class ScoreMap {
    boolean isMine = false;
    char mineType = ' ';
    int score = 0;
    public int getScore() {
        return score;
    }
    public void addScore(int score) {
        this.score += score;
    }
    public boolean checkMine() {
        return isMine;
    }
    public void setMine(char mineType) {
        this.mineType = mineType;
        this.isMine = true;
    }
    public char getMine() {
        return mineType;
    }
}

public class MinePower {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            ArrayList<ArrayList<Character>> map = new ArrayList<ArrayList<Character>>();
            while (true) {
                String line = br.readLine();
                if (line.equals("")) {
                    break;
                }
                ArrayList<Character> mapLine = new ArrayList<Character>();
                for (String data : line.split(" ")) {
                    mapLine.add(data.charAt(0));
                }
                //System.out.println(mapLine);
                map.add(mapLine);
            }
            int height = map.size();
            int width = map.get(0).size();
            System.out.println("height=" + height + ", width=" + width);
            ScoreMap[][] scoreMap = new ScoreMap[height][width];

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    char data = map.get(i).get(j);
                    scoreMap[i][j] = new ScoreMap();
                    if (data == 'a' || data == 'b') {
                        System.out.println("i=" + i + ", j=" + j);
                        scoreMap[i][j].setMine(data);
                        System.out.println(scoreMap[i][j].getMine());
                    }
                }
            }
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    char data = map.get(i).get(j);
                    switch (data) {
                        case 'a':
                            fillScore(scoreMap, height, width, i, j, 1);
                            break;
                        case 'b':
                            fillScore(scoreMap, height, width, i, j, 10);
                            break;
                    }
                }
            }

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (scoreMap[i][j].checkMine()) {
                        System.out.format("%3s", scoreMap[i][j].getMine());
                    } else {
                        System.out.format("%3d", scoreMap[i][j].getScore());
                    }
                }
                System.out.print("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addScore(ScoreMap[][] scoreMap, int i, int j, int score) {
        System.out.println("i=" + i + ", j=" + j + ", score=" + score);
        if (!scoreMap[i][j].checkMine()) {
            scoreMap[i][j].addScore(score);
        }
    }

    public static void fillScore(ScoreMap[][] scoreMap, int height, int width, int i, int j, int score) {
        if (i > 0) {
            if (j > 0) {
                addScore(scoreMap, i - 1, j - 1, score);
            }
            addScore(scoreMap, i - 1, j, score);
            if (j < width - 1) {
                addScore(scoreMap, i - 1, j + 1, score);
            }
        }

        if (j > 0) {
            addScore(scoreMap, i, j - 1, score);
        }
        if (j < width - 1) {
            addScore(scoreMap, i, j + 1, score);
        }

        if (i < height - 1) {
            if (j > 0) {
                addScore(scoreMap, i + 1, j - 1, score);
            }
            addScore(scoreMap, i + 1, j, score);
            if (j < width - 1) {
                addScore(scoreMap, i + 1, j + 1, score);
            }
        }
    }
}

