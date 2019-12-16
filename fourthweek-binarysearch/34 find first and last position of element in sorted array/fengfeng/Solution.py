class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        left,right=0,len(nums) - 1
        start,end = -1,-1
        while right >= left:
            mid = left + ((right - left) >> 1)
            if nums[mid] > target:
                right = mid - 1;
            elif nums[mid] < target:
                left = mid + 1
            else:
                if mid == 0 or nums[mid - 1] != target:
                    start = mid
                    break
                else:
                    right = mid - 1
        left,right=0,len(nums) - 1
        while right >= left:
            mid = left + ((right - left) >> 1)
            if nums[mid] > target:
                right = mid - 1;
            elif nums[mid] < target:
                left = mid + 1
            else:
                if mid == len(nums) - 1 or nums[mid + 1] != target:
                    end = mid
                    break
                else:
                    left = mid + 1
        return [start,end]
