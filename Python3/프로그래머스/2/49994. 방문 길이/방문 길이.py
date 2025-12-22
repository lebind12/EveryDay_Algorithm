from pprint import pprint
def check(y, x):
    return y >= 0 and y <= 10 and x >= 0 and x <= 10

def solution(dirs):
    answer = 0
    # 상 하 좌 우
    # U D L R
    dy = [-1, 1, 0, 0]
    dx = [0, 0, -1, 1]
    cur_point = [5, 5]
    
    route_set = set()
    
    print(cur_point)
    
    for dir in dirs:
        if dir == 'U':
            if check(cur_point[0] + dy[0], cur_point[1] + dx[0]):
                cur_point[0] += dy[0]
                cur_point[1] += dx[0]
                
                route_set.add(((cur_point[0]+1, cur_point[1]), (cur_point[0], cur_point[1])))
                route_set.add(((cur_point[0], cur_point[1]), (cur_point[0]+1, cur_point[1])))
        elif dir == 'D':
            if check(cur_point[0] + dy[1], cur_point[1] + dx[1]):
                cur_point[0] += dy[1]
                cur_point[1] += dx[1]
                
                route_set.add(((cur_point[0]-1, cur_point[1]), (cur_point[0], cur_point[1])))
                route_set.add(((cur_point[0], cur_point[1]), (cur_point[0]-1, cur_point[1])))
        elif dir == 'L':
            if check(cur_point[0] + dy[2], cur_point[1] + dx[2]):
                cur_point[0] += dy[2]
                cur_point[1] += dx[2]
                
                route_set.add(((cur_point[0], cur_point[1]+1), (cur_point[0], cur_point[1])))
                route_set.add(((cur_point[0], cur_point[1]), (cur_point[0], cur_point[1]+1)))
        elif dir == 'R':
            if check(cur_point[0] + dy[3], cur_point[1] + dx[3]):
                cur_point[0] += dy[3]
                cur_point[1] += dx[3]
                
                route_set.add(((cur_point[0], cur_point[1]-1), (cur_point[0], cur_point[1])))
                route_set.add(((cur_point[0], cur_point[1]), (cur_point[0], cur_point[1]-1)))
    
    pprint((route_set))
    return len(route_set) // 2