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

/** This is an auto generated class representing the Labels type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Labels", type = Model.Type.USER, version = 1, authRules = {
  @AuthRule(allow = AuthStrategy.OWNER, ownerField = "owner", identityClaim = "cognito:username", provider = "userPools", operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
@Index(name = "byReturns", fields = {"returnsID"})
public final class Labels implements Model {
  public static final QueryField ID = field("Labels", "id");
  public static final QueryField TYPE = field("Labels", "type");
  public static final QueryField IMAGE = field("Labels", "image");
  public static final QueryField QRCODE = field("Labels", "qrcode");
  public static final QueryField RETURNS_ID = field("Labels", "returnsID");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="LabelType", isRequired = true) LabelType type;
  private final @ModelField(targetType="String") String image;
  private final @ModelField(targetType="String") String qrcode;
  private final @ModelField(targetType="ID", isRequired = true) String returnsID;
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
  
  public LabelType getType() {
      return type;
  }
  
  public String getImage() {
      return image;
  }
  
  public String getQrcode() {
      return qrcode;
  }
  
  public String getReturnsId() {
      return returnsID;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Labels(String id, LabelType type, String image, String qrcode, String returnsID) {
    this.id = id;
    this.type = type;
    this.image = image;
    this.qrcode = qrcode;
    this.returnsID = returnsID;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Labels labels = (Labels) obj;
      return ObjectsCompat.equals(getId(), labels.getId()) &&
              ObjectsCompat.equals(getType(), labels.getType()) &&
              ObjectsCompat.equals(getImage(), labels.getImage()) &&
              ObjectsCompat.equals(getQrcode(), labels.getQrcode()) &&
              ObjectsCompat.equals(getReturnsId(), labels.getReturnsId()) &&
              ObjectsCompat.equals(getCreatedAt(), labels.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), labels.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getType())
      .append(getImage())
      .append(getQrcode())
      .append(getReturnsId())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Labels {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("type=" + String.valueOf(getType()) + ", ")
      .append("image=" + String.valueOf(getImage()) + ", ")
      .append("qrcode=" + String.valueOf(getQrcode()) + ", ")
      .append("returnsID=" + String.valueOf(getReturnsId()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static TypeStep builder() {
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
  public static Labels justId(String id) {
    return new Labels(
      id,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      type,
      image,
      qrcode,
      returnsID);
  }
  public interface TypeStep {
    ReturnsIdStep type(LabelType type);
  }
  

  public interface ReturnsIdStep {
    BuildStep returnsId(String returnsId);
  }
  

  public interface BuildStep {
    Labels build();
    BuildStep id(String id);
    BuildStep image(String image);
    BuildStep qrcode(String qrcode);
  }
  

  public static class Builder implements TypeStep, ReturnsIdStep, BuildStep {
    private String id;
    private LabelType type;
    private String returnsID;
    private String image;
    private String qrcode;
    public Builder() {
      
    }
    
    private Builder(String id, LabelType type, String image, String qrcode, String returnsID) {
      this.id = id;
      this.type = type;
      this.image = image;
      this.qrcode = qrcode;
      this.returnsID = returnsID;
    }
    
    @Override
     public Labels build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Labels(
          id,
          type,
          image,
          qrcode,
          returnsID);
    }
    
    @Override
     public ReturnsIdStep type(LabelType type) {
        Objects.requireNonNull(type);
        this.type = type;
        return this;
    }
    
    @Override
     public BuildStep returnsId(String returnsId) {
        Objects.requireNonNull(returnsId);
        this.returnsID = returnsId;
        return this;
    }
    
    @Override
     public BuildStep image(String image) {
        this.image = image;
        return this;
    }
    
    @Override
     public BuildStep qrcode(String qrcode) {
        this.qrcode = qrcode;
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
    private CopyOfBuilder(String id, LabelType type, String image, String qrcode, String returnsId) {
      super(id, type, image, qrcode, returnsID);
      Objects.requireNonNull(type);
      Objects.requireNonNull(returnsID);
    }
    
    @Override
     public CopyOfBuilder type(LabelType type) {
      return (CopyOfBuilder) super.type(type);
    }
    
    @Override
     public CopyOfBuilder returnsId(String returnsId) {
      return (CopyOfBuilder) super.returnsId(returnsId);
    }
    
    @Override
     public CopyOfBuilder image(String image) {
      return (CopyOfBuilder) super.image(image);
    }
    
    @Override
     public CopyOfBuilder qrcode(String qrcode) {
      return (CopyOfBuilder) super.qrcode(qrcode);
    }
  }
  

  public static class LabelsIdentifier extends ModelIdentifier<Labels> {
    private static final long serialVersionUID = 1L;
    public LabelsIdentifier(String id) {
      super(id);
    }
  }
  
}
