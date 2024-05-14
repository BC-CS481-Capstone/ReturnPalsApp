package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.Model;

import java.util.Objects;
import java.util.List;

/** This is an auto generated class representing the PaymentSheet type in your schema. */
public final class PaymentSheet implements Model {
  private final String paymentIntent;
  private final String ephemeralKey;
  private final String customer;
  private final String publishableKey;
  public String getPaymentIntent() {
      return paymentIntent;
  }
  
  public String getEphemeralKey() {
      return ephemeralKey;
  }
  
  public String getCustomer() {
      return customer;
  }
  
  public String getPublishableKey() {
      return publishableKey;
  }
  
  private PaymentSheet(String paymentIntent, String ephemeralKey, String customer, String publishableKey) {
    this.paymentIntent = paymentIntent;
    this.ephemeralKey = ephemeralKey;
    this.customer = customer;
    this.publishableKey = publishableKey;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      PaymentSheet paymentSheet = (PaymentSheet) obj;
      return ObjectsCompat.equals(getPaymentIntent(), paymentSheet.getPaymentIntent()) &&
              ObjectsCompat.equals(getEphemeralKey(), paymentSheet.getEphemeralKey()) &&
              ObjectsCompat.equals(getCustomer(), paymentSheet.getCustomer()) &&
              ObjectsCompat.equals(getPublishableKey(), paymentSheet.getPublishableKey());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getPaymentIntent())
      .append(getEphemeralKey())
      .append(getCustomer())
      .append(getPublishableKey())
      .toString()
      .hashCode();
  }
  
  public static PaymentIntentStep builder() {
      return new Builder();
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(paymentIntent,
      ephemeralKey,
      customer,
      publishableKey);
  }
  public interface PaymentIntentStep {
    EphemeralKeyStep paymentIntent(String paymentIntent);
  }
  

  public interface EphemeralKeyStep {
    CustomerStep ephemeralKey(String ephemeralKey);
  }
  

  public interface CustomerStep {
    PublishableKeyStep customer(String customer);
  }
  

  public interface PublishableKeyStep {
    BuildStep publishableKey(String publishableKey);
  }
  

  public interface BuildStep {
    PaymentSheet build();
  }
  

  public static class Builder implements PaymentIntentStep, EphemeralKeyStep, CustomerStep, PublishableKeyStep, BuildStep {
    private String paymentIntent;
    private String ephemeralKey;
    private String customer;
    private String publishableKey;
    public Builder() {
      
    }
    
    private Builder(String paymentIntent, String ephemeralKey, String customer, String publishableKey) {
      this.paymentIntent = paymentIntent;
      this.ephemeralKey = ephemeralKey;
      this.customer = customer;
      this.publishableKey = publishableKey;
    }
    
    @Override
     public PaymentSheet build() {
        
        return new PaymentSheet(
          paymentIntent,
          ephemeralKey,
          customer,
          publishableKey);
    }
    
    @Override
     public EphemeralKeyStep paymentIntent(String paymentIntent) {
        Objects.requireNonNull(paymentIntent);
        this.paymentIntent = paymentIntent;
        return this;
    }
    
    @Override
     public CustomerStep ephemeralKey(String ephemeralKey) {
        Objects.requireNonNull(ephemeralKey);
        this.ephemeralKey = ephemeralKey;
        return this;
    }
    
    @Override
     public PublishableKeyStep customer(String customer) {
        Objects.requireNonNull(customer);
        this.customer = customer;
        return this;
    }
    
    @Override
     public BuildStep publishableKey(String publishableKey) {
        Objects.requireNonNull(publishableKey);
        this.publishableKey = publishableKey;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String paymentIntent, String ephemeralKey, String customer, String publishableKey) {
      super(paymentIntent, ephemeralKey, customer, publishableKey);
      Objects.requireNonNull(paymentIntent);
      Objects.requireNonNull(ephemeralKey);
      Objects.requireNonNull(customer);
      Objects.requireNonNull(publishableKey);
    }
    
    @Override
     public CopyOfBuilder paymentIntent(String paymentIntent) {
      return (CopyOfBuilder) super.paymentIntent(paymentIntent);
    }
    
    @Override
     public CopyOfBuilder ephemeralKey(String ephemeralKey) {
      return (CopyOfBuilder) super.ephemeralKey(ephemeralKey);
    }
    
    @Override
     public CopyOfBuilder customer(String customer) {
      return (CopyOfBuilder) super.customer(customer);
    }
    
    @Override
     public CopyOfBuilder publishableKey(String publishableKey) {
      return (CopyOfBuilder) super.publishableKey(publishableKey);
    }
  }
  
}
