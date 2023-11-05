package Greedy.AbdulBari;

import java.util.Arrays;

public class KnapSack {

    static class Item{
        int values;
        int weight;

        Item(int values, int weight){
            this.values = values;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        
        int  N = 3, W = 50;
        int values[] = {60,100,120};
        int weight[] = {10,20,30};

        Item[] item = new Item[N];

        for (int i = 0 ; i < item.length; i++){
            item[i] = new Item(values[i], weight[i]);
        }

        Arrays.sort(item, (Item i1, Item i2) -> {
            double r1 = (double) (i1.values) / (double) i1.weight;
            double r2 = (double) (i2.values) / (double) i2.weight;

            return Double.compare(r2, r1);
        });

        int i = 0;
        double ans = 0;
        double W1 = W;
        while (W1 > 0 && i < N) {
            if (W1 >= item[i].weight){
                ans = ans + item[i].values;
                W1 = W1 - item[i].weight;    
            } else {
                double f = W1 / item[i].weight;
                ans = ans + f * item[i].values;
                W1 = W1 - f * item[i].weight;
            }
            i++;
        }

        System.out.println("Answer:" + ans);
    }
}
