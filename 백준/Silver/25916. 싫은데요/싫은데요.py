N, M = map(int, input().split(' '))
start = 0
end = 1
array = list(map(int, input().split(' ')))

maximum = 0
s = array[0]
while start < N:
    if s > M :
        s -= array[start]
        start += 1
    else:
        maximum = max(s, maximum)
        if end == N:
            s -= array[start]
            start += 1
        else:
            s += array[end]
            end += 1
print(maximum)