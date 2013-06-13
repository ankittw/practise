#include<iostream>
#include<string.h>
using namespace std;
int max(int a,int b)
    {   if(a>b)
            return a;
        else
            return b;
    }
int dpwithfirst(int a[],int i)
            {   if(i==0)
                return a[0];
                else if(i==1)
                    return max(a[0],a[1]);
                else
                        return max(dpwithfirst(a,i-2)+a[i],dpwithfirst(a,i-1));
            }
int dpwithlast(int a[],int i)
            {   if(i==0)
                    return a[1];
                else if(i==1)
                        return a[1];
                else if(i==2)
                        return max(a[1],a[2]);
                else
                            return max(dpwithlast(a,i-2)+a[i],dpwithlast(a,i-1));
            }
 int main()
{   int a[] = {10, 3, 2, 5, 7, 8};
    int b[]={1,2,3,4,5,1,2,3,4,5};
    int c[]= {94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61, 6, 237,
        12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397, 52, 72, 37, 51, 1, 81,
        45, 435, 7, 36, 57, 86, 81, 72};
    int d[]={7, 7, 7, 7, 7, 7, 7};

   int size_a=sizeof(a)/sizeof(int);
   int size_b=sizeof(b)/sizeof(int);
   int size_c=sizeof(c)/sizeof(int);
   int size_d=sizeof(d)/sizeof(int);
   cout<<"\n"<<max(dpwithfirst(a,size_a-2),dpwithlast(a,size_a-1));
   cout<<"\n"<<max(dpwithfirst(b,size_b-2),dpwithlast(b,size_b-1));
    cout<<"\n"<<max(dpwithfirst(c,size_c-2),dpwithlast(c,size_c-1));
    cout<<"\n"<<max(dpwithfirst(d,size_d-2),dpwithlast(d,size_d-1));
     return 0;
 }
