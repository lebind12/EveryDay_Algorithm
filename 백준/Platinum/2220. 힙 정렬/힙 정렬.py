import sys


input = sys.stdin.readline
N = int(input())

# 리스트 연산은 느린데..
answer = [1]
length = 1

# 1. 항상 1의 위치는 answer의 맨 끝.
# 2. 1의 위치를 root 노드로 옮긴다.
# 3. 맨 끝에 최대값을 붙이고 1과 위치를 바꾼다.
# 4. 최대값이 N이 될 때 까지 반복한다.
for i in range(2, N+1):
    one_position = length - 1
    
    while True:
        # 1의 위치가 root 노드면 탈출
        if one_position == 0:
            break
        answer[(one_position - 1) // 2], answer[one_position] = answer[one_position], answer[(one_position - 1) // 2]
        one_position = (one_position - 1) // 2
    
    # 최대값을 끝에 붙이고
    answer.append(i)
    # 1과 위치를 바꾼다.
    answer[one_position], answer[length] = answer[length], answer[one_position]
    length += 1
    # print(answer)
print(" ".join(str(x) for x in answer))