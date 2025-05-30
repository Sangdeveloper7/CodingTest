#!/bin/bash

start_date="2025-02-02"
branch="main"

files=(
  "out/production/Codingtest/ArraySort.class"
  "out/production/Codingtest/PR_ab출력.class"
  "out/production/Codingtest/PR_구명보트_Sliding.class"
  "out/production/Codingtest/PR_보석쇼핑_Sliding_HashMap.class"
  "out/production/Codingtest/백준/백준_구간합구하기_SegmentTree.class"
  "out/production/Codingtest/백준/백준_수열2559_SlidingWindow.class"
  "out/production/Codingtest/백준/백준_숫자의합.class"
  "out/production/Codingtest/PR_가장큰정사각형_DP.class"
  "out/production/Codingtest/PR_거스름돈_DP.class"
  "out/production/Codingtest/PR_네트워크_DFS.class"
  "out/production/Codingtest/PR_시험장나누기.class"
  "out/production/Codingtest/PR_정수를나선형으로배치하기.class"
  "out/production/Codingtest/취업준비/Race$Decrement.class"
  "out/production/Codingtest/취업준비/Race$Increment.class"
  "out/production/Codingtest/취업준비/Race.class"
  "out/production/Codingtest/취업준비/Mutex$Decrement.class"
  "out/production/Codingtest/취업준비/Mutex$Increment.class"
  "out/production/Codingtest/취업준비/Mutex.class"
  "out/production/Codingtest/마라톤.class"
  "out/production/Codingtest/백준/백준_N과M1_BackTracking.class"
  "out/production/Codingtest/백준/백준_N과M2_BackTracking.class"
  "out/production/Codingtest/백준/백준_내리막길_DFS.class"
  "out/production/Codingtest/백준/백준_알파벳_BackTrackingNode.class"
  "out/production/Codingtest/백준/백준_알파벳_BackTracking.class"
  "out/production/Codingtest/백준/백준_연구소_BFSNode.class"
  "out/production/Codingtest/백준/백준_연구소_BFS.class"
  "out/production/Codingtest/백준/백준_퇴사_DP.class"
  "out/production/Codingtest/백준/백준_평범한배낭_DPGoods.class"
  "out/production/Codingtest/백준/백준_평범한배낭_DP.class"
  "out/production/Codingtest/BackTracking.class"
  "out/production/Codingtest/PR_2곱하기N_DP.class"
  "out/production/Codingtest/PR_ab출력.class"
  "out/production/Codingtest/Race$Decrement.class"
  "out/production/Codingtest/Race$Increment.class"
  "out/production/Codingtest/Race.class"
  "out/production/Codingtest/Race_Practice_쓰레드$Decrement.class"
  "out/production/Codingtest/Race_Practice_쓰레드$Increment.class"
  "out/production/Codingtest/Race_Practice_쓰레드.class"
  "out/production/Codingtest/백준/백준_알파벳_BackTrackingNode.class"
  "out/production/Codingtest/백준/백준_알파벳_BackTracking.class"
  "out/production/Codingtest/백준/백준_연구소_BFSNode.class"
  "out/production/Codingtest/백준/백준_연구소_BFS.class"
  "out/production/Codingtest/백준/백준_퇴사_DPSang.class"
  "out/production/Codingtest/백준/백준_평범한배낭_DPSGoods.class"
  # 15개 더 채워야 함 — 나머지 파일 이름 다 주면 자동 추가해줄게
)

for i in "${!files[@]}"
do
  file=${files[$i]}
  commit_date=$(date -v+${i}d -j -f "%Y-%m-%d" "$start_date" "+%Y-%m-%dT12:00:00")

  git add "$file"
  GIT_AUTHOR_DATE="$commit_date" \
  GIT_COMMITTER_DATE="$commit_date" \
  git commit -m "🌱 $file 잔디 심기 커밋" --date="$commit_date"
done

git push origin $branch