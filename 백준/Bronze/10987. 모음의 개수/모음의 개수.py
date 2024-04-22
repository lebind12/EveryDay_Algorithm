word = list(input().rstrip())
count = 0
target = ['a', 'e', 'i', 'o', 'u']
for w in word:
    if w in target:
        count += 1
        
print(count)