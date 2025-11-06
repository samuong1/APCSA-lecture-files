import random

N = 10000
M = 10000
s = "" 
direction = ["N", "S", "E", "W"]
s += (f"{N} {M}\n")
for i in range(N):
    s += random.choice(direction) + " " + str(random.randint(1, int(1e9))) + "\n"
for i in range(M):
    s += str(random.randint(1, int(1e9))) + "\n"
print(s)