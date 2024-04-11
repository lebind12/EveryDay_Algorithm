N = int(input())
string = list(str(N))

if N % 7 == 0:
    if '7' in string:
        print(3)
    else:
        print(1)
else:
    if '7' in string:
        print(2)
    else:
        print(0)