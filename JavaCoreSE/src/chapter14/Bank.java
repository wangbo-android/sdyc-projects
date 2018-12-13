package chapter14;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wangbo
 */
public class Bank {

    private final double[] accounts;

    private Lock bankLock;

    private Condition sufficientFunds;

    public Bank(int n,double initialBalance){

        accounts = new double[n];

        for(int i=0;i<accounts.length;i++){
            accounts[i] = initialBalance;
        }
        bankLock = new ReentrantLock();
        sufficientFunds = bankLock.newCondition();
    }

    public void transfer(int from,int to,double amout) throws InterruptedException{

        bankLock.lock();

        try{

            while(accounts[from] < amout){
                sufficientFunds.await();
            }
            System.out.println(Thread.currentThread());
            accounts[from] -= amout;
            System.out.printf(" %10.2f from %d to %d",amout,from,to);
            accounts[to] += amout;
            System.out.printf(" Total Balance:%10.2f%n",getTotalBalance());
            sufficientFunds.signalAll();
        }finally {

            bankLock.unlock();
        }
    }

    public double getTotalBalance(){

        bankLock.lock();
        try{

            double sum = 0;
            for(double a : accounts){

                sum += a;
            }
            return sum;
        }finally {

            bankLock.unlock();
        }
    }

    public int size(){

        return accounts.length;
    }
}
