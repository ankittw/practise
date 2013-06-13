#include<stdio.h>
#include<conio.h>
//void quicksort(int[],int low,int high)
//void add(int a[],int);
void swap(int,int);
//void disp(int[],int);

void add(int a[],int n)
{int i;
 for(i=0;i<n;i++)
 scanf("%d",&a[i]);
}
void quicksort(int a[],int low,int high)
{
     if(low<high)
     {
     int i,j,temp;
     int key;
     key=a[low];
     
     i=low;
     j=high+1;
     do{
     
            do i++; while(a[i]<key );
            
            do j--; while(a[j]>key );
            
          if(i<j)  {
                   temp=a[i];
                   a[i]=a[j];
                   a[j]=temp;
                   }
            }
            while(i<j);
            temp=a[j];
                   a[j]=key;
                   a[low]=temp;
      quicksort(a,low,j-1);
      quicksort(a,j+1,high);
      
}
}
void swap(int a,int b)
{ int temp;
 temp=a;
 a=b;
 b=temp;
}               

 
 void display(int a[],int n)
 {
      int i;
      for(i=0;i<n;i++)
  printf("%d",a[i]);
}
               
int main()

 {   int a[10];
  add(a,10);
  quicksort(a,0,9);
  display(a,10);
  getch();
  return 0;
}
