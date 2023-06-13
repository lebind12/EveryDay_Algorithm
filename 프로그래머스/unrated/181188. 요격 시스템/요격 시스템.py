def solution(targets):
    answer = 0
    
    # start, end 변수를 설정
    # start는 점점 뒤로, end는 점점 앞으로 가면서 좁힘
    # 새로 받은 start가 end 보다 뒤에있으면 그거 쏴서 요격하고 다음껄 start와 end로 설정
    
    # targets는 start 순으로 정렬
    targets.sort(key = lambda x : x[0])
    # print(targets)
    start, end = targets[0]
    # print(targets)
    for target in targets[1:]:
        new_start, new_end = target
        # 새로 받은 start가 end 보다 뒤에 있으면 그거 쏴서 요격하고 다음껄 start와 end로 설정
        if end <= new_start:
            answer += 1
            start = new_start
            end = new_end
        else:
            if start < new_start:
                start = new_start
            if end > new_end:
                end = new_end
    #     print([start, end])
    # print(answer)
    answer += 1 # 마지막 타겟 처리
    
    return answer