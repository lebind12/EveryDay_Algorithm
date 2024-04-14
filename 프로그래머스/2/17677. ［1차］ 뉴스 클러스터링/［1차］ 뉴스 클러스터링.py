def solution(str1, str2):
    answer = 0
    and_amount = 0
    or_amount = 0
    
    # 1. 두개씩 끊는다
    # 2. 정렬한다
    # 3. 비교해서 앞글자가 다른게 보이면 넘어간다.
    # 4. 개수 비교해서 나눈거에 65536 곱하기
    str1 = str1.lower()
    str2 = str2.lower()
    list_str1 = []
    list_str2 = []
    len_str1 = len(str1)
    len_str2 = len(str2)
    
    for i in range(len_str1-1):
        if str1[i].isalpha() and str1[i+1].isalpha():
            list_str1.append(str1[i] + str1[i+1])
    for i in range(len_str2-1):
        if str2[i].isalpha() and str2[i+1].isalpha():
            list_str2.append(str2[i] + str2[i+1])

    
    if len(list_str1) == 0 and len(list_str2) == 0:
        return 1 * 65536
    
    list_str1.sort()
    list_str2.sort()
    
    # print(list_str1)
    # print(list_str2)
    
    and_list = []
    or_list = []
    
    str1_index = 0
    str2_index = 0
    
    while True:
    # for i in range(1):
        if str1_index >= len(list_str1) or str2_index >= len(list_str2):
            break
        a = list_str1[str1_index]
        b = list_str2[str2_index]
        # print(a, b)
        if a[0] == b[0]:
            if a[1] == b[1]:
                and_list.append(a)
                or_list.append(a)
                str1_index += 1
                str2_index += 1
            else:
                if a[1] < b[1]:
                    or_list.append(a)
                    str1_index += 1
                else:
                    or_list.append(b)
                    str2_index += 1
        elif a[0] < b[0]:
            or_list.append(a)
            str1_index += 1
        else:
            or_list.append(b)
            str2_index += 1
            
    # print(str1_index, str2_index)   
    
    
    if str1_index < len(list_str1):
        for i in range(str1_index, len(list_str1)):
            or_list.append(list_str1[i])
    if str2_index < len(list_str2):
        for i in range(str2_index, len(list_str2)):
            or_list.append(list_str2[i])
    
    # print(and_list)
    # print(or_list)
    
    and_amount = len(and_list)
    or_amount = len(or_list)
    answer = (and_amount / or_amount) * 65536 // 1
    return answer