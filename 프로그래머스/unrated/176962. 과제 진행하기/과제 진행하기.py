import heapq


def solution(plans):
    answer = []
    # plan : [과목, 시작시간, 걸리는시간]
    # 1. plan을 받는다.
    # 2. 시작시간을 본다.
    # 3. 이미 시작한 과제가 있다면 걸리는 시간을 하던 과제의 시작시간에서 받은 시작시간 간의 차이를 빼준다.
    # 4. 덜한 과제를 리스트에 모아둔다.
    
    # 배열은 시간 순으로 정렬되어있지 않다.
    works = []
    later_works = []
    for plan in plans:
        homework, start, time = plan
        # 힙에 넣을 요소들 정리
        hour, minute = map(int, start.split(':'))
        start = hour * 60 + minute
        time = int(time)
        heapq.heappush(works, (start, time, homework))
    
    # 힙에서 빼면서 시작시간을 기억
    before = [-1, -1, "blank"]
    later = 0
    while len(works):
        start, time, homework = heapq.heappop(works)
        # print([start, time, homework], before)
        # print(later_works)
        # 처음으로 꺼낸거
        if before[0] == -1:
            before = [start, time, homework]
            continue
        
        # 꺼낸 거 확인
        # 만일 start - before.start 가 before.time 보다 작으면 => 덜한거
        if start - before[0] < before[1]:
            # 덜한거는 나중에 하기 힙에 넣음, 우선 순위 기억
            heapq.heappush(later_works, [later, before[1] - (start - before[0]), before[2]])
            # before는 이제 새로 시작하는걸로
            before = [start, time, homework]
            later -= 1
        # 다하고 바로 꺼내면 answer에 추가하고 다음꺼 받음
        elif start - before[0] == before[1]:
            answer.append(before[2])
            before = [start, time, homework]
        # 여유가 있으면 덜한거 꺼내서 좀 하다가 넣음
        else:
            answer.append(before[2])
            remain_time = start - before[0]
            # 만일 미룬게 있으면
            while len(later_works) > 0:
                later_prior, later_time, later_homework = heapq.heappop(later_works)
                # later_time과 start - before[0]를 비교
                # 남은 시간보다 더 여유있으면 힙에서 빼고 answer에 추가
                if remain_time - before[1] >= later_time:
                    answer.append(later_homework)
                    remain_time -= later_time
                # 여유 없으면 쫌만 하다가 다시 later_works에 같은 우선순위로 집어넣음
                else:
                    heapq.heappush(later_works, [later_prior, later_time - (start - before[0] - before[1]), later_homework])
                    break
            before = [start, time, homework]
            
    # print(before)
    # print(later_works)
    answer.append(before[2]) # 마지막으로 하던거 끝내고
    # 미룬거 모두 제거
    while len(later_works):
        _, _, homework = heapq.heappop(later_works)
        answer.append(homework)
    return answer