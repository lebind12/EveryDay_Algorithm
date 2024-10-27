import sys
from collections import defaultdict

input = sys.stdin.readline
N, M = map(int, input().split(' '))
quiz_0_data = defaultdict(list)
quiz_1_data = defaultdict(str)

for _ in range(N):
  team_name = input().rstrip()
  member_count = int(input())
  for _ in range(member_count):
    member_name = input().rstrip()
    quiz_0_data[team_name].append(member_name)
    quiz_1_data[member_name] = team_name

for _ in range(M):
  quiz_question = input().rstrip()
  quiz_category = int(input())
  if quiz_category == 0:
    for member in sorted(quiz_0_data[quiz_question]):
      print(member)
  elif quiz_category == 1:
    print(quiz_1_data[quiz_question])
