import sys

# 입력을 한 줄에서 공백으로 구분하여 받습니다.
# sys.stdin.readline()은 한 줄을 읽어오고, .split()은 공백을 기준으로 문자열을 나눕니다.
# map(int, ...)를 사용하여 나눠진 문자열들을 각각 정수형(int)으로 변환합니다.
A, B = map(int, sys.stdin.readline().split())

# A에서 B를 뺀 결과를 출력합니다.
print(A - B)