#include<iostream>
using namespace std;
void merge(int arr[][2],int l,int m,int r)
{
    int n1 = m - l +1;
    int n2 = r - m;
    int la[n1][2];
    int ra[n2][2];
    for(int i=0;i<n1;i++)
    {
        la[i][0]=arr[l+i][0];
        la[i][1]=arr[l+i][1];
    }
    for(int i=0;i<n2;i++)
    {
        ra[i][0]=arr[m+i+1][0];
        ra[i][1]=arr[m+i+1][1];
    }
    int i=0;
    int j=0;
    int k=l;
    while (i<n1 && j<n2)
    {
        if (la[i][0]<=ra[j][0])
        {
            arr[k][0]=la[i][0];
            arr[k][1]=la[i][1];
            i++;
        }
        else
        {
            arr[k][0]=ra[j][0];
            arr[k][1]=ra[j][1];
            j++;
        }
        k++;
    }
    while(i<n1)
    {
        arr[k][0]=la[i][0];
        arr[k][1]=la[i][1];
        i++;
        k++;
    }
    while(j<n2)
    {
        arr[k][0]=ra[j][0];
        arr[k][1]=ra[j][1];
        j++;
        k++;
    }
}
void mergesort(int arr[][2],int l,int r)
{
    if(l<r)
    {
        int m = l + (r-l)/2;
        mergesort(arr,l,m);
        mergesort(arr,m+1,r);
        merge(arr,l,m,r);
    }
}
int main()
{

}
