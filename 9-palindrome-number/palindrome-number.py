class Solution:
    def isPalindrome(self, x: int) -> bool:
        if x<0:
            return False
        
        if x<10:
            return True
            
        st = str(x)
        s = ''
        while x>0:
            r = x%10
            s += str(r)
            x//=10

        if st==s:
            return True
        else:
            return False 


        