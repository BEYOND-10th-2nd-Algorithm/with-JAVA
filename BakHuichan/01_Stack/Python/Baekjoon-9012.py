def VPS(N):
    point = 0
    while(True):
        if len(N) == point:
            if len(N) == 0:
                return print("YES")
            else:
                return print("NO")
        if N[point:point + 2] == "()":
            N = N[:point] + N[point + 2:]
            point -= 1
        else:
            point += 1

T = int(input())
N = []
for i in range(T):
    VPS(input())
