def get_difference(first_word, second_word):
    length = len(first_word)
    diff_value = 0
    for idx in range(length):
        if first_word[idx] != second_word[idx]:
            diff_value += 1
            
        if diff_value > 1:
            return False
    return True

def recursion(seq_words, start, target, words, visited):
    if target not in words:
        return 0
    
    if seq_words[-1] == target:
        # print(seq_words)
        return len(seq_words) - 1
    
    length = len(words)
    value = 99
    for idx in range(length):
        if not visited[idx] and get_difference(seq_words[-1], words[idx]):
            seq_words.append(words[idx])
            visited[idx] = True
            value = min(recursion(seq_words, idx + 1, target, words, visited), value)
            seq_words.pop()
            visited[idx] = False
    return value
    
def solution(begin, target, words):
    answer = 0
    length = len(words)
    visited = [False] * length
    
    answer = recursion([begin], 0, target, words, visited)
    
    return answer