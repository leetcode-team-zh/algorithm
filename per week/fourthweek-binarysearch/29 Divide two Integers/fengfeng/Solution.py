
class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        isNeg = (dividend > 0) ^ (divisor > 0)
        dividend  = dividend if dividend > 0 else abs(dividend)
        divisor = divisor if divisor > 0 else  abs(divisor)
        if dividend < divisor:
            return 0
        count,res = 0,0
        while dividend >= (divisor << count):
            count = count + 1
        while count >= 0 and dividend > 0:
            tmp =  divisor << count
            if tmp <= dividend:
                res = res + (1 << count)
                dividend = dividend -  tmp
            count = count - 1
        if isNeg:
            res = 0 - res
        return res if -(1<<31) <= res <= (1<<31)-1 else (1<<31)-1 
