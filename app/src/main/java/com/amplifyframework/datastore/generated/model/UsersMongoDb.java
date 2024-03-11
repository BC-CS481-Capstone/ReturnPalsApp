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

/** This is an auto generated class representing the UsersMongoDb type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "UsersMongoDbs", type = Model.Type.USER, version = 1, authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
public final class UsersMongoDb implements Model {
  public static final QueryField ID = field("UsersMongoDb", "id");
  public static final QueryField EMAIL = field("UsersMongoDb", "email");
  public static final QueryField ADDRESS = field("UsersMongoDb", "address");
  public static final QueryField SUBSCRIPTION = field("UsersMongoDb", "subscription");
  public static final QueryField FIRST_NAME = field("UsersMongoDb", "first_name");
  public static final QueryField LAST_NAME = field("UsersMongoDb", "last_name");
  public static final QueryField PHONE_NUMBER = field("UsersMongoDb", "phone_number");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String") String email;
  private final @ModelField(targetType="String") List<String> address;
  private final @ModelField(targetType="String") String subscription;
  private final @ModelField(targetType="String") String first_name;
  private final @ModelField(targetType="String") String last_name;
  private final @ModelField(targetType="String") String phone_number;
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
  
  public List<String> getAddress() {
      return address;
  }
  
  public String getSubscription() {
      return subscription;
  }
  
  public String getFirstName() {
      return first_name;
  }
  
  public String getLastName() {
      return last_name;
  }
  
  public String getPhoneNumber() {
      return phone_number;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private UsersMongoDb(String id, String email, List<String> address, String subscription, String first_name, String last_name, String phone_number) {
    this.id = id;
    this.email = email;
    this.address = address;
    this.subscription = subscription;
    this.first_name = first_name;
    this.last_name = last_name;
    this.phone_number = phone_number;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      UsersMongoDb usersMongoDb = (UsersMongoDb) obj;
      return ObjectsCompat.equals(getId(), usersMongoDb.getId()) &&
              ObjectsCompat.equals(getEmail(), usersMongoDb.getEmail()) &&
              ObjectsCompat.equals(getAddress(), usersMongoDb.getAddress()) &&
              ObjectsCompat.equals(getSubscription(), usersMongoDb.getSubscription()) &&
              ObjectsCompat.equals(getFirstName(), usersMongoDb.getFirstName()) &&
              ObjectsCompat.equals(getLastName(), usersMongoDb.getLastName()) &&
              ObjectsCompat.equals(getPhoneNumber(), usersMongoDb.getPhoneNumber()) &&
              ObjectsCompat.equals(getCreatedAt(), usersMongoDb.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), usersMongoDb.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getEmail())
      .append(getAddress())
      .append(getSubscription())
      .append(getFirstName())
      .append(getLastName())
      .append(getPhoneNumber())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("UsersMongoDb {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("email=" + String.valueOf(getEmail()) + ", ")
      .append("address=" + String.valueOf(getAddress()) + ", ")
      .append("subscription=" + String.valueOf(getSubscription()) + ", ")
      .append("first_name=" + String.valueOf(getFirstName()) + ", ")
      .append("last_name=" + String.valueOf(getLastName()) + ", ")
      .append("phone_number=" + String.valueOf(getPhoneNumber()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static Builder builder() {
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
  public static UsersMongoDb justId(String id) {
    return new UsersMongoDb(
      id,
      null,
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
      address,
      subscription,
      first_name,
      last_name,
      phone_number);
  }
  public interface BuildStep {
    UsersMongoDb build();
    BuildStep id(String id);
    BuildStep email(String email);
    BuildStep address(List<String> address);
    BuildStep subscription(String subscription);
    BuildStep firstName(String firstName);
    BuildStep lastName(String lastName);
    BuildStep phoneNumber(String phoneNumber);
  }
  

  public static class Builder implements BuildStep {
    private String id;
    private String email;
    private List<String> address;
    private String subscription;
    private String first_name;
    private String last_name;
    private String phone_number;
    public Builder() {
      
    }
    
    private Builder(String id, String email, List<String> address, String subscription, String first_name, String last_name, String phone_number) {
      this.id = id;
      this.email = email;
      this.address = address;
      this.subscription = subscription;
      this.first_name = first_name;
      this.last_name = last_name;
      this.phone_number = phone_number;
    }
    
    @Override
     public UsersMongoDb build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new UsersMongoDb(
          id,
          email,
          address,
          subscription,
          first_name,
          last_name,
          phone_number);
    }
    
    @Override
     public BuildStep email(String email) {
        this.email = email;
        return this;
    }
    
    @Override
     public BuildStep address(List<String> address) {
        this.address = address;
        return this;
    }
    
    @Override
     public BuildStep subscription(String subscription) {
        this.subscription = subscription;
        return this;
    }
    
    @Override
     public BuildStep firstName(String firstName) {
        this.first_name = firstName;
        return this;
    }
    
    @Override
     public BuildStep lastName(String lastName) {
        this.last_name = lastName;
        return this;
    }
    
    @Override
     public BuildStep phoneNumber(String phoneNumber) {
        this.phone_number = phoneNumber;
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
    private CopyOfBuilder(String id, String email, List<String> address, String subscription, String firstName, String lastName, String phoneNumber) {
      super(id, email, address, subscription, first_name, last_name, phone_number);
      
    }
    
    @Override
     public CopyOfBuilder email(String email) {
      return (CopyOfBuilder) super.email(email);
    }
    
    @Override
     public CopyOfBuilder address(List<String> address) {
      return (CopyOfBuilder) super.address(address);
    }
    
    @Override
     public CopyOfBuilder subscription(String subscription) {
      return (CopyOfBuilder) super.subscription(subscription);
    }
    
    @Override
     public CopyOfBuilder firstName(String firstName) {
      return (CopyOfBuilder) super.firstName(firstName);
    }
    
    @Override
     public CopyOfBuilder lastName(String lastName) {
      return (CopyOfBuilder) super.lastName(lastName);
    }
    
    @Override
     public CopyOfBuilder phoneNumber(String phoneNumber) {
      return (CopyOfBuilder) super.phoneNumber(phoneNumber);
    }
  }
  

  public static class UsersMongoDbIdentifier extends ModelIdentifier<UsersMongoDb> {
    private static final long serialVersionUID = 1L;
    public UsersMongoDbIdentifier(String id) {
      super(id);
    }
  }
  
}
