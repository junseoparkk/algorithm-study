#include <iostream>
using namespace std;

int money[100000];
int top = -1;

void push(int x)
{
	money[++top] = x;
}

void del()
{
	top--;
}

int main(void)
{
	int k,n,size=0;
	int total = 0;
	cin >> k;
	
	for (int i = 0; i < k; i++)
	{
		cin >> n;
		if (n != 0)
		{
			push(n);
			size++;
		}
		else
			del();
	}
    
	for (int i = 0; i < top+1; i++)
		total += money[i];
	cout << total;
}