import sys


"""
1377번 Bubble sort
문제에 제시된 코드는 C++로 작성된 코드로
만일 배열이 Bubble sort로 완전히 정렬된 경우에 change 값이 변하지 않으므로
이때의 i 값을 return하라는 코드이다.

Bubble sort를 실행 할 때 idx를 바꾸는 한바퀴를 지나면
맨 오른쪽으로 가는 하나의 인덱스를 제외하고는 다른 인덱스 값들은 좌측으로 한칸씩 움직이게 된다
이 문제는 좌측으로 한칸씩 가게되는 원리를 이용한 문제이다.
"""

# 입력부
N = int(sys.stdin.readline().rstrip())
array = list()
answer = list()
for i in range(N):
    array.append((int(sys.stdin.readline().rstrip()), i))

"""
Bubble sort가 완전히 정렬되어 멈출 때 까지
제자리를 찾지 않은 인덱스는 계속해서 좌측으로 한칸씩 이동하게 된다.
따라서 미리 sorted 된 array를 확인하고 이 array와 원본 array를 비교하여
좌측으로 가장 많이 이동한 원소의 idx 차이가 이 문제의 답이다.
왜냐하면 이 원소가 Bubble sort가 끝날 때 까지 좌측으로 움직였기 때문
"""
sorted_array = sorted(array)
for idx in range(len(sorted_array)):
    answer.append(sorted_array[idx][1] - idx)
# 문제에서 배열의 맨 왼쪽 idx를 1로 정의했기 때문에 1을 더해줌
print(max(answer) + 1)