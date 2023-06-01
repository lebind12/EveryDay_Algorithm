def solution(sequence):
    answer = 0
    N = len(sequence)
    # p는 1부터, n은 -1부터 적용한 pulse_sequence
    dp_pulse_p = [0] * N
    dp_pulse_n = [0] * N
    
    dp_pulse_p[0] = sequence[0]
    dp_pulse_n[0] = sequence[0] * -1
    
    if dp_pulse_p[0] < 0:
        dp_pulse_p[0] = 0
    if dp_pulse_n[0] < 0:
        dp_pulse_n[0] = 0
    
    for i in range(1, N):
        # 짝수 인덱스
        if i % 2 == 0:
            # 짝수는 p일때 1, n일때 -1
            if dp_pulse_p[i - 1] + sequence[i] > 0:
                dp_pulse_p[i] = dp_pulse_p[i - 1] + sequence[i]
            else:
                dp_pulse_p[i] = 0
            
            if dp_pulse_n[i - 1] + (sequence[i] * -1) > 0:
                dp_pulse_n[i] = dp_pulse_n[i - 1] + (sequence[i] * -1)
            else:
                dp_pulse_n[i] = 0
        # 홀수 인덱스
        else:
            # 짝수는 p일때 -1, n일때 1
            if dp_pulse_p[i - 1] + (sequence[i] * -1) > 0:
                dp_pulse_p[i] = dp_pulse_p[i - 1] + (sequence[i] * -1)
            else:
                dp_pulse_p[i] = 0
            
            if dp_pulse_n[i - 1] + sequence[i] > 0:
                dp_pulse_n[i] = dp_pulse_n[i - 1] + sequence[i]
            else:
                dp_pulse_n[i] = 0
    # print(dp_pulse_p)
    # print(dp_pulse_n)
    
    answer = max(max(dp_pulse_p), max(dp_pulse_n))
    return answer