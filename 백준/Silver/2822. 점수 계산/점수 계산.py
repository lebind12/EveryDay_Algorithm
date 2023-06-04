scores = {}
for i in range(1, 9):
    scores[int(input())] = i
score = sorted(scores, reverse=True)[:5]
print(sum(score))
print(" ".join(sorted([str(scores[s]) for s in score])))