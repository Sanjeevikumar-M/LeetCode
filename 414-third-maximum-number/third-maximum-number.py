class Solution:
    def thirdMax(self, nums: List[int]) -> int:
        ################# Using 3 pointers ##############################
        first_max = float('-inf')
        second_max = float('-inf')
        third_max = float('-inf')

        seen = set()

        for num in nums:
            if num in seen:
                continue
            seen.add(num)
            if num > first_max:
                third_max, second_max, first_max = second_max, first_max, num
            elif num > second_max:
                third_max, second_max = second_max, num
            elif num > third_max:
                third_max = num

        if third_max == float('-inf'):
            return first_max
        return third_max



        ################ Using Sort #####################################
        # sorted_list = list(sorted(set(nums))[::-1])
        # if len(sorted_list) < 3:
        #     return sorted_list[0]
        # else:
        #     return sorted_list[2]