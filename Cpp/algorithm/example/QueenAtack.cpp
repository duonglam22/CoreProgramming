#include <bits/stdc++.h>

using namespace std;

vector<string> split_string(string);

int subSpecial(int a, int b) {
    if(a >= b) {
        return a - b;
    }
    else 
    return b - a;
}

// Complete the queensAttack function below.
int queensAttack(int n, int k, int r_q, int c_q, vector<vector<int>> obstacles) {
    int rowQueen = n - r_q;
    int colQueen = c_q - 1;

    int count = 0;
    int countU = -1;
    int countD = -1;
    int countL = -1;
    int countR = -1;
    int countUR = -1;
    int countUL = -1;
    int countDR = -1;
    int countDL = -1;

    for(int i = 0; i < k; i++) {
        int row = n - obstacles[i][0];
        int col = obstacles[i][1] - 1;

        if(rowQueen == row && colQueen == col) {
            return 0;
        }

        //itorator L
        if(rowQueen == row && col < colQueen) {
            int tem = colQueen - col - 1;
            if(countL == -1 ) {
                countL = tem;
            }
            else {
                countL = countL <= tem ? countL : tem;
            }
            continue;
        }

        //itorator R
        if(rowQueen == row && col > colQueen) {
            int tem = col - colQueen - 1;
            if(countR == -1) {
                countR = tem;
            }
            else {
                countR = countR <= tem ? countR : tem;
            }
            continue;
        }

        //itorator U
        if(colQueen == col && row < rowQueen) {
            int tem = rowQueen - row -1;
            if(countU == -1) {
                countU = tem;
            }
            else {
                countU = countU <= tem ? countU : tem;
            }
            continue;
        }

        //itorator D
        if(colQueen == col && row > rowQueen) {
            int tem = row - rowQueen - 1;
            if(countD == -1) {
                countD = tem;
            }
            else {
                countD = countD <= tem ? countD : tem;
            }
            continue;
        }

        //interator UL
        if(row < rowQueen && col < colQueen) {
            if(rowQueen - row == colQueen - col) {
                int tem = rowQueen - row -1;
                if(countUL == -1) {
                    countUL = tem;
                }
                else {
                    countUL = countUL <= tem ? countUL : tem;
                }
            }
            continue;
        }

        //iterator UR
        if(row < rowQueen && col > colQueen) {
            if(rowQueen - row == col -colQueen) {
                int tem = rowQueen - row - 1;
                if(countUR == -1) {
                    countUR = tem;
                }
                else {
                    countUR = countUR <= tem ? countUR : tem;
                }
            }
            continue;
            
        }

        //iterator DL
        if(row > rowQueen && col < colQueen) {
            if(row - rowQueen == colQueen - col) {
                int tem = row - rowQueen - 1;
                if(countDL == -1) {
                    countDL = tem;
                }
                else {
                    countDL = countDL <= tem ? countDL : tem;
                }
            }
            continue;
        }

        //iterator DR
        if(row > rowQueen && col > colQueen) {
            if(row - rowQueen == col - colQueen) {
                int tem = row - rowQueen - 1;
                if(countDR == -1) {
                    countDR = tem;
                }
                else {
                    countDR = countDR <= tem ? countDR : tem;
                }
            }
            continue;
        }
    }

    if(countU != -1) {
        count += countU;
    } 
    else  {
        count += rowQueen;
    }

    if(countD != -1) {
        count += countD;
    }
    else {
        count += n - rowQueen - 1;
    }

    if(countL != -1) {
        count += countL;
    }
    else {
        count += colQueen;
    }

    if(countR != -1) {
        count += countR;
    }
    else {
        count += n - colQueen - 1;
    }

    if(countUR != -1) {
        count += countUR;
    }
    else {
        int colTem = n - colQueen - 1;
        int tem = rowQueen <= colTem ? rowQueen : colTem;
        count += tem;
    }

    if(countUL != -1) {
        count += countUL;
    }
    else {
        int tem = rowQueen <= colQueen ? rowQueen : colQueen;
        count += tem;
    }

    if(countDR != -1) {
        count += countDR;
    }
    else {
        int rowTem = n - rowQueen -1;
        int colTem = n - colQueen -1;
        int tem = rowTem <= colTem ? rowTem : colTem;
        count += tem;
    }

    if(countDL != -1) {
        count += countDL;
    }
    else {
        int rowTem = n - rowQueen -1;
        int tem = rowTem <= colQueen ? rowTem : colQueen;
        count += tem;
    }

    return count;
}

int main()
{
    int n;
    int k;
    int r_q;
    int c_q;

    cout << "input n: " << endl;
    cin >>n;
    cout << "input k: " << endl;
    cin >> k;
    cout << "input r_q: " << endl;
    cin >> r_q;
    cout << "input c_q: " << endl;
    cin >> c_q;

    vector<vector<int>> obstacles(k);
    for (int i = 0; i < k; i++) {
        obstacles[i].resize(2);
        for (int j = 0; j < 2; j++) {
            cin >> obstacles[i][j];
        }
    }
    cout << "obstacles size: " << obstacles.size() << endl;
    int result = queensAttack(n, k, r_q, c_q, obstacles);
    cout << "result: " << result << "\n";
    return 0;
}
