Distribution Buckets

Given an array of n integers within a known range (e.g.1-1000), write some code that can distribute 
the numbers in k bins of the samesize within the range (e.g. for k = 2, the integer 5 should go in the first oftwo bins, the second bin would be empty).
要实现一个bucket类 Bucket(int low,int high,int size)， insert(int value) 和insert(vectorvalues)还要自己写testcase 还有 出现错误之后，函数有什么错误处理机制(exception)也都要自己设计。 这是我面过的最软件工程的面试，里面有关很多的软件测试，设计呀还有怎么让一个程序变得更robust的相应问题 因为，题目很简单所以对算法没有要求。
题目来源：一亩三分地
Discussion

定义接口，定义私有成员（怎么存储bins, numbers, range, and bin size, etc)。 然后就是接口的实现了。
对了还有exception处理，最好用C++ standard exception, such as logic_error (invalide_argument, out_of_range, length_error).
Solution

class Bucket {
public:
    Bucket() {
    }
    Bucket(int low, int high, int n) {
        _low = low;
        _high = high;
        size = n;
        bins.resize(n);
    }
    void Insert(int value) {
        if(value < _low || value > _hight) {
            throw invalid_argument("Error: Input value is out of range.");
        }
        //if(cur_bin == bins.size()) {
            //throw out_of_range("Error: not 
        //}
        bins[cur_bin].emplace_back(value);
        cur_bin = (cur_bin+1) % bins.size();        
    }
    //return the number of values that are successfully inserted
    int Insert(vector<int>values) {
        int cnt =0;
        for(auto const& value : values) {
            if(value < _low || value > _hight) {
                continue;
            }
            Insert(value);
            cnt++;
        }
        return cnt;
    }
    vector<vector<int> > OutputBins() {
        return bins;
    }
    void test {
        try {
        Bucket bucket(1, 100, 3);
        bucket.Insert(5);
        vector<int> test_v;
        for (int i = 1; i < 30; i++) {
            test_v.emplace_back(i);
        }
        auto num = bucket.Insert(test_v);
        cout << num << " " << test_v.size()<<endl;
        }
        catch (const logic_error& le) {
            cout << le.what() << endl;
        }
    }
private:
    int _low = 0;
    int _high = 0;
    int size = 0; //number of bins
    vector<vector<int> > bins;
    int cur_bin = 0; //current bin
}
使用template

template<class T>
class Bucket {
public:
    Bucket() {
    }
    Bucket(T low, T high, int n) {
        _low = low;
        _high = high;
        size = n;
        bins.resize(n);
    }
    void Insert(T value) {
        if(value < _low || value > _hight) {
            throw invalid_argument("Error: Input value is out of range.");
        }
        //if(cur_bin == bins.size()) {
            //throw out_of_range("Error: not 
        //}
        bins[cur_bin].emplace_back(value);
        cur_bin = (cur_bin+1) % bins.size();        
    }
    //return the number of values that are successfully inserted
    int Insert(vector<T>values) {
        int cnt =0;
        for(auto const& value : values) {
            if(value < _low || value > _hight) {
                continue;
            }
            Insert(value);
            cnt++;
        }
        return cnt;
    }
    vector<vector<T> > OutputBins() {
        return bins;
    }
    void test {
        try {
        Bucket<int> bucket(1, 100, 3);
        bucket.Insert(5);
        vector<int> test_v;
        for (int i = 1; i < 30; i++) {
            test_v.emplace_back(i);
        }
        auto num = bucket.Insert(test_v);
        cout << num << " " << test_v.size()<<endl;
        }
        catch (const logic_error& le) {
            cout << le.what() << endl;
        }
    }
private:
    T _low = 0;
    T _high = 0;
    int size = 0; //number of bins
    vector<vector<T> > bins;
    int cur_bin = 0; //current bin
}
