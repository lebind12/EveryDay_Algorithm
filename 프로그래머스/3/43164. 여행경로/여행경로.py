from collections import deque


def solution(tickets):
    answer = []
    queue = deque([["ICN", ["ICN"], []]])

    while queue:
        current, path, used = queue.popleft()
        if len(used) == len(tickets):
            answer.append(path)
        for idx, ticket in enumerate(tickets):
            if ticket[0] == current and idx not in used:
                queue.append([ticket[1], path + [ticket[1]], used + [idx]])
    answer.sort()
    
    return answer[0]