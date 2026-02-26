class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int t=numBottles;
        while(numBottles>=numExchange){
            t = t+(numBottles/numExchange);
            numBottles = (numBottles/numExchange) + (numBottles%numExchange);
        }
        return t;
    }
}