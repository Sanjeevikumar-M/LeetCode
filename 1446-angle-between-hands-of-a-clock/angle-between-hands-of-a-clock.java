class Solution {
    public double angleClock(int hour, int minutes) {
        double ma = minutes*6;
        hour = hour%12;
        double ha = (hour*30)+(minutes*0.5);
        double diff = Math.abs(ha-ma);
        return Math.min(diff,360-diff); 
    }
}