from collections import deque


def solution(priorities, location):
    answer = 0
    length = len(priorities)
    sorted_list = deque(sorted(priorities))
    locs = [i for i in range(length)]
    
    priorities = deque(priorities)
    locs = deque(locs)

    while True:
        v = priorities.popleft()
        loc = locs.popleft()
        if v == sorted_list[-1]:
            sorted_list.pop()
            answer += 1
            if loc == location:
                break
        else:
            priorities.append(v)
            locs.append(loc)
            
    return answer