class Solution:
    def processStr(self, s: str) -> str:
        result = []
        for ch in s:
            if ch == '#':
                result = result + result
            elif ch == '%':
                result.reverse()
            elif ch == '*':
                if result:    
                    result.pop()
            else:
                result.append(ch)
        return "".join(result)