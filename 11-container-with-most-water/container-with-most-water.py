
class Solution:
    def maxArea(self, height):
        area_=0
        left=0
        right=len(height)-1
        while right> left:
            area=(right-left)* min(height[left],height[right])
            area_= max(area_,area)
            if height[right]> height[left]:
                left+=1
            else:
                right-=1
        return area_