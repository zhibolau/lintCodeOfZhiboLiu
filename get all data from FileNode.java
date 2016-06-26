/*

给定一个class FileNode, FileNode有两种类型分别是folder还有file, 
如果是file的话它提供一个接口来输出其里面的data(并不需要实现），
如果是folder,那么有一个函数listChildren返回list<FileNode>提供folder里面包含的其他file跟folder....
题目要实现的是给定一个FileNode, 然后把里面包含的所有file data给输出.....因为题目一开始有点绕，花了点时间理解。

最开始写了个简单的recursion, 小哥问recursion版本会有什么优劣势，follow up是让我写个不用recursion的
，然后我写了个bfs版本。。再一个follow up是用iterative来写recursion的版本。。。


*/



/*
FileNode : file: getData()
			Folder: listChildren() : file and folder
*/

//recursion

public Data getAlldataFromFileNode(FileNode f){
	Data d = new Data();
	if(f == null){
		return d;
	}
	help(d,f);
	return d;
}

public void help(Data d, FileNode f){
	if(f == null){
		return d;
	}
	if(f == fileType){
		d.add( f.getData());
	}
	else{
		for(int i = 0; i < f.listChildren().size(); i++){
			help(d,f.listChildren().get(i));
		}
	}
}

//iterative STACK
public Data getAlldataFromFileNode(FileNode f){
	Data d = new Data();
	if(f == null){
		return d;
	}
	Stack<FileNode> s = new Stack<FileNode>();
	s.push(f);
	while(!s.isEmpty()){
		FileNode temp = s.pop();
		if(f == fileType){
			d.add( f.getData());
		}
		else{
			for(FileNode c : f.listChildren()){
				s.push(c);
			}
		}
	}
	return d;
