#include<iostream>
#include<new>
using namespace std;
struct node 
{ int data;
  struct node *left;
  struct node *right;
}*root=NULL;
  node* newNode(node *root,int val)
{ 
  
	if(root==NULL)
		{	root=new node;

			root->data=val;
			root->left=NULL;
			root->right=NULL;
			
	
	
		}
	if(val>(root->data))
		root->right=newNode(root->right,val);
	else if(val<(root->data))
		root->left=newNode(root->left,val);	
        //if(val==root->data)
	//	cout<<"\nduplicate value";
	return root;
	//cout<<"value inserted";
}
void inorder(node *root)
{	if(root!=NULL)
		
		{
			inorder(root->left);
			cout<<root->data;
			inorder(root->right);
		}
}
int islca(node *root,int n1,int n2)
	{
		if(root==NULL)
			{	cout<<"no ancestor";
				return 0;
			}
		if((root->data)>n1 && root->data<n2)
			return root->data;
		







	}
int main()
{ root=newNode(root,11);
  newNode(root,2);
  newNode(root,10);
  newNode(root,15);
  newNode(root,1);
  newNode(root,12);
  newNode(root,19);
	
  inorder(root);
  return 0;
}	
