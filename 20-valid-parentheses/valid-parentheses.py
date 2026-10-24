class Solution:
    def isValid(self, s: str) -> bool:
        n = len(s)
        if n%2!=0: return False
        ch = []
        for c in s:
            if c=='(':
                ch.append(')')
            elif c=='[':
                ch.append(']')
            elif c=='{':
                ch.append('}')
            elif not ch or ch.pop()!=c:
                return False
        return not ch