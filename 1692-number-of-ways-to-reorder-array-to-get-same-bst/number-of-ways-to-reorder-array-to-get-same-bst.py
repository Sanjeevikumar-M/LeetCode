# https://www.youtube.com/@0x3f
class Solution:
    def numOfWays(self, nums: list[int]) -> int:
        MOD = 1_000_000_007
        # 数组模拟双向链表
        n = len(nums)
        prev = [i - 1 for i in range(n + 2)]
        next = [i + 1 for i in range(n + 2)]

        # size[x] 表示子树 x 的大小（节点个数）
        size = [0] * (n + 2)

        # 分母
        mul = 1

        # 自底向上构建二叉搜索树
        for x in reversed(nums):
            size[x] = 1

            # 加上左子树的大小
            left = prev[x]
            if size[left] > 0:
                size[x] += size[left]
                # 删除节点 left
                pl = prev[left]
                prev[x] = pl
                next[pl] = x

            # 加上右子树的大小
            right = next[x]
            if size[right] > 0:
                size[x] += size[right]
                # 删除节点 right
                nr = next[right]
                prev[nr] = x
                next[x] = nr

            mul = mul * size[x] % MOD

        fac = 1  # 分子
        for i in range(2, n + 1):
            fac = fac * i % MOD

        return (fac * pow(mul, -1, MOD) - 1) % MOD