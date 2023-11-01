N, M = map(int, input().split(' '))
values = list(map(int, input().split(' ')))
sums = []
sums.append(0)
for i in range(1, N+1):
    sums.append(sums[i-1] + values[i-1])
# print(sums)

count = 0
for i in range(N+1):
    for j in range(i+1, N+1):
        if sums[j] - sums[i] == M:
            # print(j, i)
            count += 1
print(count)