package br.com.kabum.msshipping.application;

public abstract class UseCase<IN, OUT> {
    
    public abstract OUT execute(IN anIn);
}
