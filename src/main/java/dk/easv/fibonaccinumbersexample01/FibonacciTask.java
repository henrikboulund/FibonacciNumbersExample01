package dk.easv.fibonaccinumbersexample01;

import javafx.concurrent.Task;

public class FibonacciTask extends Task<Long> {

    private final int n;

    FibonacciTask(int n)
    {
        this.n = n;
    }

    @Override
    protected Long call() throws Exception {
        updateMessage("Calculating...");
        long result = Fibonacci(n);
        updateMessage("Done calculating!");
        return result;
    }

    private long Fibonacci(int fib)
    {
        if(fib == 1 || fib == 2)
        {
            return fib;
        }
        else
        {
            return Fibonacci(fib - 1) + Fibonacci(fib - 2);
        }
    }
}
