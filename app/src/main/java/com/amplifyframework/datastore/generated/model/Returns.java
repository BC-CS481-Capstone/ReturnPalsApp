package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.temporal.Temporal;
import com.amplifyframework.core.model.annotations.HasMany;
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

/** This is an auto generated class representing the Returns type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Returns", type = Model.Type.USER, version = 1, authRules = {
  @AuthRule(allow = AuthStrategy.OWNER, ownerField = "owner", identityClaim = "cognito:username", provider = "userPools", operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
@Index(name = "byUser", fields = {"userID"})
public final class Returns implements Model {
  public static final QueryField ID = field("Returns", "id");
  public static final QueryField EMAIL = field("Returns", "email");
  public static final QueryField DATE = field("Returns", "date");
  public static final QueryField LABEL_IDS = field("Returns", "label_ids");
  public static final QueryField METHOD = field("Returns", "method");
  public static final QueryField CONFRIMATION_NUMBER = field("Returns", "confrimation_number");
  public static final QueryField ADDRESS = field("Returns", "address");
  public static final QueryField USER_ID = field("Returns", "userID");
  public static final QueryField STATUS = field("Returns", "status");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="AWSEmail") String email;
  private final @ModelField(targetType="AWSDate") Temporal.Date date;
  private final @ModelField(targetType="Int") List<Integer> label_ids;
  private final @ModelField(targetType="PickupMethod") PickupMethod method;
  private final @ModelField(targetType="String") String confrimation_number;
  private final @ModelField(targetType="String") String address;
  private final @ModelField(targetType="Labels") @HasMany(associatedWith = "returnsID", type = Labels.class) List<Labels> Labels = null;
  private final @ModelField(targetType="ID", isRequired = true) String userID;
  private final @ModelField(targetType="PickupStatus") PickupStatus status;
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
  
  public Temporal.Date getDate() {
      return date;
  }
  
  public List<Integer> getLabelIds() {
      return label_ids;
  }
  
  public PickupMethod getMethod() {
      return method;
  }
  
  public String getConfrimationNumber() {
      return confrimation_number;
  }
  
  public String getAddress() {
      return address;
  }
  
  public List<Labels> getLabels() {
      return Labels;
  }
  
  public String getUserId() {
      return userID;
  }
  
  public PickupStatus getStatus() {
      return status;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Returns(String id, String email, Temporal.Date date, List<Integer> label_ids, PickupMethod method, String confrimation_number, String address, String userID, PickupStatus status) {
    this.id = id;
    this.email = email;
    this.date = date;
    this.label_ids = label_ids;
    this.method = method;
    this.confrimation_number = confrimation_number;
    this.address = address;
    this.userID = userID;
    this.status = status;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Returns returns = (Returns) obj;
      return ObjectsCompat.equals(getId(), returns.getId()) &&
              ObjectsCompat.equals(getEmail(), returns.getEmail()) &&
              ObjectsCompat.equals(getDate(), returns.getDate()) &&
              ObjectsCompat.equals(getLabelIds(), returns.getLabelIds()) &&
              ObjectsCompat.equals(getMethod(), returns.getMethod()) &&
              ObjectsCompat.equals(getConfrimationNumber(), returns.getConfrimationNumber()) &&
              ObjectsCompat.equals(getAddress(), returns.getAddress()) &&
              ObjectsCompat.equals(getUserId(), returns.getUserId()) &&
              ObjectsCompat.equals(getStatus(), returns.getStatus()) &&
              ObjectsCompat.equals(getCreatedAt(), returns.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), returns.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getEmail())
      .append(getDate())
      .append(getLabelIds())
      .append(getMethod())
      .append(getConfrimationNumber())
      .append(getAddress())
      .append(getUserId())
      .append(getStatus())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Returns {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("email=" + String.valueOf(getEmail()) + ", ")
      .append("date=" + String.valueOf(getDate()) + ", ")
      .append("label_ids=" + String.valueOf(getLabelIds()) + ", ")
      .append("method=" + String.valueOf(getMethod()) + ", ")
      .append("confrimation_number=" + String.valueOf(getConfrimationNumber()) + ", ")
      .append("address=" + String.valueOf(getAddress()) + ", ")
      .append("userID=" + String.valueOf(getUserId()) + ", ")
      .append("status=" + String.valueOf(getStatus()) + ", ")
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
  public static Returns justId(String id) {
    return new Returns(
      id,
      null,
      null,
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
      date,
      label_ids,
      method,
      confrimation_number,
      address,
      userID,
      status);
  }
  public interface UserIdStep {
    BuildStep userId(String userId);
  }
  

  public interface BuildStep {
    Returns build();
    BuildStep id(String id);
    BuildStep email(String email);
    BuildStep date(Temporal.Date date);
    BuildStep labelIds(List<Integer> labelIds);
    BuildStep method(PickupMethod method);
    BuildStep confrimationNumber(String confrimationNumber);
    BuildStep address(String address);
    BuildStep status(PickupStatus status);
  }
  

  public static class Builder implements UserIdStep, BuildStep {
    private String id;
    private String userID;
    private String email;
    private Temporal.Date date;
    private List<Integer> label_ids;
    private PickupMethod method;
    private String confrimation_number;
    private String address;
    private PickupStatus status;
    public Builder() {
      
    }
    
    private Builder(String id, String email, Temporal.Date date, List<Integer> label_ids, PickupMethod method, String confrimation_number, String address, String userID, PickupStatus status) {
      this.id = id;
      this.email = email;
      this.date = date;
      this.label_ids = label_ids;
      this.method = method;
      this.confrimation_number = confrimation_number;
      this.address = address;
      this.userID = userID;
      this.status = status;
    }
    
    @Override
     public Returns build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Returns(
          id,
          email,
          date,
          label_ids,
          method,
          confrimation_number,
          address,
          userID,
          status);
    }
    
    @Override
     public BuildStep userId(String userId) {
        Objects.requireNonNull(userId);
        this.userID = userId;
        return this;
    }
    
    @Override
     public BuildStep email(String email) {
        this.email = email;
        return this;
    }
    
    @Override
     public BuildStep date(Temporal.Date date) {
        this.date = date;
        return this;
    }
    
    @Override
     public BuildStep labelIds(List<Integer> labelIds) {
        this.label_ids = labelIds;
        return this;
    }
    
    @Override
     public BuildStep method(PickupMethod method) {
        this.method = method;
        return this;
    }
    
    @Override
     public BuildStep confrimationNumber(String confrimationNumber) {
        this.confrimation_number = confrimationNumber;
        return this;
    }
    
    @Override
     public BuildStep address(String address) {
        this.address = address;
        return this;
    }
    
    @Override
     public BuildStep status(PickupStatus status) {
        this.status = status;
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
    private CopyOfBuilder(String id, String email, Temporal.Date date, List<Integer> labelIds, PickupMethod method, String confrimationNumber, String address, String userId, PickupStatus status) {
      super(id, email, date, label_ids, method, confrimation_number, address, userID, status);
      Objects.requireNonNull(userID);
    }
    
    @Override
     public CopyOfBuilder userId(String userId) {
      return (CopyOfBuilder) super.userId(userId);
    }
    
    @Override
     public CopyOfBuilder email(String email) {
      return (CopyOfBuilder) super.email(email);
    }
    
    @Override
     public CopyOfBuilder date(Temporal.Date date) {
      return (CopyOfBuilder) super.date(date);
    }
    
    @Override
     public CopyOfBuilder labelIds(List<Integer> labelIds) {
      return (CopyOfBuilder) super.labelIds(labelIds);
    }
    
    @Override
     public CopyOfBuilder method(PickupMethod method) {
      return (CopyOfBuilder) super.method(method);
    }
    
    @Override
     public CopyOfBuilder confrimationNumber(String confrimationNumber) {
      return (CopyOfBuilder) super.confrimationNumber(confrimationNumber);
    }
    
    @Override
     public CopyOfBuilder address(String address) {
      return (CopyOfBuilder) super.address(address);
    }
    
    @Override
     public CopyOfBuilder status(PickupStatus status) {
      return (CopyOfBuilder) super.status(status);
    }
  }
  

  public static class ReturnsIdentifier extends ModelIdentifier<Returns> {
    private static final long serialVersionUID = 1L;
    public ReturnsIdentifier(String id) {
      super(id);
    }
  }
  
}
