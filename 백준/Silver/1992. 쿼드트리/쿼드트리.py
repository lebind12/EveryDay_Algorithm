def quad_tree(x, y, n):
    # n x n 영상이 모두 같은 값인지 확인
    if n == 1:
        return str(arr[y][x])
    
    result = []
    for i in range(y, y + n):
        for j in range(x, x + n):
            # 한 칸이라도 다르면, 다시 분할
            if arr[i][j] != arr[y][x]:
                # append result of each part
                result.append('(')
                result.extend(quad_tree(x, y, n//2))
                result.extend(quad_tree(x + n//2, y, n//2))
                result.extend(quad_tree(x, y + n//2, n//2))
                result.extend(quad_tree(x + n//2, y + n//2, n//2))
                result.append(')')
                
                return result

    # 모두 같은 값이면, 그 값을 반환
    return str(arr[y][x])

N = int(input())
arr = [list(map(int, list(input()))) for _ in range(N)]
print(''.join(quad_tree(0, 0, N)))
