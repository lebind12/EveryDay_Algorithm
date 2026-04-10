import sys


input = sys.stdin.readline
s = input().rstrip()

in_bracket = False
words = []
answer = ""
for c in s:
    if c == '<':
        in_bracket = True
        tmp = list(words)
        tmp.reverse()
        answer += "".join(tmp)
        answer += "<"
        words = []
        
    elif c == '>':
        in_bracket = False
        answer += "".join(words)
        answer += ">"
        words = []
    elif c == " ":
        if in_bracket == True:
            answer += "".join(words)
            answer += " "
            words = []
        else:
            tmp = list(words)
            tmp.reverse()
            answer += "".join(tmp)
            answer += " "
            words = []
    else:
        words.append(c)

if words:
    tmp = list(words)
    tmp.reverse()
    answer += "".join(tmp)
    answer += " "
    words = []
        
        
print(answer)