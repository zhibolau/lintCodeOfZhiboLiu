 int findsecondmaxvalue(int *a,int size)  
{  
    int max = a[0];         //最大值    
    int second = a[1];      //次大值   
    for(int i = 0;i < size;i++)  
    {  
        if(a[i] > max)       //更新最大值和次大值   
        {  
            second = max;      
            max = a[i];  
        }  
        else if(a[i] < max && a[i] > second)  //更新次大值    
        {  
            second = a[i];  
        }  
    }  
    return second;  
}  



public int findSecondMax(int[] a){
	if(a == null){
		return -1;
	}
	int size = a.length;
	int max = a[0];
	int second = a[1];
	for(int i=0; i<size; i++){
		if(a[i] > max){
			max = a[i];
			second = max;
		}
		else if(a[i] < max && a[i] > second){
			second = a[i];
		}
	}
	return second;
}