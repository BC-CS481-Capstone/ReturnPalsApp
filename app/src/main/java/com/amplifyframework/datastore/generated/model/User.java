package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.annotations.HasMany;
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

/** This is an auto generated class representing the User type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Users", type = Model.Type.USER, version = 1, authRules = {
  @AuthRule(allow = AuthStrategy.PRIVATE, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ }),
  @AuthRule(allow = AuthStrategy.OWNER, ownerField = "owner", identityClaim = "cognito:username", provider = "userPools", operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
public final class User implements Model {
  public static final QueryField ID = field("User", "id");
  public static final QueryField EMAIL = field("User", "email");
  public static final QueryField PHONE = field("User", "phone");
  public static final QueryField SUBSCRIPTION = field("User", "subscription");
  public static final QueryField FIRST_NAME = field("User", "firstName");
  public static final QueryField LAST_NAME = field("User", "lastName");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="AWSEmail", isRequired = true) String email;
  private final @ModelField(targetType="AWSPhone") String phone;
  private final @ModelField(targetType="PricingPlan", isRequired = true) PricingPlan subscription;
  private final @ModelField(targetType="String") String firstName;
  private final @ModelField(targetType="String") String lastName;
  private final @ModelField(targetType="Address") @HasMany(associatedWith = "userID", type = Address.class) List<Address> addresses = null;
  private final @ModelField(targetType="Address") @HasMany(associatedWith = "userID", type = Address.class) List<Address> Payments = null;
  private final @ModelField(targetType="Address") @HasMany(associatedWith = "userID", type = Address.class) List<Address> Returns = null;
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
  
  public String getEmail() {
      return email;
  }
  
  public String getPhone() {
      return phone;
  }
  
  public PricingPlan getSubscription() {
      return subscription;
  }
  
  public String getFirstName() {
      return firstName;
  }
  
  public String getLastName() {
      return lastName;
  }
  
  public List<Address> getAddresses() {
      return addresses;
  }
  
  public List<Address> getPayments() {
      return Payments;
  }
  
  public List<Address> getReturns() {
      return Returns;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private User(String id, String email, String phone, PricingPlan subscription, String firstName, String lastName) {
    this.id = id;
    this.email = email;
    this.phone = phone;
    this.subscription = subscription;
    this.firstName = firstName;
    this.lastName = lastName;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      User user = (User) obj;
      return ObjectsCompat.equals(getId(), user.getId()) &&
              ObjectsCompat.equals(getEmail(), user.getEmail()) &&
              ObjectsCompat.equals(getPhone(), user.getPhone()) &&
              ObjectsCompat.equals(getSubscription(), user.getSubscription()) &&
              ObjectsCompat.equals(getFirstName(), user.getFirstName()) &&
              ObjectsCompat.equals(getLastName(), user.getLastName()) &&
              ObjectsCompat.equals(getCreatedAt(), user.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), user.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getEmail())
      .append(getPhone())
      .append(getSubscription())
      .append(getFirstName())
      .append(getLastName())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("User {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("email=" + String.valueOf(getEmail()) + ", ")
      .append("phone=" + String.valueOf(getPhone()) + ", ")
      .append("subscription=" + String.valueOf(getSubscription()) + ", ")
      .append("firstName=" + String.valueOf(getFirstName()) + ", ")
      .append("lastName=" + String.valueOf(getLastName()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static EmailStep builder() {
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
  public static User justId(String id) {
    return new User(
      id,
      null,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      email,
      phone,
      subscription,
      firstName,
      lastName);
  }
  public interface EmailStep {
    SubscriptionStep email(String email);
  }
  

  public interface SubscriptionStep {
    BuildStep subscription(PricingPlan subscription);
  }
  

  public interface BuildStep {
    User build();
    BuildStep id(String id);
    BuildStep phone(String phone);
    BuildStep firstName(String firstName);
    BuildStep lastName(String lastName);
  }
  

  public static class Builder implements EmailStep, SubscriptionStep, BuildStep {
    private String id;
    private String email;
    private PricingPlan subscription;
    private String phone;
    private String firstName;
    private String lastName;
    public Builder() {
      
    }
    
    private Builder(String id, String email, String phone, PricingPlan subscription, String firstName, String lastName) {
      this.id = id;
      this.email = email;
      this.phone = phone;
      this.subscription = subscription;
      this.firstName = firstName;
      this.lastName = lastName;
    }
    
    @Override
     public User build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new User(
          id,
          email,
          phone,
          subscription,
          firstName,
          lastName);
    }
    
    @Override
     public SubscriptionStep email(String email) {
        Objects.requireNonNull(email);
        this.email = email;
        return this;
    }
    
    @Override
     public BuildStep subscription(PricingPlan subscription) {
        Objects.requireNonNull(subscription);
        this.subscription = subscription;
        return this;
    }
    
    @Override
     public BuildStep phone(String phone) {
        this.phone = phone;
        return this;
    }
    
    @Override
     public BuildStep firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
    
    @Override
     public BuildStep lastName(String lastName) {
        this.lastName = lastName;
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
    private CopyOfBuilder(String id, String email, String phone, PricingPlan subscription, String firstName, String lastName) {
      super(id, email, phone, subscription, firstName, lastName);
      Objects.requireNonNull(email);
      Objects.requireNonNull(subscription);
    }
    
    @Override
     public CopyOfBuilder email(String email) {
      return (CopyOfBuilder) super.email(email);
    }
    
    @Override
     public CopyOfBuilder subscription(PricingPlan subscription) {
      return (CopyOfBuilder) super.subscription(subscription);
    }
    
    @Override
     public CopyOfBuilder phone(String phone) {
      return (CopyOfBuilder) super.phone(phone);
    }
    
    @Override
     public CopyOfBuilder firstName(String firstName) {
      return (CopyOfBuilder) super.firstName(firstName);
    }
    
    @Override
     public CopyOfBuilder lastName(String lastName) {
      return (CopyOfBuilder) super.lastName(lastName);
    }
  }
  

  public static class UserIdentifier extends ModelIdentifier<User> {
    private static final long serialVersionUID = 1L;
    public UserIdentifier(String id) {
      super(id);
    }
  }
  
}
