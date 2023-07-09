import sys
input = sys.stdin.readline

board = []
for _ in range(12):
	board.append(list(input().rstrip()))

visit = [[0 for _ in range(6)] for _ in range(12)]
global combo_count
ans = 0

def find_combo(i, j, color, count):
	global combo_count

	try:
		if visit[i][j] == 0 and board[i][j] == color:
			visit[i][j] = count
			combo_count += 1
			if i > 0:
				find_combo(i-1, j, color, count)
			if i < 11:
				find_combo(i+1, j, color, count)
			if j > 0:
				find_combo(i, j-1, color, count)
			if j < 5:
				find_combo(i, j+1, color, count)
	except:
		print(i, j)

def gravity():
	for i in range(6):
		for j in range(10, -1, -1):
			if board[j][i] != '.' and board[j+1][i] =='.':
				for k in range(11, j, -1):
					if board[k][i] =='.':
						board[k][i] = board[j][i]
						board[j][i] = '.'

while(1):
	combo = False
	count = 0
	# Find combo and explode them
	for i in range(12):
		for j in range(6):
			if board[i][j] != '.':
				combo_count = 0
				count += 1
				find_combo(i, j, board[i][j], count)
				if combo_count >3:
					combo = True
					for k in range(12):
						for l in range(6):
							if visit[k][l] == count:
								board[k][l] = '.'

	if combo ==False:
		break

	ans +=1		
	#implement gravity
	gravity()

	#initialize visit
	for k in range(12):
		for l in range(6):
			visit[k][l] = 0

print(ans)