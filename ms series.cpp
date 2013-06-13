 /* Circular Queues */
    #include<iostream>
	  
	  using namespace std;		

	  const int MAX = 10;
	 class queue
	  {	public:
		   int a;
		
		   queue()	
			{		
				a=0;
			//	flag=0;		

			}
		   
		   
		   void display()
			{
				cout<<" "<<a;
			}
	  };
	void insert(class queue *q)
	{	int iterator=1;
		//q[iterator].flag=1;
		q[iterator].a=1;
		for(int i=2;i<=10;i++)
			{ int count=i;
				for(int j=0;j<i;j++)
				{    
			  
				{	
					iterator++; 
					if(iterator>MAX-1)
						iterator=0;	
					
					//if(q[iterator].flag==0)
				  	
				  	cout<<" in loop";					  
					//if(iterator>MAX-1)
					//	iterator=0;	
							
				  	
				   if(q[iterator].a!=0)
					{	j--;
						
									
					}
					
			       }	     	
				}
			  iterator++;
			  	
			  
			  cout<<"value of iterator after loop"<<" "<<iterator<<"\n";
			if(iterator>MAX-1)
				iterator=0;  
				if(q[iterator].a==0)
				  {
					  //q[iterator].flag=1;
					  q[iterator].a=i;
             			  }
				else
				  while(q[iterator].a!=0)
					iterator++;
				q[iterator].a=i;	
			}
	}	
	
	int main()
	{
		class queue q[10];
			insert(q);
			for(int i=0;i<10;i++)		
				{ cout<<" "<<q[i].a;
//				  cout<<" "<<q[i].flag;
				  cout<<"\n";		
				}	
		return 0;		
}
