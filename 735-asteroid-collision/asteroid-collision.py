class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        st = []
        for ast in asteroids:
            isAlive = True
            while st and isAlive and ast<0 and st[-1]>0:
                if st[-1] < abs(ast):
                    st.pop()
                    continue
                if st[-1] == abs(ast):
                    st.pop()
                isAlive = False
            if isAlive:
                st.append(ast)
        return st