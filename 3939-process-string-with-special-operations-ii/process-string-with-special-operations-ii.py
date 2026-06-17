class Solution:
    def processStr(self, s: str, k: int) -> str:
        n = len(s)
        lengths = [0] * (n + 1)
        
        # Forward Pass: Track only the sizes
        for i in range(n):
            char = s[i]
            if char == '*':
                lengths[i + 1] = max(0, lengths[i] - 1)
            elif char == '#':
                lengths[i + 1] = lengths[i] * 2
            elif char == '%':
                lengths[i + 1] = lengths[i]
            else:
                lengths[i + 1] = lengths[i] + 1
                
        # If k is out of bounds
        if k >= lengths[n]:
            return "."
            
        # Backward Pass: Reverse engineer index k
        for i in range(n - 1, -1, -1):
            char = s[i]
            if char == '*':
                continue
            elif char == '#':
                if k >= lengths[i]:
                    k %= lengths[i]  # Map k back to the first half
            elif char == '%':
                k = lengths[i] - 1 - k  # Flip index for mirror image
            else:
                if k == lengths[i]:
                    return char
                    
        return "."
        