def solution(k, ranges):
    answer = []
    # 높이가 낮은구간의 직사각형과 더 높은구간의 직각삼각형의 너비
    # 직사각형은 높이가 낮은구간의 가로폭은 1, 세로폭은 더 작은 값,
    # 직각삼각형은 가로폭 1, 세로폭은 두 수의 차이
    # 전체 직사각형에서 직각삼각형 빼기
    # max_h - ((max_h - min_h) / 2)) => max_h / 2 + min_h / 2
    
    kol = []
    while True:
        kol.append(k)
        if k == 1:
            break
        if k % 2 == 0:
            k //= 2
        else:
            k = k * 3 + 1
    answers = []
    for r in ranges:
        answer = 0.0
        reverse_flag = 1
        start = r[0]
        end = len(kol) + r[1]
        if end <= start:
            answer = -1.0
        else:
            for i in range(start, end-1):
                answer = answer + (((max(kol[i], kol[i+1]) + min(kol[i], kol[i+1])) / 2) * reverse_flag)
        answers.append(answer)
    
    return answers