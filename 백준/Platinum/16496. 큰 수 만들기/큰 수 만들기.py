N = int(input())
array = list(map(str, input().split(' ')))
array.sort(key=lambda x : (x * 11)[:11], reverse=True)
if array[0] == '0':
    print('0')
else:
    print("".join(array))