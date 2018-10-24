package com.study181030;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class SharkDinner1671 {
    public static class Spec {
        int size;
        int velocity;
        int iq;
        int eatableAmount = 0;

        Spec(int size, int velocity, int iq) {
            this.size = size;
            this.velocity = velocity;
            this.iq = iq;
        }

        public void setEatableAmount(int amount) {
            this.eatableAmount = amount;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        ArrayList<Spec> specSharkList = new ArrayList<>();

        for(int i=0; i<n; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            int size = Integer.parseInt(st.nextToken());
            int velocity = Integer.parseInt(st.nextToken());
            int iq = Integer.parseInt(st.nextToken());

            specSharkList.add(new Spec(size, velocity, iq));
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i == j) {
                    continue;
                }

                // 크기, 속도, 지능이 모두 같다면
                if (specSharkList.get(i).size == specSharkList.get(j).size
                        &&  specSharkList.get(i).velocity == specSharkList.get(j).velocity
                        &&  specSharkList.get(i).iq == specSharkList.get(j).iq ) {
                    continue;
                }

                if (specSharkList.get(i).size > specSharkList.get(j).size
                        && specSharkList.get(i).velocity > specSharkList.get(j).velocity
                        && specSharkList.get(i).iq > specSharkList.get(j).iq) {

                }
            }
        }

        for(Spec each : specSharkList) {
            System.out.println(each.size + ", velocity : " + each.velocity);
        }


    }
}
