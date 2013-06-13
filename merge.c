#include<stdio.h>
#include<conio.h>

void mergesort(int[],int low,int high);
void merge(int[],int low,int mid,int high);
void display(int arr[],int low,int hig){
     int i;
     for(i=low;i<=hig;i++)
  printf("%d  ",arr[i]);
  printf("\n");
     
}

int main()
{ int i,a[5];
  for(i=0;i<5;i++)
  scanf("%d",&a[i]);
for(i=0;i<5;i++)
  printf("%d\n",a[i]);
  mergesort(a,0,4);

  for(i=0;i<=4;i++)
  printf("%d\n",a[i]);
  getch();
  return 0;
}
void mergesort(int a[],int low,int high)
{ int mid;
              if(low<high)
{ mid=(low+high)/2;
  printf("inside mergesort");
  display(a,low,high);
//printf("  *** %d ***  ",mid);
 mergesort(a,low,mid);
 mergesort(a,mid+1,high);
 merge(a,low,mid,high);
}
}

void merge(int a[],int low,int mid,int high)
{ int i,j,k,l,b[5];
 i=low;
 j=mid+1;
 k=0;
 while((i<=mid)&&(j<=high))
 { if(a[i]<=a[j])
 { b[k]=a[i];
i++;
}
else
{b[k]=a[j];
j++;}
k++;
}
if(j>high)
{
  for(l=i;l<=mid;l++)
 { b[k]=a[l];
  k++;}
}
if(i>mid)
{ for(l=j;l<=high;l++)
   {b[k]=a[l];
   k++;}
}
          printf("\nDisplaying arra B\n");
display(b,0,(k-1));
k=0;
for(l=low;l<=high;l++)
{
                      a[l]=b[k];
                      k++;
                      }
                      printf("\nDisplaying arra A\n");
                      display(a,low,high);
}

