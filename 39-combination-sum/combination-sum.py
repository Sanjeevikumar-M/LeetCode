class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        def validCombination(index,ctarget,curr_combo):
            if ctarget == 0:
                res.append(list(curr_combo))
                return
            if ctarget < 0:
                return
            for i in range(index,len(candidates)):
                curr_combo.append(candidates[i])
                validCombination(i,ctarget - candidates[i],curr_combo)
                curr_combo.pop()
        validCombination(0,target,[])
        return res