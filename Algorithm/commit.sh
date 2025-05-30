#!/bin/bash

# 시작 날짜 세팅 (2024년 1월 1일)
start_date="2024-01-01"
# 파일 리스트
filelist="filelist.txt"

# 날짜를 계산하기 위한 카운터
i=0

while read filename; do
    # 파일이 존재할 때만 처리
    if [ -f "$filename" ]; then
        # 날짜 계산
        commit_date=$(date -d "$start_date +$i day" +"%Y-%m-%dT12:00:00")
        # git add/commit
        git add "$filename"
        GIT_AUTHOR_DATE="$commit_date" GIT_COMMITTER_DATE="$commit_date" git commit -m "Add $filename" --date="$commit_date"
        # 카운터 증가
        i=$((i+1))
    else
        echo "$filename 파일이 존재하지 않습니다."
    fi
done < "$filelist"
