n = int(input())
array = list(map(int, input().split()))
#dp[i]는 i번쨰 원소를 마지막 원소로 하는 LIS의 길이
dp = [1]*n 
for i in range(1,n):
    for j in range(i):
        if array[i] > array[j]:
            dp[i] = max(dp[i], dp[j]+1) #증가하는 경우
            
result = max(dp)
print(result)