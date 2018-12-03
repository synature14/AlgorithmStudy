package com.study181204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 치킨배달15686 {
    static public int MAX = 100000000;
    static public int answer = MAX;
    static public ArrayList<Position> chickenShop;
    static public ArrayList<Position> house;
    static public int m;

    public static class Position {
        int x, y;
        boolean isVisited;

        Position(int x, int y){
            this.x = x;
            this.y = y;
            this.isVisited = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        chickenShop = new ArrayList<>();
        house = new ArrayList<>();

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num == 1) {
                    house.add(new Position(i, j));
                } else if (num == 2) {
                    chickenShop.add(new Position(i, j));
                }
            }
        }

        solve(0,0);
        dfs();
        System.out.println(answer);
    }

    public static void solve(int nextStart, int countOfChickenShop) {
        if(countOfChickenShop == m || chickenShop.size() == m) {
            dfs();
            return;
        }

        for (int i = nextStart; i < chickenShop.size(); i++)
        {
            if (chickenShop.get(i).isVisited == false)								//치킨집이 선택된곳이 아니면
            {
                chickenShop.get(i).isVisited = true;								//해당 치킨집을 선택하고
                solve(i + 1, countOfChickenShop + 1);							//DFS  sol함수 호출
                chickenShop.get(i).isVisited = false;								//재귀함수 종료후 돌아오면 치킨집 선택 해제
            }
        }

        return;
    }

    public static void dfs() {
        int total = 0;
        // house 기준으로
        for(int eachHouse=0; eachHouse<house.size(); eachHouse++) {
            Position pHouse = house.get(eachHouse);
            int distance = MAX;

            for(int eachChicken=0; eachChicken<chickenShop.size(); eachChicken++) {
                Position pChicken = chickenShop.get(eachChicken);
                if(pChicken.isVisited == false) {
                    int temp = Math.abs(pHouse.x - pChicken.x) + Math.abs(pHouse.y - pChicken.y);
                    if (temp < distance) {
                        distance = temp;
                    }
                }
            }
            total += distance;
        }

        if(total < answer) {
            answer = total;
        }
    }
}
