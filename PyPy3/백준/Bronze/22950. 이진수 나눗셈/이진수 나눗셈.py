N = int(input())
M = int(input().rstrip(), 2)
K = int(input())

D = 1 << K

# print(N, M, K, D)
print("YES") if M % D == 0 else print("NO")
