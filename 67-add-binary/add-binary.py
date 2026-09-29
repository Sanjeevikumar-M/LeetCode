class Solution:
    def addBinary(self, a: str, b: str) -> str:
        res = ''
        carry = 0
        l1 = len(a)-1
        l2 = len(b)-1
        while l1>-1 or l2>-1 or carry>0:
            val1 = int(a[l1]) if l1>=0 else 0
            val2 = int(b[l2]) if l2>=0 else 0

            s = val1+val2+carry
            if s==2:    
                carry = 1
                res+='0'
            elif s==3:
                carry = 1
                res+='1'
            else:
                carry=0
                res+=str(s)
            l1-=1
            l2-=1
        return res[::-1]
