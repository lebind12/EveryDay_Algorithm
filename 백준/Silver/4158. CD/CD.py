import sys

input = sys.stdin.readline
while True:
    N, M = map(int, input().split(' '))
    if N == 0 and M == 0:
        break
    sun = []
    sang = []
    for _ in range(N):
        sun.append(int(input()))
    for _ in range(M):
        sang.append(int(input()))
    sun_pointer = 0
    sang_pointer = 0
    count = 0
    while sun_pointer < N and sang_pointer < M:
        # print(sun[sun_pointer], sang[sang_pointer])
        if sun[sun_pointer] == sang[sang_pointer]:
            count += 1
            sun_pointer += 1
            sang_pointer += 1
        elif sun[sun_pointer] > sang[sang_pointer]:
            if sang_pointer == M-1:
                sun_pointer += 1
            else:
                sang_pointer += 1
        elif sun[sun_pointer] < sang[sang_pointer]:
            if sun_pointer == N - 1:
                sang_pointer += 1
            else:
                sun_pointer += 1
    print(count)