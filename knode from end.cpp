#include<iostream>
#include<new>
using namespace std;
struct node
{ int data;
  struct node *next;
}*head=NULL;

void insert(int val)
  { if(head==NULL)
		{ 	head=new node;
	          	head->data=val;
		  	head->next=NULL;
		}
	  else 
		{	node *temp=new node;
			temp->data=val;
			temp->next=head;
			head=temp;
		}
	}
void display(node *head)
	{	 cout<<"\n";
		if(head!=NULL)
		do
			{ cout<<head->data<<"->";
			  head=head->next;
			}while(head!=NULL);
	}
void displayK(node *head,int k)
	{	 
		while(head->next->next!=NULL)
			{	k=k-1;
				if(k==1)
				{ break;
				}
				cout<<"\n"<<head->data;					
				head=head->next;
				
			}
		
		cout<<"\nelement is printed"<<head->next->data;
		head->next=head->next->next;
		
	}		
int main()
	{
		insert(5);
		insert(4);
		insert(3);
		insert(7);
		insert(2);
		display(head);
		cout<<"\n";
		displayK(head,5);
		display(head);
		return 0;
	}
