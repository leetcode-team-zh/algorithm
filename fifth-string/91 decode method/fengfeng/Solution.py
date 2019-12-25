
class Solution:
    def numDecodings(self, s: str) -> int:
        strLen,a,b = len(s),1,0
        if strLen == 0:
            return 0
        cur = strLen - 1
        while cur >= 0:
            c = s[cur:cur+1]
            if c == '1':
                a,b= a + b,a
            elif c == '2':
                if cur + 1 < strLen and s[cur+1:cur+2] > '6':
                    a,b=a,a
                else:
                    a,b=a+b,a
            elif c =='0':
                a,b=0,a
            else:
                a,b=a,a
            cur = cur - 1
        return a
        
