def solution(new_id):
    answer = new_id
    # 1단계 lower
    answer = new_id.lower()
    # 2단계 isalpha 
    tmp = ''
    for i in range(len(answer)):
        if answer[i] in ['-', '_', '.'] or answer[i].isalpha() or answer[i].isdigit():
            tmp += answer[i]
    answer = tmp
    # 3단계 마침표 줄이기
    tmp = ''
    dot_founded = False
    for i in range(len(answer)):
        if answer[i] != '.':
            tmp += answer[i]
            if dot_founded:
                dot_founded = False
        else:
            if not dot_founded:
                dot_founded = True
                tmp += answer[i]
    answer = tmp
    # 4단계 마침표 strip
    if len(answer) >= 2:
        if answer[0] == '.':
            answer = answer[1:]
        if answer[-1] == '.':
            answer = answer[:-1]
    else:
        if answer == '.':
            answer = ''
    # 5단계 빈문자 a 대입
    if len(answer) == 0:
        answer = 'a'
    # 6단계 16자 미만의 글자
    if len(answer) >= 16:
        answer = answer[:15]
    if len(answer) >= 2:
        if answer[0] == '.':
            answer = answer[1:]
        if answer[-1] == '.':
            answer = answer[:-1]
    else:
        if answer == '.':
            answer = ''
    # 7단계 2자 이하의 글자
    if len(answer) <= 2:
        last_letter = answer[-1]
        while len(answer) < 3:
            answer += last_letter
    
    return answer