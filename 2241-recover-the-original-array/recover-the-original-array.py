class Solution:
    def recoverArray(self, nums: List[int]) -> List[int]:
        N2 = len(nums)
        N = N2 >> 1
        # sort the input in asc order
        nums.sort()
        
        # get the freq count
        counter = Counter(nums)
        keys = sorted(counter)

        # get the smallest and largest elem
        smallest, largest = keys[0], keys[-1]

        for key in keys[1:]:
            guess = key - smallest

            # this isn't the right guess
            if guess & 1 or largest - guess not in counter:
                continue

            # validate the guess against entire arr
            remaining = counter.copy()
            res = []

            for num in keys:
                count = remaining[num]
                if count == 0:
                    continue

                # invalid guess
                if remaining[num + guess] < count:
                    break

                remaining[num + guess] -= count
                remaining[num] = 0
                res += [num + (guess >> 1)] * count

            if len(res) == N:
                return res

        return [] 