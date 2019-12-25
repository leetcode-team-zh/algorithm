class Solution:
    def reverseWords(self, s: str) -> str:
        res,size,i= [],len(s),0
        while i < size:
            if s[i] != " ":
                start = i
                while  i < size and s[i]!= " ":
                    i= i + 1
                res.insert(0,s[start:i])                
            else:
                i = i + 1
        return " ".join(res)
