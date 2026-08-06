class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] days = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
        int[] monthCode = {1,4,4,0,2,5,0,3,6,1,4,6};
        int code = 0;
        if(year/100 == 18) code = 2;
        else if(year/100==19) code = 0;
        else if(year/100==20) code = 6;
        else if(year/100==21) code = 4;
        if(isLeap(year)){
            monthCode[0]--;
            monthCode[1]--;
        }
        int d = (day + code + monthCode[month-1]+(year%100)+(year%100)/4)%7-1;
        if(d == -1) d = 6;
        return days[d];
    }

    private static boolean isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}