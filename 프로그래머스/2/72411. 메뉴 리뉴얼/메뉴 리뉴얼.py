from itertools import combinations
from collections import defaultdict
import heapq

def solution(orders, course):
    answer = []
    hash_map = defaultdict(int)
    
    for order in orders:
        for c in course:
            datas = combinations(sorted(order), c)
            for data in datas:
                hash_map["".join(data)] += 1
    
    count_map = defaultdict(list)
    for word, count in hash_map.items():
        if count >= 2:
            heapq.heappush(count_map[len(word)], (-1 * count, word))
    
    for c in course:
        if len(count_map[c]) > 0:
            maximum_count = count_map[c][0][0]
            
            for i in range(len(count_map[c])):
                if count_map[c][i][0] == maximum_count:
                    answer.append(count_map[c][i][1])
    
    # print(count_map)
    # print(answer)
    
    answer.sort()
    
    return answer