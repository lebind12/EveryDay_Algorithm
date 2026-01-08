import sys

input = sys.stdin.readline
s = input()
in_num = False
nums = []
num = 0
dump = 0
last_ops = '+'

for ch in s:
    if ch >= '0' and ch <= '9':
        num = num * 10 + (ord(ch) - ord('0'))
        in_num = True
    else:
        if ch == '+':
            dump += num
        else:
            nums.append(dump + num)
            dump = 0
        last_ops = ch
        num = 0
        in_num = False

if in_num:
    nums.append(dump + num)

print(nums[0] - sum(nums[1:]))