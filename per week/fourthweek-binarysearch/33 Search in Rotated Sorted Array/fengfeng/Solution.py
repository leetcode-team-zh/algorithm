class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left,right = 0,len(nums) - 1
        while right >= left:
            mid = (right + left) // 2
            if nums[mid] == target:
                return mid
            if right == left:
                return -1
            if nums[mid] > nums[left]:
                if nums[left] < target < nums[mid]:
                    right = mid - 1
                elif target == nums[left]:
                    return left
                else:
                    left = mid + 1
            else:
                if nums[mid] < target < nums[right]:
                    left = mid + 1
                elif nums[right] == target:
                    return right
                else:
                    right = mid;
        return -1
