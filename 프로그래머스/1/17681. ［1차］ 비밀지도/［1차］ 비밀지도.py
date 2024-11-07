def solution(n, arr1, arr2):
    answer = []

    for i in range(len(arr1)):
        line = str(bin(arr1[i] | arr2[i]))[2:]
        while len(line) < n:
            line = '0'+line
        
        line = line.replace('1', '#')
        line = line.replace('0', ' ')
        
        answer.append(line)
    
    return answer