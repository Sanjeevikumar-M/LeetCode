class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        last_occ = {ch:i for i,ch in enumerate(s)}
        st = []
        visited = set()

        for i,ch in enumerate(s):
            if ch in st:
                continue
            while st and st[-1]>ch and last_occ[st[-1]]>i:
                removed = st.pop()
                visited.remove(removed)
            st.append(ch)
            visited.add(ch)
        return "".join(st)