from collections import defaultdict

def solution(topping):
    left_dict = defaultdict(int)
    right_dict = defaultdict(int)
    answer = 0
    
    for x in topping:
        right_dict[x] += 1
        
    # print(right_dict)
    # print()
    
    for x in topping[:-1]:
        right_dict[x] -= 1
        left_dict[x] += 1
        
        if right_dict[x] == 0:
            del right_dict[x]
        
        # print(right_dict)
        # print(left_dict)
        
        if len(right_dict.keys()) == len(left_dict.keys()):
            answer += 1
    return answer