package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.temporal.Temporal;
import com.amplifyframework.core.model.ModelIdentifier;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.AuthStrategy;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.ModelOperation;
import com.amplifyframework.core.model.annotations.AuthRule;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the Payments type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Payments", type = Model.Type.USER, version = 1, authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
@Index(name = "byUser", fields = {"userID"})
public final class Payments implements Model {
  public static final QueryField ID = field("Payments", "id");
  public static final QueryField PAYMENT_PLAN = field("Payments", "payment_plan");
  public static final QueryField DATE = field("Payments", "date");
  public static final QueryField USER_ID = field("Payments", "userID");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="PricingPlan") PricingPlan payment_plan;
  private final @ModelField(targetType="AWSDate") Temporal.Date date;
  private final @ModelField(targetType="ID", isRequired = true) String userID;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  /** @deprecated This API is internal to Amplify and should not be used. */
  @Deprecated
   public String resolveIdentifier() {
    return id;
  }
  
  public String getId() {
      return id;
  }
  
  public PricingPlan getPaymentPlan() {
      return payment_plan;
  }
  
  public Temporal.Date getDate() {
      return date;
  }
  
  public String getUserId() {
      return userID;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Payments(String id, PricingPlan payment_plan, Temporal.Date date, String userID) {
    this.id = id;
    this.payment_plan = payment_plan;
    this.date = date;
    this.userID = userID;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Payments payments = (Payments) obj;
      return ObjectsCompat.equals(getId(), payments.getId()) &&
              ObjectsCompat.equals(getPaymentPlan(), payments.getPaymentPlan()) &&
              ObjectsCompat.equals(getDate(), payments.getDate()) &&
              ObjectsCompat.equals(getUserId(), payments.getUserId()) &&
              ObjectsCompat.equals(getCreatedAt(), payments.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), payments.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getPaymentPlan())
      .append(getDate())
      .append(getUserId())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Payments {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("payment_plan=" + String.valueOf(getPaymentPlan()) + ", ")
      .append("date=" + String.valueOf(getDate()) + ", ")
      .append("userID=" + String.valueOf(getUserId()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static UserIdStep builder() {
      return new Builder();
  }
  
  /**
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   */
  public static Payments justId(String id) {
    return new Payments(
      id,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      payment_plan,
      date,
      userID);
  }
  public interface UserIdStep {
    BuildStep userId(String userId);
  }
  

  public interface BuildStep {
    Payments build();
    BuildStep id(String id);
    BuildStep paymentPlan(PricingPlan paymentPlan);
    BuildStep date(Temporal.Date date);
  }
  

  public static class Builder implements UserIdStep, BuildStep {
    private String id;
    private String userID;
    private PricingPlan payment_plan;
    private Temporal.Date date;
    public Builder() {
      
    }
    
    private Builder(String id, PricingPlan payment_plan, Temporal.Date date, String userID) {
      this.id = id;
      this.payment_plan = payment_plan;
      this.date = date;
      this.userID = userID;
    }
    
    @Override
     public Payments build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Payments(
          id,
          payment_plan,
          date,
          userID);
    }
    
    @Override
     public BuildStep userId(String userId) {
        Objects.requireNonNull(userId);
        this.userID = userId;
        return this;
    }
    
    @Override
     public BuildStep paymentPlan(PricingPlan paymentPlan) {
        this.payment_plan = paymentPlan;
        return this;
    }
    
    @Override
     public BuildStep date(Temporal.Date date) {
        this.date = date;
        return this;
    }
    
    /**
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     */
    public BuildStep id(String id) {
        this.id = id;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, PricingPlan paymentPlan, Temporal.Date date, String userId) {
      super(id, payment_plan, date, userID);
      Objects.requireNonNull(userID);
    }
    
    @Override
     public CopyOfBuilder userId(String userId) {
      return (CopyOfBuilder) super.userId(userId);
    }
    
    @Override
     public CopyOfBuilder paymentPlan(PricingPlan paymentPlan) {
      return (CopyOfBuilder) super.paymentPlan(paymentPlan);
    }
    
    @Override
     public CopyOfBuilder date(Temporal.Date date) {
      return (CopyOfBuilder) super.date(date);
    }
  }
  

  public static class PaymentsIdentifier extends ModelIdentifier<Payments> {
    private static final long serialVersionUID = 1L;
    public PaymentsIdentifier(String id) {
      super(id);
    }
  }
  
}
