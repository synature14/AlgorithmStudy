package com.WinterCoding;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SkillTree {
    public static class Position{
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class SourceDestination {
        Position source;
        Position destination;

        SourceDestination(Position src, Position dest) {
            this.source = src;
            this.destination = dest;
        }
    }

    public static void main(String[] args) {
        String dirs = "ULURRDLLURULD";

//        String dirs = "LULLLLLLU";
        String[] direction = dirs.split("");
        Queue<Position> queue = new LinkedList<>();

        for(int i=0; i<direction.length; i++) {
            switch (direction[i]) {
                case "U":
                    queue.add(new Position(0, 1));
                    break;
                case "D":
                    queue.add(new Position(0, -1));
                    break;
                case "L":
                    queue.add(new Position(-1, 0));
                    break;
                case "R":
                    queue.add(new Position(1, 0));
                    break;
            }
        }

        int count = 0;
        boolean isVisited;
        Stack<SourceDestination> robotPath = new Stack<>();      // 출발 좌표 -> 도착 좌표
        Position start = new Position(5, 5);
        robotPath.add(new SourceDestination(start, start));

        while(!queue.isEmpty()) {
            isVisited = false;
            Position dir = queue.poll();
            Position current = robotPath.peek().destination;

            int nextY = dir.y + current.y;
            int nextX = dir.x + current.x;

            Position next = new Position(nextX, nextY);

            if(nextX>=0 && nextX<11 && nextY>=0 && nextY<11) {
                SourceDestination newPath = new SourceDestination(current, next);
                for(int i=0; i<robotPath.size(); i++) {
                    if(robotPath.get(i).source.y == newPath.source.y &&
                            robotPath.get(i).source.x == newPath.source.x &&
                            robotPath.get(i).destination.y == newPath.destination.y &&
                            robotPath.get(i).destination.x == newPath.destination.x) {
                        isVisited = true;
                        break;
                    }
                }

                if (!isVisited) {
                    count += 1;
                }

                robotPath.add(new SourceDestination(new Position(nextX, nextY), new Position(current.x, current.y)));
                robotPath.add(new SourceDestination(new Position(current.x, current.y), new Position(nextX, nextY)));
            }
        }

        System.out.println(count);
    }
}
