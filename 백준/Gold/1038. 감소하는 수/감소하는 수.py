import sys


input = sys.stdin.readline
N = int(input())
table = [[] for _ in range(11)] # 자리수 테이블
count = 0
for i in range(10):
    if count == N:
        print(i)
        exit()
    table[1].append(i)
    count += 1
# 1자리 감소하는 수는 끝
# 앞의 자리수에서 감소하도록 값을 넣음
digit = 2 # 현재 자리수
while digit < 11: # 10자리가 최대 감소수의 자리
    for num in table[digit-1]: # 이전 자리의 감소수를 받아서
        num_last = num % 10 # 이전 자리의 마지막 숫자
        for last in range(0, num_last): # 마지막 숫자에서 값을 하나씩 빼면서
            new_num = num * 10 + last # 만들어진 감소수
            if count == N:
                print(new_num) # count가 똑같으면 그거 출력
                exit()
            else:
                table[digit].append(new_num)
                count += 1
    digit += 1
print(-1) # 못찾았으면 -1
    
