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

/** This is an auto generated class representing the Address type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Addresses", type = Model.Type.USER, version = 1, authRules = {
  @AuthRule(allow = AuthStrategy.OWNER, ownerField = "owner", identityClaim = "cognito:username", provider = "userPools", operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ }),
  @AuthRule(allow = AuthStrategy.PRIVATE, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
@Index(name = "byUser", fields = {"userID"})
public final class Address implements Model {
  public static final QueryField ID = field("Address", "id");
  public static final QueryField ADDRESS = field("Address", "address");
  public static final QueryField USER_ID = field("Address", "userID");
  public static final QueryField NICK_NAME = field("Address", "nick_name");
  public static final QueryField USER_EMAIL = field("Address", "user_email");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String address;
  private final @ModelField(targetType="ID", isRequired = true) String userID;
  private final @ModelField(targetType="String") String nick_name;
  private final @ModelField(targetType="AWSEmail") String user_email;
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
  
  public String getAddress() {
      return address;
  }
  
  public String getUserId() {
      return userID;
  }
  
  public String getNickName() {
      return nick_name;
  }
  
  public String getUserEmail() {
      return user_email;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Address(String id, String address, String userID, String nick_name, String user_email) {
    this.id = id;
    this.address = address;
    this.userID = userID;
    this.nick_name = nick_name;
    this.user_email = user_email;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Address address = (Address) obj;
      return ObjectsCompat.equals(getId(), address.getId()) &&
              ObjectsCompat.equals(getAddress(), address.getAddress()) &&
              ObjectsCompat.equals(getUserId(), address.getUserId()) &&
              ObjectsCompat.equals(getNickName(), address.getNickName()) &&
              ObjectsCompat.equals(getUserEmail(), address.getUserEmail()) &&
              ObjectsCompat.equals(getCreatedAt(), address.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), address.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getAddress())
      .append(getUserId())
      .append(getNickName())
      .append(getUserEmail())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Address {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("address=" + String.valueOf(getAddress()) + ", ")
      .append("userID=" + String.valueOf(getUserId()) + ", ")
      .append("nick_name=" + String.valueOf(getNickName()) + ", ")
      .append("user_email=" + String.valueOf(getUserEmail()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static AddressStep builder() {
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
  public static Address justId(String id) {
    return new Address(
      id,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      address,
      userID,
      nick_name,
      user_email);
  }
  public interface AddressStep {
    UserIdStep address(String address);
  }
  

  public interface UserIdStep {
    BuildStep userId(String userId);
  }
  

  public interface BuildStep {
    Address build();
    BuildStep id(String id);
    BuildStep nickName(String nickName);
    BuildStep userEmail(String userEmail);
  }
  

  public static class Builder implements AddressStep, UserIdStep, BuildStep {
    private String id;
    private String address;
    private String userID;
    private String nick_name;
    private String user_email;
    public Builder() {
      
    }
    
    private Builder(String id, String address, String userID, String nick_name, String user_email) {
      this.id = id;
      this.address = address;
      this.userID = userID;
      this.nick_name = nick_name;
      this.user_email = user_email;
    }
    
    @Override
     public Address build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Address(
          id,
          address,
          userID,
          nick_name,
          user_email);
    }
    
    @Override
     public UserIdStep address(String address) {
        Objects.requireNonNull(address);
        this.address = address;
        return this;
    }
    
    @Override
     public BuildStep userId(String userId) {
        Objects.requireNonNull(userId);
        this.userID = userId;
        return this;
    }
    
    @Override
     public BuildStep nickName(String nickName) {
        this.nick_name = nickName;
        return this;
    }
    
    @Override
     public BuildStep userEmail(String userEmail) {
        this.user_email = userEmail;
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
    private CopyOfBuilder(String id, String address, String userId, String nickName, String userEmail) {
      super(id, address, userID, nick_name, user_email);
      Objects.requireNonNull(address);
      Objects.requireNonNull(userID);
    }
    
    @Override
     public CopyOfBuilder address(String address) {
      return (CopyOfBuilder) super.address(address);
    }
    
    @Override
     public CopyOfBuilder userId(String userId) {
      return (CopyOfBuilder) super.userId(userId);
    }
    
    @Override
     public CopyOfBuilder nickName(String nickName) {
      return (CopyOfBuilder) super.nickName(nickName);
    }
    
    @Override
     public CopyOfBuilder userEmail(String userEmail) {
      return (CopyOfBuilder) super.userEmail(userEmail);
    }
  }
  

  public static class AddressIdentifier extends ModelIdentifier<Address> {
    private static final long serialVersionUID = 1L;
    public AddressIdentifier(String id) {
      super(id);
    }
  }
  
}
