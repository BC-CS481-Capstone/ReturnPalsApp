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
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
public final class User implements Model {
  public static final QueryField ID = field("User", "id");
  public static final QueryField NAME_FIRST = field("User", "NameFirst");
  public static final QueryField NAME_LAST = field("User", "NameLast");
  public static final QueryField EMAIL = field("User", "Email");
  public static final QueryField EXPIRE_DATE = field("User", "ExpireDate");
  public static final QueryField MEMBER_SHIP_TYPE = field("User", "MemberShipType");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String NameFirst;
  private final @ModelField(targetType="String", isRequired = true) String NameLast;
  private final @ModelField(targetType="AWSEmail", isRequired = true) String Email;
  private final @ModelField(targetType="String", isRequired = true) String ExpireDate;
  private final @ModelField(targetType="String", isRequired = true) String MemberShipType;
  private final @ModelField(targetType="UserAddress") @HasMany(associatedWith = "userID", type = UserAddress.class) List<UserAddress> UserAddresses = null;
  private final @ModelField(targetType="SchedulePackage") @HasMany(associatedWith = "userID", type = SchedulePackage.class) List<SchedulePackage> SchedulePackages = null;
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
  
  public String getNameFirst() {
      return NameFirst;
  }
  
  public String getNameLast() {
      return NameLast;
  }
  
  public String getEmail() {
      return Email;
  }
  
  public String getExpireDate() {
      return ExpireDate;
  }
  
  public String getMemberShipType() {
      return MemberShipType;
  }
  
  public List<UserAddress> getUserAddresses() {
      return UserAddresses;
  }
  
  public List<SchedulePackage> getSchedulePackages() {
      return SchedulePackages;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private User(String id, String NameFirst, String NameLast, String Email, String ExpireDate, String MemberShipType) {
    this.id = id;
    this.NameFirst = NameFirst;
    this.NameLast = NameLast;
    this.Email = Email;
    this.ExpireDate = ExpireDate;
    this.MemberShipType = MemberShipType;
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
              ObjectsCompat.equals(getNameFirst(), user.getNameFirst()) &&
              ObjectsCompat.equals(getNameLast(), user.getNameLast()) &&
              ObjectsCompat.equals(getEmail(), user.getEmail()) &&
              ObjectsCompat.equals(getExpireDate(), user.getExpireDate()) &&
              ObjectsCompat.equals(getMemberShipType(), user.getMemberShipType()) &&
              ObjectsCompat.equals(getCreatedAt(), user.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), user.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getNameFirst())
      .append(getNameLast())
      .append(getEmail())
      .append(getExpireDate())
      .append(getMemberShipType())
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
      .append("NameFirst=" + String.valueOf(getNameFirst()) + ", ")
      .append("NameLast=" + String.valueOf(getNameLast()) + ", ")
      .append("Email=" + String.valueOf(getEmail()) + ", ")
      .append("ExpireDate=" + String.valueOf(getExpireDate()) + ", ")
      .append("MemberShipType=" + String.valueOf(getMemberShipType()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static NameFirstStep builder() {
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
      NameFirst,
      NameLast,
      Email,
      ExpireDate,
      MemberShipType);
  }
  public interface NameFirstStep {
    NameLastStep nameFirst(String nameFirst);
  }
  

  public interface NameLastStep {
    EmailStep nameLast(String nameLast);
  }
  

  public interface EmailStep {
    ExpireDateStep email(String email);
  }
  

  public interface ExpireDateStep {
    MemberShipTypeStep expireDate(String expireDate);
  }
  

  public interface MemberShipTypeStep {
    BuildStep memberShipType(String memberShipType);
  }
  

  public interface BuildStep {
    User build();
    BuildStep id(String id);
  }
  

  public static class Builder implements NameFirstStep, NameLastStep, EmailStep, ExpireDateStep, MemberShipTypeStep, BuildStep {
    private String id;
    private String NameFirst;
    private String NameLast;
    private String Email;
    private String ExpireDate;
    private String MemberShipType;
    public Builder() {
      
    }
    
    private Builder(String id, String NameFirst, String NameLast, String Email, String ExpireDate, String MemberShipType) {
      this.id = id;
      this.NameFirst = NameFirst;
      this.NameLast = NameLast;
      this.Email = Email;
      this.ExpireDate = ExpireDate;
      this.MemberShipType = MemberShipType;
    }
    
    @Override
     public User build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new User(
          id,
          NameFirst,
          NameLast,
          Email,
          ExpireDate,
          MemberShipType);
    }
    
    @Override
     public NameLastStep nameFirst(String nameFirst) {
        Objects.requireNonNull(nameFirst);
        this.NameFirst = nameFirst;
        return this;
    }
    
    @Override
     public EmailStep nameLast(String nameLast) {
        Objects.requireNonNull(nameLast);
        this.NameLast = nameLast;
        return this;
    }
    
    @Override
     public ExpireDateStep email(String email) {
        Objects.requireNonNull(email);
        this.Email = email;
        return this;
    }
    
    @Override
     public MemberShipTypeStep expireDate(String expireDate) {
        Objects.requireNonNull(expireDate);
        this.ExpireDate = expireDate;
        return this;
    }
    
    @Override
     public BuildStep memberShipType(String memberShipType) {
        Objects.requireNonNull(memberShipType);
        this.MemberShipType = memberShipType;
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
    private CopyOfBuilder(String id, String nameFirst, String nameLast, String email, String expireDate, String memberShipType) {
      super(id, NameFirst, NameLast, Email, ExpireDate, MemberShipType);
      Objects.requireNonNull(NameFirst);
      Objects.requireNonNull(NameLast);
      Objects.requireNonNull(Email);
      Objects.requireNonNull(ExpireDate);
      Objects.requireNonNull(MemberShipType);
    }
    
    @Override
     public CopyOfBuilder nameFirst(String nameFirst) {
      return (CopyOfBuilder) super.nameFirst(nameFirst);
    }
    
    @Override
     public CopyOfBuilder nameLast(String nameLast) {
      return (CopyOfBuilder) super.nameLast(nameLast);
    }
    
    @Override
     public CopyOfBuilder email(String email) {
      return (CopyOfBuilder) super.email(email);
    }
    
    @Override
     public CopyOfBuilder expireDate(String expireDate) {
      return (CopyOfBuilder) super.expireDate(expireDate);
    }
    
    @Override
     public CopyOfBuilder memberShipType(String memberShipType) {
      return (CopyOfBuilder) super.memberShipType(memberShipType);
    }
  }
  

  public static class UserIdentifier extends ModelIdentifier<User> {
    private static final long serialVersionUID = 1L;
    public UserIdentifier(String id) {
      super(id);
    }
  }
  
}
