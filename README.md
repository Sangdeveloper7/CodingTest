코딩 테스트 연습 프로젝트 ✨
<p align="center"> <img src="https://img.shields.io/badge/C++-00599C?style=flat&logo=c%2B%2B&logoColor=white"/> <img src="https://img.shields.io/badge/Python-3776AB?style=flat&logo=python&logoColor=white"/> <img src="https://img.shields.io/badge/CodeTest-Practice-green?style=flat"/> </p>
C++, Python으로 작성된 코딩 테스트 문제 풀이 저장소입니다.
알고리즘 및 자료구조 문제 해결 능력을 키우는 것을 목표로 합니다.

<br/>
목차 (Table of Contents)
프로젝트 소개
폴더 구조
설치 및 실행 방법
문제 풀이 예시
기여 방법
라이선스
<br/>
프로젝트 소개
본 저장소는 프로그래밍 문제 풀이 과정을 기록하고, 더 나은 알고리즘을 탐색하기 위해 만들어졌습니다.
다양한 문제를 접하고 꾸준히 풀면서 코딩 테스트 대비에 도움이 되고자 합니다.

언어: C++ 17 이상 / Python 3.8 이상
주요 내용: 자료구조(스택, 큐, 힙 등), 알고리즘(정렬, 그래프, DP 등), 각종 코딩테스트 기출 문제
<br/>
폴더 구조
bash
코드 복사
.
├── README.md               # 리드미 파일
├── cpp_solutions           # C++로 작성된 풀이
│   ├── problem_001.cpp
│   ├── problem_002.cpp
│   └── ...
├── python_solutions        # Python으로 작성된 풀이
│   ├── problem_001.py
│   ├── problem_002.py
│   └── ...
└── docs                    # 추가 문서, 예시 등
    └── ...
cpp_solutions/: C++ 문제 풀이 코드
python_solutions/: Python 문제 풀이 코드
docs/: 문제 요약, 해설, 참고자료 등의 문서
<br/>
설치 및 실행 방법
C++ 예시
컴파일
bash
코드 복사
g++ -o solution cpp_solutions/problem_001.cpp
실행
bash
코드 복사
./solution
Python 예시
실행
bash
코드 복사
python python_solutions/problem_001.py
<br/>
문제 풀이 예시
아래 예시는 단순한 예시 문제를 풀어놓은 샘플입니다. 본인의 문제 풀이 과정을 자유롭게 추가하세요!

cpp
코드 복사
// cpp_solutions/problem_001.cpp
#include <iostream>
using namespace std;

int main() {
    int a, b;
    cin >> a >> b;
    cout << a + b << endl;  // 단순 덧셈 출력
    return 0;
}
python
코드 복사
# python_solutions/problem_001.py
a, b = map(int, input().split())
print(a + b)  # 단순 덧셈 출력
<br/>
기여 방법
저장소를 Fork 합니다.
새로운 브랜치를 생성하세요. (예: git checkout -b feature/new-solution)
새로운 풀이 혹은 수정사항을 추가 후 커밋하세요.
본 저장소에 Pull Request를 생성하세요.
리뷰 및 승인 과정을 거쳐 병합됩니다.
<br/>
라이선스
이 프로젝트는 MIT License를 따릅니다. 자유롭게 포크하여 사용하시고, 언제든 기여하실 수 있습니다.

<br/>
<p align="center"> <b>Made with ♥ for Coding Test Practice</b> </p>
