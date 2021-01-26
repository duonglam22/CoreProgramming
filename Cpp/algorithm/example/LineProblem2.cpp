#include<iostream>
#include "vector"
using namespace std;

void swap(int** arr, int left, int right)
{
    int first = arr[0][left];
    int second = arr[1][left];
    
    arr[0][left] = arr[0][right];
    arr[1][left] = arr[1][right];
    
    arr[0][right] = first;
    arr[1][right] = second;
}
 
 
int partition (int **arr, int low, int high)
{
    int pivot = arr[1][high];    // pivot
    int left = low;
    int right = high - 1;
    while(true){
        while(left <= right && arr[1][left] < pivot) left++;
        while(right >= left && arr[1][right] > pivot) right--;
        if (left >= right) break;
        swap(arr, left, right);
        left++;
        right--;
    }
    swap(arr, left, high);
    return left;
}
 
void quickSort(int** arr, int low, int high)
{
    if (low < high)
    {

        int pi = partition(arr, low, high);
 
        // recusive
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}

int sub(int a, int b) {
    if(a >= b) 
        return a - b;
    return b - a;
}

int findNearestHouse(int first, int last, int** arr, int &position) {
     //cout << "do find nearest house" << endl;
    if(last - first <= 1) {
        int dis1 = sub(position, arr[1][first]);
        int dis2 = sub(position, arr[1][last]);
        if(dis1 < dis2) {
            return arr[0][first];
        }
        else if(dis1 > dis2) {
            return arr[0][last];
        }
        else {
            if(arr[0][first] <= arr[0][last])
                return arr[0][first];
            return arr[0][last];
        }
    }

    int middleIndex = (first + last)/2;
    if(arr[1][middleIndex] == position) {
        return arr[0][middleIndex];
    }
    if(arr[1][middleIndex] > position) {
        return findNearestHouse(first, middleIndex, arr, position);
    }
    else {
        return findNearestHouse(middleIndex, last, arr, position);
    }
}

int main() {
    int n;
    vector<int> vec;

    //cout << "input n: " << endl;
    cin >> n;

    int** arr;
    arr = new int*[2];
    for(int i = 0; i < 2; i++) {
        arr[i] = new int[n];
    }
    for (int i = 0; i < n; i++) {
        scanf("%d %d", &arr[0][i], &arr[1][i]);
        // cout << arr[0][i] << " " << arr[1][i] << endl;
    }

    while(true) {
        int tmp;
        // cout << "input value: " << endl;
        if(scanf("%d", &tmp) == 1) {
            //  cout << "value : " << tmp << endl;
            vec.push_back(tmp);
        }
        else {
            break;
        }
    }

    // cout << "size vector: " << vec.size() << endl;

    quickSort(arr, 0, n-1);
    for(int i = 0; i < n; ++i) {
        // cout << arr[1][i] << " " ;
    }

    for(int i = 0; i < vec.size(); i++) {
        int result = findNearestHouse(0, n-1, arr, vec[i]);
        cout << result << endl;
    }
    
    return 0;
}