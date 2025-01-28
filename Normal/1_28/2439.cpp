#include <iostream>

using namespace std;

int main(){
    int number = 0;
    cin >> number;
    for(int i = 1; i<=number; i++){
        // 줄 마다 카운트
        for(int k = 0; k<number - i; k++){
            cout << " ";
        }
        for(int a = 0; a<i; a++){
            cout << "*";
        }
        cout << "\n";
    }
    return 0;
}