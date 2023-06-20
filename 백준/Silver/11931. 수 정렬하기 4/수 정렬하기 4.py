arr = []
N = int(input())
for _ in range(N):
    arr.append(int(input()))
arr.sort(reverse=True)
print("\n".join(str(x) for x in arr))