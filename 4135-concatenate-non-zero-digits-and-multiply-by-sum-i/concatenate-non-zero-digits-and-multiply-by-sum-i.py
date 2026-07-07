class Solution:
    def sumAndMultiply(self, n: int) -> int:
        if n<=0:
            return 0
        x = 0
        s = ""
        while n>0:
            rem = n%10
            x+=rem
            if rem!=0:
                s += str(rem)
            n//=10
        s=s[::-1]
        return int(s)*x