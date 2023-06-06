N = int(input())
tickets = list(map(int, input().split(' ')))
tickets.sort()
minimum = 1
idx = 0
while True:
    # print(idx)
    if idx >= N:
        print(minimum)
        break
    elif minimum != tickets[idx]:
        print(minimum)
        break
    else:
        idx += 1
        minimum += 1