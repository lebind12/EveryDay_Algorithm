n = int(input())
array = list(map(int, input().split(' ')))
x = int(input())
array.sort()
count = 0

start = 0
end = n-1

while start != end:
    if array[start] + array[end] == x:
        count += 1
        start += 1
    elif array[start] + array[end] < x:
        start += 1
    else:
        end -= 1
print(count)