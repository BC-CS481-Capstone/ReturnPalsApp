package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.annotations.HasOne;
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

/** This is an auto generated class representing the SchedulePackage type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "SchedulePackages", type = Model.Type.USER, version = 1, authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
@Index(name = "byUser", fields = {"userID"})
public final class SchedulePackage implements Model {
  public static final QueryField ID = field("SchedulePackage", "id");
  public static final QueryField DATE = field("SchedulePackage", "Date");
  public static final QueryField PACKAGE_LABELS = field("SchedulePackage", "PackageLabels");
  public static final QueryField USER_ID = field("SchedulePackage", "userID");
  public static final QueryField SCHEDULE_PACKAGE_USER_ADDRESS_ID = field("SchedulePackage", "schedulePackageUserAddressId");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String") String Date;
  private final @ModelField(targetType="UserAddress") @HasOne(associatedWith = "id", type = UserAddress.class) UserAddress UserAddress = null;
  private final @ModelField(targetType="String", isRequired = true) List<String> PackageLabels;
  private final @ModelField(targetType="ID", isRequired = true) String userID;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  private final @ModelField(targetType="ID") String schedulePackageUserAddressId;
  /** @deprecated This API is internal to Amplify and should not be used. */
  @Deprecated
   public String resolveIdentifier() {
    return id;
  }
  
  public String getId() {
      return id;
  }
  
  public String getDate() {
      return Date;
  }
  
  public UserAddress getUserAddress() {
      return UserAddress;
  }
  
  public List<String> getPackageLabels() {
      return PackageLabels;
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
  
  public String getSchedulePackageUserAddressId() {
      return schedulePackageUserAddressId;
  }
  
  private SchedulePackage(String id, String Date, List<String> PackageLabels, String userID, String schedulePackageUserAddressId) {
    this.id = id;
    this.Date = Date;
    this.PackageLabels = PackageLabels;
    this.userID = userID;
    this.schedulePackageUserAddressId = schedulePackageUserAddressId;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      SchedulePackage schedulePackage = (SchedulePackage) obj;
      return ObjectsCompat.equals(getId(), schedulePackage.getId()) &&
              ObjectsCompat.equals(getDate(), schedulePackage.getDate()) &&
              ObjectsCompat.equals(getPackageLabels(), schedulePackage.getPackageLabels()) &&
              ObjectsCompat.equals(getUserId(), schedulePackage.getUserId()) &&
              ObjectsCompat.equals(getCreatedAt(), schedulePackage.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), schedulePackage.getUpdatedAt()) &&
              ObjectsCompat.equals(getSchedulePackageUserAddressId(), schedulePackage.getSchedulePackageUserAddressId());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getDate())
      .append(getPackageLabels())
      .append(getUserId())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .append(getSchedulePackageUserAddressId())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("SchedulePackage {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("Date=" + String.valueOf(getDate()) + ", ")
      .append("PackageLabels=" + String.valueOf(getPackageLabels()) + ", ")
      .append("userID=" + String.valueOf(getUserId()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()) + ", ")
      .append("schedulePackageUserAddressId=" + String.valueOf(getSchedulePackageUserAddressId()))
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
  public static SchedulePackage justId(String id) {
    return new SchedulePackage(
      id,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      Date,
      PackageLabels,
      userID,
      schedulePackageUserAddressId);
  }
  public interface PackageLabelsStep {
    UserIdStep packageLabels(List<String> packageLabels);
  }
  

  public interface UserIdStep {
    BuildStep userId(String userId);
  }
  

  public interface BuildStep {
    SchedulePackage build();
    BuildStep id(String id);
    BuildStep date(String date);
    BuildStep schedulePackageUserAddressId(String schedulePackageUserAddressId);
  }
  

  public static class Builder implements PackageLabelsStep, UserIdStep, BuildStep {
    private String id;
    private List<String> PackageLabels;
    private String userID;
    private String Date;
    private String schedulePackageUserAddressId;
    public Builder() {
      
    }
    
    private Builder(String id, String Date, List<String> PackageLabels, String userID, String schedulePackageUserAddressId) {
      this.id = id;
      this.Date = Date;
      this.PackageLabels = PackageLabels;
      this.userID = userID;
      this.schedulePackageUserAddressId = schedulePackageUserAddressId;
    }
    
    @Override
     public SchedulePackage build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new SchedulePackage(
          id,
          Date,
          PackageLabels,
          userID,
          schedulePackageUserAddressId);
    }
    
    @Override
     public UserIdStep packageLabels(List<String> packageLabels) {
        Objects.requireNonNull(packageLabels);
        this.PackageLabels = packageLabels;
        return this;
    }
    
    @Override
     public BuildStep userId(String userId) {
        Objects.requireNonNull(userId);
        this.userID = userId;
        return this;
    }
    
    @Override
     public BuildStep date(String date) {
        this.Date = date;
        return this;
    }
    
    @Override
     public BuildStep schedulePackageUserAddressId(String schedulePackageUserAddressId) {
        this.schedulePackageUserAddressId = schedulePackageUserAddressId;
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
    private CopyOfBuilder(String id, String date, List<String> packageLabels, String userId, String schedulePackageUserAddressId) {
      super(id, Date, PackageLabels, userID, schedulePackageUserAddressId);
      Objects.requireNonNull(PackageLabels);
      Objects.requireNonNull(userID);
    }
    
    @Override
     public CopyOfBuilder packageLabels(List<String> packageLabels) {
      return (CopyOfBuilder) super.packageLabels(packageLabels);
    }
    
    @Override
     public CopyOfBuilder userId(String userId) {
      return (CopyOfBuilder) super.userId(userId);
    }
    
    @Override
     public CopyOfBuilder date(String date) {
      return (CopyOfBuilder) super.date(date);
    }
    
    @Override
     public CopyOfBuilder schedulePackageUserAddressId(String schedulePackageUserAddressId) {
      return (CopyOfBuilder) super.schedulePackageUserAddressId(schedulePackageUserAddressId);
    }
  }
  

  public static class SchedulePackageIdentifier extends ModelIdentifier<SchedulePackage> {
    private static final long serialVersionUID = 1L;
    public SchedulePackageIdentifier(String id) {
      super(id);
    }
  }
  
}
