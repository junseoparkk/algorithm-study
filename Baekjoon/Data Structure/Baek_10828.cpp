#include <stdio.h>
#define MAX 10000

int stack[MAX];
int top = -1;

int empty()
{
	if (top == -1)
		return 1;
	else
		return 0;
}

void push(int x)
{
	top++;
	stack[top] = x;
}

void pop()
{
	if (empty())
		printf("-1\n");
	else
		printf("%d\n", stack[top--]);
}

void size()
{
	printf("%d\n", top + 1);
}

void topp()
{
	if (empty())
		printf("-1\n");
	else
		printf("%d\n", stack[top]);
}

int main(void)
{
	int testcase;
	char order[6];
	int num;
	int ordernum;
	
	scanf("%d\n", &testcase);
	
	for (int i = 0; i < testcase; i++)
	{
		scanf("%s", &order,6);

		if ((char)order[0] == 'p' && (char)order[1] == 'u')
			ordernum = 1;
		else if ((char)order[0] == 'p' && (char)order[1] == 'o')
			ordernum = 2;
		else if ((char)order[0] == 's')
			ordernum = 3;
		else if ((char)order[0] == 'e')
			ordernum = 4;
		else if ((char)order[0] == 't')
			ordernum = 5;

		switch (ordernum)
		{
		case 1:
		{
			scanf("%d", &num);
			push(num);
			break;
		}
		case 2:
		{
			pop();
			break;
		}
		case 3:
		{
			size();
			break;
		}
		case 4:
		{
			printf("%d\n",empty());
			break;
		}
		case 5:
		{
			topp();
			break;
		}
		}
	}
}