package de.telran.market.error;

public class ProductNotFoundException extends IllegalArgumentException{

  public ProductNotFoundException(String s) {
    super(s);
  }
}
