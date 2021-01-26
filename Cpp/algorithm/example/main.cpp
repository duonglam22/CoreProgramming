#include <bits/stdc++.h>

using namespace std;

// Complete the flatlandSpaceStations function below.
int flatlandSpaceStations(int n, vector<int> c) {
    int m = c.size();
    if(n == m) {
        return 0;
    }
    int result = 0;
    int distanceLeft = 0;
    int distanceRight = 0;
    bool flagEnd = true;
    bool flagBegin = true;
    vector<int> dataCity(n);
    for(int i = 0; i < n; i++) {
        dataCity[i] = 0;
    }
    //1 is station
    for(int i =5 0; i < m; i++) {
        dataCity[c[i]] = 1;
    }
    for (int i = 0; i < n; i++) {
        if(dataCity[i] == 1) {
            result = i;
            break;
        }
    }
    for(int i = 0; i < n; i++) {
        
        //is station
        if(dataCity[i] == 1) {
            distanceRight = 0;
            distanceLeft = 0;
            // flagBegin = false;
            continue;
        }
        
        if(i != 0) {
            distanceLeft += 1;
        }
        
        
        //travel right
        if(distanceRight > 0 && flagEnd) {
            distanceRight -= 1;
        }
        else {
            if(i < n-1) {
                flagEnd = false;
                for(int j = i+1; j < n; j++) {
                    distanceRight += 1;
                    if(dataCity[j] == 1) {
                        flagEnd = true;
                        break;
                    }

                }
            }
        }
        
        int tem = distanceRight < distanceLeft ? distanceRight : distanceLeft;
        if(result < tem) {
            result = tem;
        }
    }
    
    return result;
}

int main()
{
    int n;
    int m;

    cout << "input n: " << endl;
    cin >> n;
    cout << "input m: " << endl;
    cin >> m;

    vector<int> c(m);

    for (int i = 0; i < m; i++) {
        int c_item; 
        cout << "input number: " << endl;
        cin >> c_item;
        c[i] = c_item;
    }

    int result = flatlandSpaceStations(n, c);

    cout <<"result is: " << result << "\n";

    return 0;
}

