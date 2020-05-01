class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0: return 1;
        sign = True if n > 0 else False
        res,tmp,n = 1,x,abs(n)
        tmp,v = x,1
        if v & n:
            res = res * tmp
        v = v << 1
        while v <= n:
            tmp = tmp * tmp
            if v & n:
                res = res * tmp
            v = v << 1
        if not sign:
            res = 1 / res
        return res

