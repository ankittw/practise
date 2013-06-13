
public class Topcoder
{
public static int maxDonations(int[] a)
{
    int dp1[]=new int[a.length];
    int dp2[]=new int[a.length];
    if(a.length<1)
    return 0;
    if(a.length==1)
    return a[0];
    if(a.length==2)return 
    Math.max(a[0],a[1]);
    if(a.length==3)
    {
    a[0]=Math.max(a[0],a[1]);
    return Math.max(a[0],a[2]);
    }
    dp1[0]=a[0];
    dp1[1]=a[0];
    for(int i =2;i<a.length-1;i++)
    {
    dp1[i]=Math.max(dp1[i-2]+a[i], dp1[i-1]);
    }
    dp2[0]=a[1];
    dp2[1]=a[1];
    dp2[2]=Math.max(a[1],a[2]);
    for(int i = 3;i<a.length;i++)
        dp2[i]=Math.max(dp2[i-2]+a[i], dp2[i-1]);
    return Math.max(dp1[dp1.length-2], dp2[dp2.length-2]);
}
public static void main(String [] ags){
    int a[] = {10, 3, 2, 5, 7, 8};
    int b[]={1,2,3,4,5,1,2,3,4,5};
    int c[]= {94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61, 6, 237, 
        12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397, 52, 72, 37, 51, 1, 81, 
        45, 435, 7, 36, 57, 86, 81, 72};
    int d[]={7, 7, 7, 7, 7, 7, 7};
    System.out.println(maxDonations(a));
    System.out.println(maxDonations(b));
    System.out.println(maxDonations(c));
    System.out.println(maxDonations(d));
}
}
