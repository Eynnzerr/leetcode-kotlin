package offer

class Solution62 {
    /*
    圆圈中最后一个数字
    思路：动态规划
    设f(n,m)为求0..n-1数字围成的圈中每次删除第m个数字最后留下的数字解。
    由于n个数字删除1个数字后剩下n-1个数字，且这n-1个数字应当重新排列，从0开始变为从删除数字的下一个数字即m%n开始，
    故可以得到正常n-1数字序列与n数字序列删除一个数字得到的n-1数字序列的映射关系：
    [0,1,2,3...n-2] -> [m%n,m%n+1,m%n+2,...m%n+n-2] 为 x -> (x+m%n) % n = (x+m) % n 连续2次模n等效于1次模n
    又f(1,m)恒为0
     */
    fun lastRemaining(n: Int, m: Int) = if(n == 1) 0 else (2..n).fold(0) { res, i -> (res + m) % i }
}