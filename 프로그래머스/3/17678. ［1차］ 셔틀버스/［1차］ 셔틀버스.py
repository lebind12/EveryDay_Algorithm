from collections import deque

def time_format_delta(time):
    hour, minute = map(int, time.split(':'))
    return hour * 60 + minute

def time_delta_format(delta):
    hour = delta // 60
    minute = delta % 60
    return f"{hour:02d}:{minute:02d}"

def solution(n, t, m, timetable):
    timetable.sort(key = lambda x : time_format_delta(x))
    current = time_format_delta("09:00")
    answer = "09:00"
    timetable = deque(timetable)
    
    # 막차 전까지 승객 실어 보내기
    while n:
        if n == 1:
            break
        
        # 차 도착, 최대 m명만큼
        for i in range(m):
            if time_format_delta(timetable[0]) <= current:
                timetable.popleft()
        current += t # 다음 차
        n -= 1
        
    # 막차
    print(time_delta_format(current))
    # 막차에 탈 수 있는 인원 조사
    available_people = 0
    for i in range(len(timetable)):
        if time_format_delta(timetable[i]) > current:
            break
        else:
            available_people += 1
    if available_people + 1 <= m: # 콘을 포함한 모두를 막차에 태울 수 있으면
        answer = time_delta_format(current) # 막차 도착시간에 오면 됨
    else: # 모두 못태우면
        # 탈 수 있는 사람들 중 가장 늦은 사람보다 1분 먼저 오면 됨.
        last_one = time_format_delta(timetable[m-1])
        answer = time_delta_format(last_one - 1)
            
    return answer