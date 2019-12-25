class Solution:
    def simplifyPath(self, path: str) -> str:
        stack,i,size=[],0,len(path)
        while i < size:
            if path[i] != '/':
                start = i
                while i < size and path[i] != '/':
                    i += 1
                token = path[start:i]
                if token == '..':
                    if len(stack) > 0:
                        stack.pop()
                elif token!='.':
                    stack.append(token)
            i += 1
        return "/" + "/".join(stack)
       
