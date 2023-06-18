value = reversed(input().rstrip())
answer = 0
digit = 0
for idx, num in enumerate(value):
    if num.isalpha():
        answer += (ord(num) - 55) * (16 ** idx)
    else:
        answer += int(num) * (16 ** idx)
print(answer)