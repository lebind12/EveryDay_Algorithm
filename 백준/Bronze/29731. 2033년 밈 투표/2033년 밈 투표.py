a = ['Never gonna give you up', 'Never gonna let you down', 'Never gonna run around and desert you', 'Never gonna make you cry', 'Never gonna say goodbye', 'Never gonna tell a lie and hurt you', 'Never gonna stop']
N = int(input())
flag = True
for _ in range(N):
    b = input().rstrip()
    if b not in a:
        print('Yes')
        flag = False
        break
if flag:
    print('No')
