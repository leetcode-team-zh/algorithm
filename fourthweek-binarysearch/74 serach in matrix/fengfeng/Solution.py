class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if len(matrix) == 0 or len(matrix[0]) == 0:
            return False
        start,right,high = 0,len(matrix[0])-1,len(matrix)-1

        while start < len(matrix) and start < len(matrix[0]):
            
            left = start
            index = -1
            while left <= right:
                mid = (left + right) // 2
                if matrix[start][mid] == target:
                    return True
                elif matrix[start][mid] > target:
                    right = mid - 1
                else:
                    if mid == right:
                        index = right
                        break
                    elif matrix[start][mid+1] > target:
                        index = mid
                        break
                    elif matrix[start][mid+1] == target:
                        return True
                    else:
                        left = mid + 1
            
            if index == -1:
                return False
            right = index
            
            index = -1
            low = start
            while low <= high:
                mid = (low + high) // 2
                if matrix[mid][start] == target:
                    return True
                elif matrix[mid][start] > target:
                    high = mid - 1
                else:
                    if mid == high:
                        index = high
                        break
                    elif matrix[mid+1][start]  > target:
                        index = mid
                        break
                    elif matrix[mid+1][start] == target:
                        return True
                    else:
                        low = mid + 1

            
            if index == -1:
                return False
            high = index
        
            start = start + 1
        

        return False
    
