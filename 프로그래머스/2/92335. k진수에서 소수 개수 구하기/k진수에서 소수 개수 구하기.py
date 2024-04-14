import math

def isprime(a):
    if a == 1:
        return False
    for i in range(2, int(math.sqrt(a)) + 1):
        if a % i == 0:
            return False
    return True

def n_base(n, q):
    rev_base = ''
    
    while n > 0:
        n, mod = divmod(n, q)
        rev_base += str(mod)
        
    return rev_base[::-1]

def solution(n, k):
    answer = 0
    
    string = n_base(n, k).split('0')
    for word in string:
        if word != '' and isprime(int(word)):
            answer += 1
    return answer