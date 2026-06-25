class Solution {
    public boolean lemonadeChange(int[] bills) {
        if(bills[0]==10 || bills[0]==20){
            return false;
        }
        int five = 0;
        int ten = 0;
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                five++;
                continue;
            }
            if(bills[i]==10){
                ten++;
                if(five==0){
                    return false;
                }
                five--;
                continue;
            }
            if(bills[i]==20){
                if(ten==0 && five <= 2){
                    return false;
                }else if(five == 0){
                    return false;
                }else if(ten > 0 && five > 0){
                    ten--;
                    five--;
                }else if(five >= 3){
                    five-=3;
                }
            }
        }
        return true;
    }
}