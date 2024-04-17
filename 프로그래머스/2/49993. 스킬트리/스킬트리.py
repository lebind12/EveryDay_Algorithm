def solution(skill, skill_trees):
    answer = 0
    
    skill = skill[::-1]
    
    for trees in skill_trees:
        trees = trees[::-1]
        skill_index = 0
        tree_index = 0
        found = False
        while True:
            if found and skill_index >= len(skill):
                answer += 1
                break
            
            elif found and skill_index < len(skill) and tree_index >= len(trees):
                break
                
            if not found and tree_index >= len(trees):
                tree_index = 0
                skill_index += 1
                if skill_index >= len(skill):
                    answer += 1
                    break
            
            if trees[tree_index] == skill[skill_index]:
                skill_index += 1
                if not found:
                    found = True
            tree_index += 1
    return answer